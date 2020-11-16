package com.example.demo.Controller;

import java.io.Serializable;

public class Response implements Serializable {
    String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
