package world.ucode.Control;

import org.apache.commons.codec.binary.Base64;
import javax.imageio.ImageIO;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.*;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import world.ucode.Model.Picture;

@WebServlet("/upload")
@MultipartConfig
public class Servlet extends HttpServlet {
    private Gson gson = new Gson();
//    private BufferedImage bufferedImage;
//    private String imageInString;
//    private Picture picture;
//    private byte[] bytes;
//    private InputStream inputStream;
    private PrintWriter printWriter;
//    ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printWriter = resp.getWriter();
        Part part = req.getPart("file");

        String imageJson = imageBytesToJson(part);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        printWriter.print(imageJson);
        printWriter.close();
    }

    private BufferedImage pixelizatingImage(InputStream inputStream) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(inputStream);
        Raster src = bufferedImage.getData();
        WritableRaster dest = src.createCompatibleWritableRaster();

        for (int y = 0; y < src.getHeight(); y += 5) {
            for (int x = 0; x < src.getWidth(); x += 5) {
                double[] pixel = new double[4];
                pixel = src.getPixel(x, y, pixel);
                for (int yd = y; (yd < y + 5) && (yd < dest.getHeight()); yd++) {
                    for (int xd = x; (xd < x + 5) && (xd < dest.getWidth()); xd++) {
                        dest.setPixel(xd, yd, pixel);
                    }
                }
            }
        }
        bufferedImage.setData(dest);
        return bufferedImage;
    }

    String imageBytesToJson(Part part) throws IOException {
        BufferedImage bufferedImage = null;
        String imageInString;
        Picture picture;
        byte[] bytes;
        InputStream inputStream;
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        inputStream = part.getInputStream();
        picture = new Picture();

        bufferedImage = pixelizatingImage(inputStream);

        ImageIO.write(bufferedImage, "png", baos);

        bytes = baos.toByteArray();
        imageInString = Base64.encodeBase64String(bytes);
        picture.setImage(imageInString);

        String json = gson.toJson(picture);
        return json;
    }
}
