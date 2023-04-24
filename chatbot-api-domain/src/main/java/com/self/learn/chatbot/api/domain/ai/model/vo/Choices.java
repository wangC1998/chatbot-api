package com.self.learn.chatbot.api.domain.ai.model.vo;

public class Choices {
    private Message message;
    private String finishReason;
    private int index;



    public void setMessage(Message message) {
        this.message = message;
    }
    public Message getMessage() {
        return message;
    }

    public void setFinishReason(String finishReason) {
        this.finishReason = finishReason;
    }
    public String getFinishReason() {
        return finishReason;
    }

    public void setIndex(int index) {
        this.index = index;
    }
    public int getIndex() {
        return index;
    }



}
