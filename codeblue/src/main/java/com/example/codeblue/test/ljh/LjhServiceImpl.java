package com.example.codeblue.test.ljh;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.codeblue.vo.Answer;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.QuestionBoard;
import com.example.codeblue.vo.ReportHistory;


@Service
@Transactional
public class LjhServiceImpl implements LjhService{
	@Autowired LjhMapper ljhMapper;
	
	//신고 대상(질문)상세 정보 가져오기
	@Override
	public QuestionBoard getReportQuestionBoardOne(int questionId) {
		System.out.println("::: AdminServiceImpl - getReportQuestionBoardOne :::");
		return ljhMapper.selectReportQuestionBoardOne(questionId);
	}
	//신고 대상(답변)상세 정보 가져오기
	@Override
	public Answer getReportAnswerOne(int answerId) {
		System.out.println("::: AdminServiceImpl - getReportAnswerOne :::");
		return ljhMapper.selectReportAnswerOne(answerId);
	}
	@Override
	public ReportHistory getReportHistoryOne(int reportHistoryId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	






	

	
	
	
	
	
	

//	@Override
//	public int addHospital(HospitalForm hospitalForm) {
//		System.out.println("::: serviceIMPl - addHospital :::");
//		System.out.println("hospitalForm : "+ hospitalForm.toString());
//		// HospitalForm 분리 작업 -> Hospital, HospitalImg
//		
//		//Hospital
//		Hospital hospital = new Hospital();
//		hospital.setHospitalName(hospitalForm.getHospitalName());
//		hospital.setHospitalNumber(hospitalForm.getHospitalNumber());
//		hospital.setRegion(new Region());
//		hospital.getRegion().setRegionId(hospitalForm.getRegion().getRegionId());
//		hospital.setHospitalAddress(hospitalForm.getHospitalAddress());
//		hospital.setHospitalAddress2(hospitalForm.getHospitalAddress2());
//		System.out.println(hospital.toString());
//		ljhMapper.insertHospital(hospital);
//		
//		//HospitalImg
//		MultipartFile mf = hospitalForm.getHospitalImg();
//		String contentType = mf.getContentType();
//		String originName = mf.getOriginalFilename();
//		long size = mf.getSize();
//		// 파일의 확장자 명만 구하기
//		String extension = originName.substring(originName.lastIndexOf(".")+1);
//		String filename = UUID.randomUUID().toString().replace("-", "");//-없애기.
//		// 파일의 랜덤 이름 만들기 									
//		String saveFileName = filename+"."+extension;
//		//HosptalImg에 저장
//		HospitalImg hospitalImg = new HospitalImg();
//		hospitalImg.setHospitalImgName(filename);
//		hospitalImg.setHospitalImgExtension(extension);
//		hospitalImg.setHospitalImgOriginName(originName);
//		hospitalImg.setHospitalImgSize(size);
//		System.out.println("HospitalImg : "+ hospitalImg);
//		//mapper.insertHospitalImg(hospitalImg);
//		
//		try {
//			mf.transferTo(new File("C:\\Spring\\work-space\\board\\src\\main\\webapp\\upload\\"+saveFileName));
//		} catch ( Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException();
//		}
//		return 0;
//	}

}