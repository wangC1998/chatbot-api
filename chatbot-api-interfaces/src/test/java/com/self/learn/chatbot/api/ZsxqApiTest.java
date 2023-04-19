package com.self.learn.chatbot.api;

import cn.hutool.core.date.DateUtil;
import com.self.learn.chatbot.api.domain.model.aggregates.AnswerQuestion;
import com.self.learn.chatbot.api.domain.model.aggregates.AskMeResult;
import com.self.learn.chatbot.api.domain.model.req.AnswerReq;
import com.self.learn.chatbot.api.domain.model.vo.Topics;
import com.self.learn.chatbot.api.domain.service.IZsxqApi;
import com.self.learn.chatbot.api.domain.service.impl.ZsxqApi;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ZsxqApiTest {

    @Value("${chatbot-api.groupId}")
    private String groupId;


    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    IZsxqApi zsxqApi;

    @Test
    public void Test_01() {

        String group = "15552514151582";
        String cookies = "zsxqsessionid=49af21bf739fab78cffeae6b0fa84fad; zsxq_access_token=0058B458-94FD-804D-B42A-2D08D7457F3E_F230FC31B0A19C9A; abtest_env=beta";
        IZsxqApi api = new ZsxqApi();

        AskMeResult allUnAnswerQuestion = api.getAllUnAnswerQuestion(group, cookies);
    }


    @Test
    public void allTest() {

        String defaultans = "我不知道";
        // 1. 先获取所有未回答列表
        AskMeResult allUnAnswerQuestion = zsxqApi.getAllUnAnswerQuestion(groupId, cookie);

        if (allUnAnswerQuestion.getSucceeded()) {

            List<Topics> topics = allUnAnswerQuestion.getRespData().getTopics();

            for (Topics topic : topics) {
                long topic_id = topic.getTopicId();
                AnswerReq answerReq = new AnswerReq();
                answerReq.setText(defaultans+ DateUtil.now());
                AnswerQuestion answerQuestion = new AnswerQuestion();
                answerQuestion.setReq_data(answerReq);
                Boolean ok = zsxqApi.answerQuestion(Long.toString(topic_id), cookie, answerQuestion);

                if (ok) {
                    System.out.println("该问题回答成功:" + topic_id);
                } else {
                    System.out.println("该问题回答失败:" + topic_id);
                }
            }
        }
    }
}

// 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

