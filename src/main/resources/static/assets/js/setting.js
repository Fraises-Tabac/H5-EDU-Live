
/*弹出信息编辑浮窗*/

function showEditDiv () {
/*初始化编辑框*/
    $("#nickname").val($("#Name").text());

    $("#cover").show();
    $("#editDiv").show();
}

/*隐藏信息编辑浮窗*/
function hideEditDiv () {
    $("#editDiv").hide();
    $(".cover").css('display','none');
}

/*申请成为教师*/
function teacherApplication(){
    var user={};
    user.name=$("#Name");
    $.ajax("/submit",{
        type:"post",
        dataType:"json",
        contentType : "application/json",
        data : user,
        success:function (response) {
            if(response==='SUCCESS'){
                alert("申请提交成功");
            }
            else{
                alert("申请提交失败");
            }
        },error:function () {
            alert("申请提交失败");
        }
    })
}

/*控制简介字数*/
var max=200;
var strlen ;
var txtval=0;
//判断是不是中文字符
function isChinese(str){
    var reCh = /[u00-uff]/;
    return !reCh.test(str);
}
//检查还可以输入多少字
function numChange(){
    strlen=0;
    txtval = $.trim($("#mod_profile").val());
    for(var i =0;i<txtval.length;i++) {
        if (isChinese(txtval.charAt(i)) === true) {
            strlen = strlen + 2;
        } else {
            strlen = strlen + 1;
        }
    }
        strlen = Math.ceil(strlen / 2); //中英文相加除2取整数
    if(strlen>200){
        $("#mod_profile").val(txtval.substring(0,max));
    }else {
        strlen = max - strlen;
        $("#count").empty();
        $("#count").append(strlen);
    }
}

/*提交个人信息给服务器*/
function save () {
    /*获取编辑框内的信息*/
    var nickname=$("#nickname").val();
    var gender=$('input:radio[name="gender"]:checked').val();
    var profession=$('input:radio[name="profession"]:checked').val();
    var birthday_year=$("#select_year").val();
    var birthday_month=$("#select_month").val();
    var birthday_day=$("#select_day").val();
    var province=$("#eprovinceName").val();
    var city=$("#ecityName").val();
    var country=$("#edistrictName").val();
    var profile=$("#mod_profile").val();
    var birthday=birthday_year+'-'+birthday_month+'-'+birthday_day;
    var zone=province+'-'+city+'-'+country;

    /*更新个人信息页面*/
    $("#Name").text(nickname);
    if(gender==="male"){
        $("#Gender").text("男");
    }
    else if(gender==="female"){
        $("#Gender").text("女");
    }
    if(profession==="student"){
        $("#Major").text("学生");
    }
    else if(profession==="teacher"){
        $("#Major").text("教师");
    }
    $("#Zone").text(zone);
    $("#Birthday").text(birthday);
    $("#Profile").text(profile);
    $(".mine").text(nickname);

    /*提交给服务器端*/
    var user={
        nickname:'',
        gender:'',
        profession:'',
        birthday:'',
        zone:'',
        profile:'',
    };
    user.name=$("#phone").text();
    user.password=$("#password").text();
    user.nickname=nickname;
    user.gender=gender;
    user.profession=profession;
    user.birthday=birthday;
    user.zone=zone;
    user.profile=profile;
    $.ajax("/modify", {
        type:"post",
        dataType:"json",
        contentType : "application/json",
        data : user,
        success:function (response) {
            if(response==='SUCCESS'){
                alert("信息修改成功！");
                hideEditDiv();
            }
            else{
                alert("信息修改失败！");
                return false;
            }
        },
        error:function () {
            alert("信息修改失败！");
            return false;
        }
    });
    hideEditDiv();
}

/*更换头像*/
$(function(){
    var inputFile = document.getElementById('avatarFile');

    // 监听文件改变
    inputFile.addEventListener('click', function() {this.value = null;}, false);
    inputFile.addEventListener('change', readData, false);

});
// 文件改变响应
function readData(evt) {
    evt.stopPropagation();
    evt.preventDefault();

    var file = evt.dataTransfer !== undefined ? evt.dataTransfer.files[0] : evt.target.files[0];

    if (!file.type.match(/image.*/)) {return;}

    var reader = new FileReader();

    reader.onload = (function() {

        return function(e) {
            var img = new Image();
            img.src = e.target.result;

            img.onload = (function() {

                var canvas = document.createElement('canvas');
                canvas.width = 800;
                canvas.height = 800;

                var ctx = canvas.getContext("2d");

                ctx.clearRect(0, 0, canvas.width, canvas.height); // canvas清屏

                //重置canvans宽高 canvas.width = img.width; canvas.height = img.height;

                ctx.drawImage(img, 0, 0, canvas.width, canvas.height); // 将图像绘制到canvas上

                canvas.toDataURL("image/jpeg");//必须等压缩完才读取canvas值，否则canvas内容是黑帆布

                cropAndUploadImage(canvas.toDataURL("image/jpeg"));
            });
        }
    })(file);
    reader.readAsDataURL(file);
}
/*上传图片给服务器*/
function cropAndUploadImage(base64){

    var b64 = base64.split(",")[1];
    var load = layerLoad();
    $.ajax({
        url: 'User!uploadImg.action',
        type: "post",
        data:{
            photo : b64,
        },
        dataType: 'json',
        success:function(data) {
            if(data.success){
                setTimeout(function(){
                    window.location.reload();
                },1000);

            }else {
                layer.close(load);
                layerOpen(date.error);
            }
        },
        error : function() {
            // view("异常！");
            layer.close(load);
            layerAlert("图片上传超时！");
        }
    })
}














