package com.example.productmsdemo.repository;

import com.example.productmsdemo.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findById(Long id);
    @Modifying
    @Query(value = "update products set count = count - :count  where id=:id", nativeQuery = true)
    void decreaseCountById(@Param(value = "id") Long id,@Param(value = "count") int count);

    @Modifying
    @Query(value = "update products set count = count + :count where id=:id", nativeQuery = true)
    void increaseCountById(@Param(value = "id") Long id, @Param(value = "count") int count);

    List<Product> findAll();

    void deleteById(Long id);

    void deleteAll();


}
