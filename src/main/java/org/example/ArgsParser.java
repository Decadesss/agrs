package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgsParser {
    public static Schema parse(String args) {
        List<String> argsList = splitArgs(args);
        List<Flag> flagList = parseArgsListToFlagList(argsList);
        return new Schema(flagList);
    }

    private static List<Flag> parseArgsListToFlagList(List<String> argsList) {
        List<Flag> flagList = new ArrayList<>();
        for (String arg : argsList) {
            Flag flag = parseArgToFlag(arg);
            if (flag != null) {
                flagList.add(flag);
            }
        }
        return flagList;
    }

    private static Flag parseArgToFlag(String arg) {
        String[] splitArg = arg.split(" ");
        ArgInfoEnum matchedEnum = ArgInfoEnum.match(splitArg[0]);
        if (matchedEnum != null) {
            Flag flag = new Flag();
            flag.setFlag(matchedEnum.getFlag());
            flag.setDescribe(matchedEnum.name());

            //-l 没有参数，特殊处理
            if (matchedEnum.getFlag().equals("l")){
                flag.setValue("true");
            }else {
                flag.setValue(splitArg[1]);
            }
            return flag;
        }
        return null;
    }

    private static List<String> splitArgs(String args) {
        String[] splitArgs = args.split("-");

        //遗弃第一个字符串，因为它是冗余的空字符串或非参数相关字符串
        return new ArrayList<>(
                Arrays.asList(splitArgs)
                        .subList(1, splitArgs.length));
    }
}
