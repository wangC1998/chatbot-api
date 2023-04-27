package com.self.learn.chatbot.api.domain.ai.service;

import com.self.learn.chatbot.api.domain.ai.model.req.AiReq;
import com.self.learn.chatbot.api.domain.ai.model.res.AiResp;

public interface IAI {

    /**
     * 通过ChatGpt回答问题
     * @param question
     * @return
     */
    AiResp ansQuesByChatGpt(String question);

}
