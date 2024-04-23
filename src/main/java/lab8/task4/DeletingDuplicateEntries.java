package lab8.task4;

import java.sql.*;

public class DeletingDuplicateEntries {

    private static final String URL = "jdbc:mysql://localhost:3306/laborator";
    private static final String USERNAME = "student";
    private static final String PASSWORD = "student";

    public static void deleteDuplicateEntries() {
        Connection connection = null;
        Statement statement = null;

        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();

            String sql = "SELECT operation_type, left_operand, right_operand, operation, result, COUNT(*) AS count " +
                    "FROM smarterCalculatorResults " +
                    "GROUP BY operation_type, left_operand, right_operand, operation, result " +
                    "HAVING count > 1";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                String operationType = resultSet.getString("operation_type");
                String leftOperand = resultSet.getString("left_operand");
                String rightOperand = resultSet.getString("right_operand");
                String operation = resultSet.getString("operation");
                String result = resultSet.getString("result");

                sql = "DELETE FROM smarterCalculatorResults " +
                        "WHERE operation_type = ? " +
                        "  AND left_operand = ? " +
                        "  AND right_operand = ? " +
                        "  AND operation = ? " +
                        "  AND result = ? " +
                        "LIMIT 1";
                PreparedStatement deleteStatement = connection.prepareStatement(sql);
                deleteStatement.setString(1, operationType);
                deleteStatement.setString(2, leftOperand);
                deleteStatement.setString(3, rightOperand);
                deleteStatement.setString(4, operation);
                deleteStatement.setString(5, result);
                deleteStatement.executeUpdate();
            }

            System.out.println("Duplicate entries deleted successfully.");

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
        deleteDuplicateEntries();
    }
}

