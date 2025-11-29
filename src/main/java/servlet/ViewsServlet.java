package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TravelDestinations;
import repository.TravelDestinationsRepository;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "ViewsServlet", urlPatterns = {"/travel", "/travel/detail"})
public class ViewsServlet extends HttpServlet {

    private TravelDestinationsRepository repository = new TravelDestinationsRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getServletPath();

        if (path.equals("/travel")) {
            // Hiển thị danh sách
            List<TravelDestinations> destinations = repository.getAll();
            request.setAttribute("TravelDestinations", destinations);
            request.getRequestDispatcher("/WEB-INF/views/views-traveldestinations.jsp")
                    .forward(request, response);

        } else if (path.equals("/travel/detail")) {
            // Hiển thị chi tiết
            String idParam = request.getParameter("id");
            if (idParam != null) {
                try {
                    int id = Integer.parseInt(idParam);
                    TravelDestinations destination = repository.getById(id);

                    if (destination != null) {
                        request.setAttribute("destination", destination);
                        request.getRequestDispatcher("/WEB-INF/views/detail-traveldestinations.jsp")
                                .forward(request, response);
                    } else {
                        response.sendRedirect(request.getContextPath() + "/travel");
                    }
                } catch (NumberFormatException e) {
                    response.sendRedirect(request.getContextPath() + "/travel");
                }
            } else {
                response.sendRedirect(request.getContextPath() + "/travel");
            }
        }
    }
}
