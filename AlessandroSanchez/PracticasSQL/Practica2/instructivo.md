#INSTRUCTIVO

1. Abrimos la terminal de debian.

2. Nos cambiamos a postgres con el comando:
   - ** sudo -i -u postgres **

3. En la terminal cambiara de nuestro usuario a postgres por ejemplo: 
   - ** elghettoboy@ALE -----> postgres@ALE **

4. Ya dentro de postgres nos metemos a una base de datos que tengamos con el siguiente comando:
   - ** psql -U admin -d db0

5. Nos saldra el nombre de la base de datos, eso quiere decir que estamos conectados a esa base de datos:
   - ** db0=# **

6. En esa base de datos podemos crear otra base de datos, con el siguiente comando:
   - ** create database "CantanteDB" **

7. Nos conectamos a la base de datos creada anteriormente con el comando: 
   - ** \c "CantanteDB" **
   - Nos saldra un mensaje de que ahora estamos conectados a esa base de datos y con que usuario.

8. Creamos un schema:
   - ** create schema musica; **
   - Nos saldra un mensaje de que el esquema se ha creado.

9. Creamos un tabla:
   - ** create table musica.cantante (id serial primary key, nombre text, nacionalidad text, fecha_nacimiento date); **
   - Nos saldra un mensaje de que la tabla se ha creado.

10. Creamos una segunda tabla, haciendo referencia a la primera tabla creada:
   - ** create table musica.canciones (id serial primary key, titulo text, genero text, duracion time, id_cantante int foreing key(id_cantante) references musica.cantante(id)); **
   - Nos saldra un mensaje de que la tabla se ha creado.

11. Ahora insertamos los registros para la primera tabla , con el siguiente comando:
   - ** insert into musica.cantante (nombre, nacionalidad,fecha_nacimiento) values ('Kendrick Lamar', 'Estadounidense', '1987-06-17'); **
   - Asi hasta llenar 10 registros.
   - Por cada registro no saldra un mensaje que se ha insertado.

12. Ahora insertamos los registros para la segunda tabla, igual mismo comando:
   -  ** insert into musica.canciones (titulo, genero, duracion, id_cantante) values ('HUMBLE', 'HIP HOP', '00:02:57', 9); **
   - Asi hasta llenar 10 registros.
   - Por cada registro no saldra un mensaje que se ha insertado.

13. Ahora hacemos una consulta de la primera tabla, con el siguiente comando:
   - ** select * from musica.cantante; ** 
   - Nos mostrara la tabla completa.

14. Ahora hacemos una consulta de la segunda tabla, con el siguiente comando:
   - ** select * from musica.canciones; **
   - Nos mostrara la tabla completa.

