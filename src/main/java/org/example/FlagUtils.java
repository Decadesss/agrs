package org.example;

import java.util.ArrayList;
import java.util.List;

public class FlagUtils {
    public static List<Flag<?>> initFlagList() {
        List<Flag<?>> flagList = new ArrayList<>();
        for (SchemaEnum value : SchemaEnum.values()) {
            Flag<?> flag = new Flag<>(value.getFlag(), value.getFlag(), value.getType());
            flagList.add(flag);
        }
        return flagList;
    }

    public static void supplyDefaultValues(List<Flag<?>> flagList) {
        for (Flag<?> flag : flagList) {
            if (flag.getFlag().equals("l")) {
                return;
            }
        }
        flagList.add(new Flag<>("l", "logging", false, Boolean.class));
    }

    public static Flag<?> matchByFlagName(String flagName, List<Flag<?>> flagList) {
        for (Flag<?> flag : flagList) {
            if (flag.getFlag().equals(flagName)){
                return flag;
            }
        }
        return null;
    }
}
