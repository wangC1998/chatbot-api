/**
  * Copyright 2023 bejson.com 
  */
package com.self.learn.chatbot.api.domain.zsxq.model.vo;
import java.util.Date;

/**
 * Auto-generated: 2023-04-18 21:26:2
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class OwnerDetail {

    private int questions_count;
    private Date joinTime;
    public void setQuestions_count(int questions_count) {
         this.questions_count = questions_count;
     }
     public int getQuestions_count() {
         return questions_count;
     }

    public void setJoinTime(Date joinTime) {
         this.joinTime = joinTime;
     }
     public Date getJoinTime() {
         return joinTime;
     }

}