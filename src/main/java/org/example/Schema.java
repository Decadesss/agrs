package org.example;

import java.util.logging.StreamHandler;

public class Schema {
    String flag;
    String name;
    String value;
    String defaultValue;


    public Schema() {
    }

    public Schema(String flag, String name, String value, String defaultValue) {
        this.flag = flag;
        this.name = name;
        this.value = value;
        this.defaultValue = defaultValue;
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
     */
    public void setFlag(String flag) {
        this.flag = flag;
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
        return "Schema{flag = " + flag + ", name = " + name + ", value = " + value + ", defaultValue = " + defaultValue + "}";
    }
}
