import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Escueladb {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/escueladb";
        String user = "admin";
        String password = "alessandro12";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a PostgreSQL!");

            statement = connection.createStatement();

            String query1 = "select * from gestion_escolar.materias";
            resultSet = statement.executeQuery(query1);

            System.out.println("Materias:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre de la Materia: " + resultSet.getString("nombre_materia"));
            }
            resultSet.close();

            String query2 = "select * from gestion_escolar.grupos";
            resultSet = statement.executeQuery(query2);

            System.out.println("Grupos:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Grupo: " + resultSet.getString("grupo"));
            }
            resultSet.close();
            
            String query3 = "select e.id, e.nombre_estudiante, g.grupo, m.nombre_materia from gestion_escolar.estudiantes e join gestion_escolar.grupos g on e.grupo_id = g.id join gestion_escolar.materias m on e.materia_id = m.id";
            resultSet = statement.executeQuery(query3);

            System.out.println("Estudiantes, Materias y Grupo:");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre_estudiante") + ", Grupo: " + resultSet.getString("grupo") + ", Materia: " + resultSet.getString("nombre_materia"));
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
