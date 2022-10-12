# CRUD - Portal de gestión de usuarios

*Autor: Álvaro Madrid
Fecha de entrega: 25 / Julio / 2022*

El presente proyecto consiste en la elaboración de un portal web de gestión de usuarios, donde se pueden realizar funciones básicas de **CRUD**, implementando el enfoque **MVC** (Modelo-Vista-Controlador) a través de **JSP**, **Servlet** y **JDBC**.

## Modelo

La parte del modelo del proyecto se compone de tres clases de Java:

1. **Conexion**: Se utiliza para establecer la conexión con la base de datos a través del método '**getConexion()'**.
2. **ConsultasUsuarios**: Se utiliza para realizar las  consultas CRUD sobre la base de datos:
    1. '**registraUsuario()**' -*Create*-,
    2. '**existeUsuario()**' -*Read*-,
    3. '**modificaUsuario()**' -*Update*-,
    4. '**eliminaUsuario()**' -*Delete*-.
3. **Usuario**: Se utiliza para recoger la información sobre el usuario y el cual se utilizará para manejar la base de datos. Se compone de cuatro atributos: nombre, apellido, usuario, contraseña y ámbito de interés en el arte.

## Vista
La vista del proyecto se compone de nueve JSP:

1. **welcome.jsp**: contiene un formulario de registro para recoger todos los datos del usuario a dar de alta, y está vinculado al Servlet 'AltaUsuario'.
2. **login.jsp**: contiene un formulario para recoger el usuario y contraseña del usuario a iniciar sesión, y está vinculado al Servlet 'LoginUsuario'.
3. **portal.jsp**: contiene tres opciones para el usuario (modificar contraseña, eliminar usuario o salir de la sesión). A través del atributo 'usuario' de la sesión, se valida el acceso a esta página.
4. **modifica.jsp**: sirve para modificar la contraseña, y contiene un campo de texto para insertar la nueva contraseña. A través del atributo 'usuario' de la sesión, se valida el acceso a esta página.
5. **elimina.jsp**: sirve para eliminar un usuario, y contiene un campo de texto para insertar la contraseña como medio de confirmación.  A través del atributo 'usuario' de la sesión, se valida el acceso a esta página.
6. **logout.jsp**: sirve para salir de la sesión, y automáticamente se redirige a 'welcome.jsp'. A través del atributo 'usuario' de la sesión, se valida el acceso a esta página.
7. **error.jsp**: muestra un error en la creación de usuario.
8. **portal_success.jsp**: muestra que el cambio de contraseña ha sido exitoso y contiene las mismas opciones que 'portal.jsp'. A través del atributo 'usuario' de la sesión, se valida el acceso a esta página.
9. **portal_error.jsp**: muestra un error en la modificación de contraseña. A través del atributo 'usuario' de la sesión, se valida el acceso a esta página.

## Controlador
El controlador del proyecto se basa en cuatro servlets, los cuales utilizan el método POST (evitando así ver los datos en la URI):

1. **AltaUsuario**: los parámetros informados en 'welcome.jsp' se pasan al servlet a través del objeto 'request'. Si el usuario ha informado todos los campos y son correctos, se crea el nuevo usuario en la base de datos.
2. **EliminaUsuario**: confirmando la acción con la contraseña, se elimina el usuario (el cual se pasa al servlet a través del atributo de la sesión 'usuario').
3. **LoginUsuario**: los parámetros informados en 'login.jsp' se pasan al servlet a través del objeto 'request'. Si el usuario ha informado los campos usuario y contraseña correctamente, se accede al portal del usuario ('portal.jsp').
4. **ModificaUsuario**: introduciendo el nuevo valor, se modifica la contraseña del usuario (el cual se pasa al servlet a través del atributo de la sesión 'usuario'). Si el cambio de contraseña ha sido exitoso, se vuelve al portal con un mensaje de éxito ('portal_success.jsp').