package com.futher.school.service;

import java.util.List;

import com.futher.school.entity.Type;

public interface TypeService {

	Type getId(String usIdentityname);

	List<Type> selectTypeName(Integer tyPid);

}
