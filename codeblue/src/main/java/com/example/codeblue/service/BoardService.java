package com.example.codeblue.service;

import java.util.List;

import javax.swing.plaf.synth.Region;

import com.example.codeblue.vo.Feild;

public interface BoardService {

	public List<Region> getRegionList();
	public List<Feild> getFeildList();
}
