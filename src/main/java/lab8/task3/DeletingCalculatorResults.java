package lab8.task3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DeletingCalculatorResults {

    private static final String URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USERNAME = "student";
    private static final String PASSWORD = "student";

    public static void deleteResultsByOperationType(String operationType) {
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "DELETE FROM smarterCalculatorResults WHERE operation_type = ?";
            statement = connection.prepareStatement(sql);

            statement.setString(1, operationType);

            int rowsAffected = statement.executeUpdate();
            System.out.println("Deleted " + rowsAffected + " rows for operation type: " + operationType);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        deleteResultsByOperationType("multiplication");
    }
}

