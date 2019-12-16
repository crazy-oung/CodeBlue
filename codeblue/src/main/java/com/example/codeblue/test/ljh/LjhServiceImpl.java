package com.example.codeblue.test.ljh;


import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.example.codeblue.vo.FaqBoard;
import com.example.codeblue.vo.Hospital;
import com.example.codeblue.vo.HospitalForm;
import com.example.codeblue.vo.HospitalImg;
import com.example.codeblue.vo.Inquiry;
import com.example.codeblue.vo.InquiryHistory;
import com.example.codeblue.vo.Page;
import com.example.codeblue.vo.Region;


@Service
@Transactional
public class LjhServiceImpl implements LjhService{
	@Autowired LjhMapper ljhMapper;
	
	//문의 내역 리스트 가져오기
	@Override
	public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String inquiryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryList :::");
		
		Page page = new Page();
		page.setRowPerPage(rowPerPage);
		page.setBeginRow((currentPage-1)*rowPerPage);
		page.setSearchWord(searchWord);
		page.setSearchCategory(inquiryId);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		int totalRow = ljhMapper.InquiryHistoryTotalRow(page);
		int lastPage = totalRow/rowPerPage;
		
		if(totalRow % rowPerPage != 0) {
			lastPage ++;
		}
		List<InquiryHistory> list = ljhMapper.selectInquiryHistoryList(page);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("totalRow", totalRow);
		map.put("list", list);
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("lastPage", lastPage);
		map.put("searchWord", searchWord);
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);	
		
		System.out.println(map.toString());
		return map;
	}
	
	//Inquiry 카테고리 가져오기
	@Override
	public List<Inquiry> getInquiryList() {
		System.out.println(":::AdminServiceImpl - getInquiryList:::");
		return ljhMapper.selectInquiryList();
	}
	//Inquiry 리스트 삭제
	@Override
	public void removeInquiryHistoryList(List<String> inquiryHistoryIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeInquiryHistoryList :::");
		System.out.println(inquiryHistoryIdList.toString());
		ljhMapper.deleteInquiryHistoryAnswerList(inquiryHistoryIdList);
		ljhMapper.deleteInquiryHistoryList(inquiryHistoryIdList);
		System.out.println("공지사항 지우기 성공");
	}
	
	//FAQ 전체 리스트 가져오기
	@Override
	public Map<String, Object> getFaqBoardList(int currentPage, int rowPerPage, String searchWord, String toDate, String fromDate, String serviceCategoryId) {
		System.out.println(":::AdminServiceImpl - getFaqBoardList:::");
		System.out.println("currentPage :"+currentPage+"/rowPerPage :"+rowPerPage);

		Page page = new Page();
		page.setBeginRow((currentPage-1)*rowPerPage);
		page.setRowPerPage(rowPerPage);
		page.setSearchWord(searchWord);
		page.setToDate(toDate);
		page.setFromDate(fromDate);
		page.setSearchCategory(serviceCategoryId);
		System.out.println("setBeginRow" + page.getBeginRow());
		System.out.println("setRowPerPage" + page.getRowPerPage());
		System.out.println("setSearchWord" + page.getSearchWord());
		System.out.println("toDate  : " + page.getToDate());
		System.out.println("fromDate" + page.getFromDate());
		System.out.println("searchCategory : "+page.getSearchCategory());
		int totalRow = ljhMapper.selectFaqBoardTotalCount(page);
		int lastPage = 0;
		
		if(totalRow % rowPerPage != 0) {
			lastPage = (totalRow/rowPerPage)+1;
		}else {
			lastPage = totalRow/rowPerPage;
		}
		System.out.println("lastPage:"+ lastPage );
		
		List<FaqBoard> list = ljhMapper.selectFaqBoardList(page);
		System.out.println(list.toString());
		
		Map<String, Object> map = new HashMap<String,Object>();
		map.put("currentPage", currentPage);
		map.put("rowPerPage", rowPerPage);
		map.put("searchWord", searchWord);
		map.put("totalRow", totalRow);
		map.put("lastPage", lastPage);
		map.put("list", list);
		map.put("toDate", toDate);
		map.put("fromDate", fromDate);		
		return map;
	}
	
	//FAQ 리스트 삭제
	@Override
	public void removeFaqBoardList(List<String> faqBoardIdList) {
		System.out.println("::: AdminBoardServiceImpl - removeNoticeBoardList :::");
		System.out.println(faqBoardIdList.toString());
		ljhMapper.deleteFaqBoardList(faqBoardIdList);
		System.out.println("공지사항 지우기 성공");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//질문 답변 댓글 총 개수 가져오기
	@Override
	public int getAnswerCommentCount(int answerId) {
		System.out.println("::: serviceIMPl - getAnswerCommentCount :::");
		return ljhMapper.selectAnswerCommentCount(answerId);
	}

	@Override
	public int addHospital(HospitalForm hospitalForm) {
		System.out.println("::: serviceIMPl - addHospital :::");
		System.out.println("hospitalForm : "+ hospitalForm.toString());
		// HospitalForm 분리 작업 -> Hospital, HospitalImg
		
		//Hospital
		Hospital hospital = new Hospital();
		hospital.setHospitalName(hospitalForm.getHospitalName());
		hospital.setHospitalNumber(hospitalForm.getHospitalNumber());
		hospital.setRegion(new Region());
		hospital.getRegion().setRegionId(hospitalForm.getRegion().getRegionId());
		hospital.setHospitalAddress(hospitalForm.getHospitalAddress());
		hospital.setHospitalAddress2(hospitalForm.getHospitalAddress2());
		System.out.println(hospital.toString());
		ljhMapper.insertHospital(hospital);
		
		//HospitalImg
		MultipartFile mf = hospitalForm.getHospitalImg();
		String contentType = mf.getContentType();
		String originName = mf.getOriginalFilename();
		long size = mf.getSize();
		// 파일의 확장자 명만 구하기
		String extension = originName.substring(originName.lastIndexOf(".")+1);
		String filename = UUID.randomUUID().toString().replace("-", "");//-없애기.
		// 파일의 랜덤 이름 만들기 									
		String saveFileName = filename+"."+extension;
		//HosptalImg에 저장
		HospitalImg hospitalImg = new HospitalImg();
		hospitalImg.setHospitalImgName(filename);
		hospitalImg.setHospitalImgExtension(extension);
		hospitalImg.setHospitalImgOriginName(originName);
		hospitalImg.setHospitalImgSize(size);
		System.out.println("HospitalImg : "+ hospitalImg);
		//mapper.insertHospitalImg(hospitalImg);
		
		try {
			mf.transferTo(new File("C:\\Spring\\work-space\\board\\src\\main\\webapp\\upload\\"+saveFileName));
		} catch ( Exception e) {
			e.printStackTrace();
			throw new RuntimeException();
		}
		return 0;
	}





	
	
	
	
	
	
	
	
	
	/*
	//문의사항 답변 저장
	@Override
	public void addInquiryHistoryAnswer(InquiryHistoryAnswer inqruiyHistoryAnswer) {
		System.out.println(":::AdminServiceImpl - addInquiryHistoryAnswer:::");
		int row = ljhMapper.insertInquiryHistoryAnswer(inqruiyHistoryAnswer);
		System.out.println(inqruiyHistoryAnswer.getInquiryHistory().getInquiryHistoryId());
		if(row != 0 ) {
			ljhMapper.updateInquiryHistory(inqruiyHistoryAnswer.getInquiryHistory().getInquiryHistoryId());
		}
	}
	//문의내역 상세페이지 가져오기
	@Override
	public InquiryHistory getInquiryHistoryOne(int inquiryHistoryId) {
		System.out.println("::: AdminServiceImpl - getInquiryHistoryOne :::");
		return ljhMapper.selectInquiryHistoryOne(inquiryHistoryId);
	}
	//문의 내역 리스트 가져오기
		@Override
		public Map<String, Object> getInquiryHistoryList(int currentPage, int rowPerPage) {
			System.out.println("::: AdminServiceImpl - getInquiryHistoryList :::");
			
			Page page = new Page();
			page.setRowPerPage(rowPerPage);
			page.setBeginRow((currentPage-1)*rowPerPage);
			
			int totalRow = ljhMapper.InquiryHistoryTotalRow();
			int lastPage = totalRow/rowPerPage;
			
			if(totalRow % rowPerPage != 0) {
				lastPage ++;
			}
			List<InquiryHistory> list = ljhMapper.selectInquiryHistoryList(page);
			
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("totalRow", totalRow);
			map.put("list", list);
			map.put("currentPage", currentPage);
			map.put("rowPerPage", rowPerPage);
			map.put("lastPage", lastPage);
			System.out.println(map.toString());
			return map;
		}*/
	
}