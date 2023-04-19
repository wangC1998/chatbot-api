package com.self.learn.chatbot.api.domain.service.impl;

import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.self.learn.chatbot.api.domain.model.aggregates.AnswerQuestion;
import com.self.learn.chatbot.api.domain.model.aggregates.AskMeResult;
import com.self.learn.chatbot.api.domain.model.req.AnswerReq;
import com.self.learn.chatbot.api.domain.service.IZsxqApi;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;


@Service
public class ZsxqApi implements IZsxqApi {

    @Override
    public Boolean answerQuestion(String topic, String cookie, AnswerQuestion answerQuestion) {
        HttpRequest request = HttpUtil.createPost("https://api.zsxq.com/v2/topics/"+topic+"/answer");
        request.contentType("application/json; charset=UTF-8");
        request.cookie(cookie);
        request.body(JSON.toJSONString(answerQuestion));
        HttpResponse response = request.execute();
        response.charset(StandardCharsets.UTF_8);
        if (response.isOk()&& JSON.parseObject(response.body(), AskMeResult.class).getSucceeded()) {
            return true;
        }
        return false;
    }

    @Override
    public AskMeResult getAllUnAnswerQuestion(String groups, String cookie) {

        HttpRequest request = HttpUtil.createGet("https://api.zsxq.com/v2/groups/"+groups+"/topics?scope=unanswered_questions&count=20");
        request.cookie(cookie);
        request.contentType("application/json; charset=UTF-8");

        HttpResponse response = request.execute();
        AskMeResult askMeResult = null;

        if (response.isOk()) {
            askMeResult = JSON.parseObject(response.body(), AskMeResult.class);

        } else {
            // TODO: 2023/4/18 本次请求错误,请进行错误排查
        }


        return askMeResult;

    }
}
