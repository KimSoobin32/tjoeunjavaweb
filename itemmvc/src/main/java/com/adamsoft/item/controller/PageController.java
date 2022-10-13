package com.adamsoft.item.controller;

import java.io.File;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.adamsoft.item.domain.MemberDTO;
import com.adamsoft.item.domain.ReportDTO;

import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

//Controller를 만들기 위한 어노테이션
@Controller
@Slf4j
@Log4j	//로그 출력을 위한 인스턴스를 생성하기 위한 어노테이션
public class PageController {
	private static final Logger logger = LoggerFactory.getLogger(PageController.class);
	//처리할 url과 전송 방식
	@RequestMapping(value = "blog/{num}", method = RequestMethod.GET)
	//Model은 뷰에게 데이터를 넘기기위한 객체
	public String blog(@PathVariable int num, Model model) {
		//로그 출력
		logger.info("num: "+num);
		
		//뷰에게 데이터 전달
		//num이라는 이름으로 num이라는 데이터를 전달
		model.addAttribute("num",num);
		
		//출력할 뷰 이름 설정
		return "blog";
	}
	
	@RequestMapping(value = "parameter", method = RequestMethod.GET)
	public String parameter(Model model) {
		
		return "parameter";
	}
	
	//파라미터를 HttpServletRequest를 이용해서 읽기
	@RequestMapping(value = "getlink", method = RequestMethod.GET)
	public void getlink(HttpServletRequest request, Model model) {
		String name = request.getParameter("name");
		String job = request.getParameter("job");
		logger.info("name: "+name+", job: "+job);
	}
	
	//파라미터를 @RequestParam을 이용해서 읽기
	@RequestMapping(value = "getform", method = RequestMethod.GET)
	public void getform(@RequestParam("name") String name, @RequestParam("password") String password, Model model) {
		//@RequestParam request.getParameter해오는것과 같음
		logger.info("name: "+name+", password: "+password);
	}
	
	//파라미터를 Command 객체를 이용해서 읽기 - 이 방법 ㅊㅊ
	@RequestMapping(value = "postform", method = RequestMethod.POST)
	public void postform(MemberDTO dto, Model model) {
		
		logger.info("dto: "+dto);	//dto: MemberDTO [name=adan, password=123456] toString()에서 지정한 형태로 나옴..
	}
	
	@RequestMapping(value = "fileupload", method = RequestMethod.POST)
	public void fileupload(ReportDTO dto, HttpServletRequest request) {
		
		if(dto.getPictureurl().isEmpty()) {
			System.out.println("업로드 파일이 없습니다.");
		}else {
			//System.out.println("업로드 파일이 존재합니다.");
			//프로젝트 내의 upload 디렉토리의 절대경로
			String filepath = request.getServletContext().getRealPath("/upload");
			//System.out.println(filepath);	//C:\stsproject\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\wtpwebapps\itemmvc역슬upload
			
			filepath = filepath + "/" + UUID.randomUUID() +dto.getPictureurl().getOriginalFilename();
			
			File file = new File(filepath);
			try {
				dto.getPictureurl().transferTo(file);
			}catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			
		}
		
		//logger.info("dto: "+dto);
	}
	
}
