<%@page import="es.uned.master.java.bancaonlineuned.controlador.Controlador.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!-- *************** LLAMADA AL ARCHIVO HEADER ***************   -->
<jsp:include page="vista/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <title>Banca Online</title>
</head>
<body>


<section>
    <div class="container">
        <div class="row">
            <div class="col-12 text-white text-center negro" style="padding: 50px">
                1 <span class="material-icons">arrow_forward</span> 2 <span class="material-icons">arrow_forward</span> <span style="color: #ffb500;">3</span>
            </div>
        </div>
        <div class="row bg-white py-4 text-center">
            <p class="h1"><strong>¡Terminamos!</strong></p>
            <p class="m-2 p-5">El alta en <span class="naranja">BANCA ONLINE</span> se ha realizado existosamente. Recibirá en brebe un email, para realizar una videollamada para confirmar los datos.</p>
        </div>
        <div class="row bg-white py-3 text-center">
            <p class="h2"><strong>¡Gracias por dejarnos ser tu banco!</strong></p>
        </div>
        <div class="row bg-white d-flex justify-content-center">
            <a href="index.jsp" class="col-2 btn boton text-white my-4">Volver al Inicio</a>
        </div>

    </div>
</section>

</body>
</html>