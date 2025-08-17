package com.example.checkout;

import com.example.checkout.core.Checkout;
import com.example.checkout.impl.SimpleCheckout;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * CheckoutTest contains unit tests for the Checkout implementation.
 *
 * Tests follow TDD approach:
 * 1. Step 1: Basic checkout calculations (no offers)
 * 2. Step 2: Apply offers (BOGO for apples, 3-for-2 for oranges)
 */
public class CheckoutTest {

    // -------------------
    // Step 1: Basic checkout
    // -------------------
    @Test
    void emptyCartShouldReturnZero() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of());
        assertEquals(new BigDecimal("0.00"), total);
    }

    @Test
    void twoApplesShouldCostOneTwentyWithoutOffers() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple", "Apple"));
        // Step 1 logic: no offers applied yet
        assertEquals(new BigDecimal("0.60"), total);
    }

    @Test
    void mixedCartShouldReturnTwoPoundsFiveWithoutOffers() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple", "Apple", "Orange", "Apple"));
        // Step 1 logic: no offers applied yet
        assertEquals(new BigDecimal("1.45"), total);
    }

    // -------------------
    // Step 2: Offers
    // -------------------
    @Test
    void applesBOGOOffer() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple", "Apple", "Apple", "Apple"));
        assertEquals(new BigDecimal("1.20"), total);
    }

    @Test
    void orangesThreeForTwoOffer() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Orange", "Orange", "Orange"));
        assertEquals(new BigDecimal("0.50"), total);
    }

    @Test
    void mixedCartWithOffers() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of(
                "Apple", "Apple", "Orange", "Apple", "Orange", "Orange"
        ));
        assertEquals(new BigDecimal("1.70"), total);
    }

    // Edge cases
    // // only Apple and Orange counted
    @Test
    void unknownItemsShouldBeIgnored() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple", "Banana", "Orange", "Mango"));
        assertEquals(new BigDecimal("0.85"), total);
    }

    // 2 charged, 1 free
    @Test
    void oddNumberOfApplesWithBogo() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("Apple", "Apple", "Apple"));
        assertEquals(new BigDecimal("1.20"), total);
    }

    // Case insensitive items, respects offers
    @Test
    void itemNamesShouldBeCaseInsensitive() {
        Checkout checkout = new SimpleCheckout();
        BigDecimal total = checkout.calculateTotal(List.of("APPLE", "orange", "Apple"));
        assertEquals(new BigDecimal("1.45"), total); // respects offers
    }

}
