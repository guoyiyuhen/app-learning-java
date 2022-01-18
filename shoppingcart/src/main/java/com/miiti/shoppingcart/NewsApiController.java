package com.miiti.shoppingcart;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Home page controller.
 *
 * @author Paul Chapman
 */
@RestController
public class NewsApiController {
    private int count;

    @GetMapping("/home")
    public int home() {
        return count++;
    }
}
