<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
//========================================
// @brief 데이터사전 > 용어 > 목록
//========================================
// @history 
//  	2021.02.09 박이정(마인드원) 최초작성
//========================================
%>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/jsp/layout/header.jsp"/>
<script src="/js/terms.js"></script>

<body>
    <div class="bg"></div>
    <div class="wrap">
        <jsp:include page="/WEB-INF/jsp/layout/top.jsp"/>
        <jsp:include page="/WEB-INF/jsp/layout/menu.jsp"/>

        <div class="container">
            <div class="title">
            	<div style="float:left;"><h1>용어</h1></div>
            	<div class="location"><ul><li class="home"></li><li>데이터사전</li><li>용어</li></ul></div>
            </div>
            <div class="cont_divide">
            	<div class="left">
		            <div class="write"><!-- 검색 -->
		                <div class="write_inner">
							<div class="write_search">
							<form name="searchForm" id="searchForm" method="GET">
								<input type="hidden" id="page" name="page">
								<input type="hidden" id="searchtmp" name="" value=""  />
								<select name="post" id="post" onChange="_list.getList(1);" class="selectp">
									   <option value=''> -- 주제구분 선택 -- </option>
								</select>
								<select name="searchName" id="searchName" onChange="setPlaceholder(this)"  class="selectp">
										<!-- <option value=''> -- 검색선택 -- </option> -->
										<option value="termNm" >용어명</option>
										<option value="termEnAbbr" >용어영문약어</option>
										<option value="termEnNm" >용어영문명</option>
										<!-- <option value="registYmd" >등록일자</option> -->
								</select>
								<input type="text" name="searchValue" id="searchValue" value="" 
									placeholder="검색할 내용을 입력해주세요"  class="inputp"
									onkeypress="if(event.keyCode==13) {_list.getList(1); return false;}"/>
							</form>
							</div>
							<a href="#" onclick="_list.getList(1);">조회</a>
						</div> 
						
					</div>
		            <div class="container_inner task_list_wrap">
		                <div class="task_list">
		                <table id="list_t">
		                    <colgroup>
		                        <col style="width:5%">
		                        <col style="width:8%">
		                        <col style="width:15%">
		                        <col style="width:12%">
		                        <col style="width:auto">
		                        <col style="width:10%">
		                        <col style="width:10%">
		                        <col style="width:10%">
		                        <col style="width:8%">
		                    </colgroup>
		                    <thead>
		                        <tr>
		                            <th scope="col">번호</th>
		                            <th scope="col">용어분류</th>
		                            <th scope="col">용어명</th>
		                            <th scope="col">용어영문약어</th>
		                            <th scope="col">용어영문명</th>
		                            <th scope="col">데이터타입</th>
		                            <th scope="col">데이터길이</th>
		                            <th scope="col">소수점길이</th>
		                            <th scope="col">등록 일자</th>
		                        </tr>
		                    </thead>
		                    <tbody id="listData">
								
		                    </tbody>
		                </table>
		                </div>
		                <jsp:include page="/WEB-INF/jsp/layout/paging.jsp"/> 
		            </div>            	
            	</div>
            	<div class="right">
	                <div class="write">
		                <div class="write_inner">
							<a href="#" onclick="detailForm.reset();">신규</a>
							<a href="#" onclick="$('#detailForm').submit();">저장</a>
							<a href="#" onclick="_list.deleteOne();">삭제</a>
						</div> 
					</div>
	                <div class="user_form">
	                <form name="detailForm" id="detailForm" onsubmit="return false;">
						<input type="hidden" name="nmode" value="">
						<input type="hidden" name="pk" value="">
						<input type="hidden" name="page" value="">
	                    <table class="edit_table">
	                        <colgroup>
	                            <col style="width:15%">
	                            <col style="auto">
	                        </colgroup>
	                        <tbody>
	                        <tr>
	                            <th><label for="termSn">용어 일련번호</label></th>
	                            <td><input type="text" name="termSn" id="termSn" value="" readonly ></td>
	                        </tr>
	                        <tr>
	                            <th class="required"><label for="termCl">용어 분류</label></th>
	                            <td>
	                                <select name="termCl" id="termCl" required></select>
	                            </td>
	                        </tr>
	                        <tr>
	                            <th class="required"><label for="termExprsnNm">용어표현명</label></th>
	                            <td><input type="text" name="termExprsnNm" id="termExprsnNm"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th class="required"><label for="termNm">용어명</label></th>
	                            <td><input type="text" name="termNm" id="termNm"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th class="required"><label for="termEnAbbr">용어영문약어</label></th>
	                            <td><input type="text" name="termEnAbbr" id="termEnAbbr"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th class="required"><label for="termEnNm">용어영문명</label></th>
	                            <td><input type="text" name="termEnNm" id="termEnNm"  value="" style="width:100%"></td>
	                        </tr>
	                        <tr>
	                            <th><label for="termDc">용어설명</label></th>
	                            <td><textarea name="termDc" id="termDc"  value="" style="width:100%;"></textarea>
	                        </tr>
	                        <tr>
	                            <th class="required"><label for="dataType">데이터타입</label></th>
	                            <td><input type="text" name="dataType" id="dataType"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th><label for="dataLt">데이터길이</label></th>
	                            <td><input type="text" name="dataLt" id="dataLt"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th><label for="dcmlpointLt">소수점길이</label></th>
	                            <td><input type="text" name="dcmlpointLt" id="dcmlpointLt"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th><label for="exprsnFom">표현형식</label></th>
	                            <td><input type="text" name="exprsnFom" id="exprsnFom"  value="" style="width:100%"></td>
	                        </tr>
	                        <tr>
	                            <th><label for="unit">단위</label></th>
	                            <td><input type="text" name="unit" id="unit"  value="" ></td>
	                        </tr>
	                        <tr>
	                            <th><label for="permValDc">허용값설명</label></th>
	                            <td><input type="text" name="permValDc" id="permValDc"  value="" style="width:100%"></td>
	                        </tr>
	                        <tr>
	                            <th><label for="registId">등록아이디</label></th>
	                            <td><input type="text" name="registId" id="registId"  value="" readonly></td>
	                        </tr>
	                        <tr>
	                            <th><label for="registDt">등록일시</label></th>
	                            <td><input type="text" name="registDt" id="registDt"  value="" readonly></td>
	                        </tr>
	                        <tr>
	                            <th><label for="registId">수정아이디</label></th>
	                            <td><input type="text" name="registId" id="registId"  value="" readonly></td>
	                        </tr>
	                        <tr>
	                            <th><label for="registDt">수정일시</label></th>
	                            <td><input type="text" name="registDt" id="registDt"  value="" readonly></td>
	                        </tr>
	                        </tbody>
	                    </table>
	                    <!-- <div class="btn_user_form_wrap">
	                        <input class="btn_user_modify" type="button" value="저장" >
	                        <input class="btn_user_delete" type="button" value="삭제" >									
							<input class="btn_user_submit" type="button" value="취소" onClick="history.back();">
	                    </div> -->
	                
	                </form>
	                </div>            	
            	</div>
            </div>

        </div><!--//container-->
    </div>
</body>
<script>

</script>
</html>