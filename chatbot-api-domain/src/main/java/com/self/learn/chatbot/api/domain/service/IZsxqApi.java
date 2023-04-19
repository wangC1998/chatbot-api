package com.self.learn.chatbot.api.domain.service;

import com.self.learn.chatbot.api.domain.model.aggregates.AnswerQuestion;
import com.self.learn.chatbot.api.domain.model.aggregates.AskMeResult;
import com.self.learn.chatbot.api.domain.model.req.AnswerReq;

public interface IZsxqApi {

    /**
     * 获取所有未回答列表
     */
    AskMeResult getAllUnAnswerQuestion(String groups, String cookie);


    Boolean answerQuestion(String topic, String cookie, AnswerQuestion answerQuestion);
}
