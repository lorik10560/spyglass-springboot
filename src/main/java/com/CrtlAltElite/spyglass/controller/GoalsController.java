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
	
	
	//get all goals for list 
	@GetMapping("goal-list")
	 public List<Goals> getAllGoals(){
		 return goalsRepository.findAll();
	 }
	
	//get goal by id 
	@GetMapping("/goals/{id}")
	public ResponseEntity<Goals> getGoalsById(@PathVariable("id") long id)
	{
		Optional<Goals> goalsData = goalsRepository.findById(id);

	    if (goalsData.isPresent()) 
	    {
	      return new ResponseEntity<>(goalsData.get(), HttpStatus.OK);
	    } 
	    else 
	    {
	      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    }
	}
	 
	 
	 @GetMapping("goals/{id}")
	 public List<Goals> getGoalsById(@PathVariable(value="id") int id) {
		 return goalsRepository.findById(id);
	 }
	 
	 //add a goal

	 @PostMapping("goals/add")
		public ResponseEntity<Goals> createCustomer(@RequestBody Goals goal) 
		{
		    try 
		    {
		    	Goals _goal = goalsRepository.save(new goal (goal.getId(), goal.getDescription(), goal.getPicture(), goal.get()));
		      
		      return new ResponseEntity<>(_goal, HttpStatus.CREATED);
		    } 
		    catch (Exception e) 
		    {
		      return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		    }
		}
	 
	 //update an employee
	 @PutMapping("goals/{id}")
	 public ResponseEntity<Object> updateEmployee(
			 @RequestBody Goals goal, 
			 @PathVariable int id ){
		 Optional<Goals> goalsRepo =
				 Optional.ofNullable(
						 goalsRepository.findById(id));
		 if (!goalsRepo.isPresent())
			 return ResponseEntity.notFound().build();
		 goal.setEmployeeid(id);
		 goalsRepository.save(goal);
		 return ResponseEntity.noContent().build();
	 }

}
