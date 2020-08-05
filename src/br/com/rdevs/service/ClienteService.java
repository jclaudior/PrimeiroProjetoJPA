package br.com.rdevs.service;

import javax.persistence.EntityManager;

import br.com.rdevs.dao.CrudEntityManager;
import br.com.rdevs.entity.ClienteEntity;


public class ClienteService {
	
	EntityManager em = null;
	
	public ClienteService() {
		em = CrudEntityManager.getEntityManager();
	}
	
	public void inserir(ClienteEntity cliente) {
		em.getTransaction().begin();
		em.persist(cliente);
		em.getTransaction().commit();
	}
	
	public ClienteEntity burcarPorId (int id) {
		ClienteEntity cliente = em.find(ClienteEntity.class, id);
		return cliente;
	}
	
	public void atualizar(ClienteEntity cliente) {
		em.getTransaction().begin();
		em.merge(cliente);
		em.getTransaction().commit();
	}
	
	public void deletar (int id) {
		ClienteEntity cliente = this.burcarPorId(id);
		if(cliente != null) {
			em.getTransaction().begin();
			em.remove(cliente);
			em.getTransaction().commit();
		}
	}
}
