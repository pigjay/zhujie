package com.pigganme.framework.config.mq;

/**
 * @Author:zhujie
 * @Date: Create in 11:43 2017/11/28
 **/
public class RocketConfig {
    /**
     * 启动测试之前请替换如下 XXX 为您的配置
     */
    public  static  final  String PUBLIC_TOPIC = "test";//公网测试
    public  static  final  String PUBLIC_PRODUCER_ID = "PID_SCHEDULER";
    public  static  final  String PUBLIC_CONSUMER_ID = "CID_SERVICE";

    public  static  final  String ACCESS_KEY = "123";
    public  static  final  String SECRET_KEY = "123";
    public  static  final  String TAG = "";
    public  static  final  String THREAD_NUM = "25";//消费端线程数

    /**
     * ONSADDR 请根据不同Region进行配置
     * 公网测试: http://onsaddr-internet.aliyun.com/rocketmq/nsaddr4client-internet
     * 公有云生产: http://onsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal
     * 杭州金融云: http://jbponsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal
     * 深圳金融云: http://mq4finance-sz.addr.aliyun.com:8080/rocketmq/nsaddr4client-internal
     */
    public static final String ONSADDR = "http://onsaddr-internal.aliyun.com:8080/rocketmq/nsaddr4client-internal";

}
