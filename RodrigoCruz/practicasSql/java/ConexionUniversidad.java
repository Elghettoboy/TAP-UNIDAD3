import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class ConexionUniversidad {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/universidaddb";
        String USER = "admin";
        String PASSWORD = "137946";

        Connection connection = null; 
        ResultSet resultSet = null;
        Statement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            System.out.println("");
            System.out.println("Conexión exitosa a UniversidadDB");
            System.out.println("");
            
            String query1 = "select * from UniversidadDB.Estudiantes";
            resultSet = statement.executeQuery(query1);
            System.out.println("--Query 1: Estudiantes--");
            System.out.println("");
            while (resultSet.next()) {
                    System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre") + ", Edad: " + resultSet.getInt("edad") + ", Carrera: " + resultSet.getString("carrera"));
            }

            String query2 = "select * from UniversidadDB.Cursos";
            resultSet = statement.executeQuery(query2);
            System.out.println("");
            System.out.println("");
            System.out.println("--Query 2: Cursos--");
            System.out.println("");

            while (resultSet.next()){
                    System.out.println("ID: "+ resultSet.getInt("id")+", Nombre: "+resultSet.getString("nombre")+", Creditos: "+resultSet.getInt("creditos"));
            }

            String query3 = "select m.id, e.nombre, e.carrera, m.semestre from UniversidadDB.Matricula m join UniversidadDB.Estudiantes e on m.id=e.id";
            resultSet = statement.executeQuery(query3);
            System.out.println("");
            System.out.println("");
            System.out.println("--Query 3: traer relacion con join de la tabla matricula y estudiantes con columnas especificas--");
            System.out.println("");

            while(resultSet.next()){
                    System.out.println("ID: "+ resultSet.getInt("id")+": Nombre: "+ resultSet.getString("nombre"));
                    System.out.println("--Carrera: "+ resultSet.getString("carrera"));
                    System.out.println("--Semestre: "+resultSet.getString("semestre"));
                    System.out.println("");
            }

        } catch (Exception e) {
            System.out.println("Error en la conexión a UniversidadDB: " + e.getMessage());
        }
    }
}