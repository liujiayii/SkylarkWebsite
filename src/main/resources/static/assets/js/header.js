
$(document).ready(function(){
    $("#no-nav").click(function(){
      $("#nav-some1").slideToggle("slow");
    });
  });




$(".side-nav .moitem").click(function(){
    $(this).toggleClass("active").siblings(".side-nav>a").removeClass("active");
    $(this).next(".hiden_div").slideToggle(500).siblings(".hiden_div").slideUp(500);
  });

$(function () {
    $(document).ready(function () {
        $(".nav .nav-box").on("mouseenter","li",function () {
            $(this).children(".catebox").slideDown(100);
            $(this).toggleClass("active").siblings(".nav_b1").removeClass("active");
            $(this).siblings("li").children(".catebox").slideUp(100);
        });
        $(".nav .nav-box").on("mouseleave","li",function () {
            $(this).children(".catebox").slideUp(100);
        });
    });
});


function nav () {
    //alert(1);
    var navli2 = document.querySelectorAll(".navli2");
    var navact = document.querySelector(".navact");
    var chicks = document.querySelector(".chicks");
    var chicksleft = chicks.offsetLeft;
    var width=navli2[0].offsetWidth;
    var navactwidth=navact.offsetWidth;
//alert(width)
    navact.style.left=width*0.5+chicksleft-navactwidth*0.5+ "px";

    for (let nav = 0; nav <navli2.length; nav++) {
        navli2[nav].onmouseover = function () {
            navact.style.left=230+nav*width-navactwidth*0.5+width*0.5+"px";
        }
        navli2[nav].onmouseout = function () {
            navact.style.left=width*0.5+chicksleft-navactwidth*0.5+ "px";;
        }
    }
}
/*
var navli= document.getElementsByClassName('navli')[0];
navli.onclick=function () {
        $(".nav-span").slideToggle("slow");
    }*/