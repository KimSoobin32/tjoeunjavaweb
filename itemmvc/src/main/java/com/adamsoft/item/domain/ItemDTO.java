package com.adamsoft.item.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor	//생성자 만들어줌
@NoArgsConstructor
@Builder
public class ItemDTO {
	private int itemid;
	private String itemname;
	private int price;
	private String description;
	private String pictureurl;
}
