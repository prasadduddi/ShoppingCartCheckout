package com.example.checkout.core;

import java.math.BigDecimal;
import java.util.List;

/**
 * Checkout interface defines a method to calculate
 * the total price of a list of items in the shopping cart.
 */
public interface Checkout {
    /**
     * Calculate the total cost of items in the cart.
     *
     * @param items List of items (e.g., "Apple", "Orange")
     * @return Total cost as BigDecimal, rounded to 2 decimal places
     */
    BigDecimal calculateTotal(List<String> items);
}
