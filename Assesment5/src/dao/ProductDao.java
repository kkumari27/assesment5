package dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import model.Product;
public class ProductDao {
	private EntityManagerFactory emf;
	public void create(Product p) {
		emf=HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(p);
		em.getTransaction().commit();
	}
	public List<Product> findAll() {
		emf= HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();

		List<Product> product = em.createQuery("select p from Product p", Product.class).getResultList();

		return product;
	}
	public void delete(int id) {
		emf = HibernateOGMUtil.getEntityManagerFactory();

		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.remove(em.find(Product.class, id));
		
		em.getTransaction().commit();
	}
	public Product update(int id, String name, String description,int price,int quantity) {
		emf=HibernateOGMUtil.getEntityManagerFactory();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		Product p=em.find(Product.class, id);
		p.setName(name);
		p.setDescription(description);
		p.setPrice(price);
		p.setQuantity(quantity);
		em.getTransaction().commit();
		return p;
	}
}

