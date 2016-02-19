package harkat;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class servlerti
 */
@WebServlet("/testi")
public class servlerti extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public servlerti() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
        PrintWriter output;
      //  request.
        response.setContentType( "text/html" ); // MIME- Tyyppi asiakkaalle
        output = response.getWriter();
        // luodaan HTML-sivu:
        StringBuffer buf = new StringBuffer();
        buf.append( "<H1>Hello World!!</H1>" );
        output.println(buf.toString());
        output.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 	PrintWriter output;
	        response.setContentType( "text/html" );
	        output = response.getWriter();
	        StringBuffer buf = new StringBuffer();
	        String etunimi = request.getParameter("etunimi");
	        String sukunimi = request.getParameter("sukunimi");
	        if (sukunimi != null && sukunimi.length() > 0 && etunimi != null)
	        	buf.append("<h2>Tietojen tulostus</h2><br>");
	            buf.append("<h4>Etunimesi: " + etunimi.trim() +"</h4>");
	            buf.append("<h4>Sukunimesi: " + sukunimi.trim() +"</h4>");
	        output.println( buf.toString() );
	        output.close();
		
	}

}
