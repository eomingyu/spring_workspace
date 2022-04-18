package com.koreait.idev.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.idev.controller.GalleryController;
import com.koreait.idev.mapper.GalleryMapper;
import com.koreait.idev.model.Gallery;

@Service
public class GalleryServiceImpl implements GalleryService {
	private static final Logger logger = LoggerFactory.getLogger(GalleryServiceImpl.class);
	private final GalleryMapper dao;

	public GalleryServiceImpl(GalleryMapper dao) {
		this.dao = dao;
	}

	public List<Gallery> getList() {
		return dao.selectAll();
	}

	public int save(Gallery vo) {
		// 서버에서 전송받은 파일을 저장할 폴더를 정합니다. : c:\\upload
		String path = "c:\\upload"; // \는 출력 또는 문자열로 지정할때는 두번씁니다.
		// view(jsp) 로 전달할 파일명 리스트
		List<String> list = new ArrayList<>();
		// 서버에 전송된 내용 확인 테스트
		StringBuilder filenames = new StringBuilder();
		for (MultipartFile f : vo.getPics()) {
			// 서버에 저장할 파일객체를 생성합니다. : 생성자 인자는 파일객체의 경로와 파일명
//					File sfile = new File(path + "\\" + f.getOriginalFilename());
			if (f.getSize() != 0) {
				String temp = f.getOriginalFilename();
				String ext = temp.substring(temp.lastIndexOf('.'), temp.length()); // 확장자만 추출
				//String newfile =  UUID.randomUUID().toString().substring(0, 8) + ext;
				StringBuilder newfile= new StringBuilder("gallery_")
						.append(UUID.randomUUID().toString().substring(0, 8)).append(ext);
				// 새로운 파일명 - 중복을 최소화하려면 랜덤문자열길이를 늘리세요.
				File sfile = new File(path + "\\" + newfile);
				// f.getOriginalFilename() 는 여러 접속자(사용자)가 중복된 이름을 사용할수 있어요.
				// -> 파일명은 서버에서 임의로 정해줄것입니다.
				try {
					// MultipartFile f 로 전송받은 파일을 참조하고 있으므로
					f.transferTo(sfile); // 서버에 저장할 파일객체로 전송합니다. (서버 업로드)
					filenames.append(newfile).append(",");
				} catch (IllegalStateException | IOException e) {
					// logger.info("파일 전송오류 : " + e.getMessage());
				}
			}
		}
		vo.setFilenames(filenames.toString());
		return dao.insert(vo);
	}
}
