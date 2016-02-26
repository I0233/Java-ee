package servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tuoteLuokat.Tuote;
import tuoteLuokat.Tuotteet;
import databasePackage.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Servlet implementation class TuotteetServletti
 */
@WebServlet("/TuotteetServletti")
public class TuotteetServletti extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private Tuotteet tuotteet;
    
 
    /**
     * @see HttpServlet#HttpServlet()
     */
    
    public TuotteetServletti(){
        super();
        Connection conn = TietokantayhteysTehdas.getConnection();
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM tuotetaulu");
        	while(rs.next()){
        		Tuotteet t = new Tuotteet();
        		t.setTuote(new Tuote(rs.getString("nimi"), rs.getString("koodi"), rs.getDouble("hinta")));
        		this.tuotteet = t;
        	}
        	
        } catch (SQLException ex){
        	System.err.println("Tietoja ei pystytty hakemaan!!");
        }
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String output = "<h2>Tuotteet:</h2><pre>";
		
		Iterator<Tuote> i = this.tuotteet.getTuotteet().iterator();
		while(i.hasNext()){
			Tuote t = i.next();
			output += t.toString() + "\n";
		}
		
		output += "</pre>";
		
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().println(output);
	}

}
