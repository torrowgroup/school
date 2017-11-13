package com.futher.school.controller.manager;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.futher.school.base.BaseController;
import com.futher.school.entity.Resource;
import com.futher.school.entity.Type;
import com.futher.school.entity.User;

@RequestMapping("/resource")
@Controller
public class ResourceController extends BaseController {
	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加校园新闻界面
	 */
	@RequestMapping("toAddResource")
	public String toAddResource(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		for (int i = 0; i < typelist.size(); i++) {
			System.out.println();
			model.addAttribute("typeid", typelist.get(i).getTyId());
		}
		session.setAttribute("tyPid", tyPid);
		return "/manager/addresource";
	}

	/**
	 * @param tyPid
	 * @return转发到添加概括的类界面
	 */
	@RequestMapping("toaddGeneraLization")
	public String toaddGeneraLization(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		model.addAttribute("typelist", typelist);
		session.setAttribute("tyPid", tyPid);
		return "/manager/addgenera";
	}
	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加文件的界面
	 */
	@RequestMapping("toaddUploadFile")
	public String toaddUploadFile(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		model.addAttribute("typelist", typelist);
		session.setAttribute("tyPid", tyPid);
		return "/manager/adduploadfile";
	}
	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加链接的界面
	 */
	@RequestMapping("toaddLink")
	public String toaddLink(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		for (int i = 0; i < typelist.size(); i++) {
			model.addAttribute("typeid", typelist.get(i).getTyId());
		}
		session.setAttribute("tyPid", tyPid);
		return "/manager/addlink";
	}
	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加校园风景界面
	 */
	@RequestMapping("toaddSchoolView")
	public String toaddSchoolView(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		for (int i = 0; i < typelist.size(); i++) {
			model.addAttribute("typeid", typelist.get(i).getTyId());
		}
		session.setAttribute("tyPid", tyPid);
		return "/manager/addschoolview";
	}
	/**
	 * @param resource
	 * @param file
	 * @param model
	 * @return 添加校园风景
	 */
	@RequestMapping("addSchoolView")
	public String addSchoolView(Resource resource, MultipartFile file, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		setAddResource(resource);
		if (file.isEmpty()) {
			model.addAttribute("news", "请上传校园风景图");
			return toaddSchoolView(tyPid, model);
		} else {
			String truePath = "static/uploadImg/schoolview";
			String fileName = uploadOpus(file, truePath);
			resource.setReSpare(fileName);
		}
		int judge = resourceService.addResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toaddSchoolView(tyPid, model);
	}
	/**
	 * @param resource
	 * @param model
	 * @return 添加链接
	 */
	@RequestMapping("addLink")
	public String addLink(Resource resource, Model model) {
		resource.setReTypename("校园新闻");
		int tyPid = (int) session.getAttribute("tyPid");
		setAddResource(resource);
		int judge = resourceService.addResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toaddLink(tyPid, model);
	}
	/**
	 * @param resource
	 * @param file
	 * @param model
	 * @return 添加上传文件
	 */
	@RequestMapping("addUploadFile")
	public String addUploadFile(Resource resource, MultipartFile file, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		setAddResource(resource);
		if (tyPid == 5) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传作品");
				return toaddUploadFile(tyPid, model);
			} else {
				String truePath = "static/uploadImg/schoolopus";
				String fileName = uploadOpus(file, truePath);
				resource.setReContent(fileName);
			}
		} else if (tyPid == 6) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传资源下载文件");
				return toaddUploadFile(tyPid, model);
			} else {
				String truePath = "static/uploadImg/schoolresource";
				String fileName = uploadOpus(file, truePath);
				resource.setReContent(fileName);
			}
		} else if (tyPid == 9) {
			if (file.isEmpty()) {
				model.addAttribute("news", "请上传校园风景照片");
				return toaddUploadFile(tyPid, model);
			} else {
				String truePath = "static/uploadImg/schoolview";
				String fileName = uploadOpus(file, truePath);
				resource.setReSpare(fileName);
			}
		}
		int judge = resourceService.addResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toaddUploadFile(tyPid, model);
	}

	/**
	 * @param resource
	 * @param model
	 * @return添加概括类无文件上传的数据
	 */
	@RequestMapping("addGeneraLization")
	public String addGeneraLization(Resource resource, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		setAddResource(resource);
		int judge = resourceService.addResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toaddGeneraLization(tyPid, model);
	}

	/**
	 * 
	 * @param resource
	 * @param file
	 * @param model
	 * @return添加有文件上传的数据 如校园新闻
	 */
	@RequestMapping("/addResource")
	public String addResource(Resource resource, MultipartFile file, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		setAddResource(resource);
		if (file.isEmpty()) {
			model.addAttribute("news", "请上传新闻图片");
			return toAddResource(tyPid, model);
		} else {
			String truePath = "static/uploadImg/uploadnew";
			String fileName = uploadOpus(file, truePath);
			resource.setReSpare(fileName);
		}
		int judge = resourceService.addResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "添加成功");
		} else {
			model.addAttribute("news", "添加失败");
		}
		return toAddResource(tyPid, model);
	}

	@RequestMapping("/selectResource")
	public String selectResource(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int reTypid,
			Model model) {
		
		model.addAttribute("reTypeid", reTypid);
		model.addAttribute("messages", resourceService.findByPage(currentPage, reTypid));// 回显分页数据
		if (reTypid == 12) {
			return "manager/selectresource";
		} else if (reTypid == 5 || reTypid == 6) {
			return "manager/selectuploadfile";
		} else if (reTypid == 7) {
			return "manager/selectlink";
		} else if (reTypid == 9) {
			return "manager/selectschoolview";
		}
		return "manager/selectgeneralization";
	}
	
	@RequestMapping("deletResource")
	public String deletResource(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		int judge = resourceService.deletResource(reId);
		if (judge == 1) {
			model.addAttribute("news", "删除成功");
		} else {
			model.addAttribute("news", "删除失败");
		}
		return selectResource(1, resource.getReTypeid(), model);

	}
	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改校园新闻界面
	 */
	@RequestMapping("toUpdateResource")
	public String toUpdateResource(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
		for (int i = 0; i < typelist.size(); i++) {
			model.addAttribute("typeid", typelist.get(i).getTyId());
		}
		session.setAttribute("tyPid", resource.getReTypeid());
		model.addAttribute("resource", resource);
		return "/manager/updateresource";
	}

	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改概括类的页面
	 */
	@RequestMapping("toUpdateGeneraLization")
	public String toUpdateGeneraLization(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
		model.addAttribute("typelist", typelist);
		session.setAttribute("tyPid", resource.getReTypeid());
		model.addAttribute("resource", resource);
		return "/manager/updategeneralization";
	}
	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加文件的界面
	 */
	@RequestMapping("toUpdateUploadFile")
	public String toUpdateUploadFile(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
		model.addAttribute("typelist", typelist);
		session.setAttribute("tyPid", resource.getReTypeid());
		model.addAttribute("resource", resource);
		return "/manager/updateuploadfile";
	}
	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改链接的界面
	 */
	@RequestMapping("toUpdateLink")
	public String toUpdateLink(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
		for (int i = 0; i < typelist.size(); i++) {
			model.addAttribute("typeid", typelist.get(i).getTyId());
		}
		session.setAttribute("tyPid", resource.getReTypeid());
		model.addAttribute("resource", resource);
		return "/manager/updatelink";
	}
	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改校园风景界面
	 */
	@RequestMapping("toUpdateSchoolView")
	public String toUpdateSchoolView(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
		for (int i = 0; i < typelist.size(); i++) {
			model.addAttribute("typeid", typelist.get(i).getTyId());
		}
		model.addAttribute("resource", resource);
		session.setAttribute("tyPid", resource.getReTypeid());
		return "/manager/updateschoolview";
	}
	

	@RequestMapping("UpdateResource")
	public String UpdateResource(Resource resource, MultipartFile file, Model model) {
		System.out.println(resource+"14515666666666666666666666666666666666666666666666666666666666666666666666666");
		Resource oldResource = resourceService.selectById(resource.getReId());
		setAddResource(resource);
		if (file.isEmpty()) {
//			model.addAttribute("news", "请上传新闻图片");
//			return toUpdateResource(resource.getReId(), model);
			resource.setReSpare(oldResource.getReSpare());
		} else {
			String truePath = "static/uploadImg/uploadnew";
			String fileName = uploadOpus(file, truePath);
			resourceService.deletResource(oldResource.getReSpare(), truePath, request);
			resource.setReSpare(fileName);
		}
		int judge = resourceService.updateResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectResource(1, resource.getReTypepid(), model);
	}

	@RequestMapping("UpdateGeneraLization")
	public String UpdateGeneraLization(Resource resource, Model model) {
//		Resource oldResource = resourceService.selectById(resource.getReId());
		setAddResource(resource);
		int judge = resourceService.updateResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectResource(1, resource.getReTypepid(), model);
	}
	
	@RequestMapping("UpdateUploadFile")
	public String UpdateUploadFile(Resource resource, MultipartFile file, Model model) {
		Resource oldResource = resourceService.selectById(resource.getReId());
		setAddResource(resource);
		if (file.isEmpty()) {
			resource.setReSpare(oldResource.getReSpare());
		} else {
			String truePath = "";
			if (oldResource.getReTypepid() == 5) {
					truePath = "static/uploadImg/schoolopus";
					String fileName = uploadOpus(file, truePath);
					resource.setReContent(fileName);
			} else if (oldResource.getReTypepid() == 6) {
					truePath = "static/uploadImg/schoolresource";
					String fileName = uploadOpus(file, truePath);
					resource.setReContent(fileName);
			} else if (oldResource.getReTypepid() == 9) {
					truePath = "static/uploadImg/schoolview";
					String fileName = uploadOpus(file, truePath);
					resource.setReSpare(fileName);
			}
			if (!(truePath.equals(""))) {
				resourceService.deletResource(oldResource.getReContent(), truePath, request);
			}
		}
		int judge = resourceService.updateResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectResource(1, resource.getReTypepid(), model);
	}
	
	@RequestMapping("UpdateLink")
	public String UpdateLink(Resource resource, Model model) {
		setAddResource(resource);
		int judge = resourceService.updateResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectResource(1, resource.getReTypepid(), model);
	}
	
	@RequestMapping("UpdateSchoolView")
	public String UpdateSchoolView(Resource resource, MultipartFile file, Model model) {
		Resource oldResource = resourceService.selectById(resource.getReId());
		setAddResource(resource);
		if (file.isEmpty()) {
			resource.setReSpare(oldResource.getReSpare());
		} else {
			String truePath = "static/uploadImg/schoolview";
			String fileName = uploadOpus(file, truePath);
			resource.setReSpare(fileName);
			resourceService.deletResource(oldResource.getReSpare(), truePath, request);
		}
		int judge = resourceService.updateResource(resource);
		if (judge == 1) {
			model.addAttribute("news", "修改成功");
		} else {
			model.addAttribute("news", "修改失败");
		}
		return selectResource(1, resource.getReTypepid(), model);
	}

//	@RequestMapping("updateResource")
//	public String updateResource(Resource resource, MultipartFile file, Model model) {
//		int tyPid = (int) session.getAttribute("tyPid");
//		Resource oldResource = resourceService.selectById(resource.getReId());
//		setAddResource(resource);
//		if (resource.getReTypename().equals("校园新闻")) {
//			if (file.isEmpty()) {
//				resource.setReSpare(oldResource.getReSpare());
//			} else {
//				String truePath = "static/uploadImg/uploadnew";
//				String fileName = uploadOpus(file, truePath);
//				resourceService.deletResource(oldResource.getReSpare(), truePath, request);
//				resource.setReSpare(fileName);
//			}
//		}
//		if (tyPid == 5) {
//			if (file.isEmpty()) {
//				resource.setReContent(oldResource.getReContent());
//			} else {
//				String truePath = "static/uploadImg/schoolopus";
//				String fileName = uploadOpus(file, truePath);
//				resourceService.deletResource(oldResource.getReContent(), truePath, request);
//				resource.setReContent(fileName);
//			}
//		} else if (tyPid == 6) {
//			if (file.isEmpty()) {
//				resource.setReContent(oldResource.getReContent());
//			} else {
//				String truePath = "static/uploadImg/schoolresource";
//				String fileName = uploadOpus(file, truePath);
//				resourceService.deletResource(oldResource.getReContent(), truePath, request);
//				resource.setReContent(fileName);
//			}
//		} else if (tyPid == 9) {
//			if (file.isEmpty()) {
//				resource.setReSpare(oldResource.getReSpare());
//			} else {
//				String truePath = "static/uploadImg/schoolview";
//				String fileName = uploadOpus(file, truePath);
//				resourceService.deletResource(oldResource.getReSpare(), truePath, request);
//				resource.setReSpare(fileName);
//			}
//		}
//		int judge = resourceService.updateResource(resource);
//		if (judge == 1) {
//			model.addAttribute("news", "修改成功");
//		} else {
//			model.addAttribute("news", "修改失败");
//		}
//		return selectResource(1, resource.getReTypeid(), model);
//	}

	@RequestMapping("downloadResource")
	@ResponseBody
	public void downloadResource(int reId) throws IOException {
		response.setCharacterEncoding("UTF-8");
		Resource resource = resourceService.selectById(reId);
		String realPath = "";
		if (resource.getReTypepid() == 5) {
			realPath = "static/uploadImg/schoolopus";
			resourceService.downloadResource(resource, realPath, response, request);
		} else if (resource.getReTypepid() == 6) {
			realPath = "static/uploadImg/schoolresource";
			resourceService.downloadResource(resource, realPath, response, request);
		}
	}

	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public void upload(MultipartFile myFileName) throws IOException {
		String realName = resourceService.uploadImage(myFileName, session);
		response.getWriter().write(request.getContextPath() + "/static/uploadImg/source/" + realName);
	}

	@RequestMapping("previewContent")
	public String previewContent(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		model.addAttribute("resource", resource);
		return "manager/previewcontent";
	}

	public String uploadOpus(MultipartFile file, String truePath) {
		String fileName = resourceService.uploadResource(file, truePath, request);
		return fileName;
	}

	public void setAddResource(Resource resource) {
		Type type = typeService.selectTypeById(resource.getReTypeid());
		resource.setReTypepid(type.getTyPid());
		resource.setReTypename(type.getTyCategoryname());
		User user = (User) session.getAttribute("manager");
		resource.setRePublisher(user.getUsName());
		Date currentTime = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(currentTime);
		resource.setReReleasedate(dateString);
	}
}
