let errorIcon = '<i class="fas fa-2x fa-exclamation-triangle"></i>  エラー';
let errorColor = '#ffc0cb';
const dateFormatYear = 'YYYY/MM/DD';
const dateFormatDay = 'MM/DD';
const dateFormatTime = 'hh:mm';

class Common {

	// Constructor
    constructor() {
    }

	/**
	 * In the case of validation error, turn the objects pink
	 * @param {String} password
	 * @param {String} password(confirm)
	 * @param {String} ID of button object
	 */
	checkPassword(password, confirm, btn) {
		let passoword = password;
		let confirmPassword = confirm;

		// In case register button is clicked
		$('#' + btn).on('click', function() {
			// In case password is different from password(confirm)
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

	/**
	 * In the case of validation error, turn the objects pink
	 * @param  {String}  error
	 */
	setErrorMark(error) {
		let errorItem = document.getElementById(error);

		errorItem.style.color = errorColor;
	}
}

