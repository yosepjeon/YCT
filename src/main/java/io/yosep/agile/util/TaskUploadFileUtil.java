package io.yosep.agile.util;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

import io.yosep.agile.task.domain.dto.TaskDTO;
import io.yosep.agile.task.domain.dto.TaskFileDTO;

public class TaskUploadFileUtil {
	private static final Logger logger = LoggerFactory.getLogger(TaskUploadFileUtil.class);
	
	public static boolean makeFirstTaskFile(TaskDTO taskDTO,TaskFileDTO[] taskFileDTO) {
		String[] fileUrls;
		String path = "";
		List<MultipartFile> uploadFiles = taskDTO.getAttachments();
		fileUrls = new String[uploadFiles.size()];
		
		path = "/Users/jeon-yoseb/documents/yosep-spring_agile_cooperation_tool/tasks/"
				+ taskDTO.getTaskId() + "/";
		
		makeTaskDirectory(path);
		
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
				taskFileDTO[fileIdx] = new TaskFileDTO();
				taskFileDTO[fileIdx].setFileName(fileName);
				taskFileDTO[fileIdx].setFileUrl(path + fileName);
				taskFileDTO[fileIdx++].setTaskId(taskDTO.getTaskId());
			}
			
			return true;
		}
	}
	
	private static void makeTaskDirectory(String path) {
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
