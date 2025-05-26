package com.dci.pet_adoption.service;

import com.dci.pet_adoption.model.AdoptionCenter;
import com.dci.pet_adoption.repository.AdoptionCenterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionCenterService {

    private final AdoptionCenterRepository adoptionCenterRepository;

    public List<AdoptionCenter> findAllAdoptionCenters(){
        return adoptionCenterRepository.findAll();
    }
}
