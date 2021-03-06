package com.runtimeterror.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName="runtimeterror_leaderboard")
public class Leaderboard {
    private String userName;
    private int runtime;
    private String escapeId;
    private String difficulty;
    private int gameTime;

    public Leaderboard() {
        // no-arg
    }

    public Leaderboard(String userName, String difficulty, int gameTime, int runtime){
        setUserName(userName);
        setDifficulty(difficulty);
        setRuntime(runtime);
        setGameTime(gameTime);
    }

    @DynamoDBAttribute(attributeName="userName")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @DynamoDBAttribute(attributeName="runtime")
    public int getRuntime() {
        return runtime;
    }

    public void setRuntime(int runtime) {
        this.runtime = runtime;
    }

    @DynamoDBHashKey(attributeName = "escapeId")
    @DynamoDBAutoGeneratedKey
    public String getEscapeId() {
        return escapeId;
    }
    public void setEscapeId(String escapeId) {
        this.escapeId = escapeId;
    }

    @DynamoDBAttribute(attributeName="difficulty")
    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    @DynamoDBAttribute(attributeName="gameTime")
    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int gameTime) {
        this.gameTime = gameTime;
    }
}