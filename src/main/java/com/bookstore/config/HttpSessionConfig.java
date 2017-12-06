//package com.bookstore.config;
////1. Create Spring Session to replace HttpSession
////2. Create a ConnectionFactory to connect Spring Session to Redis
//import org.springframework.context.annotation.Bean;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//@EnableRedisHttpSession
////Spring session is backed by Redis
////Spring Configuration
//public class HttpSessionConfig {
//
//	@Bean
//	public LettuceConnectionFactory connectionFactory(){
//		return new LettuceConnectionFactory();
//	}//connects Spring Session to the Redis Server.(Connect to localhost on default port(6379))
//}

package com.bookstore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableRedisHttpSession
public class HttpSessionConfig {
	
	@Bean
	public LettuceConnectionFactory connectionFactory() {
		return new LettuceConnectionFactory();
	}

}
