package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import posjavamavenhibernate.HibernateUtil;

public class GenericDao<T extends Object> {
	
	private EntityManager entityManager = HibernateUtil.getEntityManager();
	
	public void salvar(T entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(entidade);
		transaction.commit();
	}
		
	@SuppressWarnings("unchecked")
	public T findById(Long id, T entidade) {
		return (T) entityManager.find(entidade.getClass(), id);
	}
	
	/**
	 * Salva ou atualiza
	 * @param entidade
	 */
	public T updateMerge(T entidade) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		T e = entityManager.merge(entidade);
		transaction.commit();
		return e;
	}
	
	public void delete(T entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.remove(entity);
		transaction.commit();
	}
	
	public List<T> findAll(Class<T> entity) {
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		List<T> list = entityManager.createQuery("from " + entity.getName()).getResultList();
		return list;
	}
	
	
}
