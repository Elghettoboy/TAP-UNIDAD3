import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Base {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/mindbox_r4";
        String user = "admin";
        String password = "alessandro12";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL!");

            statement = connection.createStatement();

            String query1 = "SELECT * FROM gestor.alumnos";
            resultSet = statement.executeQuery(query1);

            System.out.println("Alumnos:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id"));
                System.out.println("Nombre: " + resultSet.getString("nombre"));
                System.out.println("Edad: " + resultSet.getInt("edad"));
                System.out.println("No. Boleta: " + resultSet.getInt("no_boleta"));
            }
            resultSet.close();

            String query2 = "SELECT p.nombre, m.nombre_materia FROM gestor.profesores p INNER JOIN gestor.materias m ON p.nombre_materia = m.id";
            resultSet = statement.executeQuery(query2);

            System.out.println("Profesores y materias:");
            while (resultSet.next()) {
                System.out.println("Nombre: " + resultSet.getString("nombre") + ", Materia: " + resultSet.getString("nombre_materia"));
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
