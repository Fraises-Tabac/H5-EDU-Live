/*登录界面*/

$(document).ready(function () {
$("#login").click(function(){
    //检查输入是否为空
    var user={};
    var nickname =$("#nickname").val();
    var password = $("#password").val();
    if(nickname ===''){
        alert("失败");
        $("#name_check").text("请输入用户名！").css('color','red');
        return false;
    }
    if(password ===''){
        $("#password_check").text("请输入密码！").css('color','red');
        return false;
    }
    // else{
    //     user.txtUserCd=nickname;
    //     user.txtUserPwd=password;
    //     $.ajax("/login",{//使用post传输登陆信息
    //         type:"get",
    //         // dataType:"json",
    //         // contentType : "application/html",
    //         data : user,
    //         success:function(response) {
    //              alert(response);
                 //alert(response.getAllKeys());
            //     //alert(response.status);
            //      if (response.status === "SUCCESS") {
            //         $.load("/index");
            //     } else if (response.status === "FAIL_PHONE_NOT_EXISTS") {
            //         alert("手机号不存在！请检查后再登录");
            //         $("#nickname").cleanData();
            //         $("#password").cleanData();
            //     } else if (response.status === "FAIL_PASSWORD_WRONG") {
            //         $("#alert").text("密码输入不正确！请检查后再登录");
            //         $("#password_check").cleanData();
            //     } else if (response.status === "FAIL_SYSTEM_ERROR") {
            //         alert("系统异常，请检查网络后再登录！");
            //     } else if (response.status === "FAIL_ALREADY_LOGIN") {
            //         alert("此账号已登录，请检查后再填写");
            //         $("#nickname").cleanData();
            //         $("#password").cleanData();
            //     }
            // },
            // error : function(XMLHttpRequest, textStatus){
            //     alert("登陆失败！")
            //     alert(XMLHttpRequest.status)
            //     alert(XMLHttpRequest.state)
            //     alert(textStatus)
            // }
        // });
    // }
});
});