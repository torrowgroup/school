package com.futher.school.controller.teacher;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futher.school.base.BaseController;

@RequestMapping("/jump")
@Controller()
public class Jump extends BaseController {
	// 上传书法作品
	@RequestMapping("/uploadCalligraphy")
	public String uploadCalligraphy() {
		return "teacher/upload";
	}

	// 上传优秀教案
	@RequestMapping("/uploadGrammar")

	public String uploadGrammar() {
		return "teacher/upload";
	}

	// 上传优秀试卷
	@RequestMapping("/uploadExamination")
	public String uploadExamination() {
		return "teacher/upload";
	}

	// 上传优秀课件
	@RequestMapping("/uploadCourseware")
	public String uploadCourseware() {
		return "teacher/upload";
	}
}
