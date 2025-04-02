import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
class conexion3{
public static void main (String[] args){

String URL = "jdbc:postgresql://localhost:5432/ITIZ_2";
String USER = "admin";
String PASS = "123456";
Connection connection = null;
Statement statement = null;
ResultSet resultset = null;

try{
connection = DriverManager.getConnection (URL,USER,PASS);
System.out.println("Conexion exitosa");
statement = connection.createStatement();
String query = "select * from gestion_escolar.materias ";
resultset = statement.executeQuery(query);
System.out.println("Materias");
while(resultset.next()){
System.out.println("id materia: " + resultset.getInt("id"));
System.out.println("nombre materia: " + resultset.getString("nombre"));
System.out.println("semestre: " + resultset.getInt("semestre"));
}
resultset.close();

String query1 = "select * from gestion_escolar.carreras ";
resultset = statement.executeQuery(query1);
System.out.println("\n Carreras");
while(resultset.next()){
System.out.println("id carrera: " + resultset.getInt("id"));
System.out.println("nombre: " + resultset.getString("nombre"));

}
resultset.close();

String query2 = "select * from gestion_escolar.materias where nombre= 'Simulacion'";

resultset = statement.executeQuery(query2);
System.out.println("\n Materia");
while(resultset.next()){
System.out.println("id materia: " + resultset.getInt("id"));
System.out.println("nombre materia: " + resultset.getString("nombre"));
System.out.println("semestre: " + resultset.getInt("semestre"));

}
resultset.close();
}
catch( Exception e){
System.out.println("Conexion fallida" + e);
}

}
}
