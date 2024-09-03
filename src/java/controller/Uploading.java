package controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author upekhansaja
 */
@MultipartConfig
@WebServlet(name = "Uploading", urlPatterns = {"/Uploading"})
public class Uploading extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String email = req.getParameter("email");
        System.out.println(email);

        String applicationPath = req.getServletContext().getRealPath("");
        File newFile = new File(applicationPath + "//FILES//hello.jpeg");

        Part filePart = req.getPart("file");
        InputStream inputStream = filePart.getInputStream();

        Files.copy(inputStream, newFile.toPath(), StandardCopyOption.REPLACE_EXISTING);

    }

}
