package shop.mtcoding.mall.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.swing.text.html.parser.Entity;
import java.util.List;

@Repository
public class SellerRepository {       // 판매자 테이블 SQL에 직접 자바로 쿼리값 입력.

    @Autowired
    private EntityManager em;

    @Transactional
    public void save2(String name, String email) {
        Query query = em.createNativeQuery("insert into seller_tb(name, email) values (:name, :email)");
        query.setParameter("name", name);
        query.setParameter("email", email);
        query.executeUpdate();
    } // save

    public List<Seller> findAll() {
        Query query = em.createNativeQuery("select * from seller_tb", Seller.class);
        List<Seller> sellerList = query.getResultList();
        return sellerList;
    } // list<Product> findAll



} // class
