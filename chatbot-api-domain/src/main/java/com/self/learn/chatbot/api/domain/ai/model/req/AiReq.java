package com.self.learn.chatbot.api.domain.ai.model.req;

import com.self.learn.chatbot.api.domain.ai.model.vo.Message;

import java.util.List;

public class AiReq {
    private String model;
    private List<Message> messages;



    public void setModel(String model) {
        this.model = model;
    }
    public String getModel() {
        return model;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    public List<Message> getMessages() {
        return messages;
    }
}
