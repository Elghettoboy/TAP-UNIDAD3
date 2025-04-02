import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

class ConexionTienda {
    public static void main(String[] args) {
        String URL = "jdbc:postgresql://localhost:5432/tiendadb";
        String USER = "admin";
        String PASSWORD = "137946";

        Connection connection = null; 
        ResultSet resultSet = null;
        Statement statement = null;
        
        
        try {
        connection = DriverManager.getConnection(URL, USER, PASSWORD);
            statement = connection.createStatement();
            
            System.out.println("Conexión exitosa a TiendaDB");
            System.out.println("");
            
            String query = "select * from TiendaDB.Clientes";
            resultSet = statement.executeQuery(query);

            System.out.println("");
            System.out.println("--Query 1: mostrar clientes\n");
            
            while (resultSet.next()) {
                System.out.println("ID: " + resultSet.getInt("id") + ", Nombre: " + resultSet.getString("nombre") + ", Correo: " + resultSet.getString("correo"));
            }
            String query2 = "select c.nombre as cliente, sum(p.precio * pe.cantidad) as total_gastado from TiendaDB.Pedidos pe join TiendaDB.Clientes c on pe.cliente_id = c.id join TiendaDB.Productos p on pe.producto_id = p.id group by c.nombre";
            resultSet = statement.executeQuery(query2);
            System.out.println("");
            System.out.println("--Query 2: mostrar cliente cambiando nombre de la columna a cliente y despues hacer la suma de la cantidad de productos por el precio y cambiando la columna para que se llame total gastado--\n");
            while (resultSet.next()) {
                System.out.println("Cliente: " + resultSet.getString("cliente") + ", Total gastado: " + resultSet.getInt("total_gastado"));
            }
            String query3 = "select * from TiendaDB.Productos where precio >10000";
            resultSet = statement.executeQuery(query3);
            System.out.println("");
            System.out.println("--Query 3: mostrar productos que valgan mas de 10000\n");
            
            while (resultSet.next()) {
                System.out.println("Producto: " + resultSet.getString("nombre") + ", Precio: " + resultSet.getBigDecimal("precio"));
                
            }


        } catch (Exception e) {
            System.out.println("Error en la conexión a TiendaDB: " + e.getMessage());
        }
    }
}