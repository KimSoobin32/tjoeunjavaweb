package com.adamsoft.item.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.adamsoft.item.domain.ItemDTO;
//클래스에 @Component를 설정 시 servlet-context.xml
//파일의 component-scan에 설정된 패키지에 속한 경우 bean을 자동 생성
//@repository, @service, @contoller, @restcontroller를 기재하면 역할까지 부여함
@Repository
public class ItemRepository {
	@Autowired
	private SqlSession sqlSession;
	
	//테이블 전체 데이터를 가져오는 메서드
	public List<ItemDTO> getAll() {
		
		return sqlSession.selectList("itemmapper.getall");
	}
	
	/*
	 public 리턴타입 이름(매개변수) {
		return sqlSession.selectList("itemmapper.getall",매개변수);
	}
	 
	*/

}
