package com.prac;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com")
public class DemoConfiguration {
	
	@Bean("scan1")
	public Scanner getScanner() {
		return new Scanner(System.in);
	}
	@Bean
    public List<String> getList() {
        return List.of("A","B","C");
    }
	@Bean
	public Map<Character,Integer> getMap(){
		Map<Character, Integer> map = new LinkedHashMap<>();
		map.put('Y',1);
		map.put('a',1);
		map.put('s', 1);
		map.put('h', 1);
		map.put('h', 2);
		return map;
	}
}
