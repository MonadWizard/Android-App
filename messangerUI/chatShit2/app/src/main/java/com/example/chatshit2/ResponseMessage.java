package com.example.chatshit2;

/**
 * Created by deathcode on 26/01/18.
 */

public class ResponseMessage {

    String text;
    boolean isMe;

    public ResponseMessage(String text, boolean isMe) {
        this.text = text;
        this.isMe = isMe;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public boolean isMe() {
        return isMe;
    }

    public void setMe(boolean me) {
        isMe = me;
    }
}
