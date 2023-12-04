package org.example;

public class Flag {
    private String flag;
    private String describe;
    private String value;
    private String defaultValue;


    public Flag() {
    }

    /**
     * 获取
     * @return flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置
     * @param flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置
     * @param describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * 设置
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * 获取
     * @return defaultValue
     */
    public String getDefaultValue() {
        return defaultValue;
    }

    /**
     * 设置
     * @param defaultValue
     */
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String toString() {
        return "Flag{flag = " + flag + ", describe = " + describe + ", value = " + value + ", defaultValue = " + defaultValue + "}";
    }
}
