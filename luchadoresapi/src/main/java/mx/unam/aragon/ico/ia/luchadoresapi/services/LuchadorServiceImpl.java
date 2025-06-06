package mx.unam.aragon.ico.ia.luchadoresapi.services;

import mx.unam.aragon.ico.ia.luchadoresapi.entities.Luchador;
import mx.unam.aragon.ico.ia.luchadoresapi.respositories.LuchadorRepository;
import mx.unam.aragon.ico.ia.luchadoresapi.services.interfaces.LuchadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LuchadorServiceImpl implements LuchadorService {
    @Autowired
    private LuchadorRepository luchadorRepository;

    @Override
    public Optional<Luchador> buscarPorId(Long id) {
        return luchadorRepository.findById(id);
    }

    @Override
    public Iterable<Luchador> Listar() {
        return luchadorRepository.findAll();
    }

    @Override
    public Luchador crear(Luchador luchador) {
        return luchadorRepository.save(luchador);
    }

    @Override
    public Luchador actualizar(Long id, Luchador luchador) {
        Optional<Luchador> luchadorActualizada = luchadorRepository.findById(id);
        if (luchadorActualizada.isPresent()) {
            Luchador luchadortmp = luchadorActualizada.get();
            luchadortmp.setNombre(luchador.getNombre());
            luchadortmp.setEdad(luchador.getEdad());
            luchadortmp.setFoto(luchador.getFoto());
            luchadortmp.setMarca(luchador.getMarca());
            return luchadorRepository.save(luchadortmp);
        }else{
            return null;
        }
    }

    @Override
    public Luchador eliminar(Long id) {
        Optional<Luchador> luchadorActual = luchadorRepository.findById(id);
        if (luchadorActual.isPresent()) {
            luchadorRepository.deleteById(id);
            return luchadorActual.get();
        }else {
            return null;
        }
    }
}
