
/*更新课程页面*/
$(document).ready(function () {
    $.ajax("/",{
        type:"post",
        dataType:"json",
        contentType : "application/json",
        data :'userId',
        success:function (data) {
            var courseInfo=eval("("+data+")");
            var str='';
            var myCourse=$(".tab_box");
            myCourse.empty();
            if(courseInfo===0){
                myCourse.append(str);
            }else{
                var id='';
                var name='';
                var lecture='';
                var depiction='';
                var pubdate='';
                var video='';
                var label='';
                var pic='';
                //对其中的课程进行信息遍历
                for(var i in courseInfo){
                    var course=courseInfo[i];
                    id=course.course_id;
                    name=course.name;
                    lecture=course.lecture;
                    depiction=course.depiction;
                    pubdate=course.pubdate;
                    video=course.video;
                    label=course.label;
                    pic=course.pic;
                    str='';
                    //根据课程进度进行分类
                        str+='<li>'+'<div class="courseli">'+'<a href=video target="_blank">'+'<img width="230" src="pic" alt="depiction">'+'</a>'+
                            '<p class="memb_courname">'+'<a href=video class="blacklink">'+name+'</a>'+'</p>'+ '<div class="mpp">'+ '<div class="lv" style="width:20%;">'+
                            '</div>'+ '</div>'+ '<p class="goon">'+'<a href=video>'+'<span>'+'查看课程'+'</span>'+'</a>'+'</p>'+ '</div>' +'</li>';
                        $("#publicCourse").append(str);
                }
            }
        },
        error:function () {
            alert("课程加载失败！");
        }
    });
    //根据是否直播控制是否上传视频
    $("input:radio[name='course']").change(function () {
        var style=$('input:radio[name="course"]:checked').val();
        if(style==="live"){
            $("#picture").attr("disabled","disabled");
            $("#video").attr("disabled","disabled");
        }
        else if(style==="video"){
            $("#picture").attr("disabled",false);
            $("#video").attr("disabled",false);
        }
    });
});


/*弹出浮窗*/
function showEditDiv () {
    /*初始化编辑框*/
    $("input:text").val(' ');
    $("textarea").val('');
    $("input:radio").attr('checked',false);
    $("input:file").val('');
    $("#publishDiv").show();
}
/*隐藏浮窗*/
function hideEditDiv () {
    $("#publishDiv").hide();
}

/*控制简介字数*/
var max=300;
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
    if(strlen>300){
        $("#mod_profile").val(txtval.substring(0,max));
    }else {
        strlen = max - strlen;
        $("#count").empty();
        $("#count").append(strlen);
    }
}



function submit(){



}
















