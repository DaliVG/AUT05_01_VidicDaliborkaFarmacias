package es.cifpcm;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.script.ScriptContext;
import java.io.IOException;
import java.io.PrintWriter;
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
        String farmacia = request.getParameter("farmacia");
        Farmacia sucursal = null;

        for (Farmacia sucursalBus : pst.list()) {

            if (sucursalBus.getNOMBRE().equals(farmacia)) {

                sucursal = sucursalBus;

            }
        }

        List<Farmacia> busqueda = pst.buscararea2(pst.list(), sucursal);
        PrintWriter out = response.getWriter();

        pst.openJSON();
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"././css/style.css\"/> ");
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
        for (Farmacia sucursalMos : busqueda
        ) {
            out.append("<tr>\n");
            out.append("<td>" + sucursalMos.getNOMBRE() + "</td>\n");
            out.append("<td>" + sucursalMos.getWEB() + "</td>\n");
            out.append("<td>" + sucursalMos.getUTM_X() + "</td>\n");
            out.append("<td>" + sucursalMos.getUTM_Y() + "</td>\n");
            out.append("</tr>\n");
        }
        out.append("</tbody>\n");
        out.append("</table>\n");
    }
}

