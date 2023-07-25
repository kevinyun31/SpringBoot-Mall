package shop.mtcoding.mall.model;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.annotation.Rollback;

import java.util.List;


//@Rollback(false) // 메서드 종료시마다 롤백안하기
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 진짜 디비로 테스트
@Import({ProductRepository.class,
        SellerRepository.class
}) // 두개 이상의 클래스를 임포트에 합치는 공식


//필요한 것만 메모리에 올려서 확인 하는것
@DataJpaTest  // T -> DS -> C -> (R -> DB) (톰캣, 디에스, 컨트롤러, R, 디비)
public class ProductRepositoryTest {

    @Autowired // new 자동으로 해옴
    private ProductRepository productRepository;
    @Autowired // new 자동으로 해옴
    private SellerRepository sellerRepository;


    @Test
    public void findByIdJoinSeller_test() {
        //given (테스트를 하기 위해서 필요한 데이터 만들기)
        sellerRepository.save2("kevin","kevin@nate.com");
        productRepository.saveWithFK("사과", 3000, 50, 1);

        //when (테스트 진행)
        Product product = productRepository.findByIdJoinSeller(1);

        //then (테스트 확인)
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
        System.out.println("------- " + product.getSeller().getId());
        System.out.println("------- " + product.getSeller().getName());
        System.out.println("------- " + product.getSeller().getEmail());

    }

    @Test
    public void findByIdDTO_test() {
        //given (테스트를 하기 위해서 필요한 데이터 만들기)
        productRepository.save("바나나", 5000, 50, "설명");

        //when (테스트 진행)
        ProductDTO productDTO = productRepository.findByIdDTO(1);
        System.out.println(productDTO.getId());
        System.out.println(productDTO.getName());
        System.out.println(productDTO.getPrice());
        System.out.println(productDTO.getQty());
        System.out.println(productDTO.getDes());
    }

    @Test
    public void findById_test() {
        //given (테스트를 하기 위해서 필요한 데이터 만들기)
        productRepository.save("바나나", 5000, 50, "설명");

        //when (테스트 진행)
        Product product = productRepository.findById(1);

        //then (테스트 확인)
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println(product.getQty());
    }

    @Test
    public void findAll_test() {
        //given (테스트를 하기 위해서 필요한 데이터 만들기)
        productRepository.save("바나나", 5000, 50, "설명");
        productRepository.save("딸기", 5000, 50, "설명");

        //when (테스트 진행)
        List<Product> productList = productRepository.findAll();

        //then (테스트 확인)
        for (Product product : productList) {
            System.out.println("============");
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            System.out.println(product.getQty());
        }
    }

} // class
