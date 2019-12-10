package com.example.codeblue.test.yyj;

import org.apache.ibatis.annotations.Mapper;
import com.example.codeblue.vo.Manager;

@Mapper
public interface YyjMapper {
	//관리자 추가
	public int insertAdministrator(Manager manager);
}
