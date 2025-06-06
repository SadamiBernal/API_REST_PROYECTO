package mx.unam.aragon.ico.ia.luchadoresapi;

import mx.unam.aragon.ico.ia.luchadoresapi.entities.Luchador;
import mx.unam.aragon.ico.ia.luchadoresapi.respositories.LuchadorRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
@Disabled
@SpringBootTest
class LuchadoresapiApplicationTests {
	@Autowired
	private LuchadorRepository luchadorRepository;

	@Test
	void contextLoads() {
	}
	@Test
	void insetarLuchador() {
		Luchador luchador1 = new Luchador(null, "triple h", 38, null, "Smackdown");
		luchadorRepository.save(luchador1);
	}
	@Test
	void leerLuchadorPorClave() {
		Long claveTmp=1l;
		Luchador tmp = luchadorRepository.findLuchadorByClave(claveTmp);
		System.out.println(tmp);
	}
	@Test
	public void eliminarLuchador() {
		Long claveTmp=1l;
		luchadorRepository.deleteById(claveTmp);
	}
	@Test
	public void actualizarLuchador() {
		Long claveTmp=2l;
		Luchador tmp = luchadorRepository.findLuchadorByClave(claveTmp);
		tmp.setNombre("Undertaker");
		luchadorRepository.save(tmp);
	}
}
