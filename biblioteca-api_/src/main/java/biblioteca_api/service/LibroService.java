package biblioteca_api.service;

import biblioteca_api.model.Libro;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.server.ResponseStatusException;

@Service
public class LibroService {

    private final List<Libro> libros = new ArrayList<>();

    private Long siguienteId = 1L;

    public Libro registrarLibro(Libro libro) {

        libro.setId(siguienteId);
        siguienteId++;
        libros.add(libro);

        return libro;
    }

    public List<Libro> listarLibros() {
    return libros;
    }

    public Libro obtenerLibroPorId(Long id) {

        for (Libro libro : libros) {

            if (libro.getId().equals(id)) {
            return libro;
            }
        }

        throw new ResponseStatusException(
            HttpStatus.NOT_FOUND,
            "Libro no encontrado"
        );
    }
}
