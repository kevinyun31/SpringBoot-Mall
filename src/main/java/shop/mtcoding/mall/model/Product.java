package shop.mtcoding.mall.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@Table(name = "product_tb")
@Entity
public class Product {    //pk 연관관계의 주인
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer price; // 가격
    private Integer qty;  // 재고
    private String des;  // 상품설명

    //pk 만드는 공식
    @ManyToOne
    private Seller seller;

   }
