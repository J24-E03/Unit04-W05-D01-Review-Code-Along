package com.dci.pet_adoption.repository;

import com.dci.pet_adoption.model.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // registers this class a spring bean
public interface PetRepository extends JpaRepository<Pet,Long> {
}
