/**
 * @FileName 	term.js
 * @author 		ljpark
 * @Date 		2021.02.11
 * @Description 용어
 * @History
 * DATE			AUTHOR		NOTE	
 * -------------------------------------------------
 * 2021.02.11	ljpark		신규
 */
var prjctList; // 프로젝트명 저장 배열

$(function() {
	// 프로젝트 선택 select setting
	_commUtils.getSelectBox('/api/common/prjcts', $(".prjctNm"),'prjctNm','prjctSn').done(function(r){
		prjctList = r;
		_list.paginationInit();
		_list.getList(1);
		
	}); 
	// 도메인 선택 select setting
	_commUtils.getSelectBox('/api/common/domains', $(".domainSn"),'domainNm','domainSn');
	
	
	$("#detailForm").validate({ // $("#detailForm").submit() 호출시 실행됨.
	
		submitHandler : function () { //validation이 끝난 이후의 submit 직전 추가 작업할 부분
			console.log("validation 성공 이후 ");
 			_ajaxUtils.ajax({"url" : "/api/terms/", "method": "PUT", "form" : $("#detailForm")
				,"successCallback": function(result) {
					_list.getList();
					detailForm.reset();
				}
			});
		}
		, rules: { //규칙 - id 값으로 
			  termSn		: {number:true}	 				 // 용어 일련번호
			, domainSn		: {number:true, required:true}	 // 도메인 일련번호
			, termEnAbbr	: {maxlength:100, required:true} // 용어 영문 약어
			, termEnNm		: {maxlength:200}                // 용어 영문 명
			, termDc		: {maxByteLength:2000}           // 용어 설명
			, dataFom		: {maxlength:100}                // 데이터 형식
		}
	});
	
	// 용어구분명 입력란에서 단어 검색기능 
	$("#termSeNm").on("keypress", function (evt) {
		if(event.keyCode==13 ||event.keyCode==32)  //enter키 or space키
			_list.getWordList();
	});
	$('#termSeNm').on('blur', function(){ // focus이동시 
		$("#termNm").val($("#termSeNm").val().replace(/\s/gi, "")); // 용어명에 용어구분명의 space 제거하여 넣기
		$("#termDc").val($("#termSeNm").val()); // 용어구분명 값을 용어설명에 넣는다.
	});
	// 도메인명에 포커스 이동했을 때, 용어명이 있다면 용어명의 마지막 단어로 도메인조회
	$('#domainNm').on('focus', function(){ // focus이동시 
		if (!$("#termSeNm").val()) return;
		let iword;// space로 구분된 마지막 단어 가져오기
		let iwordarr = $("#termSeNm").val().split(' ');
		iword = iwordarr[iwordarr.length-1];
		$("#domainNm").val(iword);
		_list.getDomainList(); // 마지막 단어로 도메인 조회
	});
	// 영문 대문자처리
	$('#termEnAbbr').on('blur', function(){ $(this).val($(this).val().toUpperCase())});
	$('#termEnNm').on('blur', function(){ $(this).val($(this).val().toUpperCase())});
	
	// 도메인 명 검색기능 
	// keypress는 enter키, 숫자key일 경우 반응.. 문자일경우 enter키 입력 필요.. keyup, keydown은 너무 많은 api호출을 하게 됨.
	$("#domainNm").on("keypress", function (evt) {
		// 도메인 조회
		_list.getDomainList();
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
		
		_ajaxUtils.ajax({"url" : "/api/terms", "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#listData").html(""); // 목록 초기화
				data.content.forEach(function(f){
					processNull(f);
					$("#listData").append("<tr onclick=\"_list.getDetail('"+f.termSn+"')\">"
						+"<td>" +f.termSn+"</td><td>"+f.termSeNm+"</td><td>"+f.termNm+"</td><td>"
						+f.termEnAbbr+"</td><td>"+f.termEnNm+"</td><td>"
						+f.tWdDomain.domainNm+"</td><td>"+f.dataFom+"</td><td>"
						+prjctList[f.prjctSn]+"</td><td>"+f.registDt+"</td><td>"+f.modifyDt
						+"</td></tr>"
					);
				});
				if (data.numberOfElements == 0) {
					$("#listData").append("<tr><td colspan=9>조회결과가 없습니다.</td></tr>");
				}
				_list.pagination.setTotalItems(data.totalElements); // 총레코드 수
				_list.pagination._paginate(page); // 조회 page
				
				// 프로젝트 선택 : 로그인한 사용자의 담당프로젝트 선택 (전역변수 loginPrjctSn : header.jsp)
				//$("#detailForm #prjctSn option[value=" + loginPrjctSn + "]").attr("selected", "selected");
				$("#detailForm #prjctSn").val(loginPrjctSn).prop("selected", true);
			}
		});
	} // getList()
	,resetForm : function() {
		detailForm.reset();
		$("#detailForm #prjctSn").val(loginPrjctSn).prop("selected", true);
		mode = "POST";
	}
	,getDetail : function(termSn) {
		mode="PUT"; // 수정모드
		_ajaxUtils.ajax({"url" : "/api/terms/"+termSn
			,"successCallback": function(data) { //console.log(data);
				if (!data) return;
				for(key in data) {	
					_commUtils.setVal("detailForm", key, data[key] );
				}
				_commUtils.setVal("detailForm", "domainNm", data.tWdDomain.domainNm );
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
			_ajaxUtils.ajax({"url" : "/api/terms/"+pk, "method": "DELETE"
				,"successCallback": function(result) { console.log(result);
					alert("삭제되었습니다.");
					_list.getList();
					detailForm.reset();
				}
			});	
		}
	}

	,setDomain : function ( obj ) { 
		// 조회된 도메인 setting
		$("#domainNm").val($(obj).data("domainnm"));
		$("#domainSn").val($(obj).data("domainsn"));
		var dataFom = $(obj).data("datatype");
		if ($(obj).data("datalt")) {
			dataFom = dataFom + '('+ $(obj).data("datalt") + (($(obj).data("dcmlpointlt"))? '+'+$(obj).data("dcmlpointlt"):'') +')';
		}
		$("#dataFom").val(dataFom);
		$("#nmList").html(""); // 목록 초기화
	}
	,getDomainList : function() {
		// 기등록된 도메인 조회
		//$("#searchtmp").attr("name","domainNm");
		//$("#searchtmp").attr("value",$("#domainNm").val());
		$("#searchtmp").attr("name","domainExprsnNm");
		$("#searchtmp").attr("value",$("#domainNm").val());
		_ajaxUtils.ajax({"url" : "/api/common/domains" , "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#nmList").html(""); // 목록 초기화
				if (!data || !data.content) return;
				$("#nmList").append("<ul><li>도메인명</li><li>데이터타입</li><li>데이터길이</li></ul>");
				data.content.forEach(function(f, idx){
					$("#nmList").append("<ul onclick='_list.setDomain(this)' data-domainsn='"+ f.domainSn 
						+ "' data-domainnm='" + f.domainNm  
						+ "' data-datatype='" + f.dataType  
						+ "' data-dcmlpointlt='" + f.dcmlpointLt  
						+ "' data-datalt='" + f.dataLt + "'>" 
						+ "<li>" +f.domainNm + "</li>" 
						+ "<li>" +f.dataType + "</li>"
						+ "<li>" + f.dataLt + "</li>"
						+ "</ul>");
				});
				if (data.content.length == 1) {
					_list.setDomain( $("#nmList ul:nth-child(2)") );
				}
			}
		})		
	}
	,setDetail : function ( obj ) {
		// 조회된 단어 setting
		let enabbr = $("#termEnAbbr").val(); // 영문약어
		let enabbrArr = enabbr.split("_");
		if (enabbrArr[enabbrArr.length-1] == $(obj).data("wordenabbr")) { return;} // 기존 추가되어 있는 마지막영문약어와 추가할 영문약어가 같으면 추가하지 않음.
		
		enabbr = (enabbr)? enabbr+'_'+$(obj).data("wordenabbr") : $(obj).data("wordenabbr"); // 이전 입력된 영문약어가 있으면 '_'를 붙이고 아니면 선택한 단어로만..
		$("#termEnAbbr").val( enabbr );
		
		let ennm = $("#termEnNm").val(); // 영문명
		ennm = (ennm)? ennm + '  ' + $(obj).data("wordennm"): $(obj).data("wordennm"); // 이전 입력된 영문명이 있으면 ' '를 붙이고 아니면 선택한 단어로만..
		$("#termEnNm").val( ennm );
		//$("#termDc").val($("#termDc").val() + " " + $(obj).data("worddc"));

		$("#nmList").html(""); // 목록 초기화
	}
	,getWordList : function() {
		// 기등록된 단어 조회
		$("#searchtmp").attr("name","wordNm");
		let iword;// space로 구분된 마지막 단어 가져오기
		let iwordarr = $("#termSeNm").val().split(' ');
		iword = iwordarr[iwordarr.length-1];
		console.log(iword);
		$("#searchtmp").attr("value",iword);
		_ajaxUtils.ajax({"url" : "/api/common/words" , "form" : $("#searchForm")
			,"successCallback": function(data) { console.log(data);
				$("#nmList").html(""); // 목록 초기화
				if (!data || !data.content) return;
				$("#nmList").append("<ul><li>단어명</li><li>단어영문약어</li><li>단어영문명</li></ul>");
				data.content.forEach(function(f, idx){
					$("#nmList").append("<ul onclick='_list.setDetail(this)' "
						+ "  data-wordnm='" + f.wordNm  
						+ "' data-wordenabbr='" + f.wordEnAbbr  
						//+ "' data-worddc='" + f.wordDc.replaceAll("\"","").replaceAll("'","")
						+ "' data-wordennm='" + f.wordEnNm + "'>" 
						+ "<li>" +f.wordNm + "</li>" 
						+ "<li>" +f.wordEnAbbr + "</li>"
						+ "<li>" + f.wordEnNm + "</li>"
						+ "</ul>");
				});
				if (data.content.length == 1) {
					_list.setDetail( $("#nmList ul:nth-child(2)") );
				}
			}
		})		
	}

} // _list
