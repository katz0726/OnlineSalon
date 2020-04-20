<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/header.css" />
</head>
<header id="header-area">
	<!-- HOME -->
	<div id="home-area" class="header-item">
		<i class="fas fa-home"></i>
		<a href="${pageContext.request.contextPath}/menu/home" class="header-item-link"><span class="headrer-item-title">HOME</span></a>
	</div>
	<!-- TALK -->
	<div id="talk-area" class="header-item">
		<i class="fas fa-comment-dots"></i>
		<a href="${pageContext.request.contextPath}/menu/talk" class="header-item-link"><span class="headrer-item-title">TALK</span></a>
	</div>
	<!-- ADD FRIENDS -->
	<div id="add-friends-area" class="header-item">
		<i class="fas fa-user-plus"></i>
		<a href="${pageContext.request.contextPath}/menu/add" class="header-item-link"><span class="headrer-item-title">ADD FRIENDS</span></a>
	</div>
	<!-- TIMELINE -->
	<div id="timeline-area" class="header-item">
		<i class="fas fa-clock"></i>
		<a href="${pageContext.request.contextPath}/menu/timeline" class="header-item-link"><span class="headrer-item-title">TIMELINE</span></a>
	</div>
	<!-- USER MENU -->
	<div id="user-menu-area" class="header-item">
		<div id="user-menu-area-inner">
			<img src="${pageContext.request.contextPath}/img/user.jpg" id="user-menu-icon" />
			<div id="user-menu-box" style="display: none;">
				<span id="user-name"></span>
				<ul id="user-menu-list">
					<li class="user-menu-list-item"><a href="${pageContext.request.contextPath}/menu/mypage" class="header-item-link">マイページ</a></li>
					<li class="user-menu-list-item"><a href="${pageContext.request.contextPath}/menu/settings" class="header-item-link">設定</a></li>
					<li class="user-menu-list-item"><a href="${pageContext.request.contextPath}/logout" class="header-item-link">ログアウト</a></li>
				</ul>
			</div>
		</div>
	</div>
</header>
<script type="text/javascript">
	$(function() {
		// 画像アイコンをクリックした場合
		$('#user-menu-icon').on('click', function() {
			$('#user-menu-box').toggle();
		});
	});
</script>