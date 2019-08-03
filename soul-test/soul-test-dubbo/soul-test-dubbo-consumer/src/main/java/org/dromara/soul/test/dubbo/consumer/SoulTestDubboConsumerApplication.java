package org.dromara.soul.test.dubbo.consumer;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class SoulTestDubboConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(SoulTestDubboConsumerApplication.class, args);
  }

}
