package com.example.checkout.impl;

import com.example.checkout.core.Checkout;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class SimpleCheckout implements Checkout {

    private static final Map<String, BigDecimal> PRICE_LIST = Map.of(
            "apple", new BigDecimal("0.60"),
            "orange", new BigDecimal("0.25")
    );

    @Override
    public BigDecimal calculateTotal(List<String> items) {
        return items.stream()
                .map(String::toLowerCase)
                .map(item -> PRICE_LIST.getOrDefault(item, BigDecimal.ZERO))
                .reduce(new BigDecimal("0.00"), BigDecimal::add);
    }
}
