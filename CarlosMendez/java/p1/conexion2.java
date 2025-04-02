import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
class conexion2{
public static void main (String[] args){

String URL = "jdbc:postgresql://localhost:5432/db1";
String USER = "admin";
String PASS = "123456";
Connection connection = null;
Statement statement = null;
ResultSet resultset = null;

try{
connection = DriverManager.getConnection (URL,USER,PASS);
System.out.println("Conexion exitosa");
statement = connection.createStatement();
String query = "select * from colores.colores";
resultset = statement.executeQuery(query);
System.out.println("Colores");
while(resultset.next()){
System.out.println("id color: " + resultset.getInt("id"));
System.out.println("color: " + resultset.getString("nombre"));
}
resultset.close();

String query1 = "select * from colores.users";
resultset = statement.executeQuery(query1);
System.out.println("\n Usuarios");
while(resultset.next()){
System.out.println("id usuario: " + resultset.getInt("id"));
System.out.println("nombre: " + resultset.getString("nombre"));
System.out.println("color_id: " + resultset.getInt("color_id"));
}
resultset.close();

String query2 = "SELECT u.nombre AS nombre_usuario, c.nombre AS nombre_color" + "FROM colores.users u "
+ "LEFT JOIN colores.colores c ON u.color_id = c.id";

resultset = statement.executeQuery(query2);
System.out.println("\n Especialidad");
while(resultset.next()){
System.out.println("id color: " + resultset.getInt("id"));
System.out.println("color: " + resultset.getString("nombre"));
System.out.println("nombre: " + resultset.getString("nombre"));
System.out.println("color_id: " + resultset.getInt("color_id"));
}
resultset.close();
}
catch( Exception e){
System.out.println("Conexion fallida" + e);
}

}
}
