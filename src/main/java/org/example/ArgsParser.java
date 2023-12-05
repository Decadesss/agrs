package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArgsParser {
    public static ArgsParseResult parse(String args) {
        //初始化参数结构
        List<Flag<?>> flagList = FlagUtils.initFlagList();

        List<String> argsList = splitArgs(args);

        parseArgsListToUpdateFlagList(argsList, flagList);

        FlagUtils.supplyDefaultValues(flagList);
        return new ArgsParseResult(flagList);
    }

    private static void parseArgsListToUpdateFlagList(List<String> argsList, List<Flag<?>> flagList) {
        for (String arg : argsList) {
            parseArgToUpdateFlag(arg, flagList);
        }
    }

    private static void parseArgToUpdateFlag(String arg, List<Flag<?>> flagList) {
        String[] splitArg = arg.split(" ");
        String flagName = splitArg[0];

        SchemaEnum matchedEnum = SchemaEnum.matchByFlagName(flagName);
        Flag<?> matchedFlag = FlagUtils.matchByFlagName(flagName, flagList);

        updateFlagFromSchema(splitArg, matchedEnum, matchedFlag);
    }

    private static void updateFlagFromSchema(String[] splitArg,
                                             SchemaEnum matchedEnum, Flag<?> matchedFlag) {
        if (matchedFlag.getValue() != null){
            throw new IllegalArgumentException(
                    "Flag [" + matchedFlag.getFlagName() + "] appears multiple time");
        }

        //-l 没有参数，特殊处理
        if (matchedEnum.getFlagName().equals("l")) {
            if (splitArg.length >1){
                throw new IllegalArgumentException("Flag [-l] should not have values");
            }
            matchedFlag.setValue(true);
        } else {
            if (splitArg.length > 2){
                throw new IllegalArgumentException("Too much values");
            }
            if (splitArg.length > 1){
                matchedFlag.setValueByParseString(splitArg[1], matchedEnum.getType());
            } else {
                matchedFlag.setValue(matchedEnum.getDefaultValue());
            }
        }
    }

    private static List<String> splitArgs(String args) {
        String[] splitArgs = args.split("-");

        //遗弃第一个字符串，因为它是冗余的空字符串或非参数相关字符串
        return new ArrayList<>(
                Arrays.asList(splitArgs)
                        .subList(1, splitArgs.length));
    }
}
