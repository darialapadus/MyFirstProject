package lab8.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseManager {

    private static final String URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USERNAME = "student";
    private static final String PASSWORD = "student";

    public static void saveCalculationResult(String operationType, String leftOperand, String rightOperand, String operation, String result) {
        try (Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
            String sql = "INSERT INTO smarterCalculatorResults(operation_type, left_operand, right_operand, operation, result) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, operationType);
                statement.setString(2, leftOperand);
                statement.setString(3, rightOperand);
                statement.setString(4, operation);
                statement.setString(5, result);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}


