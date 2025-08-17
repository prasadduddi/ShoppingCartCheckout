package com.example.checkout.impl;

import com.example.checkout.core.Checkout;

import java.math.BigDecimal;
import java.util.List;

public class SimpleCheckout implements Checkout {
    @Override
    public BigDecimal calculateTotal(List<String> items) {
        return items.stream()
                .map(String::toLowerCase)
                .map(item -> switch (item) {
                    case "apple" -> new BigDecimal("0.60");
                    case "orange" -> new BigDecimal("0.25");
                    default -> BigDecimal.ZERO;
                })
                .reduce(new BigDecimal("0.00"), BigDecimal::add);
    }
}
