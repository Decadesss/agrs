package org.example;

import javafx.beans.binding.ObjectExpression;

public class Flag<T> {
    private String flag;
    private String describe;
    private T value;
    private Class<T> type;

    public Flag() {
    }

    public Flag(String flag, String describe, Class<T> type) {
        this.flag = flag;
        this.describe = describe;
        this.type = type;
    }

    public Flag(String flag, String describe, T value, Class<T> type) {
        if (!type.isInstance(value)) {
            throw new IllegalArgumentException("Value must match type:" + type.getSimpleName());
        }

        this.flag = flag;
        this.describe = describe;
        this.type = type;
        this.value = value;
    }

    /**
     * 获取
     *
     * @return flag
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 设置
     *
     * @param flag flag
     */
    public void setFlag(String flag) {
        this.flag = flag;
    }

    /**
     * 获取
     *
     * @return describe
     */
    public String getDescribe() {
        return describe;
    }

    /**
     * 设置
     *
     * @param describe describe
     */
    public void setDescribe(String describe) {
        this.describe = describe;
    }

    /**
     * 获取
     *
     * @return value
     */
    public T getValue() {
        return value;
    }

    /**
     * 设置
     *
     * @param value value
     */
    public void setValue(Object value) {
        if (this.type == null) {
            throw new IllegalArgumentException("Must set type before set value");
        }

        if (!type.isInstance(value)) {
            throw new IllegalArgumentException("Value must match type: " + type.getSimpleName());
        }

        this.value = type.cast(value);
    }

    /**
     * 设置
     *
     * @param value value
     */
    public void setValueByParseString(String value, Class<?> type) {
        if (type.equals(Integer.class)) {
            this.setValue(Integer.parseInt(value));
        } else if (type.equals(Boolean.class)) {
            this.setValue(Boolean.parseBoolean(value));
        } else if(type.equals(String.class)){
            this.setValue(value);
        }else {
            throw new IllegalArgumentException("Not supported parameter type.");
        }
    }

    public Class<T> getType() {
        return type;
    }

    public void setType(Class<T> type) {
        this.type = type;
    }

    public String toString() {
        return "Flag{flag = " + flag + ", describe = " + describe + ", value = " + value + "}";
    }
}
