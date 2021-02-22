<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
		<div class="header">
            <div class="account clearfix">
                <div class="btn_bars"><i class="fas fa-bars"></i></div>
                <div class="btn_info">
                    <a href="#" class="user_name"><span>${loginDeptNm}</span> ${loginInfo.userNm}<i class="fas fa-chevron-down"></i></a>
                    <ul>
                        <li><a href="/myinfo/page">내정보수정</a></li>
                        <li><a href="/login/logout">로그아웃</a></li>
                    </ul>
                   
                </div>
            </div><!--//account-->
            <button type="button" class="btn_mobile_menu">
                <i class="ico_menu"></i>
            </button>
            <div class="m_logo"><a href="#"><img src="/images/mindone.png" alt="logo"></a></div>   
        </div>