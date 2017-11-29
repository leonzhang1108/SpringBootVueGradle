package com.leon.base;

/**
 * Author: jianliangzhang
 * Date: 2017/11/29
 * Time: 14:48
 */
public class BaseResponse {


    private Object result;
    private Head head = new Head(0);

    public Object getResult() {
        return result;
    }

    public BaseResponse() {
    }

    public BaseResponse(Object result) {
        this.result = result;
    }
    public BaseResponse(Object result, Head head) {

        this.result = result;
        this.head = head;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public Head getHead() {
        return head;
    }

    public void setHead(Head head) {
        this.head = head;
    }
}
