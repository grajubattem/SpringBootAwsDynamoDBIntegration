package com.raju.test.mapper;


import org.junit.Assert;
import org.junit.Test;

import com.raju.dao.model.Command;
import com.raju.dto.CommandResponseItem;
import com.raju.mapper.CommandMapper;

import java.util.UUID;

public class CommandMapperTest {
    @Test
    public void testMapToCommandResponseItem(){

        Command c = new Command();
        c.setCommandId(UUID.randomUUID().toString());
        c.setStatus(1);
        c.setOnboardCommandId(8);

        CommandMapper mapper = new CommandMapper();
        CommandResponseItem cri = mapper.mapToCommandResponseItem(c);

        Assert.assertEquals(c.getCommandId(), cri.getCommandId());
        Assert.assertEquals("1", cri.getStatus());
        Assert.assertEquals(new Integer(8), cri.getOnboardCommandId());
    }
}
