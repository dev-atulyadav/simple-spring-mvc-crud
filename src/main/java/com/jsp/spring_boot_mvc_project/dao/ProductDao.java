package com.jsp.spring_boot_mvc_project.dao;

/**
 * @author Atul
 */

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Repository;

import com.jsp.spring_boot_mvc_project.dto.Product;

@Repository
public class ProductDao {

	EntityManager entityManager = Persistence.createEntityManagerFactory("spring").createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	public Product saveProductDao(Product product) {
		entityTransaction.begin();
		entityManager.persist(product);
		entityTransaction.commit();
		return product;
	}

	@SuppressWarnings("unchecked")
	public List<Product> getAllProduct() {
		return entityManager.createQuery("from Product").getResultList();
	}

	public Product getProdutById(int id) {
		return entityManager.find(Product.class, id);
	}

	public Product updateProductById(Product product) {
		Product p = getProdutById(product.getId());
		if (p != null) {
			entityTransaction.begin();
			entityManager.merge(product);
			entityTransaction.commit();
			return product;
		}
		return null;
	}
	public void deleteProductById(int id) {
		Product product = getProdutById(id);
		if(product!=null) {
			entityTransaction.begin();
			entityManager.remove(product);
			entityTransaction.commit();
		}
	}

}
