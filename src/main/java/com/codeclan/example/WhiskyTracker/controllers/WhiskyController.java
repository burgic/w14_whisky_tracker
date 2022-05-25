package com.codeclan.example.WhiskyTracker.controllers;

import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class WhiskyController {

    @Autowired
    WhiskyRepository whiskyRepository;

    @GetMapping(value = "/whisky/year")
    public ResponseEntity<List<Whisky>> getWhiskyByYear(@RequestParam(name = "year", required = false) int year) {

        return new ResponseEntity<>(whiskyRepository.findWhiskyByYear(year), HttpStatus.OK);

    }

    @GetMapping(value = "/whisky")
    public ResponseEntity<List<Whisky>> getByAgeAndDistillery(
            @RequestParam(name = "age", required = false) int age,
            @RequestParam(name = "distillery", required = false) String distillery)
    {
        if (distillery != null) {
            return new ResponseEntity<>(whiskyRepository.findByAgeAndDistilleryName(age, distillery), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(whiskyRepository.findAll(), HttpStatus.OK);
        }
    }
}
