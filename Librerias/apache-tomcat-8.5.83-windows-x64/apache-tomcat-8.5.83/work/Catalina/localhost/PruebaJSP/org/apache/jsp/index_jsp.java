/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.83
 * Generated at: 2022-11-18 03:56:43 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("        <title>Formulario de Prueba</title>\n");
      out.write("        <!--Iconos-->\n");
      out.write("        \n");
      out.write("        <!--fonts-->\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\n");
      out.write("        <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Dancing+Script:wght@400;500;600;700&family=IBM+Plex+Mono:ital,wght@0,100;0,200;0,300;0,400;0,500;0,600;0,700;1,100;1,200&family=PT+Sans+Narrow:wght@400;700&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <!-- Bootstrap-->\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi\" crossorigin=\"anonymous\">\n");
      out.write("    </head>\n");
      out.write("    <body style=\"font-family: 'PT Sans Narrow', sans-serif;\"> \n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"abs-center\">\n");
      out.write("\n");
      out.write("                <h1 class=\"text-center text-primary\">Datos de la Persona</h1>\n");
      out.write("                <p class=\"font-italic\">Ingrese una nueva Persona</p>\n");
      out.write("                <form class=\"form-control\" style=\"background-color:lavender\" action=\"SvPersonas\"  method=\"POST\">\n");
      out.write("                    <p><label>DNI: </label><input class=\"form-control\" type=\"text\" name=\"dni\"></p>\n");
      out.write("                    <p><label>Nombre: </label><input class=\"form-control\" type=\"text\" name=\"nombre\"></p>\n");
      out.write("                    <p><label>Apellido: </label><input class=\"form-control\" type=\"text\" name=\"apellido\"></p>\n");
      out.write("                    <p><label>Telefono: </label><input class=\"form-control\" type=\"text\" name=\"telefono\"></p>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Enviar</button>\n");
      out.write("                </form>\n");
      out.write("                <h1 class=\"text-center text-primary\">Ver lista de Personas</h1>\n");
      out.write("                <p class=\"font-italic\">Si desea ver todas las personas haga click en el boton mostrar personas</p>\n");
      out.write("                <form class=\"form\"  action=\"SvPersonas\"  method=\"GET\">\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Mostrar Personas</button>\n");
      out.write("                </form>\n");
      out.write("                <h1 class=\"text-center text-primary\">Eliminar Personas</h1>\n");
      out.write("                <p class=\"font-italic\">Ingrese el ID de la persona a eliminar</p>\n");
      out.write("                <form class=\"form-control\" style=\"background-color:lavender\" action=\"SvEliminar\"  method=\"POST\">\n");
      out.write("                    <p><label>ID: </label><input class=\"form-control\" type=\"text\" name=\"idEliminar\"></p>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Eliminar</button>\n");
      out.write("                </form>\n");
      out.write("                <h1 class=\"text-center text-primary\">Modificar Personas</h1>\n");
      out.write("                <p class=\"font-italic\">Ingrese el ID de la persona a Modificar</p>\n");
      out.write("                <form class=\"form-control\" style=\"background-color:lavender;margin-bottom:50px\" action=\"SvModificar\"  method=\"GET\">\n");
      out.write("                    <p><label>ID: </label><input class=\"form-control\" type=\"text\" name=\"idModificar\"></p>\n");
      out.write("                    <button type=\"submit\" class=\"btn btn-primary\">Modificar</button>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <!-- Bootstrap js-->\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-OERcA2EqjJCMA+/3y+gxIOqMEjwtxJY7qPCqsdltbNJuaOe923+mo//f6V8Qbsw3\" crossorigin=\"anonymous\"></script>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
