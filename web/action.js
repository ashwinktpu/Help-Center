/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


//for the panel menu on the index page(left side menu)


$(document).ready(function() {
    $('#cssmenu ul ul li:odd').addClass('odd');
    $('#cssmenu ul ul li:even').addClass('even');
    $('#cssmenu > ul > li > a').click(function() {
        $('#cssmenu li').removeClass('active');
        $(this).closest('li').addClass('active');
        var checkElement = $(this).next();
        if ((checkElement.is('ul')) && (checkElement.is(':visible'))) {
            $(this).closest('li').removeClass('active');
            checkElement.slideUp('normal');
        }
        if ((checkElement.is('ul')) && (!checkElement.is(':visible'))) {
            $('#cssmenu ul ul:visible').slideUp('normal');
            checkElement.slideDown('normal');
        }
        if ($(this).closest('li').find('ul').children().length == 0) {
            return true;
        } else {
            return false;
        }
    });
    /*
     - how to call the plugin:
     $( selector ).cbpNTAccordion( [options] );
     - destroy:
     $( selector ).cbpNTAccordion( 'destroy' );
     */

    $('#cbp-ntaccordion').cbpNTAccordion();
});

//for new window on the footer designed for feedback


var newwindow;
function poptastic(url)
{
    newwindow = window.open(url, 'name', 'height=900,width=900');
    if (window.focus) {
        newwindow.focus();
    }
}

//ajax for appearing  the menu panel on the index page


function load(categoryId)
{

    /*var xmlhttp = new XMLHttpRequest();

    xmlhttp.onreadystatechange = function()
    {
        if (xmlhttp.readyState == 4 && xmlhttp.status == 200)
        {
            alert(xmlhttp.responseText);
            document.getElementById("myDiv").innerHTML = xmlhttp.responseText;
        }
    }
    xmlhttp.open("GET", "Category.jsp", true);
    xmlhttp.send();*/
    var path = $(location).attr('pathname');
    var url = path + "?categoryId="+categoryId;
    $(location).attr('href',url);
}





