package com.adamsoft.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
//Builder와 AllArgsConstructor는 세트..같이 써줘야 함

public class MemberDTO {
	private String name;
	private String password;
	/*
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public String toString() {
		return "MemberDTO [name=" + name + ", password=" + password + "]";
	}
*/
}
