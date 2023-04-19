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
public class Question {

    private Owner owner;
    private Questionee questionee;
    private String text;
    private boolean expired;
    private boolean anonymous;
    private OwnerDetail ownerDetail;
    private String ownerLocation;
    public void setOwner(Owner owner) {
         this.owner = owner;
     }
     public Owner getOwner() {
         return owner;
     }

    public void setQuestionee(Questionee questionee) {
         this.questionee = questionee;
     }
     public Questionee getQuestionee() {
         return questionee;
     }

    public void setText(String text) {
         this.text = text;
     }
     public String getText() {
         return text;
     }

    public void setExpired(boolean expired) {
         this.expired = expired;
     }
     public boolean getExpired() {
         return expired;
     }

    public void setAnonymous(boolean anonymous) {
         this.anonymous = anonymous;
     }
     public boolean getAnonymous() {
         return anonymous;
     }

    public void setOwnerDetail(OwnerDetail ownerDetail) {
         this.ownerDetail = ownerDetail;
     }
     public OwnerDetail getOwnerDetail() {
         return ownerDetail;
     }

    public void setOwnerLocation(String ownerLocation) {
         this.ownerLocation = ownerLocation;
     }
     public String getOwnerLocation() {
         return ownerLocation;
     }

}