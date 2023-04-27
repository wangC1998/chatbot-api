package com.self.learn.chatbot.api;
import cn.hutool.core.text.UnicodeUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.self.learn.chatbot.api.domain.ai.model.req.AiReq;
import com.self.learn.chatbot.api.domain.ai.model.res.AiResp;
import com.self.learn.chatbot.api.domain.ai.model.vo.Message;
import org.junit.Test;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wc
 * @description 单元测试
 */
public class ApiTest {
    @Test
    public void test_01() {
        System.out.println("进行单元测试...");
    }


    @Test
    public void testGetAllQuestion() {

        HttpRequest request = HttpUtil.createGet("https://api.zsxq.com/v2/groups/15552514151582/topics?scope=unanswered_questions&count=20");
        request.cookie("zsxqsessionid=49af21bf739fab78cffeae6b0fa84fad; zsxq_access_token=0058B458-94FD-804D-B42A-2D08D7457F3E_F230FC31B0A19C9A; abtest_env=beta");
        request.contentType("application/json; charset=UTF-8");

        HttpResponse response = request.execute();
        System.out.println(response.body());
        String s = UnicodeUtil.toString(response.body());
        System.out.println(s);
        System.out.println(JSON.parseObject(response.body()));
//        response.charset(StandardCharsets.UTF_8);

        if (response.isOk()) {
//            byte[] bytes = response.bodyBytes();
//            String s = new String(bytes, StandardCharsets.UTF_8);
//            String body = response.body();
//            System.out.println(response);
//            System.out.println(JSON.toJSONString(s));
        }
    }

    @Test
    public void answerQuestion() {

        HttpRequest request = HttpUtil.createPost("https://api.zsxq.com/v2/topics/814221481421422/answer");
        request.contentType("application/json; charset=UTF-8");
        request.cookie("zsxqsessionid=49af21bf739fab78cffeae6b0fa84fad; zsxq_access_token=0058B458-94FD-804D-B42A-2D08D7457F3E_F230FC31B0A19C9A; abtest_env=product");
        request.body("{\"req_data\":{\"text\":\"测试回答\\n\",\"image_ids\":[]}}");
        HttpResponse response = request.execute();
        response.charset(StandardCharsets.UTF_8);

        if (response.isOk()) {
            System.out.println(JSON.parseObject(response.body()));
        }


    }

    @Test
    public void chatApiTest() {
        /*
        curl https://api.openai.com/v1/chat/completions \
  -H "Content-Type: application/json" \
  -H "Authorization: Bearer $OPENAI_API_KEY" \
  -d '{
    "model": "gpt-3.5-turbo",
    "messages": [{"role": "user", "content": "Hello!"}]
  }'

         */

        AiReq aiReq = new AiReq();
        aiReq.setModel("gpt-3.5-turbo");
        Message message = new Message();
        message.setContent("继续");
        message.setRole("user");
        aiReq.setMessages(Arrays.asList(message));
        String response = HttpUtil.createPost("https://api.openai.com/v1/chat/completions")
                .contentType("application/json")
                .header("Authorization", "Bearer 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")
                .body(JSON.toJSONString(aiReq))
                .execute().body();

        AiResp aiResp = JSON.parseObject(response, AiResp.class);

        System.out.println(JSON.toJSONString(aiResp));







    }


    /*
    tool:https://he3.app/zh/
    req:{
    "model": "gpt-3.5-turbo",
    "messages": [{"role": "user", "content": "帮我写一个Java单例模式"}]
  }

    resp: {"id":"chatcmpl-78I5pUj2nKIqwrgLwOUvs5bMauEPW","object":"chat.completion","created":1682210529,"model":"gpt-3.5-turbo-0301","usage":{"prompt_tokens":18,"completion_tokens":258,"total_tokens":276},"choices":[{"message":{"role":"assistant","content":"以下是一个Java单例模式的实现例子：\n\n```java\npublic class Singleton {\n  // 私有静态实例\n  private static Singleton instance;\n\n  // 私有构造方法，防止外部实例化\n  private Singleton() {}\n\n  // 公有静态方法，获取实例\n  public static Singleton getInstance() {\n    // 判断是否已有实例，如果没有则创建\n    if (instance == null) {\n      instance = new Singleton();\n    }\n    return instance;\n  }\n\n  // 其他公有方法\n  public void doSomething() {\n    // 实现某些功能\n  }\n}\n```\n\n说明：\n\n- 将构造方法私有化，确保外部无法实例化，只能通过静态方法getInstance()获取实例。\n- 用一个私有静态变量instance来存储实例，确保全局唯一。\n- 在getInstance()方法中，如果实例还不存在，则创建，否则直接返回现有实例。\n- 其他公有方法可以在实例上调用，实现某些功能。"},"finish_reason":"stop","index":0}]}

     */
}
