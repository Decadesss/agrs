package org.example;

public class ArgsParser {
    public static Schema parse(String args){
        if (args.equals("-l")){
            return new Schema("l", "logging", "true", "false");
        }
        return null;
    }
}
