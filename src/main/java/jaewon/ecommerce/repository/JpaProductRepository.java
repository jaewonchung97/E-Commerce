package jaewon.ecommerce.repository;

import jaewon.ecommerce.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * Repository Bean
 */
@Repository
@Transactional
public class JpaProductRepository implements ProductRepository {

    /**
     * Entity Manager 접근
     */
    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    /**
     * Product Insert or Update
     */
    @Override
    public Long save(Product product) {
        em.persist(product);
        return findByName(product.getName()).orElseThrow(() -> new NoSuchElementException("Create or Update Failed")).getId();
    }

    /**
     * Select Product by ID
     */
    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    /**
     * Select Products by Category
     */
    @Override
    public Optional<List<Product>> findByCategory(String title) {
        List<Product> productList = em.createQuery("select p from product as p where p.category = :category", Product.class)
                .setParameter("category", title)
                .getResultList();
        return Optional.ofNullable(productList);
    }

    /**
     * Select All Products
     */
    @Override
    public Optional<List<Product>> findAll() {
        return Optional.ofNullable(em.createQuery("select p from product as p", Product.class)
                .getResultList());
    }

    /**
     * Select Product by Name
     */
    @Override
    public Optional<Product> findByName(String name) {
        List<Product> product = em.createQuery("select p from product p where p.name=:name", Product.class)
                .setParameter("name", name)
                .getResultList();
        return product.stream().findAny();
    }
}
