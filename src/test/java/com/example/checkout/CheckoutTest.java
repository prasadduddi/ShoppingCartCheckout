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

    @Test
    void singleAppleShouldCostSixtyPence() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple"));
        assertEquals(new BigDecimal("0.60"), total);
    }

    @Test
    void twoApplesShouldCostOneTwenty() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple", "Apple"));
        assertEquals(new BigDecimal("1.20"), total);
    }

    @Test
    void singleOrangeShouldCostTwentyFivePence() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Orange"));
        assertEquals(new BigDecimal("0.25"), total);
    }
}