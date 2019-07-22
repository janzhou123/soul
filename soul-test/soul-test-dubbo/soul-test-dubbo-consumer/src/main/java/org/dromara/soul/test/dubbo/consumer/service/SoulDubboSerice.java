package org.dromara.soul.test.dubbo.consumer.service;

import cn.hutool.http.Header;
import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSONObject;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.dromara.soul.common.constant.Constants;
import org.dromara.soul.test.dubbo.api.entity.DubboTest;
import org.dromara.soul.test.dubbo.consumer.entity.DubboBody;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2019/7/19.
 */
@Service
@Slf4j
public class SoulDubboSerice {


  public String findById(String name){
    String url = "http://127.0.0.1:8086/";

    DubboBody dubboBody = new DubboBody();

    dubboBody.setInterfaceName("org.dromara.soul.test.dubbo.api.service.DubboTestService");
    dubboBody.setMethod("findById");

    Map temp = new HashMap<>();
    temp.put("java.lang.String",name);

    dubboBody.setParams(JSONObject.toJSONString(temp));
    String sendBody = JSONObject.toJSONString(dubboBody);
    log.info("=================sendBody="+sendBody);
    String result = HttpRequest.post(url)
        .header(Constants.MODULE,"getdubbo")
        .header(Constants.METHOD,"findDemo")
        .header(Constants.RPC_TYPE,"dubbo")
        .header(Header.CONTENT_TYPE,"application/json")
        .body(sendBody).execute().body();

    log.info("================result="+result);

    return result;


  }

  public String insert(DubboTest dubboTest) {
    String url = "http://127.0.0.1:8086/";
    DubboBody dubboBody = new DubboBody();
    dubboBody.setInterfaceName("org.dromara.soul.test.dubbo.api.service.DubboTestService");
    dubboBody.setMethod("insert");

    String[] paramClass = new String[]{"org.dromara.soul.test.dubbo.api.entity.DubboTest"};//参数类型  string数组
    //当参数是 POJO的时候
    dubboBody.setParamClass(JSONObject.toJSONString(paramClass));
    Object[] classParams= new Object[]{dubboTest};//参数值 object 数组
    dubboBody.setClassParams(classParams);
    String sendBody = JSONObject.toJSONString(dubboBody);
    log.info("=================sendBody="+sendBody);
    String result = HttpRequest.post(url)
        .header(Constants.MODULE,"getdubbo")
        .header(Constants.METHOD,"findDemo")
        .header(Constants.RPC_TYPE,"dubbo")
        .header(Header.CONTENT_TYPE,"application/json")
        .body(sendBody).execute().body();

    log.info("================result="+result);
    return result;
  }




}
