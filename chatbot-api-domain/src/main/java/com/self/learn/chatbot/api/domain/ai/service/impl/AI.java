package com.self.learn.chatbot.api.domain.ai.service.impl;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.self.learn.chatbot.api.domain.ai.model.req.AiReq;
import com.self.learn.chatbot.api.domain.ai.model.res.AiResp;
import com.self.learn.chatbot.api.domain.ai.model.vo.Message;
import com.self.learn.chatbot.api.domain.ai.service.IAI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.util.Arrays;


@Service
public class AI implements IAI {

    @Value("${chatbot-api.secret}")
    private String secretKey;


    @Override
    public AiResp ansQuesByChatGpt(String question) {

        AiReq aiReq = new AiReq();
        aiReq.setModel("gpt-3.5-turbo");
        Message message = new Message();
        message.setContent(question);
        message.setRole("user");
        aiReq.setMessages(Arrays.asList(message));
        String response = HttpUtil.createPost("https://api.openai.com/v1/chat/completions")
                .contentType("application/json")
                .header("Authorization", "Bearer "+secretKey)
                .body(JSON.toJSONString(aiReq))
                .execute().body();

        AiResp aiResp = JSON.parseObject(response, AiResp.class);
        return aiResp;
    }
}
