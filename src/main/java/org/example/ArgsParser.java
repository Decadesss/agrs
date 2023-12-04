package org.example;

import java.util.ArrayList;
import java.util.List;

public class ArgsParser {
    public static Schema parse(String args){
        List<Flag> flagList = new ArrayList<>();
        Flag flag;
        if (args.equals("-l")){
            flag = new Flag("l", "logging", "true", "false");
        }else {
            flag = new Flag("l", "logging", "false", "false");
        }
        flagList.add(flag);
        return new Schema(flagList);
    }
}
