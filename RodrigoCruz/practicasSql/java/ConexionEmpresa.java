import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class ConexionEmpresa {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/empresadb";
        String USER = "admin";
        String PASSWORD = "137946";
        Connection connection = null; 
        ResultSet resultSet = null;
        Statement statement = null;
        
        
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            
            System.out.println("Conexión exitosa a EmpresaDB");
            System.out.println("");

            String query = "select * from EmpresaDB.Empleados";
            resultSet = statement.executeQuery(query);
            System.out.println("--Query 1: tabla empleados--\n");
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre") + ", Puesto: " + resultSet.getString("puesto") + ", Salario: " + resultSet.getDouble("salario"));
            }
            String query2 = "select * from EmpresaDB.Empleados where salario > 2000";
            resultSet = statement.executeQuery(query2);
            System.out.println("");
            System.out.println("--Query 2: mostrar empleados donde el sueldo sea mayor a 2000--\n");
            
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre") + ", Salario: " + resultSet.getDouble("salario"));
            }
            String query3 = "select * from EmpresaDB.Departamentos";
            resultSet = statement.executeQuery(query3);
            System.out.println("");
            System.out.println("--Query 3: mostrar tabla departamentos--\n");
            
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre"));
            }
        } catch (Exception e) {
            System.out.println("Error en la conexión a EmpresaDB: " + e.getMessage());
        }
    }
}