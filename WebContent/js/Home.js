const DELIMITER = '\\';
let user = {};


var Home = (function() {
	'use strict'

	Home.prototype.inner = {

		/**
		 * initialize Home
		 */
		initialize: function() {
			this.getCookie();

			let username = document.getElementById('user-name');

			username.innerHTML = user.user_name;
		},

		/**
		 * get the data of login user from Cookie
		 * @return {Object} user
		 */
		getCookie: function() {
			// get Cookie
			let cookie = $.cookie('loginuser');

			// delete "/" of cookie data
			let formatted = this.deleteEscape(cookie);

			// convert json data to object
			user = JSON.parse(formatted);

			return user;
		},

		/**
		 * delete "/" of an argument
		 * @param {String} strData
		 * @return {String} data
		 */
		deleteEscape: function(strData) {
			let data = strData.replace(/\\+/g, '');

			return data;
		}
	}
});