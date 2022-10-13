package com.adamsoft.item.domain;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Setter
@Getter
@ToString
public class ReportDTO {
	private String name;
	private MultipartFile pictureurl;	//file은 MultipartFile로 생성
	//폼으로 전송하는 name과 같은 이름으로..
}
