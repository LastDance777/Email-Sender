package app;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

public class EMailServletTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String to = request.getParameter("to");
        String subject = request.getParameter("subject");
        String message = request.getParameter("message");
        Mail mail = new Mail();
        boolean mail_sent = mail.SendEmail(to,subject,"Hi, "+to+"\n"+message+"\nIts me");
        if(mail_sent){
            out.println("send successfully");
        }else{
            out.println("mail failed");
        }
    }
}
