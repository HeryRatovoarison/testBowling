package servlets;

import handler.Handler;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author herisata
 */
public class ScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Handler.newJeu();
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String quilles=request.getParameter("quilles");
        try {
            Handler.getJeu().lancer(Integer.parseInt(quilles));
            
        } catch (Exception ex) {
            request.setAttribute("erreur", ex.getMessage());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        request.setAttribute("frame", Handler.getJeu().getFrameCourant());
        request.setAttribute("lancer", Handler.getJeu().getLancerCourant());
        request.setAttribute("score", Handler.getJeu().scoreFinal());
        request.setAttribute("maxQuilles", Handler.getMaxQuilles());
        dispatcher.forward(request, response);
    }
}
