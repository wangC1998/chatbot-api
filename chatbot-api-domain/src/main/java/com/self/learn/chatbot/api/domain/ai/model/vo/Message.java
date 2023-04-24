package com.self.learn.chatbot.api.domain.ai.model.vo;

public class Message {

    private String role;
    private String content;



    public void setRole(String role) {
        this.role = role;
    }
    public String getRole() {
        return role;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

}
