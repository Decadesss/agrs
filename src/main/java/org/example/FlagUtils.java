package org.example;

import java.util.ArrayList;
import java.util.List;

public class FlagUtils {
    public static List<Flag<?>> initFlagList() {
        List<Flag<?>> flagList = new ArrayList<>();
        for (SchemaEnum value : SchemaEnum.values()) {
            Flag<?> flag = new Flag<>(value.getFlagName(), value.getFlagName(), value.getType());
            flagList.add(flag);
        }
        return flagList;
    }

    public static void supplyDefaultValues(List<Flag<?>> flagList) {
        for (Flag<?> flag : flagList) {
            if (flag.getValue() != null){
                continue;
            }
            SchemaEnum matchedEnum = SchemaEnum.matchByFlagName(flag.getFlagName());
            flag.setValue(matchedEnum.getDefaultValue());
        }
    }

    public static Flag<?> matchByFlagName(String flagName, List<Flag<?>> flagList) {
        for (Flag<?> flag : flagList) {
            if (flag.getFlagName().equals(flagName)){
                return flag;
            }
        }
        throw new IllegalArgumentException("Not contain " + flagName + " in initial flag list.");
    }
}
