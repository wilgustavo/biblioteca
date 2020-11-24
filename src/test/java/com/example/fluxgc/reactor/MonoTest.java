package com.example.fluxgc.reactor;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class MonoTest {

    @Test
    void pruebaBlock() {

        var saludo = Mono.just("Hola");
        assertThat(saludo.block(), equalTo("Hola"));

    }

    @Test
    void pruebaMap() {
        var cliente = crearCliente("123", "Cosme", "7500");
        cliente.subscribe(System.out::println);
    }

    private Mono<Cliente> crearCliente(String id, String nombre, String ciudadId) {
        return consultarCiudad(ciudadId)
                .map(ciudad -> new Cliente(id, nombre, ciudad));
    }

    private Mono<Ciudad> consultarCiudad(String id) {
        if(id.equals("0")) {
            return Mono.error(new IllegalArgumentException("No puede ser cero"));
        }
        return Mono.just(new Ciudad(id, "Aqui"));
    }


}

@Data
@AllArgsConstructor
class Ciudad {
    private String id;
    private String nombre;
}

@Data
@AllArgsConstructor
class Cliente {
    private String id;
    private String nombre;
    private Ciudad ciudad;
}
