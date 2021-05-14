package com.CrtlAltElite.spyglass.controller;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.CrtlAltElite.spyglass.model.*;
import com.CrtlAltElite.spyglass.repository.*;




@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/")

public class GoalsController {
	
	@Autowired
	GoalsRepository goalsRepository;
	
//get goal by id
		 @GetMapping("goals/{id}")
		 public Goals getGoalsById(@PathVariable(value="id") long id) {
			 return goalsRepository.findById(id);
		 }
		 
//get all goals
		 @GetMapping("goal-list")
		 public List<Goals> getAllGoals(){
			 return goalsRepository.findAll();
		 }
	

 //add a goal
		
		 @PostMapping("goals/add")
		 @ResponseStatus(HttpStatus.CREATED)
		 public Goals addGoals( @RequestBody Goals goal){
			 return goalsRepository.save(goal);
		 }
	 
	 //update a goal 
	 @PutMapping("goals/update/{id}")
	 public ResponseEntity<Object> updateGoals(
			 @RequestBody Goals goal, 
			 @PathVariable long id ){
		 Optional<Goals> goalsRepository =
				 Optional.ofNullable(
						 goalsRepository.findById(id));
		 if (!goalsRepository.isPresent())
			 return ResponseEntity.notFound().build();
		 goal.setId(id);
		 goalsRepository.save(goal);
		 return ResponseEntity.noContent().build();
	 }

}
