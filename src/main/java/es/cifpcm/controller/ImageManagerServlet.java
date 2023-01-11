package es.cifpcm.controller;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.impl.IOFileUploadException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

@MultipartConfig(fileSizeThreshold=1024*1024*2, // 2MB
        maxFileSize=1024*1024*10,      // 10MB
        maxRequestSize=1024*1024*50)   // 50MB
@WebServlet("/imageManager")
public class ImageManagerServlet extends HttpServlet {
    private static final String SAVE_DIR = "uploadsvidic";
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/> ");
        out.append("<title>CuackCUACK!</title>");
        // gets absolute path of the web application
        String appPath = request.getServletContext().getRealPath("");
        // constructs path of the directory to save uploaded file
        String savePath = appPath + File.separator + SAVE_DIR;
        for(File f:new File(savePath).listFiles()){
            out.println("<a href=\"uploadsvidic/"+f.getName()+"\">"+f.getName().toString()+" image</a>");
        }
        out.println("<a href='index.jsp'>Volver a inicio</a>");

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

            // gets absolute path of the web application
            String appPath = request.getServletContext().getRealPath("");
            // constructs path of the directory to save uploaded file
            String savePath = appPath + File.separator + SAVE_DIR;

            // creates the save directory if it does not exists
            File fileSaveDir = new File(savePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdir();
            }
                    for (Part part : request.getParts()) {
                        String fileName = extractFileName(part);
                        if (!fileName.equals("")){
                            // refines the fileName in case it is an absolute path
                            fileName = new File(fileName).getName();
                            part.write(savePath + File.separator + fileName);
                            request.setAttribute("result", "subio");
                            getServletContext().getRequestDispatcher("/result.jsp").forward(
                                    request, response);
                        } else {
                            request.setAttribute("result", "No se subio nah amigo");
                            getServletContext().getRequestDispatcher("/notresult.jsp").forward(
                                    request, response);
                        }

                    }
            }


            private String extractFileName(Part part) {
                String contentDisp = part.getHeader("content-disposition");
                String[] items = contentDisp.split(";");
            for (String s : items) {
                if (s.trim().startsWith("filename")) {
                    return s.substring(s.indexOf("=") + 2, s.length()-1);
                    }
            }
                return "";
    }
}



