package jaewon.ecommerce.repository;

import jaewon.ecommerce.domain.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class JpaProductRepository implements ProductRepository {
    private final EntityManager em;

    public JpaProductRepository(EntityManager em) {
        this.em = em;
    }

    @Override
    public Product save(Product product) {
        em.persist(product);
        return product;
    }

    @Override
    public Optional<Product> findById(Long id) {
        Product product = em.find(Product.class, id);
        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> findByCategory(String title) {
        return "all".equals(title) ? findAll() : em.createQuery("select p from product as p where p.category = :category", Product.class)
                .setParameter("category", title)
                .getResultList();
    }

    @Override
    public List<Product> findAll() {
        return em.createQuery("select p from product as p", Product.class)
                .getResultList();
    }
}
