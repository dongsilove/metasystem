/**
 * @FileName 	terms.js
 * @author 		ljpark
 * @Date 		2021.02.11
 * @Description 용어
 * @History
 * DATE			AUTHOR		NOTE	
 * -------------------------------------------------
 * 2021.02.11	ljpark		신규
 */
var domainList;
function setDomain( obj ) { // domainList의 index 
	$("#domainNm").val($(obj).data("domainnm"));
	$("#domainSn").val($(obj).data("domainsn"));
	var dataFom = $(obj).data("datatype");
	if ($(obj).data("datalt")) {
		dataFom = dataFom + '('+ $(obj).data("datalt") + (($(obj).data("dcmlpointlt"))? '+'+$(obj).data("dcmlpointlt"):'') +')';
	}
	$("#dataFom").val(dataFom);
	$("#domainNmList").html(""); // 목록 초기화
}


$(function() {

	// 도메인 명 자동완성기능 
	// keypress는 enter키, 숫자key일 경우 반응.. 문자일경우 enter키 입력 필요.. keyup, keydown은 너무 많은 api호출을 하게 됨.
	$("#domainNm").on("keypress", function (evt) {
		// 도메인 조회
		$("#searchtmp").attr("name","domainNm");
		$("#searchtmp").attr("value",$("#domainNm").val());
		
		_ajaxUtils.ajax({"url" : "/common/domains" , "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				domainList = []; // 목록 초기화
				$("#domainNmList").html(""); // 목록 초기화
				if (!data || !data.content) return;
				data.content.forEach(function(f, idx){
					domainList.push({ 
						 "domainNm": f.domainNm, "domainSn": f.domainSn
						,"dataType": f.dataType, "dataLt": f.dataLt
					});
					$("#domainNmList").append("<li onclick='setDomain(this)' data-domainsn='"+ f.domainSn 
						+ "' data-domainnm='" + f.domainNm  
						+ "' data-datatype='" + f.dataType  
						+ "' data-dcmlpointlt='" + f.dcmlpointLt  
						+ "' data-datalt='" + f.dataLt + "'>" 
						+ f.domainNm + "&nbsp;&nbsp;" 
						+ f.dataType + ":" + f.dataLt + "</li>");
				});
				console.log(domainList);
			}
		})
	});

	_list.paginationInit();
	_list.getList(1);

	
	$("#detailForm").validate({
	
		submitHandler : function () { //validation이 끝난 이후의 submit 직전 추가 작업할 부분
			console.log("validation 성공 이후 ");
 			_ajaxUtils.ajax({"url" : "/terms/", "method": "PUT", "form" : $("#detailForm")
				,"successCallback": function(result) {
					_list.getList();
					detailForm.reset();
				}
			});
		}
		, rules: { //규칙 - id 값으로 
			  termCl       : {required:true} 								
			, termExprsnNm : {maxByteLength:200, required:true} 			
			, domanNm        : {maxByteLength:200, required:true} 			    
			, termEnAbbr   : {maxByteLength:100, required:true} 	
			, termEnNm     : {maxByteLength:200} 							
			, termDc       : {maxByteLength:2000} 							
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
		$("#page").val(page);
		//console.log($("#page").val());
		
		//$("#searchfrm")[0].reset(); //오른쪽 상세정보 리셋
		
		_ajaxUtils.ajax({"url" : "/terms", "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#listData").html(""); // 목록 초기화
				data.content.forEach(function(f){
					processNull(f);
					$("#listData").append("<tr onclick=\"_list.getDetail('"+f.termSn+"')\">"
						+"<td>" +f.termSn+"</td><td>"+f.termNm+"</td><td>"
						+f.termEnAbbr+"</td><td>"+f.termEnNm+"</td><td>"
						+f.twdDomain.domainNm+"</td><td>"+f.dataFomt+"</td><td>"+f.registDt+"</td>"
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
	,getDetail : function(termSn) {
		mode="PUT"; // 수정모드
		_ajaxUtils.ajax({"url" : "/terms/"+termSn
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
		var pk = $("#termSn").val();
		//console.log("삭제 호출" + pk);
		if (isEmpty(pk)) {alert('삭제할 데이터를 선택하세요.'); return;}
		if(confirm("삭제하시겠습니까? 삭제 후에는 복구가 불가능 합니다."))
		{
			_ajaxUtils.ajax({"url" : "/terms/"+pk, "method": "DELETE"
				,"successCallback": function(result) { console.log(result);
					alert("삭제되었습니다.");
					_list.getList();
					detailForm.reset();
				}
			});	
		}
	}
} // _list
