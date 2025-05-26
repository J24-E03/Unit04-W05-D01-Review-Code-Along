package com.dci.pet_adoption.controller;

import com.dci.pet_adoption.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;



}
