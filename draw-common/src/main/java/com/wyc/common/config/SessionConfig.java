package com.wyc.common.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.FilterType;
import org.springframework.session.data.redis.config.annotation.web.http.RedisHttpSessionConfiguration;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
@EnableWebMvc
@Configuration
@ComponentScan(basePackages="com.wyc",
				excludeFilters={
					@Filter(type=FilterType.ASSIGNABLE_TYPE,value=AppConfig.class),
					@Filter(type=FilterType.ASSIGNABLE_TYPE,value=DatabaseConfig.class),
					@Filter(type=FilterType.ASSIGNABLE_TYPE,value=WebConfig.class),
					@Filter(type=FilterType.ASSIGNABLE_TYPE,value=GameWebConfig.class)
})
@EnableAspectJAutoProxy(proxyTargetClass=true)
public class SessionConfig {

//	@Bean
//	public RedisHttpSessionConfiguration redisHttpSessionConfiguration(){
//		RedisHttpSessionConfiguration redisHttpSessionConfiguration = new RedisHttpSessionConfiguration();
//		redisHttpSessionConfiguration.setMaxInactiveIntervalInSeconds(120);
//		return redisHttpSessionConfiguration;
//	}
//	
//	@Bean
//	public JedisConnectionFactory jedisConnectionFactory(){
//		JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
//		jedisConnectionFactory.setHostName("www.chengxihome.com");
//		jedisConnectionFactory.setPort(6379);
//		return jedisConnectionFactory;
//	}
  
}