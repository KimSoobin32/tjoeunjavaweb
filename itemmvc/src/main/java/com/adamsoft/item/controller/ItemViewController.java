package com.adamsoft.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adamsoft.item.domain.ItemDTO;
import com.adamsoft.item.service.ItemService;

@Controller
public class ItemViewController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public String getAll() {
		//필요한 서비스 메서드 호출.
		List<ItemDTO> list = itemService.getAll();
		System.out.println(list);
		
		
		return "";
	}
	
}
