package org.example;


import java.util.List;

public class ArgsParseResult {
    private final List<Flag<?>> flags;

    public ArgsParseResult(List<Flag<?>> flags) {
        this.flags = flags;
    }

    public Flag<?> getFlagByName(String targetName){
        for (Flag<?> flag : flags) {
            String flagName = flag.getFlagName();
            if (flagName.equals(targetName)){
                return flag;
            }
        }
        return null;
    }
}
