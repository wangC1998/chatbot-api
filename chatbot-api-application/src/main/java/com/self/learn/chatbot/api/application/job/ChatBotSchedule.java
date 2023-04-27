package com.self.learn.chatbot.api.application.job;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.date.DateUtil;
import com.self.learn.chatbot.api.domain.ai.model.res.AiResp;
import com.self.learn.chatbot.api.domain.ai.model.vo.Choices;
import com.self.learn.chatbot.api.domain.ai.service.IAI;
import com.self.learn.chatbot.api.domain.zsxq.model.aggregates.AnswerQuestion;
import com.self.learn.chatbot.api.domain.zsxq.model.aggregates.AskMeResult;
import com.self.learn.chatbot.api.domain.zsxq.model.req.AnswerReq;
import com.self.learn.chatbot.api.domain.zsxq.model.vo.Question;
import com.self.learn.chatbot.api.domain.zsxq.model.vo.Topics;
import com.self.learn.chatbot.api.domain.zsxq.service.IZsxqApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author wc
 */
@EnableScheduling
@Configuration
public class ChatBotSchedule {

    @Value("${chatbot-api.groupId}")
    private String groupId;


    @Value("${chatbot-api.cookie}")
    private String cookie;

    @Resource
    IAI ai;

    @Resource
    IZsxqApi zsxqApi;






    @Scheduled(cron = "0 0/1 * * * ?")
    public void scanQuesAndAns() {

        // 1. 拉取问题
        AskMeResult allUnAnswerQuestion = zsxqApi.getAllUnAnswerQuestion(groupId, cookie);

        if (allUnAnswerQuestion.getSucceeded()) {

            List<Topics> topics = allUnAnswerQuestion.getRespData().getTopics();
            for (Topics topic : topics) {
                long topicId = topic.getTopicId();

                Question question = topic.getQuestion();
                String questionContent = question.getText();


                AiResp aiResp = ai.ansQuesByChatGpt(questionContent);

                if (CollectionUtil.isNotEmpty(aiResp.getChoices())) {

                    List<Choices> choices = aiResp.getChoices();
                    Choices choice = choices.get(0);
                    String answer = choice.getMessage().getContent();


                    AnswerQuestion answerQuestion = new AnswerQuestion();
                    AnswerReq answerReq = new AnswerReq();
                    answerReq.setText(answer);
                    answerQuestion.setReq_data(answerReq);
                    Boolean ansFlag = zsxqApi.answerQuestion(Long.toString(topicId), cookie, answerQuestion);

                    if (ansFlag) {
                        System.out.println("回答完毕:" + topicId);
                    } else {
                        System.out.println("回答失败,呜呜呜:" + topicId);
                    }
                }
            }

        } else {
            System.out.println("获取问题失败");
        }

        System.out.println("完成本批次问答:"+DateUtil.now());
    }


}
