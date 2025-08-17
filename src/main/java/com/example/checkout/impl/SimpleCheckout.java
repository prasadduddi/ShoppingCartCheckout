package com.example.checkout.impl;

import com.example.checkout.core.Checkout;

import java.math.BigDecimal;
import java.util.List;

public class SimpleCheckout implements Checkout {
    @Override
    public BigDecimal calculateTotal(List<String> items) {
        return new BigDecimal("0.00");
    }
}
