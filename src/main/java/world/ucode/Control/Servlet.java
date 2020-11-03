package world.ucode.Control;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/first-serv")
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter printWriter = resp.getWriter();
        String data = req.getParameter("chlen");
        req.setAttribute("imageName", "images/ozahirnyi.png");
        printWriter.println("<h1> Data is: ");
        printWriter.println(data);
        printWriter.println("<br/>");
    }
}
