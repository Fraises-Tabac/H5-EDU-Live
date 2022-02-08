

/*更新考试页面*/
$(document).ready(function () {
    $.ajax("/",{
        type:"post",
        dataType:"json",
        contentType : "application/json",
        data :'userId',
        success:function (data) {
            var examInfo=eval("("+data+")");
            var str='';
            var myExams=$(".tab_box");
            myExams.empty();
            if(examInfo===0){
                myExams.append(str);
            }else{
                var id='';
                var name='';
                var lecture='';
                var duration='';
                var pubdate='';
                var maxScore='';
                var state='';
                var label='';
                var score='';
                var url='';
                var solutions=[];
                var subTitleScore=[];
                var pic='';
                //对其中的课程进行信息遍历
                for(var i in examInfo){
                    var exam=examInfo[i];
                    id=exam.course_id;
                    name=exam.name;
                    lecture=exam.lecture;
                    duration=exam.duration;
                    pubdate=exam.pubdate;
                    score=exam.score;
                    state=exam.state;
                    label=exam.label;
                    pic=exam.pic;
                    maxScore=exam.maxScore;
                    solutions=exam.solutions;
                    subTitleScore=exam.subTitleScore;
                    url=exam.page;
                    str='';
                    //根据课程进度进行分类
                    if(state==="done"){
                        str+='<li>'+'<div class="courseli">'+'<a href=url target="_blank">'+'<img width="230" src="pic" alt=depiction>'+'</a>'+
                            '<p class="memb_courname">'+'<a href=url class="blacklink">'+name+'</a>'+'</p>'+ '<div class="mpp">'+ '<div class="lv" style="width:20%;">'+
                            '</div>'+ '</div>'+ '<p class="goon">'+'<a href=url>'+'<span>'+'查看考试'+'</span>'+'</a>'+'</p>'+ '</div>' +'</li>';
                        $("#examed").append(str);
                    }
                    else if(state==="undone"){
                        str+='<li>'+'<div class="courseli">'+'<a href=url target="_blank">'+'<img width="230" src="pic" alt=depiction>'+'</a>'+
                            '<p class="memb_courname">'+'<a href=url class="blacklink">'+name+'</a>'+'</p>'+ '<div class="mpp">'+ '<div class="lv" style="width:20%;">'+
                            '</div>'+ '</div>'+ '<p class="goon">'+'<a href=url>'+'<span>'+'查看考试'+'</span>'+'</a>'+'</p>'+ '</div>' +'</li>';
                        $("#toExam").append(str);
                    }
                }
            }
        },
        error:function () {
            alert("信息加载失败！");
        }
    })
});