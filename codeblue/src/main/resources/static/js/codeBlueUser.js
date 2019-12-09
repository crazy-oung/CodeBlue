$(document).ready(function() {
	$("#topBar").append( '<nav class="navbar navbar-expand navbar-light topbar mb-4 shadow fixed-top" style="height: 50px; border-bottom: 1px solid #d9d9d9; border-top: 4px solid #4e73df; background: #f2f2f2;">'
							+ '<div class="container">'
							+ '<a class="navbar-brand text-primary mr-0" href="/"><img src="/img/codeBlueLogo.png" width="130px"></a> '
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

})