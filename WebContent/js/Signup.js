const REQUEST_URL = '/OnlineSalon/signup';
const HOME_URL = 'http://localhost:8080/OnlineSalon/menu/home';
const TIMEOUT_MSEC = 30000;

// check
const PASSWORD_MIN_LENGTH = 6;
const PASSWORD_LENGTH_ERROR = '<span id="error-massage">パスワードは6文字以上、１２文字以下の半角英数字で入力してください</span>';

// request URL
var Signup = (function() {
	'use strict'

	Signup.prototype.inner = {

		/**
		 * @param null
		 * @return null
		 */
		signup: function(event) {
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
					console.error(SIGNUP_ERROR + ': ' + XMLHttpRequest + '\n' + textStatus + '\n' + errorThrown);
				}
			});
		},

		/**
		 * parse array to json
		 * @param {array} data
		 * @return {String} jsonData
		 */
		parseJson : function(data) {
			let objData = {};
			let jsonData = '';
			try {

				for (let i = 0; i < data.length; i++) {
					objData[data[i].name] = data[i].value
				}

				jsonData = JSON.stringify(objData);
				console.log(jsonData);
			} catch (e) {
				console.error(JSON_PARSE_ERROR + ': ' + e);
			}
			return jsonData;
		},

		/**
		 *
		 */
		checkForm : function() {
			if ($('#user-name').val() === "") {
				myCommon.inner.setErrorMark('user-name');
				return false;
			}

			if ($('[name=gender]').val() === "") {
				myCommon.inner.setErrorMark('user-name');
				return false;
			}

			$('#search-id').on('focusout', function() {
				myCommon.inner.setErrorMark('gender');
				return false;
			});

			if ($('#search-id').val() === "") {
				myCommon.inner.setErrorMark('search-id');
				return false;
			}

			if ($('#email').val() === "") {
				myCommon.inner.setErrorMark('email');
				return false;
			}

			if ($('#password').val() === "") {
				myCommon.inner.setErrorMark('password');
				return false;
			}

			if ($('#password').length < PASSWORD_MIN_LENGTH) {
				/**
				 * @todo メッセージ追加処理を実装
				 */
				return false;
			}
		}
	}
});
