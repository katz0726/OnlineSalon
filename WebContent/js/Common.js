const errorTitle = '<i class="fas fa-2x fa-exclamation-triangle"></i>  エラー';
const errorColor = '#ffc0cb';

function Common() {

	function checkPassword(password, confirm, btn) {
		var passoword = password;
		var confirmPassword = confirm;

		// 登録ボタンクリック時
		$('#' + btn).on('click', function() {
			// パスワードと確認パスワードが異なる場合
			if (password !== confirm) {
				$('#dl').dialog({
					modal:true,
					title:errorTitle,
					buttons: {
						'OK': function() {
							$(this).dialog("close");
						}
					}
				});
			}
		});
	}

	function setErrorMark(error) {
		var errorItem = document.getElementById(error);

		errorItem.style.color = errorColor;
	}
}