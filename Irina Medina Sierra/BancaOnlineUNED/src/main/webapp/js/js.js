// Validación del lado del cliente para que el formulario no este vacio
// Lee todos los selectores dentro del formulario
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
