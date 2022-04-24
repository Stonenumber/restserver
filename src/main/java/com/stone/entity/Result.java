package com.stone.entity;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Result { //返回对象

    private int id;

    private Boolean success;

    private String message;


    private Map<String, Object> data = new HashMap<String, Object>();

    private Result(){}

    public static Result ok(){
        Result result = new Result();
        result.setSuccess(true);
        result.setMessage("Success");
        return result;
    }

    public static Result error(){
        Result result = new Result();
        result.setSuccess(false);
        result.setMessage("you can choose Integer, String or BigDecimal as your type.");
        return result;
    }

    public Result data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public Result id(int id){
        this.setId(id);
        return this;
    }


    public Result success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public Result message(String message){
        this.setMessage(message);
        return this;
    }


}
