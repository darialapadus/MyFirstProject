package lab8.task1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class CreateDatabaseTable {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/laborator";
        String username = "student";
        String password = "student";

        String sql = "CREATE TABLE IF NOT EXISTS smarterCalculatorResults (" +
                "id INT auto_increment," +
                "operation_type VARCHAR(20) NOT NULL," +
                "left_operand VARCHAR(254) NOT NULL," +
                "right_operand VARCHAR(254) NOT NULL," +
                "operation VARCHAR(2) NOT NULL," +
                "result VARCHAR(255) NOT NULL," +
                "PRIMARY KEY (id)" +
                ")";

        try (Connection connection = DriverManager.getConnection(url, username, password);
             Statement statement = connection.createStatement()) {
            statement.executeUpdate(sql);
            System.out.println("Tabela smarterCalculatorResults a fost creată cu succes.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

