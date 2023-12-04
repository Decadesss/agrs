package org.example;


import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ArgsParserTest {

    @Test
    public void Given_l_when_parse_return_logging_is_ture(){
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
}