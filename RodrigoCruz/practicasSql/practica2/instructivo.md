Instructivo: Análisis de Entidades y Creación de una Base de Datos


1. Análisis de Entidades
    Entidades Seleccionadas:
    • Jugador: Representa a una persona que juega videojuegos.
    • Videojuego: Representa un juego que un jugador puede jugar.

    Relación:
    Un jugador puede jugar varios videojuegos, y un videojuego puede ser jugado por varios jugadores. Por lo tanto, la relación es de muchos a muchos. 

2. Creación de Tablas

Estructura de las Tablas:

    1. Tabla Jugador:
        ◦ id_jugador (serial primary key)
        ◦ nombre (text)
        ◦ edad (int)
    2. Tabla Videojuego:
        ◦ id_videojuego (serial primary key)
        ◦ juego (text)
        ◦ genero (text)
        ◦ plataforma (text)

3. Creación de la Base de Datos y Esquema

Comandos SQL para crear la Base de Datos y el Esquema:


     -- Crear la base de datos
        create database videojuegosdb;

     -- Conectar a la base de datos
        \c videojuegosdb;

     -- Crear el esquema
        create schema videojuegos_schema;

    -- Crear la tabla  jugador y despues videojuego
        create table videojuegos_schema.Jugador(id_jugador serial primary key, nombre text, edad text);

        create table videojuegos_schema.Videojuego(id_videojuego serial primary key, juego text, genero text, plataforma text, id_jugador int references videojuegos_schema.Jugador(id_jugador);

4. Insertar Datos en las Tablas

    -- Insertar datos en la tabla Jugador y videojuegos usando la referencia    

        insert into videojuegos_schema.jugador(nombre, edad) values ('Carlos', 25),('Ana', 22),('Luis', 30),('Sofía', 27),('Jorge', 24),('Elena', 28),('Daniel', 21),('María', 26),('Pablo', 29),('Laura', 23);

        insert into videojuegos_schema.Videojuego (juego, genero, plataforma, id_jugador) values ('The Legend of Zelda', 'Aventura', 'Nintendo Switch', 1),('FIFA 23', 'Deportes', 'PlayStation 5', 2),('Minecraft', 'Sandbox', 'PC', 3),('Call of Duty', 'Shooter', 'Xbox', 4),('Dark Souls', 'RPG', 'PC', 5),('League of Legends', 'MOBA', 'PC', 6),('GTA V', 'Acción', 'PlayStation 5', 7),('Among Us', 'Party', 'PC', 8),('Fortnite', 'Battle Royale', 'Xbox', 9),('Super Mario', 'Plataforma', 'Nintendo Switch', 10);

5. Verificación de Datos

Ejecutar los siguientes comandos para verificar los datos insertados:

        select * from videojuegos_schema.jugador;

        select * from videojuegos_schema.Videojuego;

    



