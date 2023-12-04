package org.example;

public enum ArgInfoEnum {
    /**
     * 日志开关
     */
    logging("l", "false"),
    /**
     * 端口
     */
    port("p", "666"),
    /**
     * 目录
     */
    directory("d", "/usr/default");

    private final String flag;
    private final String defaultValue;

    ArgInfoEnum(String flag, String defaultValue) {
        this.flag = flag;
        this.defaultValue = defaultValue;
    }

    public String getFlag() {
        return flag;
    }

    public static ArgInfoEnum match(String flag) {
        if (flag == null || flag.isEmpty()){
            return null;
        }

        for (ArgInfoEnum enums : ArgInfoEnum.values()) {
            if (enums.getFlag().equals(flag)) {
                return enums;
            }
        }
        return null;
    }
}
