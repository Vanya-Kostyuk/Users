package com.example.testproject.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class User {
    @JsonProperty("user_id")
    private Integer userId;
    @JsonProperty("level_id")
    private Integer levelId;
    @JsonProperty("result")
    private Integer result;

    public User(Integer userId, Integer levelId, Integer result) {
        this.userId = userId;
        this.levelId = levelId;
        this.result = result;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getLevelId() {
        return levelId;
    }

    public void setLevelId(Integer levelId) {
        this.levelId = levelId;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) && Objects.equals(levelId, user.levelId) && Objects.equals(result, user.result);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, levelId, result);
    }
}
