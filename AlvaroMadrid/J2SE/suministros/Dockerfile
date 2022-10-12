# Usaremos la versión 11 de openJdk
FROM openjdk:11


#Crear la nueva app que contiene los ficheros
RUN mkdir /app

# Copiando los ficheros a la app en el contenedor docker
COPY target/* /app/

# Establecemos la ruta de app
WORKDIR /app

# Ejecutar la clase principal
CMD ["java", "Driver"]