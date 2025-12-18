package servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.TravelDestinations;
import repository.TravelDestinationsRepository;

import java.io.IOException;
@WebServlet(name = "CreateServlet", urlPatterns = "/travel/new")
public class CreateServlet extends HttpServlet {
    private TravelDestinationsRepository repository = new TravelDestinationsRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/create-traveldestinations.jsp").forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String country = request.getParameter("country");
        String popularityStr = request.getParameter("popularity");
        String isVisitedStr = request.getParameter("isVisited");
        String bestSeason = request.getParameter("bestSeason");
        try {
            int popularity = Integer.parseInt(popularityStr);
            int isVisited = Integer.parseInt(isVisitedStr);
            TravelDestinations destination = new TravelDestinations();
            destination.setName(name);
            destination.setCountry(country);
            destination.setPopularity(popularity);
            destination.setIsVisited(isVisited);
            destination.setBestSeason(bestSeason);
            int result = repository.insert(destination);
            if (result > 0) {
                response.sendRedirect(request.getContextPath() + "/travel");
            } else {
                request.setAttribute("error", "Failed to add destination");
                request.getRequestDispatcher("/WEB-INF/views/create-traveldestinations.jsp").forward(request, response);
            }
        } catch (NumberFormatException e) {
            request.setAttribute("error", "Invalid input format");
            request.getRequestDispatcher("/WEB-INF/views/create-traveldestinations.jsp").forward(request, response);
        }
    }
}
