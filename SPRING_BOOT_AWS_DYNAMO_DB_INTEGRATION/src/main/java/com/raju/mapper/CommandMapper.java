package com.raju.mapper;

import org.springframework.stereotype.Component;

import com.raju.dao.model.Command;
import com.raju.dto.CommandResponseItem;

@Component
public class CommandMapper {

    public CommandResponseItem mapToCommandResponseItem(Command command){
        CommandResponseItem item = new CommandResponseItem();
        item.setCommandId(command.getCommandId());
        // item.setFileType(command.getFileType()); we need to look up the string representation of the filetype int
        item.setOnboardCommandId(command.getOnboardCommandId());
        item.setStatus(command.getStatus().toString());

        return item;
    }
}
