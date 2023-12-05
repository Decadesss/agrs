package org.example;

public enum SchemaEnum {
    /**
     * 日志开关
     */
    logging("l", true, Boolean.class),
    /**
     * 端口
     */
    port("p", 666, Integer.class),
    /**
     * 目录
     */
    directory("d", "/usr/default", String.class);

    private final String flag;
    private final Object defaultValue;
    private final Class<?> type;

    SchemaEnum(String flag, Object defaultValue, Class<?> type) {
        this.flag = flag;
        this.defaultValue = defaultValue;
        this.type = type;
    }

    public String getFlag() {
        return flag;
    }

    public Object getDefaultValue() {
        return defaultValue;
    }

    public Class<?> getType() {
        return type;
    }

    public static SchemaEnum match(String flag) {
        if (flag == null || flag.isEmpty()){
            return null;
        }

        for (SchemaEnum enums : SchemaEnum.values()) {
            if (enums.getFlag().equals(flag)) {
                return enums;
            }
        }
        return null;
    }
}
