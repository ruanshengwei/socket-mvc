package com.github.ruanshengwei.socketmvc.config;

import com.alibaba.fastjson.JSONObject;
import com.github.ruanshengwei.socketmvc.annotation.SocketBody;
import com.github.ruanshengwei.socketmvc.support.RequestBody;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author ruanshengwei
 * @email 200976381@qq.com
 */

public class SocketDispatcher {


    public static Map<String, Method> methodMap=new HashMap<String, Method>();

    public static Map<String,Object> beanMap = new HashMap<String, Object>();

    public Object dispatcher(RequestBody requestBody) throws Exception {


        String path = requestBody.getUrl();
        Method method = methodMap.get(path);
        Object targetBean = beanMap.get(path);

        JSONObject requestBodyObject =requestBody.getParameters();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Annotation[][] parameterAnnotations = method.getParameterAnnotations();
        List<Object> objectList=new LinkedList<Object>();

        for (int i=0;i<parameterTypes.length;i++){
            Class clazz = parameterTypes[i];
            SocketBody socketBody = (SocketBody) parameterAnnotations[i][0];
            objectList.add(requestBodyObject.getJSONObject(socketBody.name()).toJavaObject(clazz));
        }

        Object ret = method.invoke(targetBean,objectList.toArray());

        return ret;
    }


}
