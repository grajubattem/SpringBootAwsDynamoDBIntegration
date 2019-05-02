package com.raju.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.raju.dao.Impl.CommandRepository;
import com.raju.dao.model.Command;

@RestController
@RequestMapping(value="commandManagement")
public class CommandControllers {

	@Autowired
	private CommandRepository commandRepository;
 
	@RequestMapping(value = "command", method = RequestMethod.GET)
	public String getCommand() {

		Command c = commandRepository.findByDeviceKey("10000").get(0);

		return "Get command outputs{" + c.getDeviceKey() + "}=" + c.getCommandId();
	}
	
	@RequestMapping(value = "getMultipleCommandsByDeviceKey/{deviceKey}", method = RequestMethod.GET)
	public List<Command> getMultipleCommandByDeviceKey(@PathVariable String deviceKey) {
		List<Command> commands = commandRepository.findByDeviceKey(deviceKey);
		return commands;//make 
	}
	
	@RequestMapping(value = "getMultipleCommandsByDeviceID/{deviceID}", method = RequestMethod.GET)
	public List<Command> getMultipleCommandByDeviceID(@PathVariable String deviceID) {
		List<Command> commands = commandRepository.findByDeviceId(deviceID);
		return commands;//make 
	}

	@RequestMapping(value = "getMultipleCommandsByCommandId/{commandId}", method = RequestMethod.GET)
	public List<Command> getMultipleCommandByCommandId(@PathVariable String commandId) {
		List<Command> commands = commandRepository.findByCommandId(commandId);
		return commands;//make 
	}

	@RequestMapping(value = "createCommand", method = RequestMethod.GET)
	public String createCommand() {

		Command command = new Command();
		command.setDeviceKey("45");
		command.setCommandId(UUID.randomUUID().toString());
		command.setCommandBody("{}");

		commandRepository.save(command);

		return "create command outputs";
	}
}
