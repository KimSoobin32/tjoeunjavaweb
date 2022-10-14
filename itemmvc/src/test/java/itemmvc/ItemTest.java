package itemmvc;

import java.sql.Connection;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.adamsoft.item.dao.ItemRepository;

//테스트를 위한 클래스 로드
//JUnit - 자바의 단위 테스트를 라이브러리, eclipse 내장
//배달의 민족 tdd
@RunWith(SpringJUnit4ClassRunner.class)

//설정 파일을 읽어옴
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"
		,"file:src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml"})

public class ItemTest {
	//DataSource 주입
	@Autowired
	private DataSource dataSource;
	//테스트 메서드를 만들기 위한 어노테이션
	//@Test
	public void testConnection() {
		try(Connection con = dataSource.getConnection()){
			System.out.println(con);
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		/*
		ItemDTO dto = new ItemDTO();
		dto.setItemid(1);
		dto.setItemname("사과");
		
		//빌드 아용 시
		ItemDTO dto1 = ItemDTO.builder().itemid(1).itemname("사과").build();	//인스턴스 생성과 대입을 한번에 가능
		여기서 빠진 속성은 기본값이 들어감..
		*/
	}
	
	@Autowired
	private SqlSession sqlSession;
	
	//@Test
	public void testMyBatis() {
		System.out.println(sqlSession);
	}
	
	@Autowired
	private ItemRepository itemRepository;
	
	//@Test
	public void testGetAll() {
		System.out.println(itemRepository.getAll());
	}
}
