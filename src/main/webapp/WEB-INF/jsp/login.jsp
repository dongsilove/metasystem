<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>마인드원</title>
    <link href="/asset/fontawesome/css/fontawesome-all.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/lib/jquery/jquery-3.4.1.min.js"></script>
	<script src="/js/lib/jquery/jquery.serializeObject.min.js"></script><!-- form.serializeObject()를 위해 -->
 	<script src="/js/lib/jquery/jquery.validate.min.js"></script>
    <script src="/js/util/init2.js"></script>
    <script src="/js/util/validations.js"></script>
    <script src="/js/util/ajaxUtils.js"></script>
    <script src="/js/util/commUtils.js"></script>
    <script src="/js/login.js"></script>
</head>
<style>   
    .wrap{position:inherit}
    body:before {
        content: "";
        display: block;
        position: fixed;
        left: 0;
        top: 0;
        width: 100%;
        height: 100%;
        z-index: -10;
        background: url(/images/bg_1.jpg) no-repeat top left,center center,bottom center;
        -webkit-background-size: cover;
        -moz-background-size: cover;
        -o-background-size: cover;
        background-size: cover;
        }
</style>
<body>
    <div class="wrap">
            <div class="loginWrap">
                <div class="loginTitle">
                    <h3>LOGIN</h3>
                    <p>(주)마인드원 직원들을 위한 사이트 입니다.<br/>계정이 없으신 분은 관리자에게 문의하여 주시기 바랍니다.</p>
                </div><!--lg_form-->
                <div>
                    <form form name="loginForm" id="loginForm" class="clearfix" onsubmit="return false;">
                        <input type="hidden" name="strLogin" value="ok"/>    
                        <div class="input_info">
                            <div class="input_form">
                                <input type="text" name="userId" id="userId">
                                <div class="input_label">아이디</div>
                            </div>
                            <div class="input_form">
                                <input type="password" name="pwd" id="pwd" onkeypress="if(event.keyCode==13) {$('#loginForm').submit();}">
                                <div class="input_label">비밀번호</div>
                            </div> 
                        </div>
                        <div class="input_submit">
                            <input type="button" value="로그인" name="btn_lg" id="btn_lg" onclick="">
                        </div>        
                    </form>
                    <div class="_copy">
                        © 2021 MINDONE. All Rights Reserved.
                    </div>
                </div>
            </div>
        </div><!-- wrap -->
</body>
</html>