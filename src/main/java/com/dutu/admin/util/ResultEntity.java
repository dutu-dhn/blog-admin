package com.dutu.admin.util;

/**
 * @author dutu
 * @date 2021-03-13 14:19
 */
public class ResultEntity<T> {

    public static final String SUCCESS = "SUCCESS";
    public static final String FAILED = "FAILED";

    /**
     * 用来封装当前请求处理的结果
     */
    private String result;
    /**
     * 请求处理失败返回的错误信息
     */
    private String message;
    /**
     * 要返回的数据
     */
    private T data;

    /**
     * 请求处理成功且不需要返回数据
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> successWhithoutData(){
        return new ResultEntity<E>(SUCCESS,null,null);
    }

    /**
     * 请求处理成功且需要返回数据
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> successWhithData(E data){
        return new ResultEntity<E>(SUCCESS,null,data);
    }

    /**
     * 请求处理失败
     * @param <E>
     * @return
     */
    public static <E> ResultEntity<E> failed(String message){
        return new ResultEntity<E>(FAILED,null,null);
    }

    public String getResult() {
        return result;
    }

    public String getMessage() {
        return message;
    }

    public T getData() {
        return data;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResultEntity(String result, String message, T data) {
        this.result = result;
        this.message = message;
        this.data = data;
    }

    public ResultEntity() {
    }


}
