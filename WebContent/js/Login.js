const REQUEST_URL = '/OnlineSalon/auth';
const HOME_URL = 'http://localhost:8080/OnlineSalon/menu/home';

// request URL
var Login = (function() {
	'use strict'

	Login.prototype.inner = {

		auth: function() {
			let data = [];
			let json = '';

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
				scriptCharset: 'UTF-8',
				data				 : json,
				async			 : false,
				timeout		 : 30000,
				success		 : function() {
					console.log("success!!");
					window.location.href = HOME_URL;
				},
				error				 : function(XMLHttpRequest, textStatus, errorThrown) {
					window.location.href = HOME_URL;
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
				console.log(jsonData);
			} catch (e) {
				console.error(JSON_PARSE_ERROR + ': ' + e);
			}
			return jsonData;
		}
	}
});
