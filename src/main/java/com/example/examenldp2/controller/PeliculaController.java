package com.example.examenldp2.controller;

import com.example.examenldp2.dto.*;
import com.example.examenldp2.entity.*;
import com.example.examenldp2.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/peliculas")
@RequiredArgsConstructor
public class PeliculaController {

    private final PeliculaRepository peliculaRepository;
    private final DirectorRepository directorRepository;
    private final GeneroRepository generoRepository;
    private final PeliculaGeneroRepository peliculaGeneroRepository;

    @PostMapping("/con-generos")
    @Transactional
    public ResponseEntity<ResponseDTO> crear(@RequestBody RequestDTO req) {

        Director director = directorRepository.findById(req.getDirectorId())
                .orElseThrow(() -> new RuntimeException("Director no encontrado"));

        Pelicula p = new Pelicula();
        p.setTitulo(req.getTitulo());
        p.setAnyoEstreno(req.getAnyoEstreno());
        p.setDuracionMinutos(req.getDuracionMinutos());
        p.setDirector(director);
        p = peliculaRepository.save(p);

        for (UUID genId : req.getGeneroIds()) {
            Genero g = generoRepository.findById(genId)
                    .orElseThrow(() -> new RuntimeException("Género no encontrado"));
            PeliculaGenero pg = new PeliculaGenero();
            pg.setPelicula(p);
            pg.setGenero(g);
            peliculaGeneroRepository.save(pg);
        }

        ResponseDTO res = new ResponseDTO();
        res.setId(p.getId());
        res.setTitulo(p.getTitulo());
        res.setMensaje("¡Pelicula creada con éxito!");

        return ResponseEntity.status(HttpStatus.CREATED).body(res);
    }
    @GetMapping("/setup")
    public ResponseEntity<String> setupRapido() {
        Director d = new Director();
        d.setNombre("Nolan");
        d = directorRepository.save(d);

        Genero g = new Genero();
        g.setNombre("Accion");
        g = generoRepository.save(g);

        String json = "{\n" +
                "  \"titulo\": \"Batman\",\n" +
                "  \"anyoEstreno\": 2008,\n" +
                "  \"duracionMinutos\": 152,\n" +
                "  \"directorId\": \"" + d.getId() + "\",\n" +
                "  \"generoIds\": [\n" +
                "    \"" + g.getId() + "\"\n" +
                "  ]\n" +
                "}";
        return ResponseEntity.ok(json);
    }
    @GetMapping
    public ResponseEntity<List<Pelicula>> listarTodas() {
        return ResponseEntity.ok(peliculaRepository.findAll());
    }
}