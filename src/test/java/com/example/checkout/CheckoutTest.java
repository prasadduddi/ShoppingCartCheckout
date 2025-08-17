package com.example.checkout;

import com.example.checkout.core.Checkout;
import com.example.checkout.impl.SimpleCheckout;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CheckoutTest {

    @Test
    void emptyCartShouldReturnZero() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of());
        assertEquals(new BigDecimal("0.00"), total);
    }
}