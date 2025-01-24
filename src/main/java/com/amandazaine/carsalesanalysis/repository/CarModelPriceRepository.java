package com.amandazaine.carsalesanalysis.repository;

import com.amandazaine.carsalesanalysis.entity.CarModelPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarModelPriceRepository extends JpaRepository<CarModelPriceEntity, Long> {

}
