package com.piggame.entity;

/**
 * 题目
 * @Author:zhujie
 * @Date: Create in 10:34 2018/3/5
 **/
public class Question {

    private Long id;

    //关键字
    private String keywords;

    //题目
    private String name;

    public Question(String keywords, String name) {
        this.keywords = keywords;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", keywords='" + keywords + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
