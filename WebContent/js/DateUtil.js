// week
const WEEK = [ '日曜日', '月曜日', '火曜日', '水曜日', '木曜日', '金曜日', '土曜日' ];
const DATE_DELIMITER = '/';

var DateUtil = (function() {
	'use strict'

	DateUtil.prototype.inner = {
		/**
		 * return the week string for an argument
		 * @param {int} dateNum
		 * @return {String} weekStr
		 */
		getWeek: function(dateNum) {
			let weekStr = WEEK[dateNum];

			return weekStr;
		},

		/**
		 * In case the length of 'month' is 1, fill the argument by 0
		 * @param {Date}  month
		 * @return {String} paddedMonth
		 */
	    paddingZeroForMonth : function(month) {

	    	let paddedMonth = '';
	    	let monthStr = String(month);
	        if (monthStr.length == 1) {
	        	paddedMonth = '0' + monthStr;
	        }
	        return paddedMonth;
	    },

	    /**
	     *
	     * @param ele
	     */
	    getGroupModifiedTime: function(ele) {
	    	let modifiedItems = document.getElementsByClassName(ele);
	    	console.log(modifiedItems);

			// Today
			let today = new Date();
			let todayYear = today.getFullYear();
			let todayMonth = today.getMonth() + 1;
			let todayDay = today.getDate();

			try {
				// zero padded month of today(MM)
				todayMonth = this.paddingZeroForMonth(todayMonth);

				// loop for the number of "modified-item"
				let modified = '';
				for (var i = 0; i < modifiedItems.length; i++) {
					modified = modifiedItems[i].textContent;

					// output in the following date format
					let modifiedYear		= modified.substr(0, 4);
					let modifiedMonth	= modified.substr(5, 2);
					let modifiedDay		= modified.substr(8, 2);
					let modifiedDate		= new Date(modifiedYear + '-' + modifiedMonth + '-' + modifiedDay);
					let dateDiff = this.getDateDiff(today, modifiedDate);

					if (todayYear				== modifiedYear
							&& todayMonth	== modifiedMonth
							&& todayDay		== modifiedDay) {

								// In case of same day, set the modified time(hh:ii) to "modifiedItems"
								let modifiedTime = modified.substr(11, 5);
								modifiedItems[i].innerHTML = modifiedTime;
					} else if (-8 < dateDiff && dateDiff < 0) {

						// In case the modifified date is within 1 week, set the day of week to "modifiedItems"
						let dayOfWeek = modifiedDate.getDay();
						modifiedItems[i].innerHTML = this.getWeek(dayOfWeek);

					} else if (todayYear		== modifiedYear
							&& todayMonth	!= modifiedMonth
							&& todayDay		!= modifiedDay) {

								// In case the modified date is within this year, set the date(MM-dd) to "modifiedItems"
								modifiedItems[i].innerHTML = modifiedMonth +DATE_DELIMITER + modifiedDay;
					} else {

						// In case the modified date is before last year,
						// set the date(MM-dd) to "modifiedItems"
						modifiedItems[i].innerHTML = modifiedYear + DATE_DELIMITER + modifiedMonth + DATE_DELIMITER + modifiedDay;
					}
				}
			} catch(e) {
				console.error('error: ' + e);
			}
	    },

	    /**
	     * calculate 7 days ago
	     * @param {String} dateStr
	     * @return {Date} sevenDaysAgoDate
	     */
	    calc7daysAgoDate: function(dateStr) {
			try {
				let sevenDaysAgoDate = new Date(dateStr);
				date.setDate(date.getDate() - 7);

				return sevenDaysAgoDate;

			} catch (e)  {
				console.error('error: ', e);
			}
		},

		/*
		 * calculate difference of the date between arg1 and arg2
		 * @param {String} date1Str
		 * @param {String} date2Str
		 */
	    getDateDiff: function(date1Str, date2Str) {
			var date1 = new Date(date1Str);
			var date2 = new Date(date2Str);

			// getTimeメソッドで経過ミリ秒を取得し、２つの日付の差を求める
			var msDiff = date2.getTime() - date1.getTime();

			// 求めた差分（ミリ秒）を日付へ変換します（経過ミリ秒÷(1000ミリ秒×60秒×60分×24時間)。端数切り捨て）
			var daysDiff = Math.floor(msDiff / (1000 * 60 * 60 *24));

			// 差分へ1日分加算して返却します
			return ++daysDiff;
		}
	}
});