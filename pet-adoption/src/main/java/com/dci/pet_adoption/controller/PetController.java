package com.dci.pet_adoption.controller;

import com.dci.pet_adoption.model.Pet;
import com.dci.pet_adoption.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;


    @GetMapping
    private String getAllPets(Model model){
        model.addAttribute("pets",petService.findAllPets());

        return "pets/index";
    }


    @GetMapping("/{id}")
    private String getPetById(Model model, @PathVariable Long id){

        model.addAttribute("pet",petService.getPetById(id));

        return "pets/pet-details";
    }

    @GetMapping("/new")
    private String createPet(Model model){
        model.addAttribute("pet",new Pet());

        return "pets/pet-from";
    }




}
