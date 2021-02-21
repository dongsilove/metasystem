// datepicker 설정
var _datepicker = {
	getStartYear : function() {
		return 1900;
	},
	getFinalYear : function() {
		var d = new Date();
		var y = d.getFullYear();
		return finalYear = y + 10;
	},
	dateInit : function(startYear, finalYear) {// 일 선택 달력

		if (!startYear) {
			startYear = this.getStartYear();
		}
		if (!finalYear) {
			finalYear = this.getFinalYear();
		}
		var yearRange = startYear + ':' + finalYear;

		$(".datepicker").datepicker({
			// inline: true,
			dateFormat : "yy-mm-dd", /* 날짜 포맷 */
			prevText : '이전달',
			nextText : '다을달',
			showButtonPanel : true, /* 하단 오늘 버튼 패널 사용 */
			yearRange : yearRange, /* 연도 범위 */
			// changeMonth: true, /* 월 선택박스 사용 */
			changeYear : true, /* 년 선택박스 사용 */
			showOtherMonths : true, /* 이전/다음 달 일수 보이기 */
			selectOtherMonths : true, /* 이전/다음 달 일 선택하기 */
			showOn : "both",
			buttonImage : "/images/ii/ico_input_calendar.png",
			buttonImageOnly : true,
			minDate : '-130y',
			closeText : '닫기',
			currentText : '오늘',
			showMonthAfterYear : true, /* 년과 달의 위치 바꾸기 */
			/* 한글화 */
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
			monthNamesShort : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ],
			dayNames : [ '일요일', '월요일', '화요일', '수요일', '목요일', '금요일', '토요일' ],
			dayNamesShort : [ '일', '월', '화', '수', '목', '금', '토' ],
			dayNamesMin : [ '일', '월', '화', '수', '목', '금', '토' ],
			// showAnim: 'slideDown',
			/* 날짜 유효성 체크 */
			onClose : function(selectedDate) {
			}
		});
	},
	monthInit : function(startYear, finalYear) {// 월 선택 달력

		if (!startYear) {
			startYear = this.getStartYear();
		}
		if (!finalYear) {
			finalYear = this.getFinalYear();
		}

		$(".monthpicker").monthpicker({
			pattern : 'yyyy-mm',
			startYear : startYear,
			finalYear : finalYear,
			monthNames : [ '1월', '2월', '3월', '4월', '5월', '6월', '7월', '8월', '9월', '10월', '11월', '12월' ]
		});
	}
}
