package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import repository.TravelDestinationsRepository;

import java.io.IOException;

@WebServlet(name = "DeleteServlet", urlPatterns = "/travel/delete")
public class DeleteServlet extends HttpServlet {

    private TravelDestinationsRepository repository = new TravelDestinationsRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                repository.deleteById(id);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }

        response.sendRedirect(request.getContextPath() + "/travel");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String idParam = request.getParameter("id");

        if (idParam != null) {
            try {
                int id = Integer.parseInt(idParam);
                int result = repository.deleteById(id);

                if (result > 0) {
                    request.getSession().setAttribute("message", "Deleted successfully");
                } else {
                    request.getSession().setAttribute("error", "Failed to delete");
                }
            } catch (NumberFormatException e) {
                request.getSession().setAttribute("error", "Invalid ID format");
            }
        }

        response.sendRedirect(request.getContextPath() + "/travel");
    }
}