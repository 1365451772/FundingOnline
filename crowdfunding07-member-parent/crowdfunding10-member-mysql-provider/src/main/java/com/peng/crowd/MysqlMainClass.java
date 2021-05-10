package com.peng.crowd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// 扫描MyBatis的Mapper接口所在的包
@MapperScan("com.peng.crowd.mapper")
@SpringBootApplication
public class MysqlMainClass {
	
	public static void main(String[] args) {
		SpringApplication.run(MysqlMainClass.class, args);
	}

}
