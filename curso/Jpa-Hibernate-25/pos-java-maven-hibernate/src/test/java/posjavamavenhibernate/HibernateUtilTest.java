package posjavamavenhibernate;

import java.util.List;

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
	
	@Test
	public void testePesquisar() {
		GenericDao<Usuario> daoGenerico = new GenericDao<Usuario>();
		
		Usuario usuario = new Usuario();
		
		usuario = daoGenerico.findById(1L, usuario);
		
		System.out.println(usuario);
	}
	
	@Test
	public void testeUpdate() {
		GenericDao<Usuario> daoGenerico = new GenericDao<Usuario>();
		
		Usuario usuario = new Usuario();
		
		usuario = daoGenerico.findById(1L, usuario);
		
		usuario.setNome("Joaquin Ribeiro");
		
		usuario = daoGenerico.updateMerge(usuario);
		
		System.out.println(usuario);
	}
	
	@Test
	public void testDelete() {
		GenericDao<Usuario> daoGenerico = new GenericDao<Usuario>();
		
		Usuario usuario = new Usuario();
		
		usuario = daoGenerico.findById(1L, usuario);
		
		daoGenerico.delete(usuario);
	}
	
	@Test
	public void testFindAll() {
		GenericDao<Usuario> daoGenerico = new GenericDao<Usuario>();
		List<Usuario> usuarios = daoGenerico.findAll(Usuario.class);
		usuarios.forEach(System.out::println);
	}
			
}
