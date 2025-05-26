package com.dci.pet_adoption.service;

import com.dci.pet_adoption.exception.ResourceNotFoundException;
import com.dci.pet_adoption.model.Pet;
import com.dci.pet_adoption.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // registers this class a spring bean
@RequiredArgsConstructor
public class PetService {

    private final PetRepository petRepository;

    public List<Pet> findAllPets(){
        return petRepository.findAll();
    }

    public Pet getPetById(Long id){

        return petRepository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("Pet not found with id " + id));
    }


    public Pet createNewPet(Pet pet){


        return petRepository.save(pet);
    }


    public Pet updatePet(Pet pet){

        getPetById(pet.getPetId());

        return petRepository.save(pet);

    }


    public void deletePetById(Long id){
        petRepository.deleteById(id);
    }

}
