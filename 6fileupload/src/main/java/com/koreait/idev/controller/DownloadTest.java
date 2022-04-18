package com.koreait.idev.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.idev.model.Upload;

@Controller
public class DownloadTest {
	private static final Logger logger = LoggerFactory.getLogger(DownloadTest.class);

	@GetMapping("upload2")
	public void view(Model model) {
		
	}

	@RequestMapping("/upload2")
	public String fileUpload1(Upload vo,Model model) throws Exception {
		
		List<MultipartFile> docs = vo.getDocs();
		List<String> fileNames = new ArrayList<>();
		List<Long> fileSizes = new ArrayList<>();
		List<String> origins = new ArrayList<>();
		String path = "c:\\upload\\";
		
		for(MultipartFile f : docs) {
			logger.info("getName() : {}" , f.getName());

			if (f.getSize() != 0) {
				logger.info("getOriginalFilename() :{} " , f.getOriginalFilename());
				logger.info("getSize() : {}" , f.getSize());
				
				
				String temp = f.getOriginalFilename();
				origins.add(temp);
				String ext = temp.substring(temp.lastIndexOf('.'), temp.length()); // 확장자만 추출
				String newfile = UUID.randomUUID().toString().substring(0, 8) + ext;  
				//새로운 파일명 - 중복을 최소화하려면 랜덤문자열길이를 늘리세요.
				File sfile = new File(path + "\\" + newfile);
				fileSizes.add(f.getSize());
				// f.getOriginalFilename() 는 여러 접속자(사용자)가 중복된 이름을 사용할수 있어요.
				// -> 파일명은 서버에서 임의로 정해줄것입니다.
				try {
					// MultipartFile f 로 전송받은 파일을 참조하고 있으므로
						f.transferTo(sfile); // 서버에 저장할 파일객체로 전송합니다. (서버 업로드)
						fileNames.add(newfile);
				} catch (IllegalStateException | IOException e) {
					logger.info("파일 전송오류 : " + e.getMessage());
				}
			}	
				
		}
		
		model.addAttribute("fileNames", fileNames);
		model.addAttribute("fileSizes", fileSizes);
		model.addAttribute("origins", origins);
		
		return "upload2";
	}
	
	
	@RequestMapping("/fileDownload")
	public void fileDownload2(String file, HttpServletResponse response) 
			throws Exception{
			
		
		String path ="c:\\upload";
		
		//file = new String(file.getBytes("ISO8859_1"),"UTF-8");
		path = path + "/" + file;
		
		//지정된 경로와 파일명으로 파일객체 생성
		File downloadFile = new File(path);
		
		//파일 다운로드를 위한 설정
		//MIME으로 다운로드라는 것을 설정
		response.setContentType("application/download;charset=utf-8");
		response.setContentLength((int)downloadFile.length());	//파일의 크기
		response.setHeader("Content-Disposition","attachment;filename="+file);
		response.setHeader("Content-Transfer-Encoding", "binary");
		
//파일의 전송 : A(보내는 곳,서버의 경로 파일명)	--스트림--> B(받는 곳, 요청을 보낸 사용자)
		FileInputStream fin = new FileInputStream(downloadFile);
		ServletOutputStream fout = response.getOutputStream();
		
		byte[] buf = new byte[1024];
		int size = -1;
		
		while((size = fin.read(buf,0,buf.length)) != -1) {
			fout.write(buf,0,size);
		}
		
		fin.close();
		fout.close();
		
	}

}
