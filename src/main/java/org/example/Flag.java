package org.example;

public class Flag {
    private String flag;
    private String describe;
    private String value;

    public Flag() {
    }

    public Flag(String flag, String describe, String value) {
        this.flag = flag;
        this.describe = describe;
        this.value = value;
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

    public String toString() {
        return "Flag{flag = " + flag + ", describe = " + describe + ", value = " + value + "}";
    }
}
