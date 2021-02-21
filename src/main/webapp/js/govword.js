/**
 * @FileName 	words.js
 * @author 		ljpark
 * @Date 		2021.02.11
 * @Description 도메인
 *              주제구분에 코드로 저장하지 않고 코드값을 저장하였다. 주제구분 변경시 주제구분 값으로 검색한다. 
 *              그러나 용어는 프로젝트로 관리하여, 프로젝트 일련번호가 저장되어 있다.
 * @History
 * DATE			AUTHOR		NOTE	
 * -------------------------------------------------
 * 2021.02.11	ljpark		신규
 */
var themaList;
$(function() {
	// 주제구분 selectBox setting
	_commUtils.getSelectBox('/api/common/codes/WD001', $("#themaSe"),'cdNm','cdNm').done(function(r){
		themaList = r;
	}); 
	
	_list.paginationInit();
	_list.getList(1);

});

var _list = {
	pagination : {}
	,paginationInit : function() {
		var pagination = new tui.Pagination('paging', _paging.paginationOptions); // _paging :pagind.js에 정의되어 있음.
		pagination.on('beforeMove', function(evt) { _list.getList(evt.page); });
		this.pagination = pagination;
	}
	,getList : function(page) {
		if (isEmpty(page)) page = 1;
		$("#searchtmp").attr("name",$("#searchName option:selected").val());
		$("#searchtmp").attr("value",$("#searchValue").val().toUpperCase());
		if ($("#searchName option:selected").val() == "themaSe") {
			$("#themaSe").val($("#searchValue").val());
		}
		$("#page").val(page);
		//console.log($("#page").val());
		
		//$("#searchfrm")[0].reset(); //오른쪽 상세정보 리셋
		
		_ajaxUtils.ajax({"url" : "/api/govwords", "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#listData").html(""); // 목록 초기화
				data.content.forEach(function(f){
					$("#listData").append("<tr onclick=\"getDetail('"+f.wordSn+"')\">"
						+"<td>" +f.wordSn+"</td><td>"+f.wordNm+"</td><td>"+f.wordEnAbbr+"</td><td>"+f.wordEnNm+"</td><td>"
						+f.wordDc+"</td><td>"+f.wordSe+"</td><td>"+f.themaSe+"</td><td>"+f.sttusSe+"</td><td>"+f.registYmd+"</td>"
						+"</tr>"
					);
				});
				if (data.numberOfElements == 0) {
					$("#listData").append("<tr><td colspan=9>조회결과가 없습니다.</td></tr>");
				}
				_list.pagination.setTotalItems(data.totalElements); // 총레코드 수
				_list.pagination._paginate(page); // 조회 page
			}
		});
	} // getList()
	,detailFormReset : function() {
		detailForm.reset();
		mode = "POST";
	}
} // _list
