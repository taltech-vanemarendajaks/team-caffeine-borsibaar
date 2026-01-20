package com.borsibaar.dto;

import java.math.BigDecimal;

public record InventoryResponseDto(
        Long id,
        Long productId,
        String productName,
        BigDecimal quantity,
        BigDecimal unitPrice,
        String description,
        BigDecimal basePrice,
        BigDecimal minPrice,
        BigDecimal maxPrice,
        String updatedAt) {
}
