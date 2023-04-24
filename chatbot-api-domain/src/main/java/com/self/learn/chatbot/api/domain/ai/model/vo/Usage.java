package com.self.learn.chatbot.api.domain.ai.model.vo;

public class Usage {
    private int promptTokens;
    private int completionTokens;
    private int totalTokens;



    public void setPromptTokens(int promptTokens) {
        this.promptTokens = promptTokens;
    }
    public int getPromptTokens() {
        return promptTokens;
    }

    public void setCompletionTokens(int completionTokens) {
        this.completionTokens = completionTokens;
    }
    public int getCompletionTokens() {
        return completionTokens;
    }

    public void setTotalTokens(int totalTokens) {
        this.totalTokens = totalTokens;
    }
    public int getTotalTokens() {
        return totalTokens;
    }


}
