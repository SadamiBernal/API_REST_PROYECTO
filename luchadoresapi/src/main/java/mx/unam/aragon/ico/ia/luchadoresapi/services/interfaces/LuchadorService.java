package mx.unam.aragon.ico.ia.luchadoresapi.services.interfaces;

import mx.unam.aragon.ico.ia.luchadoresapi.entities.Luchador;

import java.util.Optional;

public interface LuchadorService {
    public abstract Optional<Luchador> buscarPorId(Long id);
    public abstract Iterable<Luchador> Listar();
    public abstract Luchador crear(Luchador luchador);
    public abstract Luchador actualizar(Long id, Luchador luchador);
    public abstract Luchador eliminar(Long id);
}
