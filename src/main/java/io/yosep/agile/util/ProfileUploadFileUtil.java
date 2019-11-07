package io.yosep.agile.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

import io.yosep.agile.user.model.dto.UserDTO;

public class ProfileUploadFileUtil {
	private static final Logger logger = LoggerFactory.getLogger(ProfileUploadFileUtil.class);
	
	/*
	 * 작성일: 2019년 06월 06일 
	 * 작성자: 전요셉
	 * 내용: 프로필 파일 업로드를 위한 유틸 클래스 해당 클래스에서 UUID 및 프로필/아이디별 디렉토리를 생성하여 해당 디렉토리에 
	 * 계정에 대한 프로필 이미지를 저장한다.
	 */
	public static String uploadFile(String uploadPath, String originalName,String userId, byte[] fileData) throws Exception {
		// UUID 발급
		UUID uuid = UUID.randomUUID();
		// 저장할 파일명 = UUID + 원본이름
		String savedName = uuid.toString() + "_" + originalName;
		// 업로드할 (프로필/아이디별 폴더) 생성
		String savedPath = calcPath(uploadPath,userId);
		// 파일 경로(기존의 업로드 경로 + userId별 경로), 파일명을 받아 파일 객체 생성
		File target = new File(uploadPath + savedPath, savedName);
		// 임시 디렉토리에 업로드된 파일을 지정된 디렉토리롭 복사
		FileCopyUtils.copy(fileData, target);
		// 썸네일을 생성하기 위한 파일의 확장자 검사
		// 파일명이 aaa.bbb.ccc.jpg일 경우 마지막 마침표를 찾기 위해
		String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
		String uploadedFileName = null;
		// 썸네일 사용
		if(MediaUtils.getMediaType(formatName) != null) {
			// 썸네일 생성
			uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
			// 나머지는 아이콘
		}else {
			// 아이콘 생성
			uploadedFileName = makeIcon(uploadPath, savedPath,savedName);
		}
		
		return uploadedFileName;
	}
	
	/*
	 * 작성일: 2019년 06월 10일
	 * 작성자: 전요셉
	 * 내용: 첫 계정을 생성할때 해당 계정에 대한 프로필 생성 기능을 가진 메서드 구현
	 */
	public static void makeFirstProfile(UserDTO userDTO) {
		String profileImg = "";
		String defaultPath = "";
		String path = "";

		// 개발/운영 서버용 설정값 적용하기 -> 아직 미구현
		defaultPath = "/Users/jeon-yoseb/Documents/yosep-spring_agile_cooperation_tool/profiles/default/default-profile.gif";
		path = "/Users/jeon-yoseb/Documents/yosep-spring_agile_cooperation_tool/profiles/"
				+ userDTO.getUserId() + "/";

		makeProfileDirectory(path,userDTO.getUserId());
		
		if (!userDTO.getProfileImg().isEmpty()) {
//			profileImg = userDTO.getProfileImg().getOriginalFilename();
			String fileName = userDTO.getProfileImg().getOriginalFilename();
			int findEnxtension = fileName.lastIndexOf("."); 
			profileImg = userDTO.getUserId() + userDTO.getProfileImg().getOriginalFilename().substring(findEnxtension, fileName.length());
			try {
				// 임시 디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
				userDTO.getProfileImg().transferTo(new File(path + profileImg));
			} catch (Exception e) {
				e.printStackTrace();
			}

			userDTO.setProfileUrl(profileImg);
		} else {
			try {
				profileImg = userDTO.getUserId() + ".gif";
				String defaultPathFullName = path + profileImg;
				FileInputStream fis = new FileInputStream(defaultPath);
				FileOutputStream fos = new FileOutputStream(defaultPathFullName);

				int data = 0;
				while ((data = fis.read()) != -1) {
					fos.write(data);
				}
				fis.close();
				fos.close();

				userDTO.setProfileUrl(profileImg);
			} catch (IOException ie) {
				ie.printStackTrace();
			}
		}
	}
	
	/*
	 * 작성일: 2019년 06월 10일
	 * 작성자: 전요셉
	 * 내용: 프로필 생성시 해당 유저에 대한 프로필 파일을 저장하는 디렉토리 생성 메서드,
	 * 기존 메서드를 컨트롤러 단에서 유틸 클래스로 옮김
	 */
	private static void makeProfileDirectory(String path, String userId) {
		System.out.println("call makeProfileDriectory");
		String directoryPath = path.substring(0, path.length()-1);
		System.out.println(directoryPath);
		try {
			File file = new File(path);
			File[] files = file.listFiles();
			if (file.exists()) {
				for(File f : files) {
					f.delete();
					logger.info("디렉토리 내의 파일 삭제완료");
				}
				new File(path).delete();
			}
			file = new File(directoryPath);
			if(file.exists()) {
				file.delete();
				logger.info("디렉토리 삭제완료.");
			}
			
			new File(path).mkdirs(); // 해당 경로에 대하여 디렉토리 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/*
	 * 작성일: 2019년 06월 06일
	 * 작성자: 전요셉
	 * 내용: 아이디별 디렉토리를 추출하여 경로를 생성해내는 메서드
	 */
	private static String calcPath(String uploadPath, String userId) {
		// profile 디렉토리
		String profilePath = File.separator + "profile";
		// userId 디렉토리
		String userIdPath = profilePath + File.separator + userId;
		// 디렉토리 생성 메서드 호출
		makeDir(uploadPath, profilePath, userIdPath);
		
		return userIdPath;
	}
	
	// (프로필/아이디별 디렉토리 추출)
	private static void makeDir(String uploadPath,String... paths) {
		// 디렉토리가 존재하면
		if(new File(paths[paths.length-1]).exists()) {
			new File(paths[paths.length-1]).delete();
//			return;
		}
		
		// 디렉토리가 존재하지 않으면
		for(String path : paths) {
			File dirPath = new File(uploadPath + path);
			
			// 디렉토리가 존재하지 않으면
			if(!dirPath.exists()) {
				dirPath.mkdir();
			}
		}
	}
	
	/*
	 * 작성일: 2019년 06월 06일
	 * 작성자: 전요셉
	 * 내용: 썸네일을 생성하는 기능을 가진 메서드 구현 
	 */
	private static String makeThumbnail(String uploadPath, String path, String fileName) throws Exception {
		// 이미지를 읽기 위한 버퍼
		BufferedImage sourceImg = ImageIO.read(new File(uploadPath + path, fileName));
		// 100픽셀 단위의 썸네일 생성
		BufferedImage destImg = Scalr.resize(sourceImg, Scalr.Method.AUTOMATIC, Scalr.Mode.FIT_TO_HEIGHT,100);
		// 썸네일의 이름을 생성(원본파일명에 's_'를 붙임
		String thumbnailName = uploadPath + path + File.separator + "s_" + fileName;
		File newFile = new File(thumbnailName);
		String formatName = fileName.substring(fileName.lastIndexOf("."+1));
		// 썸네일 생성
		ImageIO.write(destImg, formatName.toUpperCase(), newFile);
		// 썸네일의 이름을 리턴함
		return thumbnailName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
	
	/*
	 * 작성일: 2019년 06월 06일 
	 * 작성자: 전요셉
	 * 내용: 아이콘을 생성하는 기능을 가진 메서드 구현
	 */
	private static String makeIcon(String uploadPath,String path, String fileName) throws Exception {
		// 아이콘의 이름
		String iconName = uploadPath + path + File.separator + fileName;
		// 아이콘 이름을 리턴
		// File.separatorChar: 디렉토리 구분자
		// 윈도우 \, 유닉스(리눅스) /
		return iconName.substring(uploadPath.length()).replace(File.separatorChar, '/');
	}
}
