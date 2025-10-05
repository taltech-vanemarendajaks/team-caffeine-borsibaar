package com.borsibaar.backend.dto;

import java.math.BigDecimal;

public record InventoryTransactionResponseDto(
        Long id,
        Long inventoryId,
        String transactionType,
        BigDecimal quantityChange,
        BigDecimal quantityBefore,
        BigDecimal quantityAfter,
        String referenceId,
        String notes,
        String createdBy,
        String createdByName,
        String createdByEmail,
        String createdAt
) {}
