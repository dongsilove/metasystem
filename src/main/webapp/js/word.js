/**
 * @FileName 	word.js
 * @author 		ljpark
 * @Date 		2021.02.11
 * @Description 단어
 *              주제구분에 코드로 저장하지 않고 코드값을 저장하였다. 주제구분 변경시 주제구분 값으로 검색한다. 
 *              그러나 용어는 프로젝트로 관리하여, 프로젝트 일련번호가 저장되어 있다.
 * @History
 * DATE			AUTHOR		NOTE	
 * -------------------------------------------------
 * 2021.02.11	ljpark		신규
 */
function setDetail( obj ) { // domainList의 index 
	$("#wordNm").val($(obj).data("wordnm"));
	$("#wordEnAbbr").val($(obj).data("wordenabbr"));
	$("#wordEnNm").val($(obj).data("wordennm"));
	$("#wordEnNm").val($(obj).data("wordennm"));
	$("#wordDc").val($(obj).data("worddc"));
	$("#nmList").html(""); // 목록 초기화
}

$(function() {
	// 주제구분 selectBox setting
	_commUtils.getSelectBox('/api/common/codes/WD005', $(".themaSe"),'cdNm','cdNm'); 
	
	_list.paginationInit();
	_list.getList(1);

	// 영문 대문자처리
	$('#wordEnAbbr').on('blur', function(){ $(this).val($(this).val().toUpperCase())});
	$('#wordEnNm').on('blur', function(){ $(this).val($(this).val().toUpperCase())});
	//$("#wordNm").val("주제");
	
	// 행정단어 명 검색기능 
	// keypress는 enter키, 숫자key일 경우 반응.. 문자일경우 enter키 입력 필요.. keyup, keydown은 너무 많은 api호출을 하게 됨.
	$("#wordNm").on("keypress", function (evt) {
		// 행정단어 조회
		$("#searchtmp").attr("name","wordNm");
		$("#searchtmp").attr("value",$("#wordNm").val());
		_ajaxUtils.ajax({"url" : "/api/common/govwords" , "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#nmList").html(""); // 목록 초기화
				if (!data || !data.content) return;
				$("#nmList").append("<ul><li>행정단어명</li><li>단어영문약어</li><li>단어영문명</li></ul>");
				data.content.forEach(function(f, idx){
					
					$("#nmList").append("<ul onclick='setDetail(this)' data-wordsn='"+ f.wordSn 
						+ "' data-wordnm='" + f.wordNm  
						+ "' data-wordenabbr='" + f.wordEnAbbr  
						+ "' data-worddc='" + f.wordDc  
						+ "' data-wordEnNm='" + f.wordEnNm  + "'>" 
						+ "<li>" + f.wordNm + "</li>" 
						+ "<li>" + f.wordEnAbbr + "</li>" 
						+ "<li>" + f.wordEnNm + "</li>"
						+ "</ul>");
				});
			}
		});
		
		// 단어조회
		$("#searchName option[value='wordNm']").attr("selected","selected");
		$("#searchValue").val($("#wordNm").val());
		_list.getList(1);
	});
	
	$("#detailForm").validate({
	
		submitHandler : function () { //validation이 끝난 이후의 submit 직전 추가 작업할 부분
			console.log("validation 성공 이후 ");
 			_ajaxUtils.ajax({"url" : "/api/words/", "method": "PUT", "form" : $("#detailForm")
				,"successCallback": function(result) {
					_list.getList();
					detailForm.reset();
				}
			});
		}
		, rules: { //규칙 - id 값으로 
			  wordSn       : {number:true}                      // 단어 일련번호
			, wordNm       : {maxByteLength:200, required:true} // 단어 명
			, wordEnAbbr   : {maxlength:100, required:true}     // 단어 영문 약어
			, wordEnNm     : {maxlength:200}                    // 단어 영문 명
			, wordDc       : {maxByteLength:2000}               // 단어 설명
			, synonm       : {maxByteLength:200}                // 동의어
			, prhibtWordNm   : {maxByteLength:200}                // 금지 단어
			, themaSe      : {maxByteLength:50}                 // 주제 구분
		}
	});
	
});

var _list = {
	pagination : {}
	,paginationInit : function() {
		 
		var pagination = new tui.Pagination('paging', _paging.paginationOptions); // _paging :paging.js에 정의되어 있음.
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
		
		_ajaxUtils.ajax({"url" : "/api/words", "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#listData").html(""); // 목록 초기화
				data.content.forEach(function(f){
					processNull(f);
					$("#listData").append("<tr onclick=\"_list.getDetail('"+f.wordSn+"')\">"
						+"<td>" +f.wordSn+"</td><td>"+f.wordNm+"</td><td>"
						+f.wordEnAbbr+"</td><td>"+f.wordEnNm+"</td><td>"
						+f.synonm+"</td><td>"+f.prhibtWordNm+"</td><td>"+f.themaSe+"</td><td>"+f.registDt+"</td>"
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
	,getDetail : function(wordSn) {
		mode="PUT"; // 수정모드
		_ajaxUtils.ajax({"url" : "/api/words/"+wordSn
			,"successCallback": function(data) { console.log(data);
				for(key in data) {	
					_commUtils.setVal("detailForm", key, data[key] );
				}
			}
		});
	}
	,save : function() {

	}
	,deleteOne : function() {
		var pk = $("#wordSn").val();
		//console.log("삭제 호출" + pk);
		if (isEmpty(pk)) {alert('삭제할 데이터를 선택하세요.'); return;}
		if(confirm("삭제하시겠습니까? 삭제 후에는 복구가 불가능 합니다."))
		{
			_ajaxUtils.ajax({"url" : "/api/words/"+pk, "method": "DELETE"
				,"successCallback": function(result) { console.log(result);
					alert("삭제되었습니다.");
					_list.getList();
					detailForm.reset();
				}
			});	
		}
	}
} // _list
