package org.dromara.soul.test.dubbo.consumer.service;

import static org.junit.Assert.*;

import cn.hutool.core.util.RandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.dromara.soul.test.dubbo.api.entity.DubboTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class SoulDubboSericeTest {
  @Autowired
  private  SoulDubboSerice soulDubboSerice;

  @Test
  public void findById() {
    soulDubboSerice.findById(RandomUtil.randomString(10));
  }
  @Test
  public void insert() {
    DubboTest dubboTest = new DubboTest();
    dubboTest.setId("1111111");
    dubboTest.setName(RandomUtil.randomString(10));
    soulDubboSerice.insert(dubboTest);
  }


}