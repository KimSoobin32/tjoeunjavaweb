package com.adamsoft.item.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adamsoft.item.dao.ItemRepository;
import com.adamsoft.item.domain.ItemDTO;

@Service
public class ItemServiceImpl implements ItemService {
	@Autowired
	private ItemRepository itemRepository;

	@Override
	public List<ItemDTO> getAll() {
		
		return itemRepository.getAll();
	}
	
	
	
}
