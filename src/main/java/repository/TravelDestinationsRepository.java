package repository;

import connection.DBConnector;
import model.TravelDestinations;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TravelDestinationsRepository {



    public List<TravelDestinations> getAll() {
        List<TravelDestinations> destinations = new ArrayList<>();

        try (Connection connection = DBConnector.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery("SELECT * FROM TravelDestinations")) {

            while(rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("DestinationName");
                String country = rs.getString("Country");
                int popularity = rs.getInt("Popularity");
                int isVisited = rs.getInt("isVisited");
                String bestSeason = rs.getString("bestSeason");

                TravelDestinations td = new TravelDestinations(id, name, country, popularity, isVisited, bestSeason);
                destinations.add(td);
            }
        } catch (Exception ex){
            ex.printStackTrace();
        }

        return destinations;
    }

    public TravelDestinations getById(int id) {
        String sql = "SELECT * FROM TravelDestinations WHERE id = ?";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if(rs.next()) {
                String name = rs.getString("DestinationName");
                String country = rs.getString("Country");
                int popularity = rs.getInt("Popularity");
                int isVisited = rs.getInt("isVisited");
                String bestSeason = rs.getString("bestSeason");

                return new TravelDestinations(id, name, country, popularity, isVisited, bestSeason);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public int insert(TravelDestinations td) {
        String sql = "INSERT INTO TravelDestinations (DestinationName, Country, Popularity, isVisited, bestSeason) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, td.getName());
            stmt.setString(2, td.getCountry());
            stmt.setInt(3, td.getPopularity());
            stmt.setInt(4, td.getIsVisited());
            stmt.setString(5, td.getBestSeason());

            return stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int update(TravelDestinations td) {
        String sql = "UPDATE TravelDestinations SET DestinationName = ?, Country = ?, Popularity = ?, isVisited = ?, bestSeason = ? WHERE id = ?";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setString(1, td.getName());
            stmt.setString(2, td.getCountry());
            stmt.setInt(3, td.getPopularity());
            stmt.setInt(4, td.getIsVisited());
            stmt.setString(5, td.getBestSeason());
            stmt.setInt(6, td.getId());

            return stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }

    public int deleteById(int id) {
        String sql = "DELETE FROM TravelDestinations WHERE id = ?";

        try (Connection connection = DBConnector.getConnection();
             PreparedStatement stmt = connection.prepareStatement(sql)) {

            stmt.setInt(1, id);
            return stmt.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            return -1;
        }
    }
}
