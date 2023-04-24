/**
  * Copyright 2023 bejson.com 
  */
package com.self.learn.chatbot.api.domain.zsxq.model.req;
import java.util.List;

/**
 * Auto-generated: 2023-04-18 21:43:16
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class AnswerReq {

    private String text;
    private List<String> image_ids;
    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

    public void setImage_ids(List<String> image_ids) {
         this.image_ids = image_ids;
     }
     public List<String> getImage_ids() {
         return image_ids;
     }

}