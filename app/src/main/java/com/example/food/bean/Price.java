package com.example.food.bean;

/**
 * @author wellorbetter
 * @since 2024/6/19 17:35
 */
public class Price {
    private int Id;
    private String Value;

    public Price() {
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
