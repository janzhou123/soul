package org.dromara.soul.test.dubbo.consumer.entity;

import lombok.Data;

/**
 * Created by Administrator on 2019/7/19.
 */
@Data
public class DubboBody {
  String interfaceName;
  String method;
  String params;
  String paramClass;
  Object[] classParams;
}
