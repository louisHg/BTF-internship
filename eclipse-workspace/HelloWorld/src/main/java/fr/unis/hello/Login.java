package fr.unis.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login")
public class Login extends HttpServlet {
    private static final long serialVersionUID = 1L;
       
    public Login() {
        super();
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
        if ( login == null ) login = "";
        if ( password == null ) password = "";
        
        HttpSession session = request.getSession( true );
        session.setAttribute("login", login);
        session.setAttribute("password", password);
        
        request.getRequestDispatcher("/Login.jsp").forward(request, response);
        	
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String login = request.getParameter( "txtLogin" );
        String password = request.getParameter( "txtPassword" );
         
        HttpSession session = request.getSession( true );
        session.setAttribute("login", login);
        session.setAttribute("password", password);
        
        System.out.println( "in the doPost" );

        if ( login.equals( "toto" ) && password.equals( "toto" ) ) {
        	request.getRequestDispatcher("/Connected.jsp").forward(request, response);
        	session.setAttribute("isConnected", true);
        } else {
        	request.getRequestDispatcher("/Login.jsp").forward(request, response);
        	session.setAttribute("isConnected", false);
        }
    }

}