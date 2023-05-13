package com.api.parkingcontrol.services;


// import java.util.Optional;
// import java.util.UUID;

// import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
// import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import com.api.parkingcontrol.models.ParkingSpotModel;
import com.api.parkingcontrol.repositories.ParkingSpotRepository;

import jakarta.transaction.Transactional;

@Service
public class ParkingSpotService {
    
    
    final ParkingSpotRepository parkingSpotRepository;

    public ParkingSpotService(ParkingSpotRepository parkingSpotRepository) {
        this.parkingSpotRepository = parkingSpotRepository;
    }

    @Transactional
    public ParkingSpotModel save(ParkingSpotModel parkingSpotModel) {
        return parkingSpotRepository.save(parkingSpotModel);
    }

    public boolean existsByParkingSpotNumber(Object parkingSpotNumber) {
        return parkingSpotRepository.existsByParkingSpotNumber(parkingSpotNumber);
    }

    public boolean existsByLicensePlateCar(Object licensePlateCar) {
        return parkingSpotRepository.existsByLicensePlateCar(licensePlateCar);
    }

    public boolean existsByApartmentAndBlock(Object apartment, Object block) {
        return parkingSpotRepository.existsByApartmentAndBlock(apartment, block);
    }

    // public Page<ParkingSpotModel> findAll(Pageable pageable){
    //     return parkingSpotRepository.findAll(pageable);
    // }

    // public Optional<ParkingSpotModel> findById(UUID id) {
    //     return parkingSpotRepository.findById(id);
    // }

    // @Transactional
    // public void delete(ParkingSpotModel parkingSpotModel) {
    //     parkingSpotRepository.delete(parkingSpotModel);
    // }
}
