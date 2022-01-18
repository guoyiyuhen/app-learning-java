package com.miiti.shoppingcart.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.miiti.shoppingcart.util.NumberUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
@JsonIgnoreProperties(ignoreUnknown=true)
public class ShoppingCart implements Serializable{

    private static final long serialVersionUID = -1947132804983588610L;

    private List<ShoppingCartLineItem> lineItems;

    private double subTotalCost;

    public ShoppingCart() {
        lineItems = new CopyOnWriteArrayList<ShoppingCartLineItem>();
    }

    public void addLineItem(ShoppingCartLineItem lineItem) {
        if(!lineItems.contains(lineItem)) {
            lineItems.add(lineItem);
            subTotalCost = NumberUtils.round(subTotalCost + lineItem.calculateTotalPrice());
        }
    }

    public double getSubTotal() {
        return subTotalCost;
    }

    public List<ShoppingCartLineItem> getLineItems() {
        return lineItems;
    }

    public void setLineItems(List<ShoppingCartLineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public void clear() {
        subTotalCost = 0.0;
        lineItems.clear();
    }

}
