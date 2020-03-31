package com.github.ruanshengwei.socketmvc.support;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class RequestBody {

    private String url;

    private JSONObject parameters;


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public JSONObject getParameters() {
        return parameters;
    }

    public void setParameters(JSONObject parameters) {
        this.parameters = parameters;
    }
}
