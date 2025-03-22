package com.example.vaultbank;

public class MessageModel {
    public MessageModel(String titleMessage, String message, String time) {
        this.titleMessage = titleMessage;
        this.message = message;
        this.time = time;
    }

    public String getTitleMessage() {
        return titleMessage;
    }

    public String getMessage() {
        return message;
    }

    public String getTime() {
        return time;
    }

    public String titleMessage;
    public String message;
    public String time;
}
