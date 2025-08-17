package com.example.checkout.impl;

import com.example.checkout.core.Checkout;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * SimpleCheckout implements the Checkout interface.
 *
 * This class calculates the total cost of items in the shopping cart.
 * Supports:
 * - Apple BOGO offer (Buy One Get One Free)
 * - Orange 3-for-2 offer
 *
 * Prices are stored in a map for easy extension.
 */
public class SimpleCheckout implements Checkout {

    private static final Map<String, BigDecimal> PRICE_LIST = Map.of(
            "apple", new BigDecimal("0.60"),
            "orange", new BigDecimal("0.25")
    );

    @Override
    public BigDecimal calculateTotal(List<String> items) {
        // Count items by type
        Map<String, Long> itemCounts = items.stream()
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(item -> item, Collectors.counting()));

        BigDecimal total = BigDecimal.ZERO;

        // Apples with BOGO offer
        long appleCount = itemCounts.getOrDefault("apple", 0L);
        long applePayCount = (appleCount / 2) + (appleCount % 2); // pay for half rounded up
        total = total.add(PRICE_LIST.get("apple").multiply(BigDecimal.valueOf(applePayCount)));

        // Oranges with 3-for-2 offer
        long orangeCount = itemCounts.getOrDefault("orange", 0L);
        long orangePayCount = (orangeCount / 3) * 2 + (orangeCount % 3); // 3-for-2
        total = total.add(PRICE_LIST.get("orange").multiply(BigDecimal.valueOf(orangePayCount)));

        return total.setScale(2, BigDecimal.ROUND_HALF_UP); // keep 2 decimal places
    }
}
