package io.yosep.agile.user.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import io.yosep.agile.user.model.dto.UserDTO;
import io.yosep.agile.user.service.UserService;
import io.yosep.agile.util.ProfileUploadFileUtil;

/*
 * 2019년 6월 4일
 * 작성자: 전요셉
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	UserService userService;

	// xml에 설정된 리소스 참조
	// bean의 uploadPath인 태그를 참조
	@Resource(name = "userProfileUploadPath")
	String uploadPath;

	/*
	 * 작성일: 2019년 06월 04일 작성자: 전요셉
	 * 내용: 로그인 화면으로 이동
	 */
	@RequestMapping(value = "/login")
	public String login() {
		return "/user/login";
	}
	
	/*
	 * 작성일: 2019년 06월 06일
	 * 작성자: 전요셉
	 * 내용: 로그인 처리
	 */
	@RequestMapping(value="/loginCheck", method=RequestMethod.POST)
	public ModelAndView loginCheck(@ModelAttribute UserDTO userDTO, HttpSession session) {
		boolean result = userService.loginCheck(userDTO, session);
		ModelAndView mav = new ModelAndView();
		
		if(result == true) {
			// 로그인 성공
			mav.setViewName("redirect:/dashboard/index");
			mav.addObject("login","success");
		}else {
			// 로그인 실패
			mav.setViewName("/user/login");
			mav.addObject("login","fail");
		}
		return mav;
	}

	/*
	 * 작성일: 2019년 06월 04일 작성자: 전요셉 내용: 회원 등록 페이지로 이동
	 */
	@RequestMapping(value = "/goToRegister")
	public String goToRegisterPage() {
		return "/user/registerUser";
	}

	/*
	 * 작성일: 2019년 06월 04일 작성자: 전요셉 내용: 회원 등록 처리 후 ==> login화면으로 리다이렉트
	 */
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public String userRegister(@ModelAttribute UserDTO userDTO) {
		ProfileUploadFileUtil.makeFirstProfile(userDTO);
		
		userService.insertUser(userDTO);
		
		return "redirect:/user/login";
	}
	
	/*
	 * 작성일: 2019년 06월 10일
	 * 작성자: 전요셉
	 * 내용: ID 중복체크(Ajax)방식
	 */
	@RequestMapping(value="/checkDupId", method=RequestMethod.GET)
	public ResponseEntity<String> checkDuplicateUserId(@RequestParam("userId")String userId) {
//		System.out.println("call checkDup");
		if(userService.checkDupUserId(userId)) {
			return new ResponseEntity<String>("success",HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("false",HttpStatus.OK);
		}
	}

	/*
	 * 작성일: 2019년 06월 07일 작성자: 전요셉 내용: 유저관련 프로필 업로드 매핑 업로드 흐름: register버튼 클릭 => 해당
	 * url로 타고들어와서 수행 => 임시디렉토리에 업로드 => 지정된 디렉토리에 저장 => 파일정보가 file에 저장 그다음 유저 생성
	 * url로 흐름이 넘어감
	 */
	@RequestMapping(value = "/profileUpload", method = RequestMethod.POST, produces = "text/plain;charset=utf-8")
	public ResponseEntity<String> uploadUserProfileImg(@PathVariable("userId") String userId, MultipartFile file)
			throws Exception {
		logger.info("originalName: " + file.getOriginalFilename());
		logger.info("size: " + file.getSize());
		logger.info("contentType: " + file.getContentType());

		return new ResponseEntity<String>(
				ProfileUploadFileUtil.uploadFile(uploadPath, file.getOriginalFilename(), userId, file.getBytes()),
				HttpStatus.OK);
	}
	
	@RequestMapping(value="/logout", method = RequestMethod.GET)
	public ModelAndView logout(HttpSession session) {
		userService.logout(session);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("/user/login");
		mav.addObject("msg", "logout");
		
		return mav;
	}
}



// ***************************** 리펙토링 이전 개발 코드들 => 나중에 따로 빼놀예정



	/*
	 * 작성일: 2019년 06월 04일 작성자: 전요셉 내용: 회원 등록 처리 후 ==> login화면으로 리다이렉트
	 */
//	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
//	public String userRegister(@ModelAttribute UserDTO userDTO) {
//		String profileImg = "";
//		String defaultPath = "";
//		String path = "";
//
//		// 개발/운영 서버용 설정값 적용하기 -> 아직 미구현
//		defaultPath = "/Users/jeon-yoseb/documents/workspace-sts-3.9.6.RELEASE/yosep-spring-agile_cooperation_tool/src/main/webapp/web-inf/images/profile/default/default-profile.gif";
//		path = "/Users/jeon-yoseb/documents/workspace-sts-3.9.6.RELEASE/yosep-spring-agile_cooperation_tool/src/main/webapp/web-inf/images/profile/"
//				+ userDTO.getUserId();
//
//		userService.insertUser(userDTO);
//
//		makeProfileDirectory(path, userDTO.getUserId());
//
//		if (!userDTO.getProfileImg().isEmpty()) {
//			profileImg = userDTO.getProfileImg().getOriginalFilename();
//
//			try {
//				// 임시 디렉토리(서버)에 저장된 파일을 지정된 디렉토리로 전송
//				userDTO.getProfileImg().transferTo(new File(path + profileImg));
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//
//			userDTO.setProfileUrl(profileImg);
//		} else {
//			try {
//				String defaultPathFullName = path + "/default-profile.gif";
//				FileInputStream fis = new FileInputStream(defaultPath);
//				FileOutputStream fos = new FileOutputStream(defaultPathFullName);
//
//				int data = 0;
//				while ((data = fis.read()) != -1) {
//					fos.write(data);
//				}
//				fis.close();
//				fos.close();
//
//				userDTO.setProfileUrl(defaultPathFullName);
//			} catch (IOException ie) {
//				ie.printStackTrace();
//			}
//		}
//
//		return "redirect:/user/login";
//	}
