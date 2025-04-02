import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
class con {
    public static void main(String[] args){
        String URL = "jdbc:postgresql://localhost:5432/p20";
        String USER = "admin";
        String PASS = "123456";
        Connection connection = null;
	    Statement statement = null;
	    ResultSet resultset = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASS); /*Se crea la conexión */
            System.out.println("Exitosa"); 
            statement = connection.createStatement(); /* */
            String query = "select * from rh.materias_p20"; /Crear la consulta/
            resultset = statement.executeQuery(query); /*Mostra la consulta */
            System.out.println("resultset: " + resultset);
            while (resultset.next()) {
                System.out.println("id: " + resultset.getInt("id"));
                System.out.println("Nombre: " + resultset.getString("name"));
                System.out.println("Edad: " + resultset.getString("edad"));
            }
        } catch (Exception e) {
            System.out.println("Conexion fallida"+e);
        }
    }
}
