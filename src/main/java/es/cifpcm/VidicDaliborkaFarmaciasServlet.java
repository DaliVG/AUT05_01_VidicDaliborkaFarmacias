package es.cifpcm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.script.ScriptContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/vidic_farm")
public class VidicDaliborkaFarmaciasServlet extends HttpServlet {
    public static Persistencia pst = new impPersistenciaVidic();
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        pst.list();
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        pst.openJSON();
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String farmacia = request.getParameter("farmacia");
        Farmacia sucursal = null;

        if (!farmacia.equals("")){

            for (Farmacia sucursalBus : pst.list()) {

                if (sucursalBus.getNOMBRE().toUpperCase().equals(farmacia.toUpperCase())) {

                    sucursal = sucursalBus;

                }
            }
            if (sucursal!=null){

                // utilizamos función de busqueda de la sucursal especifica.

                List<Farmacia> busqueda = pst.buscararea2(pst.list(), sucursal);

                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/> ");
                out.append("<h2>Estas son las farmacias que hemos encontrado: </h2>");
                out.append("<table>\n");
                out.append("<thead>\n");
                out.append("<tr>\n");
                out.append("<th>Nombre:</th>\n");
                out.append("<th>Web:</th>\n");
                out.append("<th>Telefono:</th>\n");
                out.append("<th>Coordenadas X:</th>\n");
                out.append("<th>Coordenadas Y:</th>\n");
                out.append("</tr>\n");
                out.append("</thead>\n");
                out.append("<tbody>\n");

                for (Farmacia sucursalMos : busqueda
                ) {
                    out.append("<tr>\n");
                    out.append("<td>" + sucursalMos.getNOMBRE() + "</td>\n");
                    out.append("<td>" + sucursalMos.getWEB() + "</td>\n");
                    out.append("<td>" + sucursalMos.getTELEFONO() + "</td>\n");
                    out.append("<td>" + sucursalMos.getUTM_X() + "</td>\n");
                    out.append("<td>" + sucursalMos.getUTM_Y() + "</td>\n");
                    out.append("</tr>\n");
                }
                out.append("</tbody>\n");
                out.append("</table>\n");
                out.append("<a href=\"http://localhost:8080/VidicDaliborkaFarmacias\">Volver a inicio</a>");

            } else { // Muestra de error personalizado - Farmacia no existe en el archivo.

                out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/> ");
                out.append("<h2>Oh oh! Esa farmacia no existe en nuestro archivo.</h2>\n");
                out.append("<h5>Recuerda que el nombre debe ser igual al de la lista. </h5>");
                out.append("<img src=\"./images/notfound.jpeg\" width=\"300\" height=\"300\"/></br></br>");
                out.append("<a href=\"http://localhost:8080/VidicDaliborkaFarmacias/listaFarm\">Chequea aquí la lista de farmacias</a> </br> </br>");
                out.append("<a href=\"http://localhost:8080/VidicDaliborkaFarmacias\">Prueba otra vez</a> </br> </br>");
            }

        } else { // Muestra de error personalizado - No ha introducido dato.

            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/style.css\"/> ");
            out.append("<h2>Oh oh! No ha introducido ningún nombre.</h2>\n");
            out.append("<h5>Recuerda que el nombre debe ser igual al de la lista. </h5>");
            out.append("<img src=\"./images/notfound.jpeg\" width=\"300\" height=\"300\"/></br></br>");
            out.append("<a href=\"http://localhost:8080/VidicDaliborkaFarmacias/listaFarm\">Chequea aquí la lista de farmacias</a> </br></br>");
            out.append("<a href=\"http://localhost:8080/VidicDaliborkaFarmacias\">Prueba otra vez</a></br></br>");

        }



    }
}

