package org.example;

import sun.dc.pr.PRError;

import java.nio.file.Paths;

public class Flag {
    private String name;
    private String describe;
    private String value;
    private String defaultValue;


    public Flag() {
    }

    public Flag(String name, String describe, String value, String defaultValue) {
        this.name = name;
        this.describe = describe;
        this.value = value;
        this.defaultValue = defaultValue;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
        return "Flag{name = " + name + ", describe = " + describe + ", value = " + value + ", defaultValue = " + defaultValue + "}";
    }
}
