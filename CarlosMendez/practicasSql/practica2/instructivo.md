Instructivo Creacion de base de Datos, usando terminal de linux desde windows y con terminal de postgres 

Paso uno: Abrimos nuestra terminal de linux.

Paso dos: Accedemos a nuetsra terminal de postgresql usando el comando (sudo -i -u postgres) damos enter e ingresamos nuestra contraeña.

Paso tres: Una vez dentro de la terminal de postgres accedemos a nuestra base de datos con nuestro administrador principal usando el siguiente comando (psql -U nombre del usuario -d nombre de la base de datos) e ingresamos nuestra contraseña.

Paso cuatro: Una vez dentro, procedemos a crear nuestra base de datos nueva, nuestro esquema y nuestras tablas.

Paso cinco: Primero creamos nuestra base de datos usando el comando (create database nombre de nuestra base de datos).

Paso seis: Accedemos a esa nueva base de datos usando el comando (\c nombre de la base de datos).

Paso siete: Dentro de la base de datos creamos nuestro esquema usando el siguiente comando (create schema nombre del esquema).

Paso ocho: Validamos que le esquema se haya creado correctamente con el comando (\dn).

Paso nueve: Creamos nuestras tablas dentro de nuestro esquema, recordemos que conectaremos ambas tablas por lo cual es importante el orden en que crearemos y llenaremos las tablas, tomando que tabla Medicos es la tabla que haremos primero y la tabla Pacientes como tabla dos que sera la que le introduciremos la referencia de la primer tabla.
-Usamos el siguiente comando: create table nombre del esquema.nombre de la tabla (atributos de la tabla por ejemplo (id serial primary key, nombre text, etc )). 

Paso diez: EN el caso de la segunda tabla hay una alteracion en el comando porque es donde introduciremos la referencia para que se conceten entre tablas.
-Las sintaxis es: create table nombre del esquema.nombre de la tabla (atributos de la tabla por ejemplo (id serial primary key, nombre text, id_ del atributo al que conctaremos la tabla en mi caso es id_medico int, foreign key(llave foranea) (id_medico) references nombre del esquema.nombre de la tabla a la que queremos conctar(id_medico))).

Paso once: Verificamos que se crearon las tablas correctamente usando el siguiente comando (\dt "Clinica".*)

Paso doce: Una vez que creamos nuestras tablas procedemos a insertar los datos a nuestras tablas.
-Usamos la siguinete sintaxis de ejemplo:insert into "Clinica"."Medicos" (nombre_medico,numero_consultorio, especialidad) values ('Dr. Juan Pérez', 101,'Cardiólogo');

Paso trece: Una vez que hayamos insertado todos nuestros datos, consultamos la tabla y verificamos que los datos sean correctos, usamos la sintaxis: select * from "nombre esquema","nombre tabla";

Paso catorce: Para insertar datos en la segund atbala usamos como ejemplo la siguiente sintaxis:
-insert into "Clinica"."Pacientes"(nombre, edad, telefono, id_medico)values ('Esteban García', 40, '890123456', 6);

Paso quince: Verificamos que se hayan insertado todos los registros esta segunda tabla usando la sintaxis:select * from "nombre esquema","nombre tabla";

Paso dieciseis: Finalmente hacemos consulta de las dos tablas y verificamos que ambas tengas todos lo registros y la referencia de conexion.

Y listo hemos temriando con la creacion de nuestra base de datos y la creacion de nuestras tablas.