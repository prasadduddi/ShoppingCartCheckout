package com.example.checkout.core;

import java.math.BigDecimal;
import java.util.List;

public interface Checkout {
    BigDecimal calculateTotal(List<String> items);
}