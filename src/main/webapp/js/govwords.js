/**
 * @FileName 	govword.js
 * @author 		ljpark
 * @Date 		2021.02.05
 * @Description 행정단어
 * @History
 * DATE			AUTHOR		NOTE	
 * -------------------------------------------------
 * 2021.02.05	ljpark		신규
 */
$(function() {
	
	commonAjax.getAjax("/govwords",null,function(data){
		//console.log(data);
	});
	_list.paginationInit();
	_list.getList(1);

});

var _list = {
	pagination : {}
	,paginationInit : function() {
		var pagination = new tui.Pagination('paging', _paging.paginationOptions); // _paging :system.js에 정의되어 있음.
		pagination.on('beforeMove', function(evt) {_list.getList(evt.page);	});
		this.pagination = pagination;
	}
	,getList : function(page) {
		if (isEmpty(page)) page = 1;
		$("#searchtmp").attr("name",$("#searchName option:selected").val());
		$("#searchtmp").attr("value",$("#searchValue").val());
		$("#page").val(page);
		//console.log($("#page").val());
		
		//$("#searchfrm")[0].reset(); //오른쪽 상세정보 리셋
		
		_ajaxUtil.ajax({"url" : "/govwords", "form" : $("#searchForm")
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
