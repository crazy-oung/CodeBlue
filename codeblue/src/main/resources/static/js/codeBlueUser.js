$(document).ready(function() {
	
	$("#topBar").append( '<nav class="navbar navbar-expand navbar-light topbar mb-4 shadow fixed-top" style="height: 50px; border-bottom: 1px solid #d9d9d9; border-top: 4px solid #4e73df; background: #f2f2f2;">'
							+ '<div class="container">'
							+ '<a class="navbar-brand text-primary mr-0" href="/today"><img src="/img/codeBlueLogo.png" width="125px"></a>'
							+ '<a class="btn btn-sm btn-default mx-2 hov-g text-primary font-weight-bold " href="/QnA">QnA</a>'
					        +'<form class="d-none d-sm-inline-block form-inline mr-2 my-2 my-md-0 mw-100 navbar-search" style="width:100%">'
							+'<div class="input-group">'
							+'<input type="text" class="form-control  form-control-sm bg-light border-1" placeholder="검색어" id="searchQuestionBoard">'
							+'<div class="input-group-append">'
							+'<button class="btn btn-primary btn-sm" type="button" id="search">'
							+'<i class="fas fa-search fa-sm"></i>'
							+'</button>'
							+'</div>'
							+'</div>'
							+'</form>'
							+'<div class="d-sm-none dropdown no-arrow">'	//모바일 검색
							+'<a class="dropdown-toggle text-primary btn hov-p px-2" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'
							+'<i class="fas fa-search fa-fw"></i>'
							+'</a>     '
							+'<!-- Dropdown - Messages -->    ' 
							+'<div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">        '
							+'<form class="form-inline mr-auto w-100 navbar-search">'  
							+'<div class="input-group">         '
							+'<input type="text" class="form-control bg-light border-0 small" placeholder="검색어" aria-label="Search" aria-describedby="basic-addon2" id="searchQuestionBoard">     '    
							+'<div class="input-group-append">   '        
							+'<button class="btn btn-primary" type="button" id="search">'     
							+'<i class="fas fa-search fa-sm"></i>'
							+'</button>         '
							+'</div>      ' 
							+'</div>     '
							+'</form>   '
							+'</div> '
							+'</div>'	// 모바일 검색 끝	
							+'<ul class="navbar-nav" id="userInfo">'
							+'</ul></div></nav>');
	
	$("#leftSideBar").append('<nav class="navbar pl-0 sticky-container">'
			+ '<div style="margin-top: 70px">'
			+ '	<ul class="nav flex-column">'
			+ '		<li class="pl-0"><small>질문</small></li> '
			+ '		<li class="nav-item pl-1"><a class="nav-link pl-2 font-weight-bold pt-1 pb-0" href="/today">today</a></li> '
			+ '		<li class="nav-item pl-1"><a class="nav-link pl-2 text-danger font-weight-bold pt-1 pb-0" href="/hot">hot 🔥</a></li>'
			+ '		<li class="nav-item pl-1"><a class="nav-link pl-2 text-warning font-weight-bold pt-1 pb-0" href="/help">help!</a></li>'
			+ '		<li class="nav-item pl-1"><a class="nav-link pl-2 text-success font-weight-bold pt-1 pb-0" href="/ongoing">ongoing</a></li>'
			+ '		<li class="mt-2"><small>조회</small></li> '
			+ '		<li class="nav-item"><a class="nav-link text-dark pl-2 pt-1 pb-0" href="/users">유저</a></li>'
			+ '		<li class="nav-item"><a class="nav-link text-dark pl-2 pt-1 pb-0" href="/tags">태그</a></li>'
			+ '		<li class="nav-item"><a class="nav-link text-dark pl-2 pt-1 pb-0" href="/ranking">랭킹</a></li>'
			+ ' </ul>'
			+ '</div> '
			+ '</nav>');
	
	$("#rightSideBar").append('<div class="card border-1 shadow bg-light border-bottom-primary mb-3">'
						+ '<small class="text-primary font-weight-bold card-header alert-primary px-3 border-0">'
						+ '<a class="nav-link p-0" href="/notice"><span class="badge badge-primary m-0">New</span> 새 소식이 있어요!</a>'
						+ '</small>'
						+ '<table class=" table table-sm mb-0" id="rightNoticeList">'
						+ '</table>'		
						+ '<small class="text-primary font-weight-bold card-header alert-primary px-3 border-0"><a class="nav-link p-0" href="/faq">'
						+ '<span class="badge badge-warning m-0">FAQ</span> 궁금한 것이 있나요?</a>'
						+ '</small>'
						+ '<table class=" table table-sm mb-0" id="rightFAQList">'
						+ '</table>'		
						+ '</div>');
	
	// 최근 공지 5개
   $.ajax({
      url:"/rest/getNoticeList",
      method:"post",
      data:{"rowPerPage" : "5"},
      success: function(json){
         $("#rightNoticeList").empty();
         currentPage = json.currentPage;
         lastPage = json.lastPage;
         $(json.list).each(function(index,item){
            html =  '<tr><td><a class="nav-link small px-2" href="/noticeOne?noticeId='+item.noticeId+'"><i class="far fa-comment-dots mx-1"></i>'+item.noticeTitle+'</a></td></tr>';
            $("#rightNoticeList").append(html);
         });
      }
   })
   
   // FAQ 5개
   $.ajax({
      url:"/rest/getFaqList",
      method:"post",
      data:{"rowPerPage" : "5"},
      success: function(json){
         $("#rightFAQList").empty();
         console.log(json);
         $(json.list).each(function(index,item){
            html =  '<tr><td><a class="nav-link small px-2" href="/faqOne?faqId='+item.faqId+'"><i class="far fa-comment-dots mx-1"></i>'+item.faqTitle+'</a></td></tr>';
            $("#rightFAQList").append(html);
         });
      }
   })

	$("#footer").append( '<footer class="sticky-footer bg-gray-900 py-4" id="footer">'
			+ '<div class="container my-auto small">'
			+ '<div class="row">'
			+ '<div class="col-sm-2 text-center">'
			+ '<a class="nav-link p-0 " href="/index"><img src="img/codeBlueIcon.png" width="50px"></a>'
			+ '</div>'
			+ '<div class="col-sm-2 font-weight-bold">'
			+ '	<label><a class="nav-link p-0 text-gray-400" href="/index">CODEBLUE</a></label>'
			+ '    <ul class="nav flex-column">'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">질문등록</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">정보검색</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">이용안내</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/inquiryBoard">문의하기</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/faq">자주묻는질문</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">이용약관</a></li>'
			+ '    </ul>'
			+ '</div>'
			+ '<div class="col-sm-2 font-weight-bold">'
			+ '	<label><a class="nav-link p-0 text-gray-400" href="/index">파트너</a></label>'
			+ '    <ul class="nav flex-column">'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1" href="/index">회사소개</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">회사정보</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/hospital">제휴병원</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">제휴·제안</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1  " href="/index">채용안내</a></li>'
			+ '    </ul>'
			+ '</div>'
			+ '<div class="col-sm-3 font-weight-bold">'
			+ '	<label><a class="nav-link p-0 text-gray-400" href="/index">연락처</a></label>'
			+ '    <ul class="nav flex-column">'
			+ '        <li class="nav-item"><span class="nnav-link p-0 mb-1  ">전화 0000-00000</span></li>'
			+ '        <li class="nav-item d-flex">이메일&nbsp;<a class="nav-link p-0 mb-1" href="mailto:creativecloud@kakao.com" target="_top"">creativecloud@kakao.com</a></li>'
			+ '    </ul>'
			+ '</div>'
			+ '<div class="col-sm-3">'				
			+ '	<div class="copyright text-right my-auto">'
			+ '		<img src="img/codeBlue.png" width="130px"><br>'
			+ '		<p class="mt-1">Copyright © CodeBlue Corp. <br>All Rights Reserved.</p>'
			+ '		<a class="nav-link font-weight-bold" href="https://github.com/crazy-oung/codeBlue"><i class="fab fa-github-alt mx-1"></i>GitHub</a>'
			+ '	</div>'
			+ '</div>'
			+ '</div>'
			+ '</div>'
			+ '</footer>');
	
	// 상단바 로그인 유저 표시
	$.ajax({
		url : "/rest/getLoginUser",
		method : "get",
		success : function(json) {
			console.log(json);
			if (json == "") {
				$("#userInfo").append('<li class="d-none d-sm-inline-block nav-item ml-2 mr-1">'
										+'<a class="btn btn-sm hov-p text-primary  p-1" href="/login" style="width: 70px">로그인</a>'
										+'</li>'
										+'<li class="d-none d-sm-inline-block nav-item">'
										+'<a class="btn btn-sm btn-primary p-1" href="/register" style="width: 80px">회원가입</a>'
										+'</li>'
										+'<li class="d-sm-none nav-item ml-2 mr-1">'
										+'<a class="btn btn-sm hov-p text-primary p-1" href="/login"><i class="fas fa-sign-in-alt"></i></a>'
										+'</li>'
										+'<li class="d-sm-none nav-item">'
										+'<a class="btn btn-sm btn-primary p-1" href="/register"><i class="fas fa-user-plus"></i></a>'
										+'</li>'
										
				);
				return;
			}
			
			$("#userInfo").empty();
			$("#userInfo").append('<li class="nav-item dropdown no-arrow"><a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">'
						+ '<span class="mr-2 d-none d-lg-inline text-gray-600 small" id="userName">'
						+ json.userName
						+ '</span>'
						+ '<img class="img-profile rounded-circle" src="/img/profile.svg">'
						+ '</a>'
						+ '<div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">'
						+ '<a class="dropdown-item d-sm-none text-gray-900" id="userName" href="#">'
						+ '<i class="far fa-id-badge fa-sm fa-fw mr-2 text-gray-400"></i>' + json.userName + '</a>'
						+ '<div class="dropdown-divider d-sm-none"></div>'
						+ '<a class="dropdown-item" href="/userOne?userId='+json.userId+'">'
						+ '<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>프로필</a>'
						+ '<a class="dropdown-item" href="/modifyProfile?userId='+json.userId+'"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>설정</a>'
						+ '<a class="dropdown-item" href="/userOneActive?userId='+json.userId+'"><i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>활동로그</a>'
						+ '<div class="dropdown-divider"></div>'
						+ '<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그아웃</a></li>');
		},

	})
	console.log(getParam("searchWord"));
	$("#searchQuestionBoard").val(getParam("searchWord"))
	//현재페이지값
	var currentPage = 1;
	//마지막페이지값
	var lastPage = 0;
	//검색한 단어
	var searchWord = null;
	//분야 선택
	var feildId = 99;
	if(getParam("feildId")!= null){
		feildId = getParam("feildId");
	}
	console.log("feildId: ",feildId);
	
	// 필드 테이블 출력
	$.ajax({
		url : "/rest/getFeildList",
		method : "GET",
		success : function(json){
			console.log(json);
			$(json).each(function(index, item){
				html = " <li class='nav-item'><a class='p-1 mr-1 hov-p text-primary btn ";
				if(feildId == item.feildId){
					console.log("일치!");
					html += "font-weight-bold text-lg";
				}
				html += "' href='/QnA?feildId="+item.feildId+"'>"+
						item.feildName +
						"</a></li>";
				$("#feilds").append(html);
				
			})
		}
	})
	
	//홈페이지 질문 출력
	$.ajax({
		url:"/rest/getBoardList",
		method:"POST",
		data:{"currentPage" : currentPage, "feildId":feildId,"searchCategory":$("#searchCategory").val(),"searchWord":getParam("searchWord")},
		success: function(json){
			console.log(json);
			$("#content").empty();
			if(json.searchWord != null) {
				$("#content").append(json.searchWord+"에 대한 검색 결과");
			}
			$("#totalCount").empty();
			$("#totalCount").append("검색결과"+json.totalCount+"건");
			currentPage = json.currentPage;
			lastPage = json.lastPage;
			BtnShow(currentPage,lastPage);
			$(json.list).each(function(index,item){
				html = appendItem(item);
				$("#questionBoard").append(html);
			})
		}
	})	
		
	//이전버튼
	$("#prevBtn").click(function(){
		$.ajax({
			url:"/rest/getBoardList",
			method:"POST",
			data:{"currentPage" : currentPage-1,"searchWord": getParam("searchWord"),"searchCategory":$("#searchCategory").val()},
			success: function(json){
				console.log(json);
				currentPage = json.currentPage;
				lastPage = json.lastPage;
				$("#searchWord").val(json.searchWord);
				BtnShow(currentPage,lastPage);
				$("#questionBoard").empty();
				$(json.list).each(function(index,item){
					html = appendItem(item);
					$("#questionBoard").append(html);
				})
			}
		})
	});
	
	//다음버튼
	$("#nextBtn").click(function(){
		$.ajax({
			url:"/rest/getBoardList",
			method:"POST",
			data:{"currentPage" : currentPage+1,"searchWord": getParam("searchWord"),"searchCategory":$("#searchCategory").val()},
			success: function(json){
				console.log(json);
				currentPage = json.currentPage;
				lastPage = json.lastPage;
				$("#searchWord").val(json.searchWord);
				BtnShow(currentPage,lastPage);
				$("#questionBoard").empty();
				$(json.list).each(function(index,item){
					html = appendItem(item);
					$("#questionBoard").append(html);
				})
			}
		})
	});
	
	
	//이전 다음 버튼이 숨기는지 안숨기는지 함수로변경
	function BtnShow(currentPage,lastPage) {
		if(currentPage == 1){
			$("#prevBtn").hide();
		} else {
			$("#prevBtn").show();
		}
		if(currentPage <lastPage) {
			$("#nextBtn").show();
		} else {
			$("#nextBtn").hide();
		}
	}
	$("#search").click(function(){
		if($("#searchQuestionBoard").val() == ""){
			location.href="/search";
		} else {
			location.href="/search?searchWord="+$("#searchQuestionBoard").val();
		}
	})
//	//검색버튼
//	$("#search").click(function(){
//		console.log("검색시작");
//		$.ajax({
//			url:"/rest/getBoardList",
//			method:"POST",
//			data:{"searchQuestionBoard": $("#searchQuestionBoard").val()},
//			success: function(json){
//				console.log(json);
//				currentPage = json.currentPage;
//				lastPage = json.lastPage;
//				$("#searchQuestionBoard").val(json.searchQuestionBoard);
//				searchWord = json.searchWord;
//				BtnShow(currentPage,lastPage);
//				$("#questionBoard").empty();
//				$(json.list).each(function(index,item){
//					html = appendItem(item);							
//					$("#questionBoard").append(html);
//				})
//			}
//		})
//	});
	
	$('#summernote').summernote({
		  toolbar: [
				['style', ['style']],
				['style', ['bold', 'italic', 'underline', 'clear']],
				['font', ['strikethrough', 'superscript', 'subscript']],
				['fontsize', ['fontsize']],
				['color', ['color']],
				['para', ['ul', 'ol', 'paragraph']],
				['height', ['height']],
				['fontsize', ['8','10','10','10','10']],
				['para', ['ul', 'ol', 'paragraph']],
				['table', ['table']],
				['insert', ['link', 'picture', 'video']]
			],
		lang : 'ko-KR',
		placeholder: '내용을 입력해주세요',
		tabsize: 4,
		height: 500
	});
	
}) // document ready end

// 리스트 출력
function appendItem(item){

	html = "<tr>"+
	"<td width='9%' class=><div class='text-center pt-1'>"+item.voteCount+"<br>"+
	"<small class='my-1'>추천</small>"+
	"</div></td>"+
	"<td width='11%' class='px-1'><div class='card border-success text-center pt-1' >"+item.answerCount+"<br>"+
	"<small class='text-success my-1'>답변</small>"+
	"</div></td>"+
	"<td><a class='nav-link' href='/questionBoardOne?questionId="+item.questionId+"'>"+item.questionTitle+"</a>" +
	"<div class='d-flex justify-content-between'>"+
	"<small class='p-2'>";
	if(item.questionTags != null && item.questionTags != "" ){
		console.log("태그 있음!")
		console.log(item.questionTags);
		let tags = item.questionTags;
		tags = tags.split("#");
		console.log(tags);
		for(let i=1;i<tags.length;i++){
			console.log(i);
			html+='<a class="text-primary mx-1 p-0 px-1 btn btn-sm btn-light alert-primary" href="#">#'+tags[i]+'</a>';
		}
	}
	html += "</small>"+
	"<small class='p-2'>uploaded at"+item.questionDatetime +" by <a href='/userOne?userId="+item.user.userId+"'>"+ item.user.userName+"</small></div>"
	+"</td></tr>";
	return html;
}


//파라메터 정보가 저장될 오브젝트
	var getParam = function(key){
	    var _parammap = {};
	    document.location.search.replace(/\??(?:([^=]+)=([^&]*)&?)/g, function () {
	        function decode(s) {
	            return decodeURIComponent(s.split("+").join(" "));
	        }
	
	        _parammap[decode(arguments[1])] = decode(arguments[2]);
	    });
	
	    return _parammap[key];
	};