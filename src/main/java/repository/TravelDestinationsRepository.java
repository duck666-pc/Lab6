package repository;
import connection.DBConnector;
import model.TravelDestinations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDestinationsRepository {

    public int deleteById(Integer id) {
        String sql = "DELETE FROM books WHERE TravelDestinationsId = ?";
        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public List<TravelDestinations> getAll() {
        List<TravelDestinations> books = new ArrayList<>();

        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM TravelDestinations")) {

            while(rs.next()) {
                Integer id = rs.getInt("id");
                String name = rs.getString("DestinationName");
                String country = rs.getString("Country");
                Integer popularity = rs.getInt("Popularity");
                Integer isVisited= rs.getInt("isVisited");
                String bestSeason = rs.getString("bestSeason");

                TravelDestinations td = new TravelDestinations(id, name, country, popularity, isVisited, bestSeason);
                TravelDestinations.add(td);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return td;
    }
}
