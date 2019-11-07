package io.yosep.agile.util;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import io.yosep.agile.project.model.dto.ProjectDTO;
import io.yosep.agile.project.model.dto.ProjectFileDTO;
import io.yosep.agile.project.model.dto.ProjectUserDTO;

public class ProjectUploadFileUtil {
	private static final Logger logger = LoggerFactory.getLogger(ProjectUploadFileUtil.class);

	// 작성일: 2019년 06월 13일
	// 작성자: 전요셉
	// 내용: 프로젝트 파일 업로드를 위한 유틸 메소드 UUID를 생성하여 해당 경로에 파일 업로드
	public static String uploadFile(String uploadPath, String originalName, String userId, byte[] fileData)
			throws IOException {

		return null;
	}

	// 작성일: 2019년 06월 13일
	// 작성자: 전요셉
	// 내용: 프로젝트를 생성할때 해당 프로젝트에 대한 설명을 하는 파일을 생성하는 기능을 가진 메서드
	public static boolean makeFirstProjectFile(ProjectDTO projectDTO, ProjectFileDTO[] projectFileDTO) {
		String[] fileUrls;
		String defaultPath = "";
		String path = "";
		List<MultipartFile> uploadFiles = projectDTO.getProjectFiles();
		fileUrls = new String[uploadFiles.size()];

		// 개발/운영 서버용 설정값 적용하기 -> 아직 미구현 따로 외부 설정 파일을 만들어서 적용 예정
		defaultPath = "";
		path = "/Users/jeon-yoseb/documents/yosep-spring_agile_cooperation_tool/projects/"
				+ projectDTO.getProjectId() + "/";

		makeProjectDirectory(path, projectDTO.getProjectId());

		if (uploadFiles.size() == 1 && uploadFiles.get(0).getOriginalFilename().equals("")) {
			return false;
		} else{
			int fileIdx = 0;
			for (MultipartFile mf : uploadFiles) {
				if(mf.getOriginalFilename().equals(""))
					continue;
				String fileName = mf.getOriginalFilename();
				System.out.println("fileName: " + fileName);
				int findExtension = fileName.lastIndexOf(".");
				fileUrls[fileIdx] = mf.getOriginalFilename()
						+ mf.getOriginalFilename().substring(findExtension, fileName.length());
				try {
					// 임시 디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
					mf.transferTo(new File(path + fileName));
				} catch (Exception e) {
					e.printStackTrace();
				}
				projectFileDTO[fileIdx] = new ProjectFileDTO();
				projectFileDTO[fileIdx].setFileName(fileName);
				projectFileDTO[fileIdx].setFileUrl(path + fileName);
				projectFileDTO[fileIdx++].setProjectId(projectDTO.getProjectId());
			}
			
			return true;
		} 
	}

	// 작성일: 2019년 06월 13일
	// 작성자: 전요셉
	// 내용: 프로젝트 생성시 해당 프로젝트에 대한 초기 설명파일을 저장하는 디렉토리 생성 메서드
	private static void makeProjectDirectory(String path, String projectId) {
		String directoryPath = path.substring(0, path.length() - 1);
		try {
			File file = new File(path);
			File[] files = file.listFiles();

			if (file.exists()) {
				for (File f : files) {
					f.delete();
					logger.info("디렉토리 내의 삭제되지 않고 존재하는 파일들 삭제완료");
				}
				new File(path).delete(); // 디렉토리 삭제
			}

			file = new File(directoryPath);
			if (file.exists()) {
				file.delete();
				logger.info("디렉토리 삭제 완료");
			}

			new File(path).mkdirs(); // 해당 경로에 대하여 디렉토리 생성
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
