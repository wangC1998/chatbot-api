package com.self.learn.chatbot.api.domain.model.aggregates;
import com.self.learn.chatbot.api.domain.model.res.RespData;

public class AskMeResult {
    private boolean succeeded;
    private RespData respData;
    public void setSucceeded(boolean succeeded) {
        this.succeeded = succeeded;
    }
    public boolean getSucceeded() {
        return succeeded;
    }

    public void setRespData(RespData respData) {
        this.respData = respData;
    }
    public RespData getRespData() {
        return respData;
    }




}
