package posjavamavenhibernate;

import org.junit.Test;

import dao.GenericDao;
import model.Usuario;

public class HibernateUtilTest {
	
	@Test
	public void testeHibernateUtil() {
		GenericDao<Usuario> daoGenerico = new GenericDao<Usuario>();
		
		Usuario usuario = new Usuario("Joao", "Augusto", "joao@email.com", "senha123");
		
		daoGenerico.salvar(usuario);
	}
			
}
