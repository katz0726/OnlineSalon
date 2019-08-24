<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

		<!-- jQuery -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
		<link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">

		<!-- Bootstrap -->
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

		<!-- Font Awsome -->
		<script src="https://kit.fontawesome.com/c645960b6a.js"></script>

		<!-- 共通CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" />

		<!-- 固有CSS -->
		<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/add.css" />

		<!-- 共通JS -->
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/Common.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/AddFriend.js"></script>

		<title>友だちを追加</title>
	</head>
	<body>
		<!-- header -->
		<jsp:include page="element\header.jsp" flush="true" />

		<div id="contents">
			<div id="contents-inner">
				<h1>友達を追加</h1>

				<div id="tab-wrap">
					<div id="tab-area">
						<label class="tab-invitation tab-label" for="tab1">招待</label>
						<label class="tab-qr-code tab-label" for="tab2">QRコード</label>
						<label class="tab_idsearch tab-label" for="tab3">ID検索</label>
					</div>
					<div id="panel-area">
						<div id="panel-invitaion" class="tab-panel">
							<p>panel1</p>
						</div>
						<div id="panel-qrcode" class="tab-panel">
							<p>panel2</p>
						</div>
						<div id="panel-idsearch" class="tab-panel">
							<div id="search-box-area" class="input-group">
								<input type="text" id="search-box" class="form-control" placeholder="友だちのIDで検索" />
									<span id="input-group-btn">
										<button type="button" id="search-btn" class="btn btn-primary"><i class="fas fa-search"></i></button>
									</span>
							</div>
						</div>
					</div>
				</div>
			</div>
			<div id="dialog-modal" style="display: none;">
  				<p>test</p>
			</div>

			<!-- footer -->
			<jsp:include page="element\footer.jsp" flush="true" />
		</div>
		<script type="text/javascript">
			var myCommon = new Common();
			var myAdd = new AddFriend();

			$(function() {
				$('.tab-label').on('click', function(){
					var $th = $(this).index();
					$('.tab-label').removeClass('active');
					$('.tab-panel').removeClass('active');
					$(this).addClass('active');
					$('.tab-panel').eq($th).addClass('active');
				});

				$('#search-btn').on('click', function() {
					// get a search condition
					var searchCondition = $('#search-box').val();

					// check if searh condition is empty or not
					if (myCommon.inner.checkEmpty(searchCondition)) {
						myCommon.inner.setErrorMark('search-box');

						// show error dialog message
						myCommon.inner.showErrorDialog('#dialog-modal', ERROR_TITTLE, DATE_FORMAT_ERROR);
					} else {
						// todo
						// register process
						myAdd.inner.changeConditionToJson(searchCondition);
					}
				});

				// In case the seach box is focused out,
				// turn the background color of search box transparent
				$('#search-box').on('focusout', function() {
					var searchCondition = $('#search-box').val();

					if (!myCommon.inner.checkEmpty(searchCondition)) {
						myCommon.inner.clearErrorMark('search-box');
					}
				});
			});
		</script>
	</body>
</html>