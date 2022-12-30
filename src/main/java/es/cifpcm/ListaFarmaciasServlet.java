package es.cifpcm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.webresources.FileResource;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;

@WebServlet("/listaFarm")
public class ListaFarmaciasServlet extends HttpServlet {
    public static Persistencia pst = new impPersistenciaVidic();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        pst.openJSON();
        out.println(" <link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/> ");
        out.append("<table>\n");
        out.append("<thead>\n");
        out.append("<tr>\n");
        out.append("<th>Nombre:</th>\n");
        out.append("<th>Web:</th>\n");
        out.append("<th>Coordenadas X:</th>\n");
        out.append("<th>Coordenadas Y:</th>\n");
        out.append("</tr>\n");
        out.append("</thead>\n");
        out.append("<tbody>\n");
        for (Farmacia sucursal: pst.list()
             ) {
            out.append("<tr>\n");
            out.append("<td>"+sucursal.getNOMBRE()+"</td>\n");
            out.append("<td>"+sucursal.getWEB()+"</td>\n");
            out.append("<td>"+sucursal.getUTM_X()+"</td>\n");
            out.append("<td>"+sucursal.getUTM_Y()+"</td>\n");
            out.append("</tr>\n");
        }
        out.append("</tbody>\n");
        out.append("</table>\n");
        out.append("<caption>Horarios</caption>\n");
        out.append("<table>\n");
        out.append("<thead>\n");
        out.append("<th>Lunes</th>\n");
        out.append("<th>Martes</th>\n");
        out.append("<th>Miercoles</th>\n");
        out.append("<th>Jueves</th>\n");
        out.append("<th>Viernes</th>\n");
        out.append("<th>Sabado</th>\n");
        out.append("<th>Domingo</th>\n");
        for (Farmacia sucursal: pst.list()
        ) {
            out.append("<tr>\n");
            out.append("<td>"+sucursal.getLUNES()+"</td>\n");
            out.append("<td>"+sucursal.getMARTES()+"</td>\n");
            out.append("<td>"+sucursal.getMIERCOLES()+"</td>\n");
            out.append("<td>"+sucursal.getJUEVES()+"</td>\n");
            out.append("<td>"+sucursal.getVIERNES()+"</td>\n");
            out.append("<td>"+sucursal.getSABADO()+"</td>\n");
            out.append("<td>"+sucursal.getDOMINGO()+"</td>\n");
            out.append("</tr>\n");
        }
        out.append("</tbody>\n");
        out.append("</table>\n");

    }

}

