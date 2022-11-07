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



<!-- *************** FORMULARIO DE ALTA PASO  2 ***************
Se solicita el nombre, apellido,edad y direccion. El controlador lee
estos datos y valida que el formato es correcto, los guarda
en un XXX y si es correcto va al 3do. Paso, de lo contrario
indica los errores cometidos por el usuario
*****************************************************************-->
<section>
    <div class="container">
        <div class="row">
            <div class="col-12 text-white text-center negro" style="padding: 50px">
                1 <span class="material-icons">arrow_forward</span> <span style="color: #ffb500;">2</span> <span class="material-icons">arrow_forward</span> 3
            </div>
        </div>
        <div class="row bg-white py-4 text-center">
            <p class="h1"><strong>¡Continuamos!</strong></p>
            <p class="h4">Por favor necesitamos más datos para continuar tu proceso de alta:</p>
        </div>
        <form action="Controlador" method="POST" novalidate class="needs-validation">
            <div class="row bg-white p-5">
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="text" name="nombre" id="nombre" placeholder="NOMBRE" class="form-control border-0 border-bottom" required>
                    <div class="text-muted ps-2 subtexto">Tu nombre</div>
                </div>
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="text" name="apellidos" id="ape1" placeholder="APELLIDOS" class="form-control  border-0 border-bottom" required>
                    <div class="text-muted ps-2 subtexto">Tus apellidos. Ejemplo: Sánchez Morales</div>
                </div>
            </div>
            <div class="row bg-white p-5">
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="text" name="edad" id="edad" placeholder="EDAD" maxlength="2" class="form-control border-0 border-bottom" required>
                    <div class="text-muted ps-2 subtexto">Mayores de 18 años</div>
                </div>
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="text" name="direccion" id="direccion" placeholder="DIRECCION" class="form-control  border-0 border-bottom" required>
                    <div class="text-muted ps-2 subtexto">Tu dirección, localidad y provincia</div>
                </div>
            </div>
            <div class="row bg-white d-flex justify-content-center p-3">
                <input type="reset" name="limpiar" id="limpiar" class="col-2 btn boton text-white mx-2" value="Limpiar">
                <input type="submit" name="enviar" id="enviar" class="col-2 btn boton text-white mx-2" value="Siguiente">
            </div>
        </form>
    </div>
</section>
</body>
</html>
<!-- Script para validar del lado del cliente que el formunario no se envie en blanco -->
<script>
    const forms = document.querySelectorAll('.needs-validation')

    // Cuando pulsen click en siguiente, valida que no esten vacio los campos
    Array.from(forms).forEach(form => {
        form.addEventListener('submit', event => {
            if (!form.checkValidity()) {
                event.preventDefault()
                event.stopPropagation()
            }

            form.classList.add('was-validated')
        }, false)
    })
</script>

</body>
</html>