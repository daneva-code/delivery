package com.deliver.response;

import java.util.Map;

public class RestResponse {
    private int statusCode;
    private Object body;
    private Map<String, String> headres;

    public RestResponse() {}

    public RestResponse(int statusCode, Object body, Map<String, String> headres) {
        this.statusCode = statusCode;
        this.body = body;
        this.headres = headres;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }

    public Map<String, String> getHeadres() {
        return headres;
    }

    public void setHeadres(Map<String, String> headres) {
        this.headres = headres;
    }

    @Override
    public String toString() {
        return "RestResponse{" +
                "statusCode=" + statusCode +
                ", body=" + body +
                ", headres=" + headres +
                '}';
    }
}