package com.self.learn.chatbot.api.domain.zsxq.model.aggregates;

import com.self.learn.chatbot.api.domain.zsxq.model.req.AnswerReq;

public class AnswerQuestion {

    private AnswerReq req_data;

    public AnswerReq getReq_data() {
        return req_data;
    }

    public void setReq_data(AnswerReq req_data) {
        this.req_data = req_data;
    }
}
