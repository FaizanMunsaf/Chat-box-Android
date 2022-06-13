package com.example.firebase;

public class UserModel {
    String message;
    String id;

    public UserModel(String message, String id) {
        this.message = message;
        this.id = id;
    }

    public UserModel() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
