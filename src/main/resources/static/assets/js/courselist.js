function loadContent() {
    $.ajax({
        type : "POST", //提交方式

        url : "/course",//路径

        data : "",

        success : function(courses) {//返回数据根据结果进行相应的处理  course{name,length,lecture}
            let dom = $("#courseDiv");
            d
            for(let i = 0; i < courses.size(); i++)

                dom.html("<p class='courseP'>"+courses[i].name+"</p>" +
                    "<p>"+courses[0].length+"</p>");

        },
        error : function () {


        }
    })
}


