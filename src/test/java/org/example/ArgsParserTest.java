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
        ArgsParseResult argsParseResult = ArgsParser.parse(args);

        //Assert
        assertNotNull(argsParseResult);
        Flag<?> flag = argsParseResult.getFlagByName("l");
        assertNotNull(flag);
        assertEquals(flag.getValue(), true);
    }

    @Test
    public void given_empty_when_parse_return_all_default(){
        //Arrange
        String args = "";

        //Act
        ArgsParseResult argsParseResult = ArgsParser.parse(args);

        //Assert
        Flag<?> logFlag = argsParseResult.getFlagByName("l");
        assertNotNull(logFlag);
        Flag<?> portFlag = argsParseResult.getFlagByName("p");
        assertNotNull(portFlag);
        Flag<?> directoryFlag = argsParseResult.getFlagByName("d");
        assertNotNull(directoryFlag);

        assertEquals(logFlag.getValue(), false);
        assertEquals(portFlag.getValue(), 0);
        assertEquals(directoryFlag.getValue(), "");
    }

    @Test
    public void given_p_and_l_when_parse_return_port_and_logging(){
        //Arrange
        String args = "-l -p 8080";

        //Act
        ArgsParseResult argsParseResult = ArgsParser.parse(args);

        //Assert
        assertNotNull(argsParseResult);

        Flag<?> logFlag = argsParseResult.getFlagByName("l");
        assertNotNull(logFlag);
        Flag<?> portFlag = argsParseResult.getFlagByName("p");
        assertNotNull(portFlag);

        assertEquals(logFlag.getValue(), true);
        assertEquals(portFlag.getValue(), 8080);
    }

    @Test
    public void given_p_and_l_and_d_when_parse_return_port_and_logging(){
        //Arrange
        String args = "-l -p 8080 -d /usr/logs";

        //Act
        ArgsParseResult argsParseResult = ArgsParser.parse(args);

        //Assert
        assertNotNull(argsParseResult);

        Flag<?> logFlag = argsParseResult.getFlagByName("l");
        assertNotNull(logFlag);
        Flag<?> portFlag = argsParseResult.getFlagByName("p");
        assertNotNull(portFlag);
        Flag<?> directoryFlag = argsParseResult.getFlagByName("d");
        assertNotNull(directoryFlag);

        assertEquals(logFlag.getValue(), true);
        assertEquals(portFlag.getValue(), 8080);
        assertEquals(directoryFlag.getValue(), "/usr/logs");
    }

    @Test
    public void given_p_and_d_when_no_value_return_default_value(){
        //Arrange
        String args = "-p -d";

        //Act
        ArgsParseResult argsParseResult = ArgsParser.parse(args);

        //Assert
        assertNotNull(argsParseResult);

        Flag<?> logFlag = argsParseResult.getFlagByName("l");
        assertNotNull(logFlag);
        Flag<?> portFlag = argsParseResult.getFlagByName("p");
        assertNotNull(portFlag);
        Flag<?> directoryFlag = argsParseResult.getFlagByName("d");
        assertNotNull(directoryFlag);

        assertEquals(logFlag.getValue(), false);
        assertEquals(portFlag.getValue(), 0);
        assertEquals(directoryFlag.getValue(), "");
    }
}