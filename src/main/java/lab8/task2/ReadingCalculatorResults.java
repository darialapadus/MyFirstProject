package lab8.task2;

import lab8.task1.CalculationRequest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadingCalculatorResults {

    private static final String URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USERNAME = "student";
    private static final String PASSWORD = "student";

    public static void main(String[] args) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            String sql = "SELECT operation_type, left_operand, right_operand, operation, result FROM smarterCalculatorResults";
            statement = connection.prepareStatement(sql);

            resultSet = statement.executeQuery();

            while (resultSet.next()) {
                String operationType = resultSet.getString("operation_type");
                String leftOperand = resultSet.getString("left_operand");
                String rightOperand = resultSet.getString("right_operand");
                String operation = resultSet.getString("operation");
                String result = resultSet.getString("result");

                CalculationRequest request = new CalculationRequest(leftOperand, rightOperand, operation);

                System.out.println("Operation " + request + " with result " + result + " and type " + operationType);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
