/**
  * Copyright 2023 bejson.com 
  */
package com.self.learn.chatbot.api.domain.model.vo;

/**
 * Auto-generated: 2023-04-18 21:26:2
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Group {

    private long groupId;
    private String name;
    private String type;
    public void setGroupId(long groupId) {
         this.groupId = groupId;
     }
     public long getGroupId() {
         return groupId;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

}