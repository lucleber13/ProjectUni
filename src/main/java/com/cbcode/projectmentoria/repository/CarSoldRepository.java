package com.cbcode.projectmentoria.repository;

import com.cbcode.projectmentoria.model.CarSold;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarSoldRepository extends CrudRepository<CarSold, Long> {

    @Query(value = "select m from CarSold m where upper(trim(m.model)) like '%?1%'")
    List<CarSold> findByModel(String model);

    @Query(value = "select rn from CarSold rn where rn.regNumber = ?1")
    List<CarSold> findByRegNumber(String regNumber);

    @Query(value = "select vc from CarSold vc where vc.vehicleCode = ?1")
    List<CarSold> findByVehicleCode(String vehicleCode);
}
