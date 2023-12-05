package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgsParser {
    public static Schema parse(String args) {
        List<String> argsList = splitArgs(args);
        List<Flag> flagList = parseArgsListToFlagList(argsList);
        setDefaultArg(flagList);
        return new Schema(flagList);
    }

    private static void setDefaultArg(List<Flag> flagList) {
        for (Flag flag : flagList) {
            if (flag.getFlag().equals("l")) {
                return;
            }
        }
        flagList.add(new Flag("l", "logging", "false"));
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
            return createFlagFromArgInfo(splitArg, matchedEnum);
        }
        return null;
    }

    private static Flag createFlagFromArgInfo(String[] splitArg, ArgInfoEnum matchedEnum) {
        Flag flag = new Flag();
        flag.setFlag(matchedEnum.getFlag());
        flag.setDescribe(matchedEnum.name());

        //-l 没有参数，特殊处理
        if (matchedEnum.getFlag().equals("l")) {
            flag.setValue("true");
        } else {
            flag.setValue(splitArg.length > 1 ? splitArg[1] : matchedEnum.getDefaultValue());
        }
        return flag;
    }

    private static List<String> splitArgs(String args) {
        String[] splitArgs = args.split("-");

        //遗弃第一个字符串，因为它是冗余的空字符串或非参数相关字符串
        return new ArrayList<>(
                Arrays.asList(splitArgs)
                        .subList(1, splitArgs.length));
    }
}
