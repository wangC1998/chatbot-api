package com.self.learn.chatbot.api;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import org.junit.Test;

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

        if (response.isOk()) {
            String body = response.body();
            System.out.println(JSON.toJSONString(body));
        }
    }

    @Test
    public void answerQuestion() {

        HttpRequest request = HttpUtil.createPost("https://api.zsxq.com/v2/topics/814221225112812/answer");
        request.contentType("application/json; charset=UTF-8");
        request.cookie("zsxqsessionid=49af21bf739fab78cffeae6b0fa84fad; zsxq_access_token=0058B458-94FD-804D-B42A-2D08D7457F3E_F230FC31B0A19C9A; abtest_env=product");
        request.body("{\"req_data\":{\"text\":\"我不会,哈哈哈哈\\n\",\"image_ids\":[]}}");
        HttpResponse response = request.execute();

        if (response.isOk()) {
            System.out.println(JSON.toJSONString(response.body()));
        }


    }
}
