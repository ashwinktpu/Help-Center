/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ekshiksha.helpcenter.beans;

/**
 *
 * @author ashwina
 */
public class Question {

    private int questionid;
    private String questionstring;
    private boolean status;
    private String answerurl;
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }


    public int getQuestionid() {
        return questionid;
    }

    public void setQuestionid(int questionid) {
        this.questionid = questionid;
    }

    public String getQuestionstring() {
        return questionstring;
    }

    public void setQuestionstring(String questionstring) {
        this.questionstring = questionstring;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getAnswerurl() {
        return answerurl;
    }

    public void setAnswerurl(String answerurl) {
        this.answerurl = answerurl;
    }

}
