package org.example;


import java.util.List;

public class Schema {
    private final List<Flag> flags;

    public Schema(List<Flag> flags) {
        this.flags = flags;
    }

    public Flag getFlagByName(String targetName){
        for (Flag flag : flags) {
            String flagName = flag.getFlag();
            if (flagName.equals(targetName)){
                return flag;
            }
        }
        return null;
    }
}
