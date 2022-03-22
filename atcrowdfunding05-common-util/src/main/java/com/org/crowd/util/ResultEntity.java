package com.org.crowd.util;

public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    //请求错误时，返回的错误信息
    private String message;

    //要返回的数据
    private T date;

    //封装当前请求的处理结果是成功还是失败
    private String result;

    public static <Type> ResultEntity<Type> failed(String message) {
        return new ResultEntity<Type>(null,null,FAILED);
    }

    public static <Type> ResultEntity<Type> successWithData(Type data){
        return new ResultEntity<Type>(null,data,SUCCESS);
    }

    public static <Type> ResultEntity<Type> successWithoutData() {
        return new ResultEntity<Type>(null,null,SUCCESS);
    }


    public ResultEntity(String message, T date, String result) {
        this.message = message;
        this.date = date;
        this.result = result;
    }

    public ResultEntity() {
    }

    public static String getSUCCESS() {
        return SUCCESS;
    }

    public static String getFAILED() {
        return FAILED;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDate() {
        return date;
    }

    public void setDate(T date) {
        this.date = date;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "ResultEntity{" +
                "message='" + message + '\'' +
                ", date=" + date +
                ", result='" + result + '\'' +
                '}';
    }
}
