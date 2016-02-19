package servletit;

import javax.servlet.*;
import javax.servlet.http.*;

import java.io.*;

import javax.servlet.annotation.WebServlet;

@WebServlet(value="/minunServletti", loadOnStartup=1)
public class EkaServletti extends HttpServlet {
    
    @Override
    public void doGet(    HttpServletRequest request,
            HttpServletResponse response )
            throws ServletException, IOException {
        PrintWriter output;
      //  request.
        response.setContentType( "text/html" ); // MIME- Tyyppi asiakkaalle
        output = response.getWriter();
        // luodaan HTML-sivu:
        StringBuffer buf = new StringBuffer();
        buf.append( "<HTML><HEAD><TITLE>\n" );
        buf.append( "Ensimmainen servletti - GET-metodi\n" );
        buf.append( "</TITLE></HEAD><BODY>\n" );
        buf.append( "<H1>Tämän teki minun oma servletti!</H1>Ao. generoitu JAvalla<br><br>" );
        
		for (int i=0; i<100; i++) { 
            buf.append("I= " + i + ",");
            if (i%20 == 0) buf.append("<br/>");
        }
        
        
        buf.append( "</BODY></HTML>" );
        // lähetetään sivu:
        output.println( buf.toString() );
        output.close();
    }
    
    @SuppressWarnings("rawtypes")
	@Override
    public void doPost(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter output;
        response.setContentType( "text/html" );
        output = response.getWriter();
        StringBuffer buf = new StringBuffer();
        String sukunimi = request.getParameter("sukunimi");
        //request.getPa
        if (sukunimi != null && sukunimi.length() > 0)
            buf.append("<h4>Sukunimi-parametrin arvo: " + sukunimi.trim() +"</h4>");

        buf.append("<h2>Parametrit</h2>");
        // Voidaan lukea kaikki HTTP-pyyntä parametrit:
        java.util.Enumeration nimet = request.getParameterNames();
        while (nimet.hasMoreElements()) {
            String nimi = (String)nimet.nextElement();
            buf.append(nimi + " ==> " + (String)request.getParameter(nimi)  + "<br/>");
        }

        buf.append("<h2>HTTP-otsikot</h2>");
        // Voidaan lukea kaikki HTTP-pyynnän otsikot.
        java.util.Enumeration<String> otsikot = request.getHeaderNames();
        while (otsikot.hasMoreElements()) {
            String otsikko_nimi = (String) otsikot.nextElement();
            buf.append(otsikko_nimi + " ==> " + (String)request.getHeader(otsikko_nimi)  + "<br/>");            
        }
        // Voidaan lukea HTTP-otsikot esimerkkeinä.
        
        buf.append( "</body></html>" );
        output.println( buf.toString() );
        output.close();
    }
}
/*Kutsu: <form action="../servlet/EkaServletti" method="post">
  <!-- Lähetetään parametrejä Servletilla -->
   Etunimi: <input type="text" name="etunimi" />
   Sukunimi: <input type="text" name="sukunimi" />
   <input type="submit" />
</form>*/

















