<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<jsp:include page="/WEB-INF/jsp/layout/header.jsp"/>
<script src="/js/govwords.js"></script>
<body>
    <div class="bg"></div>
    <div class="wrap">
        <jsp:include page="/WEB-INF/jsp/layout/top.jsp"/>
        <jsp:include page="/WEB-INF/jsp/layout/menu.jsp"/>

        <div class="container">
            <div class="title"><h1>행정단어</h1></div>
            <div class="write"><!-- 검색 -->
                <div class="write_inner">
					<div class="write_search">
					<form name="frm" method="GET" onsubmit="search()" >
					    <input type="checkbox" name="onoff" value="0"  onChange="search()" /> 비활성 &nbsp;
						<select name="post" id="post" onChange="search()" class="selectp">
							   <option value=''> -- 부서 선택 -- </option>
							
						</select>
						<select name="searchField" id="searchField" onChange="setPlaceholder(this)"  class="selectp">
								<option value=''> -- 검색선택 -- </option>
								<option value="name" >이름</option>
								<option value="id" >ID</option>
						</select>
						<input type="text" name="searchWord" id="searchWord" value="" placeholder="검색할 내용을 입력해주세요"  class="inputp"
										   onkeypress="if(event.keyCode==13) {search(); return false;}"/>
					</form>
					</div>
					<a href="member_edit.php"><i class="fas fa-edit"></i>등록</a>
				</div> 
				
			</div>
            <div class="container_inner task_list_wrap">
                <div class="task_list">
                <table id="list_t">
                	<caption>행정단어</caption>
                    <colgroup>
                        <col style="width:5%">
                        <col style="width:10%">
                        <col style="width:10%">
                        <col style="width:15%">
                        <col style="width:auto">
                        <col style="width:7%">
                        <col style="width:10%">
                        <col style="width:10%">
                        <col style="width:8%">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">번호</th>
                            <th scope="col">단어명</th>
                            <th scope="col">영문단어약어</th>
                            <th scope="col">영문단어명</th>
                            <th scope="col">단어설명</th>
                            <th scope="col">구분</th>
                            <th scope="col">주제 구분</th>
                            <th scope="col">상태 구분</th>
                            <th scope="col">등록 일자</th>
                        </tr>
                    </thead>
                    <tbody id="listData">
						
                    </tbody>
                </table>
                </div>
                <jsp:include page="/WEB-INF/jsp/layout/paging.jsp"/> 
            </div>
        </div><!--//container-->
    </div>
</body>
</html>