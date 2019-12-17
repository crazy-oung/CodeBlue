package com.example.codeblue.test.yyj;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.Point;

@Mapper
public interface YyjMapper {

	public List<Point> selectPointList(Page page);
	
	public int selectPointListTotalRow();
	
	public List<Map> selectPointTotalList(Page page);
	
	public int selectPointListSumTotalRow();
}
