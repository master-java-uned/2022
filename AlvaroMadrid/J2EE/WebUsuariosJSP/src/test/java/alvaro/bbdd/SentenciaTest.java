package alvaro.bbdd;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SentenciaTest {

    @Test
    void generaSentenciaTest(){

        String expected = "INSERT INTO registro_usuarios.usuarios (Nombre, Apellido, Usuario, Contrasena, Pais, Tecnologia) VALUE ('Alvaro','Madrid','amadridg','123123','España','Java');";
        String actual = Sentencia.generaSentencia("Alvaro", "Madrid", "amadridg", "123123", "España", "Java");

        assertEquals(expected, actual);
    }
}
