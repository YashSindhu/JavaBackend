package com.hibernate_product;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.producthibernate.Product;
import com.producthibernate.ProductDao;

public class ProductDaoTest {

	// emf
	// em
	// et
	static EntityManagerFactory emf;
	EntityManager em;

	@BeforeAll
	public static void initEmf() {
		emf = Persistence.createEntityManagerFactory("postgres");
	}

	@BeforeEach
	public void initEm() {
		em = emf.createEntityManager();
	}

	@Test
	public void insertProductTest() {
		System.out.println("Product Insert");
		ProductDao dao = new ProductDao();
		Product product = new Product();
		product.setId(2);
		product.setName("Pencil");
		product.setPrice(5);
		String actualRes = dao.insertProduct(product);
		assertEquals("Product inserted successfully.",actualRes);

	}
	
	@Test
	public void insertProductTestNull() {
		ProductDao dao = new ProductDao();
		String actualRes = dao.insertProduct(null);
		assertEquals("Illegal Argument",actualRes);
		
	}

	@Test
	public void findByIdTest() {
		System.out.println("Product Find");
		ProductDao dao = new ProductDao();
		Product p = dao.findProduct(1);
		assertNotNull(p);
	}
	
	@Test
	public void findByIdTestException() {
		ProductDao dao = new ProductDao();
		assertThrows(IllegalArgumentException.class,()->dao.findProduct(101));
	}
	
//	@Test
//	public void deleteByIdTest() {
//		ProductDao dao= new ProductDao();
//		String res = dao.deleteProduct(2);
//		assertEquals("Product deleted successfully.",res);
//	}
//	
//	@Test
//	public void deleteByIdTestNotExist() {
//		ProductDao dao= new ProductDao();
//		String res = dao.deleteProduct(1);
//		assertEquals("Product not found.",res);
//	}

//	@Test
//	public void deleteProductTest() {
//		System.out.println("Product Delete Test");
//
//		ProductDao dao = new ProductDao();
//
//		Product product = new Product();
//		product.setId(10);
//		product.setName("Pen");
//		product.setPrice(20);
//
//		dao.insertProduct(product);
//
//		dao.deleteProduct(10);
//
//		Product p = dao.findProduct(10);
//		assertNull(p);
//	}

	@AfterEach
	public void destroyEm() {
		em.close();
	}

	@AfterAll
	public static void destryEmf() {
		emf.close();
	}
}