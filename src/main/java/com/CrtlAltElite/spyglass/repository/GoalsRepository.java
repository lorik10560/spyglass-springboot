package com.CrtlAltElite.spyglass.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.CrtlAltElite.spyglass.model.*;


@Repository
public interface GoalsRepository extends JpaRepository <Goals,Long>{
	List<Goals> findAll();
	Goals findById(long id);
}
