const ERROR_TITTLE = '<span id="error-title"><i class="fas fa-2x fa-exclamation-triangle"></i>  エラー</span>';
const ERROR_COLOR = '#ffc0cb';
const DEFAULT_COLOR = 'transparent';

// error message
const DATE_FORMAT_ERROR = '日付フォーマットに誤りがあります';

var Common = (function() {
	'use strict'

	Common.prototype.inner = {
		/**
		 * In the case of validation error, turn the objects pink
		 * @param {String} password
		 * @param {String} password(confirm)
		 * @param {String} ID of button object
		 */
		checkPassword : function(password, confirm, btn) {
			let passoword = password;
			let confirmPassword = confirm;

			// In case register button is clicked
			$('#' + btn).on('click', function() {
				// In case password is different from password(confirm)
				if (password !== confirm) {
					$('#dl').dialog({
						modal: true,
						title: ERROR_TITTLE,
						buttons: {
							'OK': function() {
								$(this).dialog("close");
							}
						}
					});
				}
			});
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
			    height: 260,
			    width: 320,
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