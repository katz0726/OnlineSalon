// request URL
const SEARCH_URL = '/OnlineSalon/user/search';
const ZENKAKU_SPACE = /\s+/;

//
let common = '';

var AddFriend = (function() {
	'use strict'

	AddFriend.prototype.inner = {

		/**
		 * choose ID Search tab
		 */
		initialize : function() {
			$('#tab-idsearch').addClass('active');
			$('#panel-idsearch').addClass('active');
		},

		/**
		 * Search frined mached input search ID
		 * @param {String} conditionJson
		 * @return {Dictionary} result
		 */
		searchFriend : function(conditionJson) {
			let result = new Map();

			$.ajax({
				url			: SEARCH_URL,
				headers	: {
					'Accept': 'application/json',
					'Content-Type': 'application/json'
			    },
				'type'		: 'POST',
				dataType	: 'json',
				data			: conditionJson,
				async		: false,
				timeout	: 30000,
				success	: function(data) {
					result.set('user_name', data['user_name']);
				},
				error			: function(XMLHttpRequest, textStatus, errorThrown) {
					console.error(SEARCH_ERROR + ': ' + textStatus + '\n' + errorThrown);
				}
			});
			return result;
		},

		/**
		 * Change search conditons to json format
		 * @param {String} search conditoon
		 * @return {String} json
		 */
		changeConditionToJson: function(condition) {
			let conditionList = [];
			let json = '';

			// check if condition is String or not
			if (typeof(condition) == 'string') {
				conditionList = condition.split(ZENKAKU_SPACE);

				json += '{';
				for (var i = 1; i <= conditionList.length; i++) {
					json += '\"condition';
					json += i;
					json += '\" : \"';
					json += conditionList[i - 1];

					if (i != conditionList.length) {
						json += '\" ,';
					}
				}
				json += '\"}';
			}
			return json;
		}
	}
});