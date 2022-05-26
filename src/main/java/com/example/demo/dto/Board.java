package com.example.demo.dto;

import lombok.Data;

@Data
public class Board {
	private int num;
	private String id;
	private String name;
	private String subject;
	private String content;
	private String regist_day;
	private int hit;
	private String ip;

}
