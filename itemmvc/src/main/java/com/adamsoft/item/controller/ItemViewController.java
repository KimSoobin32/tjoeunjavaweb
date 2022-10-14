package com.adamsoft.item.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.adamsoft.item.domain.ItemDTO;
import com.adamsoft.item.service.ItemService;

@Controller
public class ItemViewController {
	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "getall", method = RequestMethod.GET)
	public String getAll(Model model) {
		//필요한 서비스 메서드 호출.
		List<ItemDTO> list = itemService.getAll();
		//System.out.println(list);
		
		//뷰에 데이터를 전달
		model.addAttribute("list",list);
		
		//뷰이름 - ViewResolver와 합쳐져서 실제 뷰가 결정
		return "item/list";
	}
	
	//파라미터 형태로 넘어오는 상세보기 요청 처리
	@RequestMapping(value = "getitem/{itemid}", method = RequestMethod.GET)
	public String getItem(@PathVariable("itemid") Integer itemid, Model model) {
		
		ItemDTO dto = itemService.getItem(itemid);
		model.addAttribute("item",dto);
		
		return "item/getitem";
	}
	
}
