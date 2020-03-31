package com.github.ruanshengwei.socketmvc.dto;

import com.alibaba.fastjson.JSONObject;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class RequestBody {

    private String name;

    private JSONObject object;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public JSONObject getObject() {
        return object;
    }

    public void setObject(JSONObject object) {
        this.object = object;
    }
}
