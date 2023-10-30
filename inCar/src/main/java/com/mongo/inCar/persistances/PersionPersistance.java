package com.mongo.inCar.persistances;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mongo.inCar.entities.PersionEntity;
import com.mongo.inCar.repositories.PlayerRepository;

@Component
//@Transactional()
public class PersionPersistance {
	
	
	@Autowired
	private PlayerRepository playerRepository;
	
	
	//find by id
	public Optional<PersionEntity> findById(Long id)
	{
		
		System.out.println("Database data is coming : ");
		return playerRepository.findById(id);
	}
	
	//save 
	public PersionEntity save(PersionEntity entity)
	{
		return playerRepository.save(entity);
	}
	
	//count
//	public Long count(Example<PersionEntity> exam)
//	{
//		return playerRepository.count(exam);
//	}
	
	public Long count()
	{
		return playerRepository.count();
	}
	
	//findAll
	public List<PersionEntity> findAll()
	{
		return playerRepository.findAll();
	}
	
	
	//find by page
//	public List<PersionEntity> findAll(Example<PersionEntity> ex, Pageable page)   //Specification<PersionEntity>
//	{
//		return playerRepository.findAll(ex, page).getContent();
//	}
	
	public List<PersionEntity> findAll(Pageable page)   //Specification<PersionEntity>
	{
		System.out.println("persistance getALL");
		return playerRepository.findAll(page).getContent();
	}

}
