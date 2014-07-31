<%-- 
    Document   : Index.jsp
    Created on : Jun 13, 2014, 12:37:31 PM
    Author     : ashwina
--%>

<%@page import="org.ekshiksha.helpcenter.beans.Category"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.ekshiksha.helpcenter.process.EContentMenuHelper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script type="text/javascript" src="js/jquery-latest.js"></script>
        <script type="text/javascript" src="action.js"></script>
        <link rel="stylesheet" type="text/css" href="style.css" />
        <link rel="stylesheet" type="text/css" href="css/default.css" />
        <link rel="stylesheet" type="text/css" href="css/component.css" />
        <script src="js/modernizr.custom.js"></script>
        <script src="js/jquery.cbpNTAccordion.min.js"></script>
        <title>ekShiksha</title>
    </head>
    <body>
        <div class="header">
            <div id="header-matter"><a href="Index.jsp"><div id="header-matter-inner">ekShiksha</div></a></div>
        </div>
        <div id="input-box">
            <input type="text" name="text" placeholder="   Hi , What do you want to find in the help center ?" />
            <div id="image-search"><img src="images/toolbar_find.png" /></div>
        </div>
        <div id="header-bottom">
        </div>
        <div id="home-image">
            <a href=""><img src="images/toolbar_home.png" /></a>
        </div>
        <div id="text-image">
            <a href=""> <div id="text-image-decoration">Desktop Help</div></a>
        </div>


        //menu


        <div id='cssmenu'>   

            <ul>
                
                <li class='active'><a href=''><span>Home</span></a></li>
                <li class='has-sub'><a href='#'><span>Translator,Reviewer,publisher</span></a>
                    <ul>
                        <li><a href='#'><span id="qwe" onclick="return load('1')">Translator</span></a></li>
                        <li><a href='#'><span onclick="return load('2')">Reviewer</span></a></li>
                        <li class='last'><a href='#'><span>Publisher</span></a></li>
                    </ul>
                </li>
                <li class='has-sub'><a href='#'><span>Login & Password</span></a>
                    <ul>
                        <li><a href='#'><span>Login</span></a></li>
                        <li class='last'><a href='#'><span>Password</span></a></li>
                    </ul>
                </li>
                <li class='last'><a href='#'><span onclick="return load('2')">Restrictions</span></a></li>
                <li class='last'><a href='#'><span>Classes</span></a></li>
                <li class='last'><a href='#'><span>Benefits</span></a></li>
                <li class='last'><a href='#'><span>Downloads</span></a></li>
                <li class='last'><a href='#'><span>Contribution</span></a></li>
                <li class='last'><a href='#'><span>Change Language</span></a></li>
                <li class='last'><a href='#'><span>Topics</span></a></li>
            </ul>
        </div>



        <div id="myDiv">
            <%
                String categoryId = request.getParameter("categoryId");
                if (categoryId != null) {

            %>
            <div class="container">	
                <div class="main-1">
                    <ul id="cbp-ntaccordion" class="cbp-ntaccordion">
                        <li>
                            <h5 class="cbp-nttrigger"> <span class="login-hover">Login</span></h5>
                            <%@include file="answer.html" %>
                        </li>
                        <li>
                            <h5 class="cbp-nttrigger"><span class="login-hover">Password</span></h5>
                            <div class="cbp-ntcontent">
                                <p>
                                <ol><li>We should click on the page to show the things.</li>
                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                    <ol></p>

                                        </div>
                                        </li>
                                        <li>
                                            <h5 class="cbp-nttrigger"><span class="login-hover">Forgot Password</span></h5>
                                            <div class="cbp-ntcontent">
                                                <p>
                                                <ol><li>We should click on the page to show the things.</li>
                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                    <ol></p>


                                                        </div>
                                                        </li>
                                                        <li>
                                                            <h5 class="cbp-nttrigger"><span class="login-hover">Forgot</span></h5>
                                                            <div class="cbp-ntcontent">
                                                                <p>
                                                                <ol><li>We should click on the page to show the things.</li>
                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                                    <ol></p>


                                                                        </div>
                                                                        </li>
                                                                        <li>
                                                                            <h5 class="cbp-nttrigger"><span class="login-hover">How do I logout?</span></h5>
                                                                            <div class="cbp-ntcontent">
                                                                                <p>
                                                                                <ol><li>We should click on the page to show the things.</li>
                                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>
                                                                                    <ol></p>


                                                                                        </div>
                                                                                        </li>
                                                                                        </ul>
                                                                                        </div>
                                                                                        </div>
                                                                                        <%                                                                                        } else {
                                                                                        %>

                                                                                        <div id="key">
                                                                                            <div id="key-image"><img src="images/key.png" /></div> 
                                                                                            <div id="key-text">
                                                                                                Having Trouble Logging In ?
                                                                                            </div>
                                                                                            <div id="key-text-inner">
                                                                                                <a href=" #"><div id="key-text-inner-text">Get Help Logging In and changing your password</div></a>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div id="user">
                                                                                            <div id="user-image">
                                                                                                <a href=""><img src="images/stock_people.png" /></a>
                                                                                                <div id="user-image-plus">
                                                                                                    <a href=""><img src="images/gnome_list_add.png" /></a>
                                                                                                </div>
                                                                                            </div>
                                                                                            <div id="user-text">
                                                                                                <a href=""><div id="user-text-inner">Create an Account</div></a>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div id="user-cross">
                                                                                            <div id="user-cross-image">
                                                                                                <a href=""><img src="images/stock_people.png" /></a>
                                                                                            </div>
                                                                                            <div id="user-cross-image-text">
                                                                                                <a href=""><img src="images/cross.png" /></a>
                                                                                            </div>
                                                                                            <div id="user-cross-text">
                                                                                                <a href=""><div id="user-cross-color">Get Info About Disabled Accounts</div></a>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div id="New-ek">
                                                                                            <div id="New-ek-image">
                                                                                                <a href=""><img src="images/box_upload.png" /></a>
                                                                                            </div>
                                                                                            <div id="New-ek-text">
                                                                                                <a href=""><div id="New-ek-text-color">see What's New on the ekShiksha</div></a>
                                                                                            </div>
                                                                                        </div>
                                                                                        <div id="border-1"> 
                                                                                        </div>
                                                                                        <div id="top-question">
                                                                                            Top Questions
                                                                                        </div>
                                                                                        <div id="question-1">
                                                                                            <a href=""> <div id="question-1-inner">How do I Reset My Password?</div></a> 
                                                                                        </div>
                                                                                        <div id="question-2">
                                                                                            <a  href=""><div id="question-2-inner">Does the Material Provided By ekShiksha is Free of Cost?</div></a>
                                                                                        </div>
                                                                                        <div id="question-3">
                                                                                            <a  href=""><div id="question-3-inner">What Is ekShiksha And How It could be useful?</div></a>
                                                                                        </div>
                                                                                        <div id="question-4">
                                                                                            <a  href=""><div id="question-4-inner">What Is the Way to Make a Account?</div></a>
                                                                                        </div>

                                                                                        <div id="More-help">
                                                                                            More Help
                                                                                            <div id="More-help-image">
                                                                                                <a href="MoreHelpDialog.jsp"><img src="images/diskette_locked.png" /></a>
                                                                                            </div>


                                                                                        </div>
                                                                                        <%
                                                                                            }
                                                                                        %>
                                                                                        </div>
                                                                                        <div id="border-footer">
                                                                                        </div>

                                                                                        <div id="footer-text-3">
                                                                                            <a href=""><div id="footer-text-1-color">Terms</div></a>
                                                                                        </div>
                                                                                        <div id="footer-text-2">
                                                                                            <a href=""><div id="footer-text-2-color">Contacts</div></a>
                                                                                        </div>
                                                                                        <div id="footer-text-1">
                                                                                            ekShiksha © 2014 
                                                                                        </div>
                                                                                        <div id="feedback">
                                                                                            <a href="javascript:poptastic('https://www.surveymonkey.com/s/ZBPZCCL');"><div id="feedback-color">Feedback</div></a>
                                                                                        </div>
                                                                                        </body>
                                                                                        </html>
