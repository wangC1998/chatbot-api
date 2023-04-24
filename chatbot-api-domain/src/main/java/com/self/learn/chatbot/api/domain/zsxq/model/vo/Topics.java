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
public class Topics {

    private long topicId;
    private Group group;
    private String type;
    private Question question;
    private boolean answered;
    private int likesCount;
    private int rewardsCount;
    private int commentsCount;
    private int readingCount;
    private int readersCount;
    private boolean digested;
    private boolean sticky;
    private Date createTime;
    private UserSpecific userSpecific;
    public void setTopicId(long topicId) {
         this.topicId = topicId;
     }
     public long getTopicId() {
         return topicId;
     }

    public void setGroup(Group group) {
         this.group = group;
     }
     public Group getGroup() {
         return group;
     }

    public void setType(String type) {
         this.type = type;
     }
     public String getType() {
         return type;
     }

    public void setQuestion(Question question) {
         this.question = question;
     }
     public Question getQuestion() {
         return question;
     }

    public void setAnswered(boolean answered) {
         this.answered = answered;
     }
     public boolean getAnswered() {
         return answered;
     }

    public void setLikesCount(int likesCount) {
         this.likesCount = likesCount;
     }
     public int getLikesCount() {
         return likesCount;
     }

    public void setRewardsCount(int rewardsCount) {
         this.rewardsCount = rewardsCount;
     }
     public int getRewardsCount() {
         return rewardsCount;
     }

    public void setCommentsCount(int commentsCount) {
         this.commentsCount = commentsCount;
     }
     public int getCommentsCount() {
         return commentsCount;
     }

    public void setReadingCount(int readingCount) {
         this.readingCount = readingCount;
     }
     public int getReadingCount() {
         return readingCount;
     }

    public void setReadersCount(int readersCount) {
         this.readersCount = readersCount;
     }
     public int getReadersCount() {
         return readersCount;
     }

    public void setDigested(boolean digested) {
         this.digested = digested;
     }
     public boolean getDigested() {
         return digested;
     }

    public void setSticky(boolean sticky) {
         this.sticky = sticky;
     }
     public boolean getSticky() {
         return sticky;
     }

    public void setCreateTime(Date createTime) {
         this.createTime = createTime;
     }
     public Date getCreateTime() {
         return createTime;
     }

    public void setUserSpecific(UserSpecific userSpecific) {
         this.userSpecific = userSpecific;
     }
     public UserSpecific getUserSpecific() {
         return userSpecific;
     }

}