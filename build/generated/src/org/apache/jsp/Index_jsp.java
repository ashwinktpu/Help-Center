package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import org.ekshiksha.helpcenter.beans.Category;
import java.util.ArrayList;
import org.ekshiksha.helpcenter.process.EContentMenuHelper;

public final class Index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.ArrayList<String>(1);
    _jspx_dependants.add("/answer.html");
  }

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery-latest.js\"></script>\n");
      out.write("        <script type=\"text/javascript\" src=\"action.js\"></script>\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"style.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/default.css\" />\n");
      out.write("        <link rel=\"stylesheet\" type=\"text/css\" href=\"css/component.css\" />\n");
      out.write("        <script src=\"js/modernizr.custom.js\"></script>\n");
      out.write("        <script src=\"js/jquery.cbpNTAccordion.min.js\"></script>\n");
      out.write("        <title>ekShiksha</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"header\">\n");
      out.write("            <div id=\"header-matter\"><a href=\"Index.jsp\"><div id=\"header-matter-inner\">ekShiksha</div></a></div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"input-box\">\n");
      out.write("            <input type=\"text\" name=\"text\" placeholder=\"   Hi , What do you want to find in the help center ?\" />\n");
      out.write("            <div id=\"image-search\"><img src=\"images/toolbar_find.png\" /></div>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"header-bottom\">\n");
      out.write("        </div>\n");
      out.write("        <div id=\"home-image\">\n");
      out.write("            <a href=\"\"><img src=\"images/toolbar_home.png\" /></a>\n");
      out.write("        </div>\n");
      out.write("        <div id=\"text-image\">\n");
      out.write("            <a href=\"\"> <div id=\"text-image-decoration\">Desktop Help</div></a>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        //menu\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id='cssmenu'>   \n");
      out.write("\n");
      out.write("            <ul>\n");
      out.write("                \n");
      out.write("                <li class='active'><a href=''><span>Home</span></a></li>\n");
      out.write("                <li class='has-sub'><a href='#'><span>Translator,Reviewer,publisher</span></a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href='#'><span id=\"qwe\" onclick=\"return load('1')\">Translator</span></a></li>\n");
      out.write("                        <li><a href='#'><span onclick=\"return load('2')\">Reviewer</span></a></li>\n");
      out.write("                        <li class='last'><a href='#'><span>Publisher</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li class='has-sub'><a href='#'><span>Login & Password</span></a>\n");
      out.write("                    <ul>\n");
      out.write("                        <li><a href='#'><span>Login</span></a></li>\n");
      out.write("                        <li class='last'><a href='#'><span>Password</span></a></li>\n");
      out.write("                    </ul>\n");
      out.write("                </li>\n");
      out.write("                <li class='last'><a href='#'><span onclick=\"return load('2')\">Restrictions</span></a></li>\n");
      out.write("                <li class='last'><a href='#'><span>Classes</span></a></li>\n");
      out.write("                <li class='last'><a href='#'><span>Benefits</span></a></li>\n");
      out.write("                <li class='last'><a href='#'><span>Downloads</span></a></li>\n");
      out.write("                <li class='last'><a href='#'><span>Contribution</span></a></li>\n");
      out.write("                <li class='last'><a href='#'><span>Change Language</span></a></li>\n");
      out.write("                <li class='last'><a href='#'><span>Topics</span></a></li>\n");
      out.write("            </ul>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"myDiv\">\n");
      out.write("            ");

                String categoryId = request.getParameter("categoryId");
                if (categoryId != null) {

            
      out.write("\n");
      out.write("            <div class=\"container\">\t\n");
      out.write("                <div class=\"main-1\">\n");
      out.write("                    <ul id=\"cbp-ntaccordion\" class=\"cbp-ntaccordion\">\n");
      out.write("                        <li>\n");
      out.write("                            <h5 class=\"cbp-nttrigger\"> <span class=\"login-hover\">Login</span></h5>\n");
      out.write("                            ");
      out.write("<div class=\"cbp-ntcontent\" >\r\n");
      out.write("    <ol style=\"margin-bottom: 10px;border-bottom: 1px dotted #E5E5E5; padding-bottom: 8px;\">\r\n");
      out.write("        <li>We should click on the page to show the things.</li>\r\n");
      out.write("        <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\r\n");
      out.write("        <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\r\n");
      out.write("        <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\r\n");
      out.write("    </ol>\r\n");
      out.write("</div>");
      out.write("\n");
      out.write("                        </li>\n");
      out.write("                        <li>\n");
      out.write("                            <h5 class=\"cbp-nttrigger\"><span class=\"login-hover\">Password</span></h5>\n");
      out.write("                            <div class=\"cbp-ntcontent\">\n");
      out.write("                                <p>\n");
      out.write("                                <ol><li>We should click on the page to show the things.</li>\n");
      out.write("                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                    <ol></p>\n");
      out.write("\n");
      out.write("                                        </div>\n");
      out.write("                                        </li>\n");
      out.write("                                        <li>\n");
      out.write("                                            <h5 class=\"cbp-nttrigger\"><span class=\"login-hover\">Forgot Password</span></h5>\n");
      out.write("                                            <div class=\"cbp-ntcontent\">\n");
      out.write("                                                <p>\n");
      out.write("                                                <ol><li>We should click on the page to show the things.</li>\n");
      out.write("                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                    <ol></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                        </div>\n");
      out.write("                                                        </li>\n");
      out.write("                                                        <li>\n");
      out.write("                                                            <h5 class=\"cbp-nttrigger\"><span class=\"login-hover\">Forgot</span></h5>\n");
      out.write("                                                            <div class=\"cbp-ntcontent\">\n");
      out.write("                                                                <p>\n");
      out.write("                                                                <ol><li>We should click on the page to show the things.</li>\n");
      out.write("                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                                    <ol></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                        </div>\n");
      out.write("                                                                        </li>\n");
      out.write("                                                                        <li>\n");
      out.write("                                                                            <h5 class=\"cbp-nttrigger\"><span class=\"login-hover\">How do I logout?</span></h5>\n");
      out.write("                                                                            <div class=\"cbp-ntcontent\">\n");
      out.write("                                                                                <p>\n");
      out.write("                                                                                <ol><li>We should click on the page to show the things.</li>\n");
      out.write("                                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                                                    <li>we should try to probdadfdfdsfdsfdsfdsfdsfdsfd</li>\n");
      out.write("                                                                                    <ol></p>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        </li>\n");
      out.write("                                                                                        </ul>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        ");
                                                                                        } else {
                                                                                        
      out.write("\n");
      out.write("\n");
      out.write("                                                                                        <div id=\"key\">\n");
      out.write("                                                                                            <div id=\"key-image\"><img src=\"images/key.png\" /></div> \n");
      out.write("                                                                                            <div id=\"key-text\">\n");
      out.write("                                                                                                Having Trouble Logging In ?\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                            <div id=\"key-text-inner\">\n");
      out.write("                                                                                                <a href=\" #\"><div id=\"key-text-inner-text\">Get Help Logging In and changing your password</div></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"user\">\n");
      out.write("                                                                                            <div id=\"user-image\">\n");
      out.write("                                                                                                <a href=\"\"><img src=\"images/stock_people.png\" /></a>\n");
      out.write("                                                                                                <div id=\"user-image-plus\">\n");
      out.write("                                                                                                    <a href=\"\"><img src=\"images/gnome_list_add.png\" /></a>\n");
      out.write("                                                                                                </div>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                            <div id=\"user-text\">\n");
      out.write("                                                                                                <a href=\"\"><div id=\"user-text-inner\">Create an Account</div></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"user-cross\">\n");
      out.write("                                                                                            <div id=\"user-cross-image\">\n");
      out.write("                                                                                                <a href=\"\"><img src=\"images/stock_people.png\" /></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                            <div id=\"user-cross-image-text\">\n");
      out.write("                                                                                                <a href=\"\"><img src=\"images/cross.png\" /></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                            <div id=\"user-cross-text\">\n");
      out.write("                                                                                                <a href=\"\"><div id=\"user-cross-color\">Get Info About Disabled Accounts</div></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"New-ek\">\n");
      out.write("                                                                                            <div id=\"New-ek-image\">\n");
      out.write("                                                                                                <a href=\"\"><img src=\"images/box_upload.png\" /></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                            <div id=\"New-ek-text\">\n");
      out.write("                                                                                                <a href=\"\"><div id=\"New-ek-text-color\">see What's New on the ekShiksha</div></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"border-1\"> \n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"top-question\">\n");
      out.write("                                                                                            Top Questions\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"question-1\">\n");
      out.write("                                                                                            <a href=\"\"> <div id=\"question-1-inner\">How do I Reset My Password?</div></a> \n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"question-2\">\n");
      out.write("                                                                                            <a  href=\"\"><div id=\"question-2-inner\">Does the Material Provided By ekShiksha is Free of Cost?</div></a>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"question-3\">\n");
      out.write("                                                                                            <a  href=\"\"><div id=\"question-3-inner\">What Is ekShiksha And How It could be useful?</div></a>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"question-4\">\n");
      out.write("                                                                                            <a  href=\"\"><div id=\"question-4-inner\">What Is the Way to Make a Account?</div></a>\n");
      out.write("                                                                                        </div>\n");
      out.write("\n");
      out.write("                                                                                        <div id=\"More-help\">\n");
      out.write("                                                                                            More Help\n");
      out.write("                                                                                            <div id=\"More-help-image\">\n");
      out.write("                                                                                                <a href=\"MoreHelpDialog.jsp\"><img src=\"images/diskette_locked.png\" /></a>\n");
      out.write("                                                                                            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        ");

                                                                                            }
                                                                                        
      out.write("\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"border-footer\">\n");
      out.write("                                                                                        </div>\n");
      out.write("\n");
      out.write("                                                                                        <div id=\"footer-text-3\">\n");
      out.write("                                                                                            <a href=\"\"><div id=\"footer-text-1-color\">Terms</div></a>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"footer-text-2\">\n");
      out.write("                                                                                            <a href=\"\"><div id=\"footer-text-2-color\">Contacts</div></a>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"footer-text-1\">\n");
      out.write("                                                                                            ekShiksha © 2014 \n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        <div id=\"feedback\">\n");
      out.write("                                                                                            <a href=\"javascript:poptastic('https://www.surveymonkey.com/s/ZBPZCCL');\"><div id=\"feedback-color\">Feedback</div></a>\n");
      out.write("                                                                                        </div>\n");
      out.write("                                                                                        </body>\n");
      out.write("                                                                                        </html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
