package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArgsParserTest {

    @Test
    public void given_l_when_parse_return_logging_is_ture(){
        //Arrange
        String args = "-l";

        //Act
        Schema schema = ArgsParser.parse(args);

        //Assert
        assertNotNull(schema);
        Flag flag = schema.getFlagByName("l");
        assertNotNull(flag);
        assertEquals(flag.getValue(), "true");
    }

    @Test
    public void given_empty_when_parse_return_logging_is_false(){
        //Arrange
        String args = "";

        //Act
        Schema schema = ArgsParser.parse(args);

        //Assert
        assertNotNull(schema);
        Flag flag = schema.getFlagByName("l");
        assertNotNull(flag);
        assertEquals(flag.getValue(), "false");
    }

    @Test
    public void given_p_when_parse_return_port_and_logging(){
        //Arrange
        String args = "-p 8080";

        //Act
        Schema schema = ArgsParser.parse(args);

        //Assert
        assertNotNull(schema);

        Flag logFlag = schema.getFlagByName("l");
        assertNotNull(logFlag);
        Flag portFlag = schema.getFlagByName("p");
        assertNotNull(portFlag);

        assertEquals(logFlag.getValue(), "false");
        assertEquals(portFlag.getValue(), "8080");
    }
}