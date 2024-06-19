package com.example.food.bean;

/**
 * @author wellorbetter
 * @since 2024/6/19 17:36
 */
public class Time {
    private int Id;
    private String Value;

    public Time() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    @Override
    public String toString() {
        return Value;
    }
}
