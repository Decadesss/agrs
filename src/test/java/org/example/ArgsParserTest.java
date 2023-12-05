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
    public void given_p_and_l_when_parse_return_port_and_logging(){
        //Arrange
        String args = "-l -p 8080";

        //Act
        Schema schema = ArgsParser.parse(args);

        //Assert
        assertNotNull(schema);

        Flag logFlag = schema.getFlagByName("l");
        assertNotNull(logFlag);
        Flag portFlag = schema.getFlagByName("p");
        assertNotNull(portFlag);

        assertEquals(logFlag.getValue(), "true");
        assertEquals(portFlag.getValue(), "8080");
    }

    @Test
    public void given_p_and_l_and_d_when_parse_return_port_and_logging(){
        //Arrange
        String args = "-l -p 8080 -d /usr/logs";

        //Act
        Schema schema = ArgsParser.parse(args);

        //Assert
        assertNotNull(schema);

        Flag logFlag = schema.getFlagByName("l");
        assertNotNull(logFlag);
        Flag portFlag = schema.getFlagByName("p");
        assertNotNull(portFlag);
        Flag directoryFlag = schema.getFlagByName("d");
        assertNotNull(directoryFlag);

        assertEquals(logFlag.getValue(), "true");
        assertEquals(portFlag.getValue(), "8080");
        assertEquals(directoryFlag.getValue(), "/usr/logs");
    }

    @Test
    public void given_p_and_d_when_no_value_return_default_value(){
        //Arrange
        String args = "-p -d";

        //Act
        Schema schema = ArgsParser.parse(args);

        //Assert
        assertNotNull(schema);

        Flag logFlag = schema.getFlagByName("l");
        assertNotNull(logFlag);
        Flag portFlag = schema.getFlagByName("p");
        assertNotNull(portFlag);
        Flag directoryFlag = schema.getFlagByName("d");
        assertNotNull(directoryFlag);

        assertEquals(logFlag.getValue(), "false");
        assertEquals(portFlag.getValue(), "666");
        assertEquals(directoryFlag.getValue(), "/usr/default");
    }
}