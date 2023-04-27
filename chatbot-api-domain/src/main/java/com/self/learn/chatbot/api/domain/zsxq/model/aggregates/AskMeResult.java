package com.self.learn.chatbot.api.domain.zsxq.model.aggregates;
import com.self.learn.chatbot.api.domain.zsxq.model.res.RespData;

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

    public static AskMeResult error() {
        AskMeResult res = new AskMeResult();
        res.setRespData(null);
        res.setSucceeded(false);
        return res;
    }




}
