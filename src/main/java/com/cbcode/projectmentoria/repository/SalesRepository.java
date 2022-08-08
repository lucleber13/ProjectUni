package com.cbcode.projectmentoria.repository;

import com.cbcode.projectmentoria.model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales, Long> {

}
