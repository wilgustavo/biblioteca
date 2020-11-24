package com.example.fluxgc.web;

import com.example.fluxgc.domain.AutorRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@Log4j2
public class AutorController {

    private final AutorRepository autorRepository;

    public AutorController(AutorRepository autorRepository) {
        this.autorRepository = autorRepository;
    }

    @PostMapping("/autores")
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<Void> crearAutor(@RequestBody AutorDto autor) {
        log.info("Se ha creado el autor {}", autor);
        return autorRepository.save(autor.toDomain()).then(Mono.empty());
    }

}
