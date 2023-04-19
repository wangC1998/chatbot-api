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
public class Owner {

    private long userId;
    private String name;
    private String avatar_url;
    private String location;
    public void setUserId(long userId) {
         this.userId = userId;
     }
     public long getUserId() {
         return userId;
     }

    public void setName(String name) {
         this.name = name;
     }
     public String getName() {
         return name;
     }

    public void setAvatar_url(String avatar_url) {
         this.avatar_url = avatar_url;
     }
     public String getAvatar_url() {
         return avatar_url;
     }

    public void setLocation(String location) {
         this.location = location;
     }
     public String getLocation() {
         return location;
     }

}