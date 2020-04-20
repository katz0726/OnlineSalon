const REQUEST_URL = '/OnlineSalon/auth';
const HOME_URL = 'http://localhost:8080/OnlineSalon/menu/home';
const TIMEOUT_MSEC = 30000;

//check
const PASSWORD_MIN_LENGTH = 6;
const PASSWORD_LENGTH_ERROR = '<span id="error-massage">パスワードは6文字以上、１２文字以下の半角英数字で入力してください</span>';

// request URL
var Login = (function() {
	'use strict'

	Login.prototype.inner = {

		checkForm: function() {
			let checkFlg = true;

			if ($('#email').val() === "") {
				myCommon.inner.setErrorMark('email');
				checkFlg = false;
			}

			if ($('#password').val() === "") {
				myCommon.inner.setErrorMark('password');
				checkFlg = false;
			}

			if ($('#password').val().length < PASSWORD_MIN_LENGTH) {
				/**
				 * @todo メッセージ追加処理を実装
				 */
				checkFlg = false;
			}
			return checkFlg;
		},

		auth: function(event) {
			let data = [];
			let json = '';

			event.preventDefault();

			// serialize form data to array
			data = $('form').serializeArray();

			// parse array to json
			json = this.parseJson(data);

			// authenticate login user
			$.ajax({
				url				 : REQUEST_URL,
				headers	: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
			    },
				type 			 : 'POST',
				dataType		 : 'json',
				data				 : json,
				async			 : false,
				timeout		 : TIMEOUT_MSEC,
				success		 : function() {
					location.href = HOME_URL;
				},
				error				 : function(XMLHttpRequest, textStatus, errorThrown) {
					console.error(LOGIN_ERROR + ': ' + textStatus + '\n' + errorThrown);
				}
			});
		},

		/**
		 * parse array to json
		 * @ {array} data
		 * @return {String} json
		 */
		parseJson : function(data) {
			let objData = {};
			let jsonData = '';
			try {

				for (let i = 0; i < data.length; i++) {
					objData[data[i].name] = data[i].value
				}
				jsonData = JSON.stringify(objData);
			} catch (e) {
				console.error(JSON_PARSE_ERROR + ': ' + e);
			}
			return jsonData;
		}
	}
});
