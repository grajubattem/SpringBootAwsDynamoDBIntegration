package com.raju;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.model.CreateTableRequest;
import com.amazonaws.services.dynamodbv2.model.ProvisionedThroughput;
import com.amazonaws.services.dynamodbv2.model.ResourceInUseException;
import com.raju.dao.Impl.CommandRepository;
import com.raju.dao.model.Command;

@SpringBootApplication
@RestController
public class springApp {
	    
	@Autowired
	private CommandRepository commandRepository;
	
	private DynamoDBMapper dynamoDBMapper;

    @Autowired
    private AmazonDynamoDB amazonDynamoDB;
    

	@GetMapping("/test")
	public String hello() {
		return "This is sample Spring-boot Application";
	}

	public static void main(String[] args) {
		SpringApplication.run(springApp.class, args);
	}
	
	@PostConstruct
	public void init() {
		createCommandTable();
		testDataForCommand();
	}
	
	public void createCommandTable(){
        try {
            dynamoDBMapper = new DynamoDBMapper(amazonDynamoDB);
           //dynamoDBMapper.
            CreateTableRequest tableRequest = dynamoDBMapper.generateCreateTableRequest(Command.class);
            tableRequest.setProvisionedThroughput(new ProvisionedThroughput(1L, 1L));
            amazonDynamoDB.createTable(tableRequest);
        } catch (ResourceInUseException e) {
            
        }
	}
	
	private void testDataForCommand() {
		
		Command command3 = new Command();
		command3.setDeviceKey("8000");
		command3.setCommandId("10");
		command3.setTransactionId("400");
		command3.setCommandBody("{45 DeviceKey - Its Working}");
		commandRepository.save(command3);	
		
		Command command4 = new Command();
		command4.setDeviceKey("8000");
		command4.setCommandId("15");
		command4.setTransactionId("500");
		command4.setCommandBody("{45 DeviceKey - Its Failure}");
		commandRepository.save(command4);	
		
		Command command8 = new Command();
		command8.setDeviceKey("9000");
		command8.setCommandId("18");
		command8.setTransactionId("800");
		command8.setCommandBody("{46 DeviceKey - Its Failure}");
		commandRepository.save(command8);
		

		Command command9 = new Command();
		command9.setDeviceKey("10000");
		command9.setCommandId("18");
		command9.setTransactionId("800");
		command9.setCommandBody("{47 DeviceKey - Its Success}");
		commandRepository.save(command9);
		
		
		Command command6 = new Command();
		command6.setDeviceId("1010");
		command6.setCommandBody("{45 DeviceKey - Its Device Lost}");
		command6.setStatus(205);
		commandRepository.save(command6);
		
		Command command7 = new Command();
		command7.setDeviceId("1010");
		command7.setCommandBody("{45 DeviceKey - Its Device Lost}");
		command7.setStatus(206);
		commandRepository.save(command7);
		
		
	}

}
