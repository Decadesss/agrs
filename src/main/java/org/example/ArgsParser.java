package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgsParser {
    public static ArgsParseResult parse(String args) {
        List<Flag<?>> flagList = FlagUtils.initFlagList();
        List<String> argsList = splitArgs(args);
        parseArgsListToFlagList(argsList, flagList);
        FlagUtils.supplyDefaultValues(flagList);
        return new ArgsParseResult(flagList);
    }

    private static void parseArgsListToFlagList(List<String> argsList, List<Flag<?>> flagList) {
        for (String arg : argsList) {
            Flag<?> flag = parseArgToFlag(arg);
            if (flag != null) {
                flagList.add(flag);
            }
        }
    }

    private static Flag<?> parseArgToFlag(String arg, List<Flag<?>> flagList) {
        String[] splitArg = arg.split(" ");
        String flagName = splitArg[0];
        SchemaEnum matchedEnum = SchemaEnum.matchByFlagName(flagName);
        Flag<?> matchedFlag = FlagUtils.matchByFlagName(flagName, flagList);
        if (matchedEnum != null) {
            return updateFlagFromSchema(splitArg, matchedEnum, matchedFlag);
        }
        return null;
    }

    private static Flag<?> updateFlagFromSchema(String[] splitArg, SchemaEnum matchedEnum, Flag<?> matchedFlag) {
        //-l 没有参数，特殊处理
        if (matchedEnum.getFlagName().equals("l")) {
            matchedFlag.setValue(true);
        } else {
            if (splitArg.length > 1){
                matchedFlag.setValueByParseString(splitArg[1], matchedEnum.getType());
            } else {
                matchedFlag.setValue(matchedEnum.getDefaultValue());
            }
        }
        return matchedFlag;
    }

    private static List<String> splitArgs(String args) {
        String[] splitArgs = args.split("-");

        //遗弃第一个字符串，因为它是冗余的空字符串或非参数相关字符串
        return new ArrayList<>(
                Arrays.asList(splitArgs)
                        .subList(1, splitArgs.length));
    }
}
