package com.adamsoft.item.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.adamsoft.item.domain.ItemDTO;
import com.adamsoft.item.service.ItemService;

@RestController
public class ItemRestController {
	@Autowired
	private ItemService itemService;
	
	//테이블의 데이터 전체 출력
	@RequestMapping(value = "list.json", method = RequestMethod.GET)
	public Map<String, Object> getAll(){
		Map<String, Object> map = new HashMap<String, Object>();
		List<ItemDTO> list = itemService.getAll();
		map.put("result", true);
		map.put("data",list);
		return map;
	}
	
	//상세보기
	@RequestMapping(value = "{itemid}/item.json", method = RequestMethod.GET)
	public Map<String, Object> getItem(@PathVariable("itemid") Integer itemid){
		Map<String, Object> map = new HashMap<String, Object>();
		ItemDTO item = itemService.getItem(itemid);
		map.put("result", true);
		map.put("data", item);
		return map;
	}
	
}
