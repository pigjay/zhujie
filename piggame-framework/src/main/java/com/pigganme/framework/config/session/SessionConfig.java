package com.pigganme.framework.config.session;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//maxInactiveIntervalInSeconds: 设置Session失效时间，
//使用Redis Session之后，原Boot的server.session.timeout属性不再生效
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {

	@Value("${spring.redis.host:192.168.158.128}")
	private String hostName;
	
	@Value("${spring.redis.port:6379}")
	private int port;
	@Bean
	public JedisConnectionFactory connectionFactory() {
		JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
		connectionFactory.setPort(port);
		connectionFactory.setHostName(hostName);
		return connectionFactory;
	}
}
