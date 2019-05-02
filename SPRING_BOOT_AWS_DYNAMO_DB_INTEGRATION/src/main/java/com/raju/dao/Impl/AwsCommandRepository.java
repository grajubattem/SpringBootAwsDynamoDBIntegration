package com.raju.dao.Impl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.raju.dao.model.Command;


public class AwsCommandRepository implements ICommandRepository {

    private static final Logger LOG = LoggerFactory.getLogger(AwsCommandRepository.class);

    @Autowired
    private DynamoDBMapper mapper;

    public void save(Command command) {
        mapper.save(command);
    }

    public Command getById(String deviceKey) {
        return mapper.load(Command.class,deviceKey);
    }
    
    public Command getByDeviceId(String deviceId) {
        return mapper.load(Command.class,deviceId);
    }


}

