package com.example.myapplication;

import java.io.Serializable;

public class User implements Serializable {
    private int id;
    private String username;
    private boolean state;
    private String msg;

    public User(int id, String username, boolean state, String msg) {
        this.id = id;
        this.username = username;
        this.state = state;
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isState() {
        return state;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", state=" + state +
                '}';
    }

    public void setState(boolean state) {
        this.state = state;
    }


}
