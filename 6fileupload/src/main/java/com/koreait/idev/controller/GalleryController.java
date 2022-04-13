package com.koreait.idev.controller;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.idev.model.Gallery;

@Controller
public class GalleryController {

	private static final Logger logger = LoggerFactory.getLogger(GalleryController.class);
	
	@GetMapping("gallery")
	public void view() {
		
	}
	
	@PostMapping("gallery")
	public void upload(Gallery vo) {
		//서버에서 전송받은 파일을 저장할 폴더를 정합니다. : c:\\upload
		String path = "c:\\upload";	//	\는 출력 문자열로 지정할 때는 두번씁니다.
		
		//서버에 전송된 내용 확인 테스트
		logger.info("title: "+vo.getTitle());
		for(MultipartFile f : vo.getPics()) {
			logger.info("파일명 : "+f.getOriginalFilename());	//전송받은 파일 명
			logger.info("파일 크기 : "+f.getSize());			//전송받은 파일 크기
			logger.info("랜덤 문자열 : "+UUID.randomUUID().toString());
			//서버에 저장할 파일 객체를 생성합니다. : 생성자 인자는 파일 객체의 경로와 파일명
//			File sfile = new File(path+"\\"+f.getOriginalFilename());
			String temp = f.getOriginalFilename();
			String ext = temp.substring(temp.indexOf('.'),temp.length());	//확장자만 추출
			File sfile = new File(path+"\\"+UUID.randomUUID().toString().substring(0, 8)+ext);
			//f.getOriginalFilename()은 여러 접속자(사용자)가 중복된 이름을 사용할 수 있어요.
			//-> 파일명은 서버에서 임의로 정해줄 것입니다.
			
			//MultipartFile f로 전송받은 파일을 참조하고 있으므로
			try {						//서버에 저장할 파일 객체로 전송합니다.(서버 업로드)
				f.transferTo(sfile);
			} catch (IllegalStateException | IOException e) {
				logger.info("파일 전송 오류 : "+e.getMessage());
				e.printStackTrace();
			}
		}
		
	}
	
	
}
