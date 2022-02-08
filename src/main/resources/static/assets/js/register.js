/*注册界面*/

// import * as $ from "./jquery-1.10.2";

/*实现倒计时的方法*/
var countdown=60;
function settime(obj){
    if(countdown===0){
        obj.removeAttribute("disabled");
        obj.value="获取验证码";
        countdown = 60;
    }
    else {
        obj.setAttribute("disabled", true);
        obj.value="重新发送(" + countdown + ")";
        countdown--;
    } setTimeout(function() {
        settime(obj)
    }     ,1000)
}


$(function() {
    //初始化Bomb
    Bmob.initialize("9a777aadd9ae1d982e4e92468eef345f  ", "006b7b4e4665e480cb3d54b77c301922  ");
    var user={};
    /*验证码按钮*/
    $("#identify").click(function () {
        var myphone = $("#phone").val();
        //alert(myphone);
        //settime("#identify");
        Bmob.Sms.requestSmsCode({"mobilePhoneNumber": myphone}).then(function (obj) {
            alert("smsId:"+obj.smsId);
        }, function (err) {
            alert("发送失败:" + err);
        });
    });

    /*监听事件*/
    $('input:radio[name="profession"]').on("click",function () {
        $("#attr_check").text(" ");
    });
    $("#phone").on("keypress",function(){
        if($("#phone").val().length>9) {
            $("#phone_check").text(" ");
        }
    });
    $("#identify_number").on("keydown",function(){
        $("#num_check").text(" ");
    });
    $("#password").on("keypress",function(){
        if($("#password").val().length>5){
            $("#code_check").text(" ");
        }
    });
    $("#confirm").on("keypress",function(){
        if($("#confirm").val().length>5){
            $("#confirm_check").text(" ");
        }
    });

    /*提交注册信息*/
    $("#register").click(function () {
        var myphone = $("#phone").val();
        var code = $("#identify_number").val();
        var codeBox = $("#password").val();
        var codeConfirm=$("#confirm").val();
        //检验职业选择是否为空
        var attr="student";
        var val=$('input:radio[name="profession"]:checked').val();
        if(val==null){
           // alert("什么也没选中!");
            $("#attr_check").text('请选择您的职业！').css("color","red");
            return false;
        }
        else if(val==="teacher"){
            attr="teacher";
        }
        //检验各种输入是否符合规范
        if (myphone === '') {
            $("#phone_check").text('手机号不能为空').css("color","red");
            return false;
        } else if (myphone.length !== 11) {
            $("#phone_check").text('手机号不正确').css("color","red");
            return false;
        }
        if (code === '') {
            $("#num_check").text('请填写验证码').css("color","red");
            return false;
        }
        if (codeBox === '' || codeBox.length < 5) {
            $("#code_check").text('密码不能为空并且不能少于6个字符').css("color","red");
            return false;
        }
        if (codeConfirm==='') {
            $("#confirm_check").text('请确认密码！').css("color","red");
            return false;
        }
        if(codeBox!==codeConfirm){
            $("#confirm_check").text('密码输入不正确,请重新输入！').css("color","red");
            return false;
            //$("#confirm").val(" ");
        }
        alert(myphone);
            Bmob.Sms.verifySmsCode("18340018910", 687375).then(function (obj) {
                alert("msg:"+obj.msg);
                user.name=myphone;
                user.password=codeBox;
                $.ajax("/register/submit",{//传输注册信息
                    type:"post",
                    dataType:"json",
                    contentType : "application/json",
                    data : user,
                    success:function(response) {
                        if (response.status === "SUCCESS") {
                            $.load("index.html");
                        } else if (response.status === "FAIL_PHONE_NOT_EXISTS") {
                            alert("手机号不存在！请检查后再登录");
                            $("#nickname").cleanData();
                            $("#password").cleanData();
                        } else if (response.status === "FAIL_PASSWORD_WRONG") {
                            $("#alert").text("密码输入不正确！请检查后再登录");
                            $("#password_check").cleanData();
                        } else if (response.status === "FAIL_SYSTEM_ERROR") {
                            alert("系统异常，请检查网络后再登录！");
                        } else if (response.status === "FAIL_ALREADY_LOGIN") {
                            alert("此账号已登录，请检查后再填写");
                            $("#nickname").cleanData();
                            $("#password").cleanData();
                        }
                    },
                    error : function(){
                        alert("登陆失败！")
                    }
                });
            }, function (err) {
                alert("注册失败，验证码输入不正确！"+err);
            });
        //alert("555555555");
    });
});







