# **Tienda de suministros**

Imagina un establecimiento cuya actividad principal es el alquiler de maquinaria industrial de limpieza y obra. No obstante, si algún cliente está interesado, también se los vende. Dado que estas herramientas pasan por muchas manos se requiere un mantenimiento de los mismos que se realiza en las propias instalaciones de la empresa.

Siempre trabaja con tres categorías de patinetes que se compran a un precio fijo, aunque distinto para cada una de ellas, y se alquilan por días:

Las categorías son: LIMPIEZA, OBRA y PINTURA

Los ingresos provienen de:

    Alquiler. El precio del alquiler es variable en función de la categoría:
        LIMPIEZA: 10€/día
        OBRA: 15€/día
        PINTURA: 12€/día
    Venta. Si alguien está interesado, se venden por el precio resultante de aplicar la siguiente fórmula:
        PrecioDeCompra - (AntiguedadEnMeses * 10) - (SumaDe (PrecioDeCadaReparacion - DiasDesdeLaReparacion * 0.2)) - (Desgaste * 0.02)
        No obstante, una herramienta nunca se venderá, independientemente de la fórmula anterior, por un precio inferior a:
            LIMPIEZA: 50€
            OBRA: 75€
            PINTURA: 100€

Los gastos se generan por:

    Reparaciones. Cuando un patinete se estropea lo reparamos y se valora el precio de dicha reparación como una gasto más del negocio.
    Compras. El precio de compra es variable en función de la categoría:
        LIMPIEZA: 600€
        OBRA: 1000€
        PINTURA: 800€

A cada herramienta se le asignará como número de referencia una cadena que estará compuesta por la categoría (LIMPIEZA, OBRA, PINTURA), el año de adquisición con cuatro dígitos y un número de orden de 5 dígitos que se reiniciará por cada año y categoría. Los números de referencia son únicos y no se pueden rehusar, incluso aunque el patinete se haya vendido.

Vamos a realizar una pequeña aplicación en java para la gestión de la tienda.

Básicamente se debe realizar las siguientes operaciones:

    Comprar. Nunca se podrá disponer de más de 99999 herramientas por cada categoría y año. Se anota el gasto que genera la compra de la misma.
    Vender. Solo se puede vender una herramienta si no está alquilada ni ya vendida. Se anota a qué precio ha sido vendido según la fórmula anteriormente expuesta.
    Alquilar. Sólo se puede alquilar los que estén disponibles, o sea, ni alquilado ni vendido.
    Devolver. El cliente devuelve una herramienta alquilada y este pasa a estar disponible, anotando los ingresos que ha generado el alquiler.
    Reparar. Una herramienta necesita mantenimiento, se valora el precio de la reparación y se anota el coste de la reparación.
    Ver estado. Se genera un listado con el estado en que se encuentra cada herramienta: DISPONIBLE, ALQUILADO, ENREPARACION.
    Estadísticas. Se podrán solicitar las siguientes:
        Balance General de la Tienda
        Balance de una herramienta en particular
        Historial de una herramienta

A lo largo de estos días os iré dejando pistas de como abordarlo y usaremos el foro para poder entrar en la visualización del ejercicio.