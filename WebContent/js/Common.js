var errorIcon = '<i class="fas fa-2x fa-exclamation-triangle"></i>  エラー';
var errorColor = '#ffc0cb';
const dateFormatYear = 'YYYY/MM/DD';
const dateFormatDay = 'MM/DD';
const dateFormatTime = 'hh:mm';

function Common() {

	function checkPassword(password, confirm, btn) {
		let passoword = password;
		let confirmPassword = confirm;

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
		let errorItem = document.getElementById(error);

		errorItem.style.color = errorColor;
	}

	/**
	 * 日付をフォーマットする
	 * @param  {Date}   date     日付
	 * @return {String}          フォーマット済み日付
	 */
	function dateFormat(date) {
		let today  = new Date();
		let argDate = date;
		let format = null;

		try {

			return format;
		} catch (e) {
			concole.error(DATE_FORMAT_ERROR, e.message);
		}



	}
}