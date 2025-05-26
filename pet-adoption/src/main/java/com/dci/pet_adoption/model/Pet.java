package com.dci.pet_adoption.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pet {

    @Id // denotes that the following field is the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // denotes that the database will handle primary key incrementation
    private Long petId;


    @NotBlank(message = "pet name is required")
    @Size(min = 3, max = 255, message = "Name needs to be between 3 and 255 characters")
    private String name;

    @NotBlank(message = "pet breed is required")
    private String breed;


    @Min(value = 0, message = "Pet cannot be below 0")
    @Max(value = 20, message = "Pet cannot be above 20 years old")
    private int age;

    @ManyToOne
    @JoinColumn(name = "adoption_center_id")
    private AdoptionCenter adoptionCenter;


}
