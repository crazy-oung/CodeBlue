package com.example.codeblue.test.hdy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Tag;

@Transactional
@Service
public class HdyServiceImpl implements HdyService{
	@Autowired HdyMapper hdyMapper;
	
	
}
