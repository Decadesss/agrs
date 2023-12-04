package org.example;

import java.util.logging.StreamHandler;

public class Schema {
    String tag;
    String name;
    String value;
    String defaultValue;


    public Schema() {
    }

    public Schema(String tag, String name, String value, String defaultValue) {
        this.tag = tag;
        this.name = name;
        this.value = value;
        this.defaultValue = defaultValue;
    }

    /**
     * 获取
     * @return tag
     */
    public String getTag() {
        return tag;
    }

    /**
     * 设置
     * @param tag
     */
    public void setTag(String tag) {
        this.tag = tag;
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
        return "Schema{tag = " + tag + ", name = " + name + ", value = " + value + ", defaultValue = " + defaultValue + "}";
    }
}
