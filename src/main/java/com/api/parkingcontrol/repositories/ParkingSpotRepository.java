package com.api.parkingcontrol.repositories;

import java.util.UUID;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
// import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.ParkingSpotModel;

// @Repository
public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

    boolean existsByLicensePlateCar(Object licensePlateCar);

    boolean existsByParkingSpotNumber(Object parkingSpotNumber);

    boolean existsByApartmentAndBlock(Object apartment, Object block);

    // Page<ParkingSpotModel> findAll(Pageable pageable);
}
