package es.daw.webapp_form1.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//1 LLAMAMOS A LA RUTA COMO LA ETIQUETA ACTION DEL JSP!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1
//AQUI SIEMPRE IRIA EL NOMBRE DE LA ETIQUETA DONDE HAREMOS CAMBIOS VIA SERVER
@WebServlet("/registro")
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

                //2 CREAMOS TODAS LAS VARIABLES PARA USARLAS, COGIENDOLAS EL JSP POR ETIQUETA, ID O VALOR
                //LEER LOS PARAMETROS REQUEST
                String nombre = request.getParameter("username");
                String contraseña = request.getParameter("password");
                String email = request.getParameter("email");
                String pais = request.getParameter("pais");
                //VALUE SI ES MULTIPLE RESPUESTA
                String lenguajes[] = request.getParameterValues("lenguajes");
                String roles[] = request.getParameterValues("roles");
                String idioma = request.getParameter("idioma");
                String descripcion = request.getParameter("descripcion");
                //PARA CHECKBOX
                String habilitar = request.getParameter("habilitar");

                //enabled devolvera como un if, true si esta on, por defecto si la checkbox esta marcada devolvera on
                boolean enabled = habilitar != null && habilitar.equals("on");

                String secreto = request.getParameter("secreto");

                //para guardar y controlar errores
                List<String> errores = new ArrayList<>();
                ArrayList<String> errores2 = new ArrayList<>();



        //response.getWriter().append("Served at: ").append(request.getContextPath());
       response.setContentType("text/html");
       try(PrintWriter out = response.getWriter()){
           out.println("<!DOCTYPE html>");
           out.println("<html>");
           out.println("<head>");
           out.println("<title>MyServlet</title>");
           out.println("</title>");
           out.println("   <body>");
           out.println("       <h1>RESULTADO FORM</h1>");
           out.println("       <li> Username:"+nombre+" </li>");
           out.println("       <li> Password:"+contraseña+" </li>");
           out.println("       <li> Email:"+email+" </li>");
           out.println("       <li> Pais:"+pais+" </li>");
           out.println("     <li> Lenguajes:  </li>");
           for (int i = 0; i < lenguajes.length; i++) {
            out.println("       <ul><li>"+ lenguajes[i] +"</li></ul>");  
           }
            out.println("     <li> Roles:  </li>");
              for (int i = 0; i < roles.length; i++) {
                out.println("       <ul><li>"+ roles[i] +"</li></ul>");  
               }
            out.println("       <li> Idioma:"+idioma+" </li>");
            out.println("       <li> Descripcion:"+descripcion+" </li>");
            out.println("       <li> Habilitar:"+enabled+" </li>");
            out.println("       <li> Secreto:"+secreto+" </li>");
           out.println("   </body>");
           out.println("</html>");
       }
    }
    

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO: implement POST request handling
        doGet(request, response);
    }
}
