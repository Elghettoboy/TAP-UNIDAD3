import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Db0{

    public static void main(String[] args) {
        
        String URL = "jdbc:postgresql://localhost:5432/db0";
        String USER = "admin";
        String PASSWORD = "alessandro12";

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexion Exitosa a PostgreSQL!");

            statement=connection.createStatement();

            String query1 = "select * from escuela.materias";
            resultSet = statement.executeQuery(query1);

            System.out.println("Materias: ");

                while (resultSet.next()) {
                     System.out.println("id: " + resultSet.getInt("id"));
                     System.out.println("Nombre de la materia: " + resultSet.getString("nombre"));   
                }
        
            resultSet.close();
        
        
            String query2 = "select * from escuela.estudiantes";
            resultSet = statement.executeQuery(query2);

            System.out.println("Estudiantes: ");

                while (resultSet.next()) {
                    System.out.println("id: " + resultSet.getInt("id"));
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Materia: " + resultSet.getInt("materia_id"));   
                }
            resultSet.close();
            
            String query3 = "select e.nombre, materia_id from escuela.estudiantes e join escuela.materias m on e.materia_id = m.id";
            resultSet = statement.executeQuery(query3);
            System.out.println(" Estudiantes y Materias: ");
                while (resultSet.next()) {
                    System.out.println("Nombre: " + resultSet.getString("nombre"));
                    System.out.println("Materia: " + resultSet.getInt("materia_id"));
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
        }
    }    