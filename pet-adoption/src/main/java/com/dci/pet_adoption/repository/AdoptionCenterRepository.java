package com.dci.pet_adoption.repository;

import com.dci.pet_adoption.model.AdoptionCenter;
import com.dci.pet_adoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionCenterRepository extends JpaRepository<AdoptionCenter,Long> {
}
