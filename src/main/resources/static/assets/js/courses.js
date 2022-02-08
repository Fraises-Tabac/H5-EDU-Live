

/*更新课程页面*/
$(document).ready(function () {
    $.ajax("/",{
        type:"post",
        dataType:"json",
        contentType : "application/json",
        data :'id',
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
                var state='';
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
                    state=course.state;
                    label=course.label;
                    pic=course.pic;
                    str='';
                    //根据课程进度进行分类
                    if(state==="undone"){
                        str+='<li>'+'<div class="courseli">'+'<a href=video target="_blank">'+'<img width="230" src="pic" alt="depiction">'+'</a>'+
                            '<p class="memb_courname">'+'<a href=video class="blacklink">'+name+'</a>'+'</p>'+ '<div class="mpp">'+ '<div class="lv" style="width:20%;">'+
                            '</div>'+ '</div>'+ '<p class="goon">'+'<a href=vedio>'+'<span>'+'继续学习'+'</span>'+'</a>'+'</p>'+ '</div>' +'</li>';
                        $("#learning").append(str);
                    }
                    else if(state==="done"){
                        str+='<li>'+'<div class="courseli">'+'<a href="record.html" target="_blank">'+'<img width="230" src="pic" alt="depiction">'+'</a>'+
                            '<p class="memb_courname">'+'<a href=vedio class="blacklink">'+name+'</a>'+'</p>'+ '<div class="mpp">'+ '<div class="lv" style="width:20%;">'+
                            '</div>'+ '</div>'+ '</div>' +'</li>';
                        $("#learnt").append(str);
                    }
                }
            }
        },
        error:function () {
            alert("课程加载失败！");
        }
    })
});


