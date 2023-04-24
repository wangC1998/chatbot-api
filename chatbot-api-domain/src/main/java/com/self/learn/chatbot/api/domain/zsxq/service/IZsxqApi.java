package com.self.learn.chatbot.api.domain.zsxq.service;

import com.self.learn.chatbot.api.domain.zsxq.model.aggregates.AnswerQuestion;
import com.self.learn.chatbot.api.domain.zsxq.model.aggregates.AskMeResult;

public interface IZsxqApi {

    /**
     * 获取所有未回答列表
     */
    AskMeResult getAllUnAnswerQuestion(String groups, String cookie);


    Boolean answerQuestion(String topic, String cookie, AnswerQuestion answerQuestion);
}
