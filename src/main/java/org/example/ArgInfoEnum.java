package org.example;

public enum ArgInfoEnum {
    /**
     * 日志开关
     */
    logging("l"),
    /**
     * 端口
     */
    port("p");

    private final String flag;

    ArgInfoEnum(String flag) {
        this.flag = flag;
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
