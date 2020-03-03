package com.jiaty.demo.scheduled;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @program: Practice
 * @description: 定时任务
 * @author: Jiaty
 * @create: 2020-03-03 16:28
 **/
@Component
public class DeleteImgTest implements ApplicationRunner {

    /**
     *
     *  实现ApplicationRunner，可以实现在项目启动时就执行任务～
     *
     */

//    @Resource
//    ScheduledExecutorService scheduledExecutorService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(args);
        System.out.println("这个是测试ApplicationRunner接口");
        startDeleteImgService();
    }

    //定时器
    public void startDeleteImgService() {
        System.out.println("启动删除＝＝＝＝");
//        scheduledExecutorService.schedule(RunTest::new, Long.parseLong("3"), TimeUnit.SECONDS);
    }

}