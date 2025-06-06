package mx.unam.aragon.ico.ia.luchadoresapi.controllers;

import mx.unam.aragon.ico.ia.luchadoresapi.entities.Luchador;
import mx.unam.aragon.ico.ia.luchadoresapi.respositories.LuchadorRepository;
import mx.unam.aragon.ico.ia.luchadoresapi.services.interfaces.LuchadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Iterator;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/luchadores")
public class LuchadorRestController {
    @Autowired
    private LuchadorService luchadorService;

    @GetMapping("/")
    public ResponseEntity<Iterable<Luchador>> getLuchador() {
        return new ResponseEntity<>(luchadorService.Listar(), HttpStatus.OK);

    }
    @GetMapping("/{clave}")
    public ResponseEntity<Luchador> getLuchadorPorClave(@PathVariable Long clave) {
        Optional<Luchador> tmp  =  luchadorService.buscarPorId(clave);
        if(tmp.isPresent()){
            return new ResponseEntity<>(tmp.get(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<Luchador> createLuchador(@RequestBody Luchador luchador) {
        return new ResponseEntity<>(luchadorService.crear(luchador), HttpStatus.CREATED);
    }

    @PostMapping("/{clave}")
    public ResponseEntity<String> noExisteLuchador() {
        return new ResponseEntity<>("End point no soportado", HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clave}")
    public ResponseEntity<Luchador> actuaizarParcialLuchador(@PathVariable Long clave, @RequestBody Luchador luchador) {
        Luchador tmp = luchadorService.buscarPorId(clave).orElse(null);
        if(tmp != null){
            if(luchador.getNombre() != null) tmp.setNombre(luchador.getNombre());
            if(luchador.getEdad() != null) tmp.setEdad(luchador.getEdad());
            if(luchador.getMarca() != null) tmp.setMarca(luchador.getMarca());
            if(luchador.getFoto() != null) tmp.setFoto(luchador.getFoto());
            return new ResponseEntity<>(luchadorService.actualizar(clave, tmp), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PutMapping("/{clave}")
    public ResponseEntity<Luchador> actualizarLuchador(@PathVariable Long clave, @RequestBody Luchador luchador) {
        Optional tmp= luchadorService.buscarPorId(clave);

        if (tmp.isPresent()) {
            return new ResponseEntity<>(luchadorService.actualizar(clave, luchador), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{clave}")
    public ResponseEntity<Luchador> eliminarLuchador(@PathVariable Long clave) {
        Luchador tmp = luchadorService.eliminar(clave);
        if (tmp != null) {
            return new ResponseEntity<>(tmp, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }






}
