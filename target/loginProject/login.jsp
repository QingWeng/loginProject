<%--
  Created by IntelliJ IDEA.
  User: 阿青呀
  Date: 2022/2/23
  Time: 20:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户登录</title>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"> </script>
</head>
<body>


    <div style="text-align: center">
        <form action="login" method="post" id="loginForm">
            姓名：<input type="text" name="userName" id="username" value="${messageModel.object.userName}"> <br>
            密码：<input type="password" name="userPwd" id="userpwd" value="${messageModel.object.userPwd}"> <br>
            <span id="msg" style="font-size: 12px;color: red">${messageModel.msg}</span><br>
            <button type="button"  id="loginBtn">登录</button> <button type="button">登录</button>
        </form>


    </div>

    <script type="text/javascript" src="js/jquery-3.6.0.js"></script>
    <script type="text/javascript">
        /**
                 1、给登录按钮绑定点击事件(通过ID选择器绑定）
                 2、获取用户名和密码的值
                 3、判断姓名是否为空
                    如果为空，（span标签赋值），并且return
                 4、判断密码是否为空
                    如果为空，（span标签赋值），并且return
                 5、如果都不为空，手动提交表单
        **/


        $("#loginBtn").click(function ( ) {

            var username = $("#username").val();
            var userpwd = $("#userpwd").val();
        if(isEmpty(username)){
            //如果姓名为空  提醒用户 span标签赋值  并且return html（）
            $("#msg").html("用户姓名不能为空");
            return;
        }
            if(isEmpty(userpwd)){
                //如果姓名为空  提醒用户 span标签赋值  并且return html（）
                $("#msg").html("用户密码不能为空");
                return;
            }
        //如果都不为空
            $("#loginForm").submit();

        });

        /**
         * 判断字符串是否为空
         *  如果为空返回true
         *  不为空返回false
         *
         */
        function isEmpty(str) {
        if(str == null || $.trim(str) == ""){
            return true;
        }return false;

        }


    </script>



</body>
</html>
