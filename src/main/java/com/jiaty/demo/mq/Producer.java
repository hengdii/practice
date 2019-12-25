package com.jiaty.demo.mq;

/**
 * @program: practice
 * @description: mq生产者
 * @author: jiaty
 * @create: 2019-12-23 11:43
 **/

public class Producer {

//    public static void main(String[] args) throws MQClientException, InterruptedException {
//
//        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
//        //设置namesrv地址
//        producer.setNamesrvAddr("111.231.110.149:9876");
//        //启动生产者
//        producer.start();
//
//        //发送10条消息
//        for (int i = 0; i < 10; i++) {
//            try {
//                Message msg = new Message("TopicTest" /* Topic */,
//                        "TagA" /* Tag */,
//                        ("test message" + i).getBytes(RemotingHelper.DEFAULT_CHARSET) /* Message body */
//                );
//                //设置消息延时级别  3对应10秒后发送
//                msg.setDelayTimeLevel(3);
//
//                SendResult sendResult = producer.send(msg);
//
//                System.out.printf("%s%n", sendResult);
//            } catch (Exception e) {
//                e.printStackTrace();
//                Thread.sleep(1000);
//            }
//        }
//
//        /*
//         * Shut down once the producer instance is not longer in use.
//         */
//        producer.shutdown();
//    }

}