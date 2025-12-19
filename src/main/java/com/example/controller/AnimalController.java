package com.example.controller;

import com.example.model.Animal;
import com.example.repositories.AnimalCustomRepository;
import com.example.repositories.AnimalRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalRepository animalRepository;
    private final AnimalCustomRepository animalCustomRepository;

    public AnimalController(AnimalRepository  animalRepository, AnimalCustomRepository animalCustomRepository) {
        this.animalRepository = animalRepository;
        this.animalCustomRepository = animalCustomRepository;
    }

    @PostMapping
    public ResponseEntity<Animal> createAnimal(@RequestBody Animal animal) {
        Animal saved = animalRepository.save(animal);
        return ResponseEntity.ok(saved);
    }

    @GetMapping
    public ResponseEntity<List<Animal>> getAllAnimals() {
        List<Animal> animals = animalRepository.findAll();
        return ResponseEntity.ok(animals);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Animal> getAnimalById(@PathVariable Long id) {
        return animalRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/count/{category}")
    public ResponseEntity<Integer> countByCategory(@PathVariable String category) {
        int count = animalCustomRepository.countAnimalsByCategory(category);
        return ResponseEntity.ok(count);
    }

    @PostMapping("/uppercase/{category}")
    public ResponseEntity<String> uppercaseNamesByCategory(@PathVariable String category) {
        animalCustomRepository.uppercaseNamesForCategory(category);
        return ResponseEntity.ok("Names updated to UPPERCASE for category: " + category);
    }
}
