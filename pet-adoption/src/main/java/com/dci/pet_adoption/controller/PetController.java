package com.dci.pet_adoption.controller;

import com.dci.pet_adoption.model.Pet;
import com.dci.pet_adoption.service.AdoptionCenterService;
import com.dci.pet_adoption.service.PetService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;
    private final AdoptionCenterService adoptionCenterService;


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
        model.addAttribute("adoptionCenters", adoptionCenterService.findAllAdoptionCenters());

        return "pets/pet-form";
    }


    @PostMapping("/save")
    private String postPet(@Valid @ModelAttribute Pet pet, BindingResult bindingResult, Model model){

        if(bindingResult.hasErrors()){
            model.addAttribute("pet",pet);
            return "pet/pet-form";
        }
        Pet createdPet = petService.createNewPet(pet);

        return "redirect:/pets/" + createdPet.getPetId();
    }


    @GetMapping("/update/{id}")
    private String updatePetForm(Model model, @PathVariable Long id){
        model.addAttribute("pet",petService.getPetById(id));

        return "pets/pet-form";
    }

    @PostMapping("/update")
    public String updatePet(@ModelAttribute Pet pet ,Model model){

        petService.updatePet(pet);

        return "redirect:/pets";
    }


    @GetMapping("/delete/{id}")
    public String deletePet(@PathVariable Long id){

        petService.deletePetById(id);

        return "redirect:/pets";
    }



}
