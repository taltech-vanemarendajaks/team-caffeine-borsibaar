package com.borsibaar.repository;

import com.borsibaar.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory, Long> {
    @Query("SELECT i FROM Inventory i JOIN i.product p " +
            "WHERE p.organizationId = :organizationId AND i.productId = :productId")
    Optional<Inventory> findByOrganizationIdAndProductId(@Param("organizationId") Long organizationId,
            @Param("productId") Long productId);

    @Query("SELECT i FROM Inventory i JOIN i.product p WHERE p.organizationId = :organizationId")
    List<Inventory> findByOrganizationId(@Param("organizationId") Long organizationId);

    @Query("SELECT i FROM Inventory i JOIN i.product p " +
            "WHERE p.organizationId = :organizationId AND p.categoryId = :categoryId")
    List<Inventory> findByOrganizationIdAndCategoryId(@Param("organizationId") Long organizationId,
            @Param("categoryId") Long categoryId);

    boolean existsByProductId(Long productId);
}
