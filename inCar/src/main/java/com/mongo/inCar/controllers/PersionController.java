package com.mongo.inCar.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongo.inCar.models.PersionModel;
import com.mongo.inCar.services.PersionService;
import com.onlineShop.example.commonModel.ServiceOperationResult;
import com.onlineShop.example.commonUtilMethods.FilterParameter;
import com.onlineShop.example.exception.BusinessException;
import com.onlineShop.example.exception.DatabaseException;

@RestController
@RequestMapping("/persion")
public class PersionController {
	
	
	@Autowired
	private PersionService persionService;
	
	
	
	
	
	
	//find by id
	@RequestMapping(value = "/findById/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<PersionModel> findById(@PathVariable("id") Long id)
	{
		ServiceOperationResult<PersionModel> result = new ServiceOperationResult<>();
		try
		{
			result = persionService.getById(id);
		}catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		return result;
	}
	
	//addOrUpdate
	@RequestMapping(value = "/addOrUpdate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<PersionModel> addOrUpdate(@RequestBody PersionModel model)
	{
		ServiceOperationResult<PersionModel> result = new ServiceOperationResult<>();
		try
		{
			result = persionService.addOrUpdate(model);
		}
		catch(DatabaseException ex)
		{
			throw new BusinessException(ex);
		}
		return result;
	}
	
	//getData
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceOperationResult<List<PersionModel>> getAll(@RequestBody FilterParameter filter)
	{
		ServiceOperationResult<List<PersionModel>> result = new ServiceOperationResult<>();
		try
		{
			System.out.println("controller getALL : ");
			result = persionService.getAll(filter);
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}

}
