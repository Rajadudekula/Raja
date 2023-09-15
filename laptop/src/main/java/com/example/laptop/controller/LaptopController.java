package com.example.laptop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.laptop.entity.Laptop;
import com.example.laptop.repo.LaptopRepo;

@RestController
public class LaptopController {
	@Autowired
	LaptopRepo laptopRepo;

	@PostMapping("/saveLap")
	public Laptop saveLap(@RequestBody Laptop lap) {
		return laptopRepo.save(lap);
	}
	
	
	public Laptop updateLaptop(@PathVariable Integer id,@RequestBody Laptop lap)
	{
		Laptop laptop1= laptopRepo.findById(id).get();
		laptop1.setName(lap.getName());
		laptopRepo.save(laptop1);
		return laptop1;
		
	}
	
}
