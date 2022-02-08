

/*修改密码*/

/*添加监听器*/
function span_1(){
    if($("#pre_password").val().length>5){
        $("#pcode_check").text(" ");
    }
}
function span_2(){
    if($("#password").val().length>5){
        $("#ncode_check").text(" ");
    }
}
function span_3(){
    if($("#code_confirm").val().length>5){
        $("#confirm_check").text(" ");
    }
}

/*提交修改结果*/
function code_modify() {
    var name=$(".mine").text();
    var pCode=$("#pre_password").val();
    var nCode=$("#password").val();
    var cCode=$("#code_confirm").val();
    var user={
        nCode:''
    };
    //检验两次新密码输入是否相同
    if(pCode===''){
        $("#pcode_check").text("请填写旧密码！").css("color","red");
        return false;
    }
    if(pCode.length<5){
        $("#ncode_check").text("密码错误！").css("color","red");
        return false;
    }
    if (nCode === '' || nCode.length < 5) {
        $("#ncode_check").text('密码不能为空并且不能少于6个字符').css("color","red");
        return false;
    }
    if (cCode==='') {
        $("#confirm_check").text('请确认密码！').css("color","red");
        return false;
    }
    if(nCode!==cCode){
        $("#confirm_check").text('密码输入不正确,请重新输入！').css("color","red");
        return false;
    }
    else{
        user.name=name;
        user.password=pCode;
        user.nCode=nCode;
        //提交修改信息
        $.ajax("", {
            type:"post",
            dataType:"json",
            contentType : "application/json",
            data : user,
            success:function (response) {
                if(response==="SUCCESS"){
                    alert("密码修改成功！")
                }
                if(response==="FAIL_PASSWORD_WRONG"){
                    $("#pcode_check").text("密码错误！").css("color","red");
                    return false;
                }
            },
            error:function () {
                alert("密码修改失败！请检查系统");
                return false;
            }
        });
    }

}
