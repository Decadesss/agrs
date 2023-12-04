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
        Schema parse = ArgsParser.parse(args);

        //Assert
        assertNotNull(parse);
        assertEquals(parse.getFlag(), "l");
        assertEquals(parse.getName(), "logging");
        assertEquals(parse.getValue(), "true");
    }

    @Test
    public void given_empty_when_parse_return_logging_is_false(){
        //Arrange
        String args = "";

        //Act
        Schema parse = ArgsParser.parse(args);

        //Assert
        assertNotNull(parse);
        assertEquals(parse.getFlag(), "l");
        assertEquals(parse.getName(), "logging");
        assertEquals(parse.getValue(), "false");
    }

    @Test
    public void given_l_and_p_when_parse_return_logging_is_false(){
        //Arrange
        String args = "-l -p 8080";

        //Act
        Schema parse = ArgsParser.parse(args);

        //Assert
        assertNotNull(parse);
        assertEquals(parse.getFlag(), "l");
        assertEquals(parse.getName(), "logging");
        assertEquals(parse.getValue(), "ture");
        assertEquals(parse.getFlag(), "p");
        assertEquals(parse.getName(), "port");
        assertEquals(parse.getValue(), "8080");
    }
}