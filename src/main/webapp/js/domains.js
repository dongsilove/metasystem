/**
 * @FileName 	domains.js
 * @author 		ljpark
 * @Date 		2021.02.11
 * @Description 도메인
 * @History
 * DATE			AUTHOR		NOTE	
 * -------------------------------------------------
 * 2021.02.11	ljpark		신규
 */

$(function() {
	
	_list.paginationInit();
	_list.getList(1);
	_commUtils.getCodes($("#domainCl"),"WD004"); // 도메인 분류 코드 조회(EX. 일시,번호,식별...)
	
	$("#detailForm").validate({
	
		submitHandler : function () { //validation이 끝난 이후의 submit 직전 추가 작업할 부분
			console.log("validation 성공 이후 ");
 			_ajaxUtils.ajax({"url" : "/domains/", "method": "PUT", "form" : $("#detailForm")
				,"successCallback": function(result) {
					_list.getList();
					detailForm.reset();
				}
			});
		}
		, rules: { //규칙 - id 값으로 
			  domainCl       : {required:true} 								
			, domainExprsnNm : {maxByteLength:200, required:true} 			
			, domanNm        : {maxByteLength:200, required:true} 			    
			, domainEnAbbr   : {maxByteLength:100, required:true} 	
			, domainEnNm     : {maxByteLength:200} 							
			, domainDc       : {maxByteLength:2000} 							
			, dataType       : {maxByteLength:100} 							
			, dataLt         : {number:true} 							
			, dcmlpointLt    : {number:true} 							
			, exprsnFom      : {maxByteLength:100} 							
			, unit           : {maxByteLength:50} 							
			, permValDc      : {maxByteLength:2000} 							
		}
	});
	
});

var _list = {
	pagination : {}
	,paginationInit : function() {
		console.log( _paging.paginationOptions);
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
		
		_ajaxUtils.ajax({"url" : "/domains", "form" : $("#searchForm")
			,"successCallback": function(data) { //console.log(data);
				$("#listData").html(""); // 목록 초기화
				data.content.forEach(function(f){
					processNull(f);
					$("#listData").append("<tr onclick=\"_list.getDetail('"+f.domainSn+"')\">"
						+"<td>" +f.domainSn+"</td><td>"+f.domainCl+"</td><td>"+f.domainNm+"</td><td>"
						+f.domainEnAbbr+"</td><td>"+f.domainEnNm+"</td><td>"
						+f.dataType+"</td><td>"+f.dataLt+"</td><td>"+f.dcmlpointLt+"</td><td>"+f.registDt+"</td>"
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
	,getDetail : function(domainSn) {
		mode="PUT"; // 수정모드
		_ajaxUtils.ajax({"url" : "/domains/"+domainSn
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
		var pk = $("#domainSn").val();
		//console.log("삭제 호출" + pk);
		if (isEmpty(pk)) {alert('삭제할 데이터를 선택하세요.'); return;}
		if(confirm("삭제하시겠습니까? 삭제 후에는 복구가 불가능 합니다."))
		{
			_ajaxUtils.ajax({"url" : "/domains/"+pk, "method": "DELETE"
				,"successCallback": function(result) { console.log(result);
					alert("삭제되었습니다.");
					_list.getList();
					detailForm.reset();
				}
			});	
		}
	}
} // _list
