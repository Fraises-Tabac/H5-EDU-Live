// JavaScript Document

/*!

* exam
*/
$(function() {

    /*题库导航*/
	$(".hovver").mouseover(function() {
		$(".hidebox").slideDown();
	});
	$(".hidebox").mouseover(function() {
		$(".hidebox").show();
	});
	$(".hidebox").mouseleave(function() {
		$(".hidebox").slideUp();
	});

	/*题库四大模块滑动效果*/
	$(".body_content").hover(function() {
		$(this).find(".topbox").stop().animate({
			left: '-80'
		});
	},
	function() {
		$(this).find(".topbox").stop().animate({
			left: '-468'
		});
	});

	$(".bcont1").hover(function() {
		$(this).find(".topbox1").stop().animate({
			left: '-80'
		});
	},
	function() {
		$(this).find(".topbox1").stop().animate({
			left: '-468'
		});
	});

	$(".bcont2").hover(function() {
		$(this).find(".topbox2").stop().animate({
			left: '-80'
		});
	},
	function() {
		$(this).find(".topbox2").stop().animate({
			left: '-468'
		});
	});

	$(".bcont3").hover(function() {
		$(this).find(".topbox3").stop().animate({
			left: '-80'
		});
	},
	function() {
		$(this).find(".topbox3").stop().animate({
			left: '-468'
		});
	});

	/*解析展开*/
    $(".dblink1.db5").toggle(function() {
        $(this).parent(".dblink").parent(".ansright").siblings("div").show(1000);
        $(this).css({
            "background": "url(images/ico_detail_item.png) right center no-repeat",
            "background-position": "0px -1864px"
        })
    },
    function() {
        $(this).parent(".dblink").parent(".ansright").siblings(".jiexilist").hide(1000);
        $(this).css({
            "background": "url(images/ico_detail_item.png) right center no-repeat",
            "background-position": "0px -1826px"
        })
    });

	/*题库分类*/
	$(".cate_content li").hover(function() {
		$(this).children(".shadow").animate({
			top: 0
		},
		200);
	},
	function() {
		$(this).children(".shadow").animate({
			top: -90
		},
		200);
	});

	/*输入框*/	
	$(".textfocus").focus(function() {
        $(this).css("border", "2px solid #3eb0e0");
    });
    $(".textfocus").blur(function() {
        $(this).css("border", "1px solid #999");
    });
    $(".ansright .vtk.lfloat").focus(function() {
        $(this).css("border", "2px solid #3eb0e0");
    });
    $(".ansright .vtk.lfloat").blur(function() {
        $(this).css("border", "1px solid #999");
    });

	


	
	
	
});
	

/*!
* course
*/
$(function() {

	/*课程收藏*/
	$(".codol.sc").toggle(function() {
		$(this).css({
			"background-images": "url(../images/ico_detail_item.png) no-repeat",
			"background-position": "0px -1800px"
		});
		$(this).text("取消收藏");
	},
	function() {
		$(this).css({
			"background-images": "url(../images/ico_detail_item.png) no-repeat",
			"background-position": "1px -5px"
		});
		$(this).text("收藏课程");
	});

	/*取消收藏*/
	$(".courseli.mysc").hover(function() {
		$(this).children('.mask').toggle();
	});

	/*课程目录折叠*/
	$(".mulu_title").toggle(function() {
		$(this).siblings("div").show();
		$(this).children(".mulu_zd").text("-");
	},
	function() {
		$(this).siblings("div").hide();
		$(this).children(".mulu_zd").text("+");
	});	

	/*播放页*/
	var hclinet=$(window).height();
				var Height=hclinet-20;
				$(".tabcard").height(Height);
				$(".linevideo").height(hclinet-40);
				var vh=hclinet-150;
				$("#example_video_1").attr("height",vh).css("height",vh);
	var inum = 0;
	$(".ii").click(function() {
		inum++;
		if (inum % 2 != 0) {
			$(".interact").animate({
				right: '-360px'
			},
			'fast');
			$(".linevideo").css("width", "96%");
			$(".iopen").show();
			$(this).text("<");
			$(".videoifram").width("100%").css("width", "100%");
			$(".signp").width("100%").css("width", "100%");
		} else {
			$(".interact").animate({
				right: '12px'
			},
			'fast');
			$(".linevideo").css("width", "70%");
			$(".iopen").show();
			$(this).text(">");
			$(".videoifram").width(wclinet - 440).css("width", wclinet - 440);
			$(".signp").width(wclinet - 440).css("width", wclinet - 440);
		}
	});

    /*课程学过了标签*/
    var cs = 0;
    $(".sign").click(function() {
        cs++;
        if (cs % 2 != 0) {
            $(this).css("background-position", "5px -2161px");
        } else {
            $(this).css("background-position", "5px -2104px");
        }
    });

	/*课程评价*/
	window.onload = function() {
		var oStar = document.getElementById("star");
		if (oStar != null) {
			var aLi = oStar.getElementsByTagName("li");
			var oUl = oStar.getElementsByTagName("ul")[0];
			var oSpan = oStar.getElementsByTagName("span")[1];
			var oP = oStar.getElementsByTagName("p")[0];
			var i = iScore = iStar = 0;
			var aMsg = ["很差|完全不懂在讲什么", "较差|不喜欢", "还行|勉强可以听", "推荐|不错，内容比较受用", "力荐|非常棒，强力推荐"]

			for (i = 1; i <= aLi.length; i++) {
				aLi[i - 1].index = i;
				//鼠标移过显示分数
				aLi[i - 1].onmouseover = function() {
					fnPoint(this.index);
					//浮动层显示
					oP.style.display = "block";
					//计算浮动层位置
					oP.style.left = oUl.offsetLeft + this.index * this.offsetWidth - 104 + "px";
					//匹配浮动层文字内容
					oP.innerHTML = "<em><b>" + this.index + "</b> 分 " + aMsg[this.index - 1].match(/(.+)\|/)[1] + "</em>" + aMsg[this.index - 1].match(/\|(.+)/)[1]

				};

				//鼠标离开后恢复上次评分
				aLi[i - 1].onmouseout = function() {
					fnPoint();
					//关闭浮动层
					oP.style.display = "none"
				};

				//点击后进行评分处理
				aLi[i - 1].onclick = function() {
					iStar = this.index;
					oP.style.display = "none";
					oSpan.innerHTML = "<strong>" + (this.index) + " 分</strong> (" + aMsg[this.index - 1].match(/\|(.+)/)[1] + ")"
				}
			}

			//评分处理
			function fnPoint(iArg) {
				//分数赋值
				iScore = iArg || iStar;
				for (i = 0; i < aLi.length; i++) aLi[i].className = i < iScore ? "on": "";
			}
		}

	};
	/*底部信息页面*/
	$(".pageul li a").hover(
		function(){
			$(this).children("b").css({"background-position":"0 -2559px"});
		},function(){
			$(this).children("b").css("background-position","0 -1115px");
		}
	);
});


/*!
* ask
*/
$(function() {

	/*问答*/
	$(".quform .bf2").focus(function() {
        $(this).val("");
        $(this).css("color", "#333");
    });
    $(".quform .bf2").blur(function() {
        $(this).css("color", "#666");
    });
    $(".askform input").focus(function() {
        $(this).val("");
        $(this).css("color", "#333");
    });
    $(".askform textarea").focus(function() {
        $(this).val("");
        $(this).css("color", "#333");
    });
    $(".askform textarea").blur(function() {
        if ($(this).val() != "") {
            $(this).css("color", "#666");
        } else {
            $(this).val("提问问题");
            $(this).css("color", "#666");
        }
    });
    $(".askform input").blur(function() {
        if ($(this).val() != "") {
            $(this).css("color", "#ccc");
        } else {
            $(this).val("请输入标题");
            $(this).css("color", "#666");
        }
    });
});
   

/*!
* floatbox
*/
$(function() {
    /*右侧客服飘窗*/
	$(".label_pa li").click(function() {
		$(this).siblings("li").find("span").css("background-color", "#fff").css("color", "#666");
		$(this).find("span").css("background", "#fb5e55").css("color", "#fff");
	});
	$(".em").hover(function() {
		$(".showem").toggle();
	});
	$(".qq").hover(function() {
		$(".showqq").toggle();
	});
	$(".wb").hover(function() {
		$(".showwb").toggle();
	});
	$("#top").click(function() {
		if (scroll == "off") return;
		$("html,body").animate({
			scrollTop: 0
		},
		600);
	});
	
	/*个人中心*/
	$(".link2.he.ico").mousemove(function(){
		$(".logmine").slideDown();
	});
	
	$(".logmine").mouseleave(function(){
		$(".logmine").slideUp();
	})
	$("body").click(function(){
		$(".hidebox").slideUp();
		$(".logmine").slideUp();
	});

});
	/*弹窗登录透明层*/
	function reglog_open() {
		$('body').append('<div id="mask" onclick="reglog_close();"></div>');
		$('#mask').show();
		$('#reglog').css('display', 'block');
	}
	function reglog_close() {
		$('#mask').remove();
		$('#reglog').css('display', 'none');
	}
	
	/*登录后个人中心下拉框*/
	function logmine(){
		document.getElementById("lne").style.display="block";
	}
	function logclose(){
		document.getElementById("lne").style.display="none";	
	}

