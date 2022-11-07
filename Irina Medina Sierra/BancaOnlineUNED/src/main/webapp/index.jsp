<%@page import="es.uned.master.java.bancaonlineuned.controlador.Controlador.*" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<jsp:include page="vista/header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
    <title>Banca Online</title>

</head>
<body>
<!-- *************** LLAMADA AL ARCHIVO HEADER ***************   -->


<!-- *************** FORMULARIO DE ALTA PASO 1 ***************
Se solicita el dni, telefono e email. El controlador lee
estos datos y valida que el formato es correcto, los guarda
en un XXX y si es correcto va al 2do. Paso, de lo contrario
indica los errores cometidos por el usuario
*****************************************************************-->

<section>
    <div class="container">
        ${mensaje}
        <!-- Div que indica los pasos al usuario -->
        <div class="row">
            <div class="col-12 text-white text-center negro" style="padding: 50px">
                <span style="color: #ffb500;">1</span> <span class="material-icons">arrow_forward</span> 2 <span class="material-icons">arrow_forward</span> 3
            </div>
        </div>
        <!-- Titulo de la pagina, para ir indicando  como va el proceso -->
        <div class="row bg-white py-4 text-center">
            <p class="h1"><strong>¡Comencemos!</strong></p>
            <p class="h4">Por favor necesitamos estos datos para iniciar tu proceso de alta:</p>
        </div>
        <!--  Formulario que llama leerdatos para validar y guardar-->
        <form action="Controlador" method="POST" class="needs-validation" novalidate>
            <div class="row bg-white p-5">
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="text" name="dni" id="dni" placeholder="DNI" maxlength="9" class="form-control border-0 border-bottom text-uppercase"  pattern="[0-9]{8}[A-Za-z]{1}" title="Debe poner 8 números y una letra" required>
                    <div class="text-muted ps-2 subtexto">00000000A</div>
                </div>
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="tel" name="movil" id="movil" placeholder="TELÉFONO MÓVIL" maxlength="9" class="form-control  border-0 border-bottom" pattern="^[9|8|7|6]\d{8}$" required>
                    <div class="text-muted ps-2 subtexto">000000000</div>
                </div>
            </div>
            <div class="row bg-white p-5">
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="email" name="email1" id="email1" placeholder="EMAIL" class="form-control border-0 border-bottom text-lowercase" required>
                    <div class="text-muted ps-2 subtexto">usuario@dominio.ext</div>
                </div>
                <div class="col-lg-6 col-md-12 p-3">
                    <input type="email" name="email2" id="email2" placeholder="CONFIRMA TU EMAIL" class="form-control  border-0 border-bottom text-lowercase" required>
                    <div class="text-muted ps-2 subtexto">usuario@dominio.ext</div>
                </div>
            </div>
            <div class="row bg-white d-flex justify-content-center p-3">
                <input type="reset" name="limpiar" id="limpiar" class="col-2 btn boton text-white mx-2" value="Limpiar">
                <input type="submit" name="submit" id="submit" class="col-2 btn boton text-white mx-2" value="Siguiente">
            </div>
        </form>
    </div>
</section>
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