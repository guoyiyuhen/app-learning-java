package com.miiti.shoppingcart.web.controller;

import com.miiti.shoppingcart.model.ShoppingCartLineItem;
import com.miiti.shoppingcart.services.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@RestController
public class ShoppingCartController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ShoppingCartService shoppingCartService;

    /**
     * Loads existing test data from class path file base on bucket id
     *
     * @param bucket
     *            1, 2 or 3
     */
    @RequestMapping("loadcart/{bucket}")
    public @ResponseBody
    void loadShoppingCart(@PathVariable("bucket") String bucket) {

        logger.debug("Loading data from bucket:  #" + bucket);
        shoppingCartService.loadCartFromFile(bucket);
        logger.info("Bucket loaded successfully");
    }

    /**
     * Loads shopping cart line items from request body
     *
     * @param inputLineItem
     *            string data
     */
    @RequestMapping(value = "addcart", method = RequestMethod.POST)
    public @ResponseBody
    void addCart(@RequestBody String inputLineItem) {
        shoppingCartService.addShoppingCartLineItem(inputLineItem);
    }

    /**
     * Returns line items from current shopping cart
     *
     * @return list of ShoppingCartLineItem
     */
    @RequestMapping("viewcart")
    public @ResponseBody
    List<ShoppingCartLineItem> viewShoppingCart() {
        logger.debug("Retrieving cart");
        return shoppingCartService.getShoppingCart().getLineItems();
    }

    /**
     * Returns shopping cart input data class path file
     *
     * @param bucket
     *            possible values are 1, 2 or 3
     * @return List of strings
     */
    @RequestMapping("viewbucketinput")
    public @ResponseBody
    List<String> viewBucketInput(@RequestParam("bucket") int bucket) {
        logger.debug("Getting bucket input");
        return shoppingCartService.getBucketInput(bucket);
    }
}
