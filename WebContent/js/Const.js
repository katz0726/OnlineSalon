/*------------------------------------------------------------------
 * 								MESSAGES
 *-----------------------------------------------------------------*/
// error title
const INFO_TITTLE = '<span id="info-title"><i class="fas fa-info"></i>  情報</span>';
const WARNING_TITTLE = '<span id="warning-title"><i class="fas fa-exclamation-triangle"></i>  警告</span>';
const ERROR_TITTLE = '<span id="error-title"><i class="fas fa-times"></i></i>  エラー</span>';

// ERROR Message
const STRING_EMPTY_ERROR = '未入力項目があります';
const DATE_FORMAT_ERROR = '日付フォーマットに誤りがあります';
const SEARCHID_EMPTY_ERROR = '検索IDが未入力です';
const SEARCH_ERROR = '検索処理でエラーが発生しました';
const LOGIN_ERROR = 'ログイン処理でエラーが発生しました';
const SIGNUP_ERROR = 'サインアップ処理でエラーが発生しました';
const JSON_PARSE_ERROR = 'JSON変換処理に失敗しました';

// INFO Messge
const NO_SEARCH_RESULT_INFO = '検索条件に一致する結果が見つかりませんでした';

// Settings of Spinner
const SPINNER_SETTINGS = {
	  lines: 15						// The number of lines to draw
	, length: 10					// The length of each line
	, width: 3					// The line thickness
	, radius: 15					// The radius of the inner circle
	, scale: 1						// Scales overall size of the spinner
	, corners: 1					// Corner roundness (0..1)
	, color: '#000'				// #rgb or #rrggbb or array of colors
	, opacity: 0.5				// Opacity of the lines
	, rotate: 0					// The rotation offset
	, direction: 1				// 1: clockwise, -1: counterclockwise
	, speed: 1.2					// Rounds per second
	, trail: 60						// Afterglow percentage
	, fps: 20						// Frames per second when using setTimeout() as a fallback for CSS
	, zIndex: 2e9				// The z-index (defaults to 2000000000)
	, className: 'spinner'	// The CSS class to assign to the spinner
	, top: '50%'					// Top position relative to parent
	, left: '50%'					// Left position relative to parent
	, shadow: false			// Whether to render a shadow
	, hwaccel: false			// Whether to use hardware acceleration
	, position: 'fixed'			// Element positioning
};