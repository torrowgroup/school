package com.futher.school.dao;

import com.futher.school.entity.Resource;

import java.util.HashMap;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ResourceMapper {

    int deleteByPrimaryKey(Integer reId);

    int insert(Resource record);

    int insertSelective(Resource record);

    Resource selectByPrimaryKey(Integer reId);

    int updateByPrimaryKeySelective(Resource record);

    int updateByPrimaryKey(Resource record);
    //根据类型id查询所有资源类符合的条数
    List<Resource> selectByTypeId(@Param("reTypeid")Integer reTypeid);
	//把符合条件的数据分页
	List<Resource> findByPage(HashMap<String, Object> map);
    //wqj用来获取所有resource
    List<Resource> getUploadFileName();//获取所有上传文件名
    //主页的滚动图片
	List<com.futher.school.entity.Resource> selectByPid(@Param("pid")int pid, @Param("number")int number);
    
}