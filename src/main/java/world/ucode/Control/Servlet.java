package world.ucode.Control;

import org.json.simple.JSONObject;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;

@WebServlet("/upload")
@MultipartConfig
public class Servlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("Hui", "Pinzda");
        String str = jsonObject.toString();
        printWriter.print(str);
    }
}
