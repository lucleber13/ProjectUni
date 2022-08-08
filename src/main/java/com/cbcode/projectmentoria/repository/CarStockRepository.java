package com.cbcode.projectmentoria.repository;

import com.cbcode.projectmentoria.model.CarStock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarStockRepository extends CrudRepository<CarStock, Long> {

    @Query(value = "select m from CarStock m where upper(trim(m.model)) like '%?!%' ")
    List<CarStock> findByModel(String model);

    @Query(value = "select rn from CarStock rn where rn.regNumber = ?1")
    List<CarStock> findByRegNumber(String regNumber);
}
