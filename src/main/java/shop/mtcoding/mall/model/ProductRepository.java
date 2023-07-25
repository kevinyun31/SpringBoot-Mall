package shop.mtcoding.mall.model;

import org.qlrm.mapper.JpaResultMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository // 컴퍼넌트 스캔
public class ProductRepository {
    // 프로덕트 저장소 Entity를 해준다
    @Autowired
    private EntityManager em;

       public Product findByIdJoinSeller(int id){
       Query query = em.createNativeQuery("SELECT * from product_tb pt INNER JOIN seller_tb st on pt.seller_id = st.id where pt.id = :id",Product.class);
       query.setParameter("id",id);
       Product product = (Product) query.getSingleResult();
       return product;
       }

    @Transactional
    public void saveWithFK(String name, int price, int qty, int sellerId) {
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty, seller_id) values(:name, :price, :qty, :sellerId)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.setParameter("sellerId", sellerId);
        query.executeUpdate();
    }

    public ProductDTO findByIdDTO(int id) {
        Query query = em.createNativeQuery("select id, name, price ,qty, '설명' des from product_tb where id = :id");
        query.setParameter("id", id);

        JpaResultMapper mapper = new JpaResultMapper();
        ProductDTO productDTO = mapper.uniqueResult(query, ProductDTO.class);

        return productDTO;
    }

    @Transactional
    public void save(String name, int price, int qty, String des) {
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty, des) values(:name, :price, :qty, :des)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.setParameter("des", des);
        query.executeUpdate();
    }

    public List<Product> findAll() {
        Query query = em.createNativeQuery("select * from product_tb", Product.class);
        List<Product> productList = query.getResultList();
        return productList;
    }

    public Product findById(int id) {
        Query query = em.createNativeQuery("select * from product_tb where id = :id", Product.class);
        query.setParameter("id", id);
        Product product = (Product) query.getSingleResult();
        return product;
    }

    // 위의 findById를 풀어서 적으면 이렇다. 위에선 Product.class 끝에 이거넣고 간단히 해결된다.
    public Product findById2(int id) {
        Query query = em.createNativeQuery("select * from product_tb where id = :id");
        query.setParameter("id", id);
        // row가 1건
        // 1, 바나나, 1000, 50
        Object[] object = (Object[]) query.getSingleResult();
        int id2 = (int) object[0];
        String name2 = (String) object[1];
        int price2 = (int) object[2];
        int qty2 = (int) object[3];

        Product product = new Product();
        product.setId(id2);
        product.setName(name2);
        product.setPrice(price2);
        product.setQty(qty2);
        return product;
    }

    @Transactional // spring 트랜젝션(임포트 주의)
    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from product_tb where id = :id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

    @Transactional // spring 트랜젝션(임포트 주의)
    public void upDateById(int id, String name, int price, int qty, String des) {
        Query query = em.createNativeQuery("update product_tb set id = :id, name = :name, price = :price, qty = :qty, des = :des where id = :id");
        query.setParameter("id", id);
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.setParameter("des", des);
        query.executeUpdate();
    }



}