$(document).ready(function() {
	$("#topBar").append( '<nav class="navbar navbar-expand navbar-light topbar mb-4 shadow fixed-top" style="height: 50px; border-bottom: 1px solid #d9d9d9; border-top: 4px solid #4e73df; background: #f2f2f2;">'
							+ '<div class="container">'
							+ '<a class="navbar-brand text-primary mr-0" href="/today"><img src="/img/codeBlueLogo.png" width="130px"></a> '
							+ '<a class="btn btn-sm btn-default mx-2 hov-g text-dark" href="/QnA">QnA</a>'
							+'<div class="input-group">'
							+'<input type="text" class="form-control  form-control-sm bg-light border-1" placeholder="검색어" id="searchWord">'
							+'<div class="input-group-append">'
							+'<button class="btn btn-primary btn-sm" type="button" id="search">'
							+'<i class="fas fa-search fa-sm"></i>'
							+'</button>'
							+'</div>'
							+'</div>'
							+'<ul class="navbar-nav ml-auto" id="userInfo" style="width: 20%">'
							+'</ul></div></nav>');
	
	$("#rightSideBar").append('<div class="card border-1 shadow bg-light border-bottom-primary mt-4">'
						+ '<small class="text-primary font-weight-bold card-header alert-primary px-3 border-0">'
						+ '<a class="nav-link p-0" href="/notice"><span class="badge badge-primary m-0">New</span> 새 소식이 있어요!</a>'
						+ '</small>'
						+ '<table class=" table table-sm mb-0">'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="/notice"><i class="far fa-comment-dots mx-1"></i>공지사항을 확인해보세요! </a></td>'
						+ '</tr>'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><i class="far fa-comment-dots mx-1"></i>도와주세용</a></td>'
						+ '</tr>'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><i class="far fa-comment-dots mx-1"></i>도와주세용</a></td>'
						+ '</tr>'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><i class="far fa-comment-dots mx-1"></i>도와주세용</a></td>'
						+ '</tr>'
						+ '</table>'		
						+ '<small class="text-primary font-weight-bold card-header alert-primary px-3 border-0">'
						+ '궁금한 것이 있나요?'
						+ '</small>'
						+ '<table class=" table table-sm mb-0">'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><i class="far fa-comment-dots mx-1"></i>도와주세용</a></td>'
						+ '</tr>'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><i class="far fa-comment-dots mx-1"></i>도와주세용</a></td>'
						+ '</tr>'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><img src="img/codeblueicon.png" width="15px">도와주세용</a></td>'
						+ '</tr>'
						+ '<tr>'
						+ '	<td><a class="nav-link small px-2" href="#"><img src="img/codeblueicon.png" width="15px">도와주세용</a></td>'
						+ '</tr>'
						+ '</table>'		
						+ '</div>');
					
	$("#footer").append( '<footer class="sticky-footer bg-gray-900 py-4" id="footer">'
			+ '<div class="container my-auto small">'
			+ '<div class="row">'
			+ '<div class="col-sm-2 text-center">'
			+ '<a class="nav-link p-0 " href="/index"><img src="img/codeBlueIcon.png" width="50px"></a>'
			+ '</div>'
			+ '<div class="col-sm-2 font-weight-bold">'
			+ '	<label><a class="nav-link p-0 text-gray-400" href="/index">CODEBLUE</a></label>'
			+ '    <ul class="nav flex-column">'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">질문등록</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">정보검색</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">이용안내</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">문의하기</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">자주묻는질문</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">이용약관</a></li>'
			+ '    </ul>'
			+ '</div>'
			+ '<div class="col-sm-2 font-weight-bold">'
			+ '	<label><a class="nav-link p-0 text-gray-400" href="/index">파트너</a></label>'
			+ '    <ul class="nav flex-column">'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">회사소개</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">회사정보</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">제휴·제안</a></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">채용안내</a></li>'
			+ '    </ul>'
			+ '</div>'
			+ '<div class="col-sm-3 font-weight-bold">'
			+ '	<label><a class="nav-link p-0 text-gray-400" href="/index">연락처</a></label>'
			+ '    <ul class="nav flex-column">'
			+ '        <li class="nav-item"><span class="nnav-link p-0 mb-1 text-gray-600">전화 0000-00000</span></li>'
			+ '        <li class="nav-item"><a class="nav-link p-0 mb-1 text-gray-600" href="/index">이메일 codeblue@codeblue.com</a></li>'
			+ '    </ul>'
			+ '</div>'
			+ '<div class="col-sm-3">'				
			+ '	<div class="copyright text-right my-auto">'
			+ '		<img src="img/codeBlue.png" width="130px"><br>'
			+ '		<p class="mt-1">Copyright © CodeBlue Corp. <br>All Rights Reserved.</p>'
			+ '		<a class="nav-link" href="https://github.com/crazy-oung/codeBlue"><i class="far fa-comment-github mx-1"></i>GitHub</a>'
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
				$("#userInfo").append('<li class="nav-item ml-2 mx-1">'
										+'<a class="btn btn-sm hov-p text-primary p-1" href="/login">로그인</a>'
										+'</li>'
										+'<li class="nav-item mx-1">'
										+'<a class="btn btn-sm btn-primary p-1" href="/register">회원가입</a>'
										+'</li>');
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
						+ '<a class="dropdown-item" href="/userOne">'
						+ '<i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>프로필</a>'
						+ '<a class="dropdown-item" href="#"><i class="fas fa-cogs fa-sm fa-fw mr-2 text-gray-400"></i>설정</a>'
						+ '<a class="dropdown-item" href="#"><i class="fas fa-list fa-sm fa-fw mr-2 text-gray-400"></i>활동로그</a>'
						+ '<div class="dropdown-divider"></div>'
						+ '<a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal"><i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>로그아웃</a></li>');
		},

	})

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
		data:{"currentPage" : currentPage, "feildId":feildId},
		success: function(json){
			currentPage = json.currentPage;
			lastPage = json.lastPage;
			BtnShow(currentPage,lastPage);
			$(json.list).each(function(index,item){
				html = append(item);
				$("#questionBoard").append(html);
			})
		}
	})	
	
	
	//이전버튼
	$("#prevBtn").click(function(){
		$.ajax({
			url:"/rest/getBoardList",
			method:"POST",
			data:{"currentPage" : currentPage-1,"searchWord": searchWord},
			success: function(json){
				currentPage = json.currentPage;
				lastPage = json.lastPage;
				$("#searchWord").val(json.searchWord);
				BtnShow(currentPage,lastPage);
				$("#questionBoard").empty();
				$(json.list).each(function(index,item){
					html = append(item);
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
			data:{"currentPage" : currentPage+1,"searchWord": searchWord},
			success: function(json){
				currentPage = json.currentPage;
				lastPage = json.lastPage;
				$("#searchWord").val(json.searchWord);
				BtnShow(currentPage,lastPage);
				$("#questionBoard").empty();
				$(json.list).each(function(index,item){
					html = append(item);
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
	
	//검색버튼
	$("#search").click(function(){
		console.log("검색시작");
		$.ajax({
			url:"/rest/getBoardList",
			method:"POST",
			data:{"searchWord": $("#searchWord").val()},
			success: function(json){
				console.log(json);
				currentPage = json.currentPage;
				lastPage = json.lastPage;
				$("#searchWord").val(json.searchWord);
				searchWord = json.searchWord;
				BtnShow(currentPage,lastPage);
				$("#questionBoard").empty();
				$(json.list).each(function(index,item){
					html = append(item);							
					$("#questionBoard").append(html);
				})
			}
		})
	});
	
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
function append(item){
	return "<tr>"+
	"<td width='9%' class=><div class='text-center pt-1'>"+item.voteCount+"<br>"+
	"<small class='my-1'>추천</small>"+
	"</div></td>"+
	"<td width='11%' class='px-1'><div class='card border-success text-center pt-1' >"+item.answerCount+"<br>"+
	"<small class='text-success my-1'>답변</small>"+
	"</div></td>"+
	"<td><a class='nav-link' href='/questionBoardOne?questionId="+item.questionId+"'>"+item.questionTitle+"</a>" +
	"<div class='d-flex justify-content-between'>"+
	"<small class='p-2'>태그 잔뜩 나열</small>"+
	"<small class='p-2'>uploaded at"+item.questionDatetime +" by " + item.user.userName+"</small></div>"
	+"</td></tr>";
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