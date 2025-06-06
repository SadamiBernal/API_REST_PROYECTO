package mx.unam.aragon.ico.ia.luchadoresapi.respositories;

import mx.unam.aragon.ico.ia.luchadoresapi.entities.Luchador;
import org.springframework.data.repository.CrudRepository;

public interface LuchadorRepository extends CrudRepository<Luchador, Long> {

    public Luchador findLuchadorByClave(Long clave);
}
