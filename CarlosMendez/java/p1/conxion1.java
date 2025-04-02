import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
class conxion1{
public static void main (String[] args){

String URL = "jdbc:postgresql://localhost:5432/hospital";
String USER = "admin";
String PASS = "123456";
Connection connection = null;
Statement statement = null;
ResultSet resultset = null;

try{
connection = DriverManager.getConnection (URL,USER,PASS);
System.out.println("Conexion exitosa");
statement = connection.createStatement();
String query = "select * from \"Clinica\".\"Medicos\"";
resultset = statement.executeQuery(query);
System.out.println("Medicos");
while(resultset.next()){
System.out.println("id_medico: " + resultset.getInt("id_medico"));
System.out.println("nombre_medico: " + resultset.getString("nombre_medico"));
System.out.println("numero_consultorio: " + resultset.getInt("numero_consultorio"));
System.out.println("\n especialidad: " + resultset.getString("especialidad"));
}
resultset.close();
String query1 = "select * from \"Clinica\".\"Pacientes\"";
resultset = statement.executeQuery(query1);
System.out.println("\n Pacientes");
while(resultset.next()){
System.out.println("id_paciente: " + resultset.getInt("id_paciente"));
System.out.println("nombre: " + resultset.getString("nombre"));
System.out.println("edad: " + resultset.getInt("edad"));
System.out.println("telefono: " + resultset.getInt("telefono"));
System.out.println("id_medico: " + resultset.getInt("id_medico"));
}
resultset.close();

String query2 = "select * from \"Clinica\".\"Medicos\" WHERE especialidad = 'Pediatra'";
resultset = statement.executeQuery(query2);
System.out.println("\n Especialidad");
while(resultset.next()){
System.out.println("nombre_medico: " + resultset.getString("nombre_medico"));
System.out.println("\n especialidad: " + resultset.getString("especialidad"));
}
resultset.close();

}
catch( Exception e){
System.out.println("Conexion fallida" + e);
}

}
}
