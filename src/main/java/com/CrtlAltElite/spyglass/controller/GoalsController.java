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
	
//get all goals
	 @GetMapping("goals")
	 public List<Goals> getAllGoals(){
		 return goalsRepository.findAll();
	 }
	
//get goal by id
		 @GetMapping("goals/{id}")
		 public Goals getGoalsById(@PathVariable(value="id") long id) {
			 return goalsRepository.findById(id);
		 }
		 

	

 //add a goal
		
		 @PostMapping("goals/add")
		 @ResponseStatus(HttpStatus.CREATED)
		 public Goals addGoals( @RequestBody Goals goal){
			 return goalsRepository.save(goal);
		 }
	 
	 //update a goal 
//	 @PutMapping("goals/update/{id}")
//	 public ResponseEntity<Object> updateGoals(
//			 @RequestBody Goals goal, 
//			 @PathVariable long id ){
//		 Optional<Goals> goalsRepository =
//				 Optional.ofNullable(
//						 goalsRepository.findById(id));
//		 if (!goalsRepository.isPresent())
//			 return ResponseEntity.notFound().build();
//		 goal.setId(id);
//		 goalsRepository.save(goal);
//		 return ResponseEntity.noContent().build();
//	 }
	 @PutMapping("goals/update/{id}")
		public ResponseEntity<Goals> updateGoals(@PathVariable(value="id") Long id, @RequestBody Goals goalDetails) {
			Optional<Goals> optional = goalsRepository.findById(id);
			Goals goal = null;
			if (optional.isPresent()) {
				goal = optional.get();
				goal.setId(goalDetails.getId());
				goal.setName(goalDetails.getName());
				goal.setDescription(goalDetails.getDescription());
				goal.setPicture(goalDetails.getPicture());
				goal.setTargetDate(goalDetails.getTargetDate());
				goal.setTargetAmount(goalDetails.getTargetAmount());
				goal.setCurrentAmount(goalDetails.getCurrentAmount());	 
	 
//				Goals updateGoals = goalsRepository.save(goal);
				return new ResponseEntity<>(goalsRepository.save(goal),HttpStatus.OK);
			} else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		}
	 //delete goals
	 @DeleteMapping("goals/delete/{id}")
		public ResponseEntity<HttpStatus> deleteGoal(@PathVariable(value="id") Long id) {
			try {
				goalsRepository.deleteById(id);
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			} catch (Exception e) {
				return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}

}
