package com.futher.school.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.web.multipart.MultipartFile;

public class BaseDao<T, PK extends Serializable> extends SqlSessionDaoSupport implements Serializable {

	private static final long serialVersionUID = 1L;
	private final String SUFFIX = "Mapper"; // 后缀

	private final String _INSERT = ".insert"; // 添加

	private final String _SELECTBYPRIMARYKEY = ".selectByPrimaryKey";

	private final String _UPDATEBYPRIMARYKEY = ".updateByPrimaryKey";

	private final String _DELETEBYPRIMARYKEY = ".deleteByPrimaryKey";

	private final String _SELECTALL = ".selectAll";

	private Class<T> clazz;

	@SuppressWarnings("unchecked")
	public BaseDao() {
		Type type = this.getClass().getGenericSuperclass();
		if (!(type instanceof ParameterizedType)) {
			type = type.getClass().getSuperclass().getGenericSuperclass();
		}
		clazz = (Class<T>) ((ParameterizedType) type).getActualTypeArguments()[0];
	}

	// 这是为了让父类获得SqlSessionFactory实例以便获得SqlSession，该实例已在spring-mybatis.xml配置
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	// 得到***Mapper.xml的命名空间
	public final String getNameSpace() {
		// Class<?> clazz = getSuperClassGenericType(this.getClass() , 0);
		String nameSpace = clazz.getName().replaceFirst("entity", "dao") + SUFFIX;
		return nameSpace;
	}

	public final int deleteEntity(PK id) {

		return getSqlSession().delete(this.getNameSpace() + _DELETEBYPRIMARYKEY, id);
	}

	/**
	 * 插入一条记录
	 * 
	 * @param t
	 *            对象实例
	 * @return 返回受影响的行数
	 */
	public final int insertEntity(T record) {

		return getSqlSession().insert(this.getNameSpace() + _INSERT, record);
	}

	/**
	 * 
	 * @param id
	 * @return 根据id返回一个实例
	 */
	public final T selectOneEntity(PK id) {
		return getSqlSession().selectOne(this.getNameSpace() + _SELECTBYPRIMARYKEY, id);
	}

	/**
	 * 
	 * @return 返回所有记录
	 */
	@SuppressWarnings("unchecked")
	public final List<T> selectAllEntity() {

		return (List<T>) getSqlSession().selectList(this.getNameSpace() + _SELECTALL);
	}

	/**
	 * 更新一条记录
	 * 
	 * @param t
	 *            对像实例
	 * @return 受影响的行数
	 */
	public final int updateEntity(T record) {

		return getSqlSession().update(this.getNameSpace() + _UPDATEBYPRIMARYKEY, record);
	}
	
	/**
	 * @return 富文本上传图片
	 */
	public String upload(MultipartFile myFileName, HttpSession session) throws IllegalStateException, IOException {
		String realName = "";
		if (myFileName != null) {
			String fileName = myFileName.getOriginalFilename();
			String fileNameExtension = fileName.substring(fileName.indexOf("."), fileName.length() - 1);
			// 生成实际存储的真实文件名
			realName = UUID.randomUUID().toString() + fileNameExtension;
			String realPath = session.getServletContext().getRealPath("/static/uploadImg/source");
			File uploadFile = new File(realPath, realName);
			myFileName.transferTo(uploadFile);
		}
		return realName;
	}
	/**
	 * @return 上传文件
	 */
	public String uploadFile(MultipartFile file, String truePath, HttpServletRequest request) {
		String realName = "";
		String path = request.getSession().getServletContext().getRealPath(truePath);
		File fileLocation = new File(path);
		// 此处也可以在应用根目录手动建立目标上传目录
		if (!fileLocation.exists()) {
			boolean isCreated = fileLocation.mkdir();
			if (!isCreated) {
				// 目标上传目录创建失败,可做其他处理,例如抛出自定义异常等,一般应该不会出现这种情况。
				return path;
			}
		}
		String fileName = file.getOriginalFilename();
		// 生成实际存储的真实文件名
		realName = fileName;
		File targetFile = new File(path, realName);
		if (!targetFile.exists()) {
			targetFile.mkdirs();
		}
		// 保存
		try {
			file.transferTo(targetFile);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return realName;
	}
	/**
	 * 下载文件
	 */
	public void downloadFile(String filename, String realPath, HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		response.setCharacterEncoding("UTF-8");
		// 获得下载的文件名字
		String fileName = filename;
		// 获得文件的绝对路径
		realPath = request.getSession().getServletContext().getRealPath(realPath);
		// 创建文件对象
		File file = new File(realPath, fileName);
		if (!file.exists()) {
			response.getWriter().write("文件不存在");
			return;
		}
		response.addHeader("content-disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
		IOUtils.copy(new FileInputStream(file), response.getOutputStream());
	}

	/**
	 * 删除文件
	 */
	public void deletFile(String reSpare, String truePath, HttpServletRequest request) {
		  //文件路径
		String realPath = request.getSession().getServletContext().getRealPath(truePath)+"/"+reSpare;
		System.out.println(realPath);
		File file = new File(realPath);
		 if (file.exists()) {
			  file.delete();//"删除单个文件"+name+"成功！"
			   }//"删除单个文件"+name+"失败！"
	}
	
	/**
	 * @return  上传图片
	 */
		public String uploadPicture(MultipartFile picture,String path) throws Exception {
			String fileName = picture.getOriginalFilename();
			fileName = UUID.randomUUID() + "." + fileName.substring(fileName.lastIndexOf(".") + 1);// uuid+文件扩展名避免重名,中文名等问题
			File uploadFile = new File(path, fileName);
			picture.transferTo(uploadFile);
			return fileName;
		}

}
