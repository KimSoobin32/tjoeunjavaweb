package com.adamsoft.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adamsoft.item.dao.ItemMapper;
import com.adamsoft.item.domain.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	//private ItemRepository itemRepository;
	
	private ItemMapper itemRepository;

	@Override
	public List<ItemDTO> getAll() {
		
		return itemRepository.getAll();
	}

	@Override
	public ItemDTO getItem(Integer itemid) {
		//실제는 비즈니스 로직 들어감
		return itemRepository.getItem(itemid);
	}
	
	
	
}
