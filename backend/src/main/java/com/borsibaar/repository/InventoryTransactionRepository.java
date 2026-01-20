package com.borsibaar.repository;

import com.borsibaar.entity.InventoryTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryTransactionRepository extends JpaRepository<InventoryTransaction, Long> {

    List<InventoryTransaction> findByInventoryIdOrderByCreatedAtDesc(Long inventoryId);

    Optional<InventoryTransaction> findFirstByInventoryIdOrderByCreatedAtDesc(Long inventoryId);

    List<InventoryTransaction> findByReferenceId(String referenceId);

    @Query("""
            SELECT it FROM InventoryTransaction it
            JOIN it.inventory i
            JOIN i.product p
            WHERE p.organizationId = :organizationId
            AND it.transactionType = 'SALE'
            ORDER BY it.createdAt DESC
            """)
    List<InventoryTransaction> findSaleTransactionsByOrganizationId(@Param("organizationId") Long organizationId);

    @Query(value = """
              SELECT DISTINCT p.organizationId
              FROM InventoryTransaction it
              JOIN it.inventory i
              JOIN i.product p
              WHERE it.transactionType = 'SALE'
                AND it.createdAt >= (CURRENT_TIMESTAMP - 60 SECOND)
            """)
    List<Long> findOrganizationIdsWithSalesInLastMinute();
}
