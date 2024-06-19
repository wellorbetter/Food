package com.example.food.bean;

/**
 * @author wellorbetter
 * @since 2024/6/19 17:34
 */
public class Location {
    private int Id;
    private String loc;

    public Location() {}


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    @Override
    public String toString() {
        return loc;
    }
}
