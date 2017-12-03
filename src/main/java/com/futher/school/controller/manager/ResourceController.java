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
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			for (int i = 0; i < typelist.size(); i++) {
				model.addAttribute("typeid", typelist.get(i).getTyId());
			}
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
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			model.addAttribute("typelist", typelist);
		}
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
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			model.addAttribute("typelist", typelist);
		}
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
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			for (int i = 0; i < typelist.size(); i++) {
				model.addAttribute("typeid", typelist.get(i).getTyId());
			}
		}
		session.setAttribute("tyPid", tyPid);
		return "/manager/addlink";
	}

	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加时间的页面
	 */
	@RequestMapping("toaddAllTime")
	public String toaddAllTime(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			model.addAttribute("typelist", typelist);
		}
		session.setAttribute("tyPid", tyPid);
		return "/manager/addalltime";
	}

	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加校园风景界面
	 */
	@RequestMapping("toaddSchoolView")
	public String toaddSchoolView(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			for (int i = 0; i < typelist.size(); i++) {
				model.addAttribute("typeid", typelist.get(i).getTyId());
			}
		}
		session.setAttribute("tyPid", tyPid);
		return "/manager/addschoolview";
	}

	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到添加校园信息界面
	 */
	@RequestMapping("toaddSchoolNews")
	public String toaddSchoolNews(int tyPid, Model model) {
		List<Type> typelist = typeService.selectTypeName(tyPid);
		if (typelist.isEmpty()) {
			model.addAttribute("news", "未添加类型,请添加类型");
		} else {
			for (int i = 0; i < typelist.size(); i++) {
				model.addAttribute("typeid", typelist.get(i).getTyId());
			}
		}
		// for (int i = 0; i < typelist.size(); i++) {
		// model.addAttribute("typeid", typelist.get(i).getTyId());
		// }
		session.setAttribute("tyPid", tyPid);
		return "/manager/addschoolnews";
	}

	/**
	 * @param resource
	 * @param model
	 * @return 添加学校信息
	 */
	@RequestMapping("addSchoolNews")
	public String addSchoolNews(Resource resource, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		Type type = typeService.selectTypeById(resource.getReTypeid());
		if (type == null) {
			model.addAttribute("news", "添加失败,没有添加的类型");
		} else {
			resource.setReTypepid(type.getTyPid());
			resource.setReTypename(type.getTyCategoryname());
			int judge = 0;
			Resource oldResource = resourceService.selectByTypeid(resource.getReTypeid());
			if (oldResource == null) {
				judge = resourceService.addResource(resource);
			}
			if (judge == 1) {
				model.addAttribute("news", "添加成功");
			} else {
				model.addAttribute("news", "添加失败,已添加，请重新选择");
			}
		}
		return toaddSchoolNews(tyPid, model);
	}

	/**
	 * @param resource
	 * @param model
	 * @return 添加时间
	 */
	@RequestMapping("addAllTime")
	public String addAllTime(Resource resource, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			int judge = 0;
			Resource oldResource = resourceService.selectByTypeid(resource.getReTypeid());
			if (oldResource == null) {
				judge = resourceService.addResource(resource);
			}
			if (judge == 1) {
				model.addAttribute("news", "添加成功");
			} else {
				model.addAttribute("news", "添加失败,已添加，请重新选择");
			}
		} else {
			model.addAttribute("news", "添加失败,没有添加的类型");
		}
		return toaddAllTime(tyPid, model);

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
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
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
		} else {
			model.addAttribute("news", "添加失败,没有添加的类型");
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
		int tyPid = (int) session.getAttribute("tyPid");
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			int judge = resourceService.addResource(resource);
			if (judge == 1) {
				model.addAttribute("news", "添加成功");
			} else {
				model.addAttribute("news", "添加失败");
			}
		} else {
			model.addAttribute("news", "添加失败,没有添加的类型");
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
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
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
		} else {
			model.addAttribute("news", "添加失败,没有添加的类型");
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
		int judge = 0;
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			if (resource.getReTypepid() == 2) {
				Resource oldResource = resourceService.selectByTypeid(resource.getReTypeid());
				if (oldResource == null) {
					judge = resourceService.addResource(resource);
				}
			} else {
				judge = resourceService.addResource(resource);
			}
			if (judge == 1) {
				model.addAttribute("news", "添加成功");
			} else {
				model.addAttribute("news", "已添加,请重新选择");
			}
		} else {
			model.addAttribute("news", "添加失败,没有添加的类型");
		}
		return toaddGeneraLization(tyPid, model);
	}

	/**
	 * @param resource
	 * @param file
	 * @param model
	 * @return添加有文件上传的数据 如校园新闻
	 */
	@RequestMapping("/addResource")
	public String addResource(Resource resource, MultipartFile file, Model model) {
		int tyPid = (int) session.getAttribute("tyPid");
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
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
		} else {
			model.addAttribute("news", "添加失败,没有添加的类型");
		}
		return toAddResource(tyPid, model);
	}

	/**
	 * @param currentPage
	 * @param reTypid
	 * @param model
	 * @return 分页查看资源类的数据
	 */
	@RequestMapping("/selectResource")
	public String selectResource(
			@RequestParam(value = "currentPage", defaultValue = "1", required = false) int currentPage, int reTypeid,
			String inquiry, Model model) {
		model.addAttribute("inquiry", inquiry);
		session.setAttribute("inquiry", inquiry);
		model.addAttribute("reTypeid", reTypeid);
		model.addAttribute("messages", resourceService.findByPage(currentPage, reTypeid,inquiry));// 回显分页数据
		if (reTypeid == 12) {
			return "manager/selectresource";
		} else if (reTypeid == 5 || reTypeid == 6) {
			return "manager/selectuploadfile";
		} else if (reTypeid == 7) {
			return "manager/selectlink";
		} else if (reTypeid == 9) {
			return "manager/selectschoolview";
		} else if (reTypeid == 11) {
			return "manager/selectalltime";
		} else if (reTypeid == 13) {
			return "manager/selectschoolnews";
		}
		return "manager/selectgeneralization";
	}

	/**
	 * @param reId
	 * @param model
	 * @return 删除资源类数据
	 */
	@RequestMapping("deletResource")
	public String deletResource(int reId,int reTypepid, Model model) {
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			model.addAttribute("news", "因不可知操作,此数据已删除");
		} else {
			int judge = resourceService.deletResource(reId);
			if (judge == 1) {
				model.addAttribute("news", "删除成功");
			} else {
				model.addAttribute("news", "删除失败");
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, reTypepid, inquiry, model);

	}

	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改校园新闻界面
	 */
	@RequestMapping("toUpdateResource")
	public String toUpdateResource(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				for (int i = 0; i < typelist.size(); i++) {
					model.addAttribute("typeid", typelist.get(i).getTyId());
				}
			}
		}
		// session.setAttribute("tyPid", resource.getReTypeid());
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
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				model.addAttribute("typelist", typelist);
			}
		}
		model.addAttribute("resource", resource);
		// session.setAttribute("tyPid", resource.getReTypeid());
		return "manager/updategeneralization";
	}

	/**
	 * @param tyPid
	 * @param model
	 * @return 转发到修改文件的界面
	 */
	@RequestMapping("toUpdateUploadFile")
	public String toUpdateUploadFile(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				model.addAttribute("typelist", typelist);
			}
		}
		model.addAttribute("resource", resource);
		// session.setAttribute("tyPid", resource.getReTypeid());
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
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				for (int i = 0; i < typelist.size(); i++) {
					model.addAttribute("typeid", typelist.get(i).getTyId());
				}
			}
		}
		model.addAttribute("resource", resource);
		// session.setAttribute("tyPid", resource.getReTypeid());
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
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				for (int i = 0; i < typelist.size(); i++) {
					model.addAttribute("typeid", typelist.get(i).getTyId());
				}
			}
		}
		model.addAttribute("resource", resource);
		// session.setAttribute("tyPid", resource.getReTypeid());
		return "/manager/updateschoolview";
	}

	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改时间类
	 */
	@RequestMapping("toUpdateAllTime")
	public String toUpdateAllTime(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				model.addAttribute("typelist", typelist);
			}
		}
		model.addAttribute("resource", resource);
		// session.setAttribute("tyPid", resource.getReTypeid());
		return "/manager/updatealltime";
	}

	/**
	 * @param reId
	 * @param model
	 * @return 转发到修改学校信息的界面
	 */
	@RequestMapping("toUpdateSchoolNews")
	public String toUpdateSchoolNews(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			List<Type> typelist = typeService.selectTypeName(resource.getReTypepid());
			if (typelist.isEmpty()) {
				model.addAttribute("news", "未添加类型,请添加类型");
			} else {
				for (int i = 0; i < typelist.size(); i++) {
					model.addAttribute("typeid", typelist.get(i).getTyId());
				}
			}
		}
		model.addAttribute("resource", resource);
		// session.setAttribute("tyPid", resource.getReTypeid());
		return "/manager/updateschoolnews";

	}

	/**
	 * @param resource
	 * @param model
	 * @return 修改学校信息
	 */
	@RequestMapping("updateSchoolNews")
	public String updateSchoolNews(Resource resource, Model model) {
		Type type = typeService.selectTypeById(resource.getReTypeid());
		if (type == null) {
			model.addAttribute("news", "该资源类型已删除");
		} else {
			resource.setReTypepid(type.getTyPid());
			resource.setReTypename(type.getTyCategoryname());
			int judge = resourceService.updateResource(resource);
			if (judge == 1) {
				model.addAttribute("news", "修改成功");
			} else {
				model.addAttribute("news", "修改失败");
			}
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param resource
	 * @param model
	 * @return 修改时间
	 */
	@RequestMapping("updateAllTime")
	public String updateAllTime(Resource resource, Model model) {
		int judge = 0;
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			Resource oldResource = resourceService.selectById(resource.getReId());
			if (oldResource == null) {
				model.addAttribute("news", "该资源已删除");
			} else {
				if (oldResource.getReTypeid() == resource.getReTypeid()) {
					judge = resourceService.updateResource(resource);
				} else {
					Resource otherResource = resourceService.selectByTypeid(resource.getReTypeid());
					if (otherResource == null) {
						judge = resourceService.updateResource(resource);
					}
				}
				if (judge == 1) {
					model.addAttribute("news", "修改成功");
				} else {
					model.addAttribute("news", "修改失败,已添加，请重新选择");
				}
			}
		} else {
			model.addAttribute("", "修改失败,该修改的类型不存在");
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param resource
	 * @param file
	 * @param model
	 * @return 修改校园新闻
	 */
	@RequestMapping("updateResource")
	public String updateResource(Resource resource, MultipartFile file, Model model) {
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			Resource oldResource = resourceService.selectById(resource.getReId());
			if (oldResource == null) {
				model.addAttribute("news", "该资源已删除");
			} else {
				if (file.isEmpty()) {
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
			}
		} else {
			model.addAttribute("", "修改失败,该修改的类型不存在");
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param resource
	 * @param model
	 * @return 修改校园概括类
	 */
	@RequestMapping("updateGeneraLization")
	public String updateGeneraLization(Resource resource, Model model) {
		int judge = 0;
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			Resource oldResource = resourceService.selectById(resource.getReId());
			if (oldResource == null) {
				model.addAttribute("news", "该资源已删除");
			} else {
				if (resource.getReTypepid() == 2) {
					if (oldResource.getReTypeid() == resource.getReTypeid()) {
						judge = resourceService.updateResource(resource);
					} else {
						Resource otherResource = resourceService.selectByTypeid(resource.getReTypeid());
						if (otherResource == null) {
							judge = resourceService.updateResource(resource);
						}
					}
				} else {
					judge = resourceService.updateResource(resource);
				}
				if (judge == 1) {
					model.addAttribute("news", "修改成功");
				} else {
					model.addAttribute("news", "已添加,请重新选择");
				}
			}
		} else {
			model.addAttribute("", "修改失败,该修改的类型不存在");
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param resource
	 * @param file
	 * @param model
	 * @return 修改校园文学 ，资源下载
	 */
	@RequestMapping("updateUploadFile")
	public String updateUploadFile(Resource resource, MultipartFile file, Model model) {
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			Resource oldResource = resourceService.selectById(resource.getReId());
			if (oldResource == null) {
				model.addAttribute("news", "该资源已删除");
			} else {
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
			}
		} else {
			model.addAttribute("", "修改失败,该修改的类型不存在");
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param resource
	 * @param model
	 * @return 修改链接
	 */
	@RequestMapping("updateLink")
	public String updateLink(Resource resource, Model model) {
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			Resource oldResource = resourceService.selectById(resource.getReId());
			if (oldResource == null) {
				model.addAttribute("news", "该资源已删除");
			} else {
				int judge = resourceService.updateResource(resource);
				if (judge == 1) {
					model.addAttribute("news", "修改成功");
				} else {
					model.addAttribute("news", "修改失败");
				}
			}
		} else {
			model.addAttribute("", "修改失败,该修改的类型不存在");
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param resource
	 * @param file
	 * @param model
	 * @return 修改校园风景
	 */
	@RequestMapping("updateSchoolView")
	public String updateSchoolView(Resource resource, MultipartFile file, Model model) {
		boolean sign = setAddResource(resource, model);
		if (sign == true) {
			Resource oldResource = resourceService.selectById(resource.getReId());
			if (oldResource == null) {
				model.addAttribute("news", "该资源已删除");
			} else {
				if (file.isEmpty()) {
					resource.setReSpare(oldResource.getReSpare());
				} else {
					String truePath = "static/uploadImg/schoolview";
					resourceService.deletResource(oldResource.getReSpare(), truePath, request);
					String fileName = uploadOpus(file, truePath);
					resource.setReSpare(fileName);
				}
				int judge = resourceService.updateResource(resource);
				if (judge == 1) {
					model.addAttribute("news", "修改成功");
				} else {
					model.addAttribute("news", "修改失败");
				}
			}
		} else {
			model.addAttribute("", "修改失败,该修改的类型不存在");
		}
		String inquiry = (String) session.getAttribute("inquiry");
		return selectResource(1, resource.getReTypepid(), inquiry, model);
	}

	/**
	 * @param reId
	 * @throws IOException
	 *             下载校园文学 ，资源下载
	 */
	@RequestMapping("downloadResource")
	@ResponseBody
	public void downloadResource(int reId) throws IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			response.getWriter().write("文件不存在");
		} else {
			String realPath = "";
			if (resource.getReTypepid() == 5) {
				realPath = "static/uploadImg/schoolopus";
				resourceService.downloadResource(resource, realPath, response, request);
			} else if (resource.getReTypepid() == 6) {
				realPath = "static/uploadImg/schoolresource";
				resourceService.downloadResource(resource, realPath, response, request);
			}
		}
	}

	/**
	 * @param myFileName
	 * @throws IOException
	 *             富文本上传图片
	 */
	@RequestMapping(value = "/uploadImg")
	@ResponseBody
	public void upload(MultipartFile myFileName) throws IOException {
		String realName = resourceService.uploadImage(myFileName, session);
		response.getWriter().write(request.getContextPath() + "/static/uploadImg/source/" + realName);
	}

	/**
	 * @param reId
	 * @param model
	 * @return 预览富文本添加内容
	 */
	@RequestMapping("previewContent")
	public String previewContent(int reId, Model model) {
		Resource resource = resourceService.selectById(reId);
		if (resource == null) {
			model.addAttribute("news", "该资源已被删除");
		} else {
			model.addAttribute("resource", resource);
		}
		return "manager/previewcontent";
	}

	/**
	 * @param file
	 * @param truePath
	 * @return 上传文件
	 */
	public String uploadOpus(MultipartFile file, String truePath) {
		String fileName = resourceService.uploadResource(file, truePath, request);
		return fileName;
	}

	/**
	 * @param resource
	 *            用于给添加，修改的资源添加，修改：类型 发布时间 发布人
	 */
	public boolean setAddResource(Resource resource, Model model) {
		Type type = typeService.selectTypeById(resource.getReTypeid());
		if (type == null) {
			return false;
		} else {
			resource.setReTypepid(type.getTyPid());
			resource.setReTypename(type.getTyCategoryname());
			User user = (User) session.getAttribute("manager");
			resource.setRePublisher(user.getUsName());
			Date currentTime = new Date();
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			String dateString = formatter.format(currentTime);
			resource.setReReleasedate(dateString);
		}
		return true;
	}
}
