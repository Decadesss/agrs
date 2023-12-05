package org.example;

import java.util.ArrayList;
import java.util.List;

public enum SchemaEnum {
    /**
     * 日志开关
     */
    logging("l", false, Boolean.class),
    /**
     * 端口
     */
    port("p", 0, Integer.class),
    /**
     * 目录
     */
    directory("d", "", String.class);

    private final String flagName;
    private final Object defaultValue;
    private final Class<?> type;

    SchemaEnum(String flagName, Object defaultValue, Class<?> type) {
        this.flagName = flagName;
        this.defaultValue = defaultValue;
        this.type = type;
    }

    public String getFlagName() {
        return flagName;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Class<?> getType() {
        return type;
    }

    public static SchemaEnum matchByFlagName(String flagName) {
        if (flagName == null || flagName.isEmpty()){
            return null;
        }

        List<String> validFlagName = new ArrayList<>();
        for (SchemaEnum enums : SchemaEnum.values()) {
            if (enums.getFlagName().equals(flagName)) {
                return enums;
            }
            validFlagName.add(enums.getFlagName());
        }
        throw new IllegalArgumentException("illegal flag.Valid flags are "
                + String.join(",", validFlagName));
    }
}
