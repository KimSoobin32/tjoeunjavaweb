package com.adamsoft.item.service;

import java.util.List;

import com.adamsoft.item.domain.ItemDTO;

public interface ItemService {	
	public List<ItemDTO> getAll();	//테이블 전체 데이터를 가져오는 메서드
	
	public ItemDTO getItem(Integer itemid);	//상세보기 처리를 위한 메서드
}
