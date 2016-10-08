package com.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONArray;

import org.hibernate.validator.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.model.User;
import com.service.UserService;
import com.util.Page;
import com.util.Results;

@Controller
// @Component 泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
@RequestMapping("/user")
// 请求url地址映射，类似Struts的action-mapping
public class UserController {

	@Resource
	// 获取applicationContext.xml中bean的并注入
	private UserService userService;

	@RequestMapping("/add.do")
	public String add(User user) {
		userService.add(user);
		return "redirect:/user/list.do?currentPage=0";
	}

	@RequestMapping("/login.do")
	public String login(User user, HttpSession session) {
		User query = userService.login(user);
		session.setAttribute("user", query);
		return "index";
	}

	@RequestMapping("/list.do")
	public String list(Model model, int currentPage) {
		Page page = new Page();
		page.setCurrentPage(currentPage);// 设置当前页数
		page.setEveryPage(6);// 设置每页页数
		Results result = userService.list(page);
		page = result.getPage();// 获得页数对象
		List<User> userList = result.getList();// 获得列表对象
		model.addAttribute("userList", userList);
		model.addAttribute("page", page);
		return "userlist";
	}

	@RequestMapping("/delete.do")
	public String delete(User user) {
		userService.delete(user);
		return "redirect:/user/list.do?currentPage=0";
	}

	@RequestMapping("/updatequery.do")
	public String updatequery(Model model, User user) {
		User query = userService.querybyid(user.getId());
		model.addAttribute("user", query);
		return "userupdate";
	}

	@RequestMapping("/update.do")
	public String update(User user) {
		userService.update(user);
		return "redirect:/user/list.do?currentPage=0";
	}

	@RequestMapping("/test1.do")
	// 3.1支持RedirectAttributes redirectAttributes
	// redirectAttributes.addFlashAttribute("message", "保存用户成功！");
	public String test1(User user) {
		System.out.println(user.getName());
		return "redirect:/user/list.do?currentPage=0";
	}

	@RequestMapping("/out.do")
	public String out(HttpSession session) {
		session.setAttribute("user", null);
		return "login";
	}

	// js风格提交表单
	@RequestMapping("/list2.do")
	public String list2(Model model, int currentPage) {
		Page page = new Page();
		page.setCurrentPage(currentPage);// 设置当前页数
		page.setEveryPage(6);// 设置每页页数
		Results result = userService.list(page);
		page = result.getPage();// 获得页数对象
		List<User> userList = result.getList();// 获得列表对象
		model.addAttribute("userList", userList);
		model.addAttribute("page", page);
		return "jsuserlist";
	}

	@RequestMapping("/jsadd.do")
	@ResponseBody
	public Object jsadd(User user) {
		userService.add(user);
		Map<String, String> map = new HashMap<String, String>();
		map.put("success", "true");
		map.put("msg", "后台添加成功");
		return map;
	}

	@RequestMapping("/jsdelete.do")
	@ResponseBody
	public Object jsdelete(User user) {
		userService.delete(user);
		Map<String, String> map = new HashMap<String, String>();
		map.put("success", "true");
		map.put("msg", "后台删除成功");
		return map;
	}

	// ajax选择列表
	@RequestMapping("/ajaxlist.do")
	@ResponseBody
	public Map<String, Object> list2() throws IOException {
		Page page = new Page();
		page.setCurrentPage(0);// 设置当前页数
		page.setEveryPage(10);// 设置每页页数
		Results result = userService.list(page);
		page = result.getPage();// 获得页数对象
		List<User> userList = result.getList();
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("datalist", userList);
		modelMap.put("success", "true");
		return modelMap;
	}

	// ajax用户列表
	@RequestMapping("/ajaxuserlist.do")
	@ResponseBody
	public Map<String, Object> list3() throws IOException {
		Page page = new Page();
		page.setCurrentPage(0);// 设置当前页数
		page.setEveryPage(4);// 设置每页页数
		Results result = userService.list(page);
		page = result.getPage();// 获得页数对象
		List<User> userList = result.getList();
		Map<String, Object> modelMap = new HashMap<String, Object>(3);
		modelMap.put("total", "4");
		modelMap.put("datalist", userList);
		modelMap.put("success", "true");
		return modelMap;
	}

	// //REST风格
	// @RequestMapping(value = "id.do", method = RequestMethod.GET)
	// public User view(@PathVariable("id") Long id) {
	// System.out.println("UserController.reg2()"+id);
	// return null;
	// }

	// 多文件上传
	@RequestMapping("/upload.do")
	public String upload2(HttpServletRequest request,
			HttpServletResponse response, ModelMap model)
			throws IllegalStateException, IOException {
		// 创建一个通用的多部分解析器
		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(
				request.getSession().getServletContext());
		// 判断 request 是否有文件上传,即多部分请求
		if (multipartResolver.isMultipart(request)) {
			// 转换成多部分request
			MultipartHttpServletRequest multiRequest = (MultipartHttpServletRequest) request;
			// 取得request中的所有文件名
			Iterator<String> iter = multiRequest.getFileNames();
			while (iter.hasNext()) {
				// 记录上传过程起始时的时间，用来计算上传时间
				int pre = (int) System.currentTimeMillis();
				// 取得上传文件
				MultipartFile file = multiRequest.getFile(iter.next());
				if (file != null) {
					// 取得当前上传文件的文件名称
					String myFileName = file.getOriginalFilename();
					// 如果名称不为“”,说明该文件存在，否则说明该文件不存在
					if (myFileName.trim() != "") {
						// 重命名上传后的文件名
						String fileName = pre + file.getOriginalFilename();
						// 定义上传路径
						String path = request.getSession().getServletContext()
								.getRealPath("upload");
						File localFile = new File(path, fileName);
						file.transferTo(localFile);
						// 最后一个文件地址
						model.addAttribute("fileUrl", path + fileName);
					}
				}
				// 记录上传该文件后的时间
				int finaltime = (int) System.currentTimeMillis();
				System.out.println(finaltime - pre);
			}

		}
		return "index";
	}

	// 单文件上传
	@RequestMapping(value = "/upload2.do")
	public String upload(
			@RequestParam(value = "file", required = false) MultipartFile file,
			HttpServletRequest request, ModelMap model) {

		System.out.println("开始");
		String path = request.getSession().getServletContext().getRealPath(
				"upload");
		String fileName = file.getOriginalFilename();
		// String fileName = new Date().getTime()+".jpg";
		System.out.println(path);
		File targetFile = new File(path, fileName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}

		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("fileUrl", request.getContextPath() + "/upload/"
				+ fileName);

		return "index";
	}

	// 下载
	@RequestMapping("/download.do")
	public String download(String fileName, HttpServletRequest request,
			HttpServletResponse response) {
		response.setCharacterEncoding("utf-8");
		response.setContentType("multipart/form-data");
		response.setHeader("Content-Disposition", "attachment;fileName="
				+ fileName);
		try {
			String path = request.getSession().getServletContext().getRealPath(
			"upload");// 这个download目录为啥建立在classes下的
			InputStream inputStream = new FileInputStream(new File(path
					+ File.separator + fileName));

			OutputStream os = response.getOutputStream();
			byte[] b = new byte[2048];
			int length;
			while ((length = inputStream.read(b)) > 0) {
				os.write(b, 0, length);
			}

			// 这里主要关闭。
			os.close();

			inputStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 返回值要注意，要不然就出现下面这句错误！
		// java+getOutputStream() has already been called for this response
		return null;
	}
	

}
