package com.mongo.inCar.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.aggregation.ArithmeticOperators.Integral;
import org.springframework.stereotype.Service;

import com.mongo.inCar.entities.PersionEntity;
import com.mongo.inCar.models.PersionModel;
import com.mongo.inCar.persistances.PersionPersistance;
import com.onlineShop.example.commonModel.DatabaseOperationResult;
import com.onlineShop.example.commonModel.ErrorParameter;
import com.onlineShop.example.commonModel.PaginationAttribute;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.CommonConstant;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.commonUtilMethods.FilterUtil;
import com.onlineShop.example.commonUtilMethods.SearchCriteria;
import com.onlineShop.example.commonUtilMethods.SearchOperation;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

@Service
public class PersionService {
	
	
	@Autowired
	private PersionPersistance persionPersistance;
	
	
	
	
	//get by id
	@Cacheable(value = "Persion", key="#id")
	public ServiceOperationResult<PersionModel> getById(Long id)
	{
		ServiceOperationResult<PersionModel> response = new ServiceOperationResult<>();
		try
		{
			if(id == null)
			{
				ErrorParameter err = new ErrorParameter();
				err.setErrCode("404");
				err.setErrDesc("Id must not be null : ");
				response.setErrParam(err);
				return response;
			}
			Optional<PersionEntity> en = persionPersistance.findById(id);
			if(en.isPresent())
			{
				PersionEntity entity = en.get();
				PersionModel model = new PersionModel();
				model.setId(entity.getId());
				model.setName(entity.getName());
				model.setCity(entity.getCity());
				model.setCollege(entity.getCollege());
				
				response.setResponse(model);
				
			}
			
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
		return response;
	}
	//get all
	//@Cacheable(value = "Persion")
	public ServiceOperationResult<List<PersionModel>> getAll(FilterParameter filter)
	{
		ServiceOperationResult<List<PersionModel>> response = new ServiceOperationResult<>();
		try
		{
			List<PersionModel> list = new ArrayList<>();
			DatabaseOperationResult<List<PersionEntity>> entities = dataFromDb(filter);
			
			
			for(PersionEntity entity : entities.getModelOrEntity())
			{
				PersionModel model = new  PersionModel();
				
				model.setId(entity.getId());
				model.setName(entity.getName());
				model.setCity(entity.getCity());
				model.setCollege(entity.getCollege());
				
				list.add(model);
			}
			System.out.println("service getAll : ");
			response.setPageAttribute(entities.getPageAttribute());
			response.setResponse(list);
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return response;
	}
	
	//data from database
	public DatabaseOperationResult<List<PersionEntity>> dataFromDb(FilterParameter filter)
	{
		DatabaseOperationResult<List<PersionEntity>> dbList = new DatabaseOperationResult<>();
		
		List<PersionEntity> modelOrEntity = new ArrayList<>();
		
		//pagination
		Integer showRecornOnOnePage = filter.getRecordToShowOnOnePage() == null ? CommonConstant.REC_PER_PG : filter.getRecordToShowOnOnePage();
		
		Integer from = filter.getPageIndex();
		Integer to = showRecornOnOnePage;
		Long totalRecord = filter.getRecordTotal();
		
		// filters
		String id = filter.getId();
		String name = filter.getName();
		
		List<SearchCriteria> list = new ArrayList<>();
		
		if(StringUtils.isNoneBlank(id))
		{
			list.add(new SearchCriteria("id", id, SearchOperation.EQUAL));
		}
		if(StringUtils.isNoneBlank(name))
		{
			list.add(new SearchCriteria("name", name, SearchOperation.MATCH));
		}
		
		//FilterUtil<PersionEntity> filterutil = new FilterUtil<>();
		if(totalRecord == null)
		{
			totalRecord = persionPersistance.count();
		}
		
		if(from != null && to != null)
		{
			Pageable page = PageRequest.of(from, to, Sort.by(Sort.Direction.DESC, "id"));
			modelOrEntity = persionPersistance.findAll(page);
		}
		
		
		
		
		PaginationAttribute pageAttr = dbList.getPageAttribute();
		pageAttr.setPageIndex(filter.getPageIndex());
		pageAttr.setTotalPages((int) Math.ceil(totalRecord.intValue() * 1.0 / showRecornOnOnePage));
		pageAttr.setFetchrecords(modelOrEntity.size());
		pageAttr.setShowRecordOnOnePage(showRecornOnOnePage);
		pageAttr.setTotalRecords(totalRecord);
		dbList.setModelOrEntity(modelOrEntity);
		
		return dbList;
	}
	
	
	// add or update 
	public ServiceOperationResult<PersionModel> addOrUpdate(PersionModel model)
	{
		ServiceOperationResult<PersionModel> response = new ServiceOperationResult<>();
		
		try
		{
			Long id = model.getId();
			if(id != null)
			{
				Optional<PersionEntity> ent = persionPersistance.findById(id);
				if(ent.isPresent())
				{
					PersionEntity entity = ent.get();
					entity.setId(id);
					entity.setName(model.getName() != null ? model.getName() : entity.getName());
					entity.setCity(model.getCity() != null ? model.getCity() : entity.getCity());
					entity.setCollege(model.getCollege() != null ? model.getCollege() : entity.getCollege());
					
					 persionPersistance.save(entity);
				}
			}
			else
			{
				PersionEntity entity = new PersionEntity();
				
				entity.setId(4);
				entity.setName(model.getName() != null ? model.getName() : null);
				entity.setCity(model.getCity() != null ? model.getCity() : null);
				entity.setCollege(model.getCollege() != null ? model.getCollege() : null);
				
				persionPersistance.save(entity);
			}

			response.setResponse(model);
			
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		
				return response;
	}

}
