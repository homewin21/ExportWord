package com.homewin.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.homewin.entity.User;
import com.homewin.entity.Word;
import com.homewin.mapper.WordMapper;
import com.homewin.util.ExportUtil;
import com.homewin.util.StringUtil;

@Controller
public class ExportController {
	@Autowired
	WordMapper wordmapper;

	@RequestMapping("/main")
	public String main() {
		return "main";
	}

	@RequestMapping("/save")
	public String export(HttpServletRequest request, HttpSession session,
			@RequestParam(value = "e_r", required = false) MultipartFile file) throws Exception {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String word_name = request.getParameter("word_name");

		Map<String, Object> dataMap = new HashMap<>();
		dataMap.put("title", request.getParameter("title"));
		dataMap.put("title_en", request.getParameter("title_en"));
		dataMap.put("Academy", request.getParameter("Academy"));
		dataMap.put("major", request.getParameter("major"));
		dataMap.put("stuId", request.getParameter("stuId"));
		dataMap.put("stuName", request.getParameter("stuName"));
		dataMap.put("teacher", request.getParameter("teacher"));
		dataMap.put("College", request.getParameter("College"));
		dataMap.put("Specialty", request.getParameter("Specialty"));
		dataMap.put("Number", request.getParameter("Number"));
		dataMap.put("name_en", request.getParameter("name_en"));
		dataMap.put("Advisor", request.getParameter("Advisor"));
		dataMap.put("Submitted", request.getParameter("Submitted"));
		dataMap.put("abstract_cn", request.getParameter("abstract_cn"));
		dataMap.put("keyword_cn", request.getParameter("keyword_cn"));
		dataMap.put("abstract_en", request.getParameter("abstract_en"));
		dataMap.put("keyword_en", request.getParameter("keyword_en"));
		dataMap.put("a1_1", request.getParameter("1_1").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a1_2", request.getParameter("1_2").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a1_3", request.getParameter("1_3").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a2_1", request.getParameter("2_1").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a2_2", request.getParameter("2_2").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a3", request.getParameter("3").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a4_1", request.getParameter("4_1").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a4_3", request.getParameter("4_3").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a5_1", request.getParameter("5_1").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a5_2", request.getParameter("5_2").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a6", request.getParameter("6").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a7", request.getParameter("7").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		dataMap.put("a8", request.getParameter("8").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));

		dataMap.put("a9", request.getParameter("9").replaceAll("\r\n", "</w:t></w:r></w:p><w:p><w:r><w:t>"));
		String sub_1_1 = StringUtil.getParam(request.getParameter("sub_1_1"), "课题设计的背景");
		String sub_1_2 = StringUtil.getParam(request.getParameter("sub_1_2"), "课题设计的目的和意义");
		String sub_1_3 = StringUtil.getParam(request.getParameter("sub_1_3"), "课题设计的关键技术");
		String sub_2_1 = StringUtil.getParam(request.getParameter("sub_2_1"), "运行环境");
		String sub_2_2 = StringUtil.getParam(request.getParameter("sub_2_2"), "设计思路");
		String sub_4_1 = StringUtil.getParam(request.getParameter("sub_4_1"), "数据库应用介绍");
		String sub_4_2 = StringUtil.getParam(request.getParameter("sub_4_2"), "E-R图");
		String sub_4_3 = StringUtil.getParam(request.getParameter("sub_4_3"), "数据库表结构设计");
		String sub_5_1 = StringUtil.getParam(request.getParameter("sub_5_1"), "系统设计模块");
		String sub_5_2 = StringUtil.getParam(request.getParameter("sub_5_2"), "系统功能分析");
		String main_1 = StringUtil.getParam(request.getParameter("main_1"), "引言");
		String main_2 = StringUtil.getParam(request.getParameter("main_2"), "运行环境和设计思路");
		String main_3 = StringUtil.getParam(request.getParameter("main_3"), "需求分析");
		String main_4 = StringUtil.getParam(request.getParameter("main_4"), "数据库设计");
		String main_5 = StringUtil.getParam(request.getParameter("main_5"), "系统设计");
		String main_6 = StringUtil.getParam(request.getParameter("main_6"), "结论");
		dataMap.put("main_1", main_1);
		dataMap.put("main_2", main_2);
		dataMap.put("main_3", main_3);
		dataMap.put("main_4", main_4);
		dataMap.put("main_5", main_5);
		dataMap.put("main_6", main_6);
		dataMap.put("sub_1_1", sub_1_1);
		dataMap.put("sub_1_2", sub_1_2);
		dataMap.put("sub_1_3", sub_1_3);
		dataMap.put("sub_2_1", sub_2_1);
		dataMap.put("sub_2_2", sub_2_2);
		dataMap.put("sub_4_1", sub_4_1);
		dataMap.put("sub_4_2", sub_4_2);
		dataMap.put("sub_4_3", sub_4_3);
		dataMap.put("sub_5_1", sub_5_1);
		dataMap.put("sub_5_2", sub_5_2);
		ExportUtil exportUtil = new ExportUtil("UTF-8");
//		String separator = File.separator;
		// Linux
//		File image1 = new File("/usr/cover.jpg");
		// win 第一张图片
		File image1 = new File("D:/test/cover.jpg");
//		System.out.println(image1);
		try {
			dataMap.put("image1", exportUtil.getImageStr(new FileInputStream(image1)));

			dataMap.put("image2", exportUtil.getImageStr(file.getInputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// win
		String path = "D:/test/";
		// linux
//		String path = "/usr/word/";

		exportUtil.exportDoc(path + word_name + ".doc", "templatez.ftl", dataMap);
		User user = (User) session.getAttribute("user");

		Word word = new Word(user.getId(), user.getUsername(), word_name, path, df.format(new Date()));
		List<Word> wordList = wordmapper.getWord(user.getId());
		//查询当前用户是否已经创建同名文档，如果存在则删除之前的文档记录
		for (Word word1 : wordList) {
			if (word1.getWord_name().equals(word_name)) {
				wordmapper.delWord(word_name);
				break;
			}

		}
		wordmapper.addWord(word);
		return "save";
	}

	@RequestMapping("/download")
	public String download(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		List<Word> wordList = wordmapper.getWord(user.getId());
		model.addAttribute(wordList);
		return "download";
	}

	@RequestMapping("/del/{word_name}")
	public String delword(@PathVariable String word_name) {
		wordmapper.delWord(word_name);
		return "redirect:/download";
	}

	@ResponseBody
	@RequestMapping("/duplicate/{word_name}")
	public String duplicate(HttpSession session, @PathVariable String word_name) {
		String result = "yes";

		User user = (User) session.getAttribute("user");
		List<Word> wordList = wordmapper.getWord(user.getId());
		for (Word word : wordList) {
			if (word.getWord_name().equals(word_name)) {
				result = "no";
				break;
			}

		}

		return result;

	}

}
