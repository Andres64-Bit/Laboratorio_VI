package biblioteca_api.controller;

import biblioteca_api.model.Libro;
import biblioteca_api.service.LibroService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
@RequestMapping("/api/libros")

public class LibroController {

    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping
    public Libro registrarLibro(@RequestBody Libro libro) {
        return libroService.registrarLibro(libro);
    }

    @GetMapping
    public List<Libro> listarLibros() {
        return libroService.listarLibros();
    }

    @GetMapping("/{id}")
    public Libro obtenerLibroPorId(@PathVariable Long id) {
        return libroService.obtenerLibroPorId(id);
    }
}