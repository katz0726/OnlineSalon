// request URL
const SEARCH_URL = 'user/search';
const ZENKAKU_SPACE = /\s+/;

//request URL
var AddFriend = (function() {
	'use strict'

	/**
	 * search friends matched
	 * @param {String} conditionJson
	 */
	AddFriend.prototype.inner = {

		initialize : function() {
			$('#tab-idsearch').addClass('active');
			$('#panel-idsearch').addClass('active');
		},

		searchFriend : function(conditionJson) {
			  $.ajax({
			    type    : 'GET',
			    url     : SEARCH_URL,
			    data    : conditionJson,
			    async   : true,
			    success : function(data) {
			    	console.log('成功！');
			    },
			    error : function(XMLHttpRequest, textStatus, errorThrown) {
			      console.error(SEARCH_ERROR + ': ' + textStatus + '\n' + errorThrown);
			    }
			  });
		},

		changeConditionToJson: function(condition) {
			let conditionList = [];
			let json = '';

			// check if condition is String or not
			if (typeof(condition) == 'string') {
				conditionList = condition.split(ZENKAKU_SPACE);

				json += '{';
				for (var i = 1; i <= conditionList.length; i++) {
					json += 'condition';
					json += i;
					json += ':';
					json += conditionList[i - 1];

					if (i != conditionList.length) {
						json += ',';
					}
				}
				json += '}';
			}
			return json;
		}
	}
});