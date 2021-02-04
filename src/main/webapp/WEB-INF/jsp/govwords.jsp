<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>마인드원</title>
    <link href="/asset/fontawesome/css/fontawesome-all.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/jquery.min.js"></script>
    <script src="/js/init.js"></script>
</head>
<body>
    <div class="bg"></div>
    <div class="wrap">
        <div class="header">
            <div class="account clearfix">
                <div>
                    <a href="#" class="user_name"><span>BA2</span> 박이정<i class="fas fa-chevron-down"></i></a>
                    <ul>
                        <li><a href="#">비밀번호 변경</a></li>
                        <li><a href="#">로그아웃</a></li>
                    </ul>
                   
                </div>
            </div><!--//account-->
            <button type="button" class="btn_mobile_menu">
                <i class="ico_menu"></i>
            </button>
            <div class="m_logo"><a href="#"><img src="images/polycube.b.png" alt="logo"></a></div>   
        </div>
        <div class="sidebar">
            <div class="logo">
                <a href="#"><img src="images/mindone.png" alt="logo"></a>
                <div class="about">박이정<span>BA2</span></div>
            </div>
            <ul>
                <li><a href="#">데이터사전</a>
                    <ul class="depth">
                        <li class="on"><a href="#"><i class="fas fa-edit"></i>행정단어</a></li>
                        <li><a href="#"><i class="far fa-window-maximize"></i>도메인</a></li>
                        <li><a href="#"><i class="fas fa-address-book"></i>단어</a></li>
                        <li><a href="#"><i class="fas fa-address-book"></i>용어</a></li>
                    </ul>
                </li>
                <li><a href="#">관리도구</a>
                    <ul class="depth">
                        <li><a href="#"><i class="fas fa-user-plus"></i>직원정보</a></li>
                        <li><a href="#"><i class="fas fa-user"></i>부서정보</a></li>
                    </ul>
                </li>
            </ul>
        </div><!--//sidebar-->

        <div class="container">
            <div class="title"><h1>행정단어</h1></div>
            <div class="container_inner">
                <div></div>
            </div>
        </div><!--//sidebar-->
    </div>
</body>
</html>