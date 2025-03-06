Instalar una máquina virtual con Debian en WSL:
wsl --install -d debian


Instalar PostgreSQL en Debian:
sudo apt install postgresql


Cambiar al usuario de PostgreSQL:
sudo -i -u postgres

Abrir la terminal de PostgreSQL:
psql

Verificar si PostgreSQL está en ejecución:
sudo service postgresql status

Reiniciar PostgreSQL:
sudo service postgresql restart