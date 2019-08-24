const ERROR_COLOR = '#ffc0cb';
const DEFAULT_COLOR = 'transparent';

var Common = (function() {
	'use strict'

	Common.prototype.inner = {
		/**
		 * In the case of validation error, turn the objects pink
		 * @param {String} password
		 * @param {String} password(confirm)
		 * @param {String} ID of button object
		 * @todo add the process to show error dialog
		 */
		checkPassword : function(password, confirm, btn) {
			let passoword = password;
			let confirmPassword = confirm;

			// In case register button is clicked

		},

		/**
		 * In the case of validation error, turn the objects pink
		 * @param  {String}  ele
		 */
		setErrorMark : function(ele) {
			var errorItem = document.getElementById(ele);

			errorItem.style.background = ERROR_COLOR;
		},

		/**
		 * Clear the background color
		 * @param  {String}  ele
		 */
		clearErrorMark(ele) {
			var errorItem = document.getElementById(ele);

			errorItem.style.background = DEFAULT_COLOR;
		},

		/**
		 *
		 * @param {String} str
		 * @return {boolean} checkFlg
		 */
		checkEmpty : function(str) {
			let checkFlg = false;

			//the value of argument is null / undifine / 0 length
			if (str === null
				|| str === undefined
				|| str.length === 0) {
					checkFlg = true;
			}
			return checkFlg;
		},

		/**
		 * show error dialog message
		 * @praram {String} ele
		 */
		showErrorDialog : function(ele, title, message) {
			$(ele).dialog({
				modal:true,
				title: title,
			    height: 240,
			    width: 300,
				buttons: {
					'OK': function() {
						$(this).dialog("close");
			    	}
				},
				// disable close button
				open:function(event, ui){ $(".ui-dialog-titlebar-close").hide();}
			});

			$(ele).text(message);
		}
	}
});