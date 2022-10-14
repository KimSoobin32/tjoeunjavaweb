package com.adamsoft.item.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.adamsoft.item.domain.ItemDTO;

@Repository
public interface ItemMapper {
	@Select("select * from ITEM")
	public List<ItemDTO> getAll();
	
	@Select("select * from ITEM where itemid = #{itemid}")
	public ItemDTO getItem(Integer itemid);
}
