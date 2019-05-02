package com.raju.dao.Impl;


import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import com.raju.dao.model.Command;

@EnableScan
public interface CommandRepository extends CrudRepository<Command, String> {
    List<Command> findByDeviceKey(String deviceKey);

	List<Command> findByDeviceId(String deviceID);
	
	List<Command> findByCommandId(String commandId);
}
