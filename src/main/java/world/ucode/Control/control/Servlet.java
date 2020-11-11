package world.ucode.Control.control;

import org.apache.commons.codec.binary.Base64;

import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import org.json.simple.JSONObject;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.*;
import com.google.gson.Gson;
import world.ucode.Control.model.Picture;

@WebServlet("/upload")
@MultipartConfig
public class Servlet extends HttpServlet {
    private Gson gson = new Gson();
    private BufferedImage bufferedImage;
    private String imageInString;
    private Picture picture;
    private byte[] bytes;
    private InputStream inputStream;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        Part part = req.getPart("file");
        inputStream = part.getInputStream();
        picture = new Picture();

//        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("KEY", "VALUE");
//        String str = jsonObject.toString();
//        printWriter.print(str);
//        printWriter.close();

        bufferedImage = ImageIO.read(inputStream);
//        Raster raster = bufferedImage.getData();
//        WritableRaster writableRaster = raster.createCompatibleWritableRaster();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", baos);
        bytes = baos.toByteArray();
        imageInString = Base64.encodeBase64String(bytes);
        System.out.println(imageInString);
        picture.setImage(imageInString);
        String json = gson.toJson(picture);
        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.print(json);
        printWriter.close();

        //        byte[] bytes = new byte[1024];
//        int readFileExepction = 0;
//        Part part = req.getPart("file");
//        InputStream inputStream = part.getInputStream();
//        OutputStream outputStream = resp.getOutputStream();
//        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
////
//        while ((readFileExepction = inputStream.read(bytes)) != -1) {
//            byteArrayOutputStream.write(bytes, 0, readFileExepction);
//        }
////
//        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
////
//        String test = byteArrayOutputStream.toString();
//        JSONObject jsonObject = new JSONObject();
////        jsonObject.put("image", byteArrayInputStream);
//        jsonObject.put("Hui", "Pinzda");
//        String str = jsonObject.toString();
////        System.out.println("KU epta");
////        System.out.println(str);
//        printWriter.write(test);
    }
}
