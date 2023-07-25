package shop.mtcoding.mall.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.mall.model.Product;
import shop.mtcoding.mall.model.ProductDTO;
import shop.mtcoding.mall.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    // findByIdJoinSeller를 만들어서 뷰에 쏘아보자.



    @ResponseBody
    @GetMapping("/test")
    public ProductDTO test(){
        ProductDTO productDTO = productRepository.findByIdDTO(3); //findByTest(3); 강사님 깃헙엔 이래 되있음.
        return productDTO;
    }

    // 수정값 입력하기
    @PostMapping("/product/update")
    public String update(int id, String name, int price, int qty, String des) {
        System.out.println(id);
        System.out.println(name);
        System.out.println(price);
        System.out.println(qty);
        System.out.println(des);
        productRepository.upDateById(id, name, price, qty, des);
        return "redirect:/"; //콘트롤러의 메서드를 재호출하는 방법 = (리퀘스트)
    }

    // 삭제 입력하기.
    @PostMapping("/product/delete")
    public String delete(int id) {
        productRepository.deleteById(id);         // 세션은 브라우저가 다닫히면 사라진다.
//        HttpSession session = request.getSession();  // 리퀘스트를 통해 세션에 접근만 한다. 서버측 저장소.
//        session.setAttribute("info", "삭제잘됐음");
        return "redirect:/"; //콘트롤러의 메서드를 재호출하는 방법 = (리퀘스트)
    }

    // 상세값 확인하기
    @GetMapping("/product/{id}")
    public String detail(@PathVariable int id, HttpServletRequest request) throws IOException {
        // 경로 변수인 id를 출력합니다.
        //System.out.println("id : " + id);
        // productRepository를 사용하여 해당 id에 해당하는 Product를 가져옵니다.
        Product product = productRepository.findById(id);
        request.setAttribute("p", product);
        // Product 객체의 속성을 출력합니다.
        //System.out.println(product.getId());
        //System.out.println(product.getName());
        //System.out.println(product.getPrice());
        //System.out.println(product.getQty());
        // Product 객체를 "p"라는 이름으로 HttpServletRequest의 속성으로 설정합니다.
        // 이렇게 하면 view 페이지에서 "p"라는 이름으로 Product 객체에 접근할 수 있습니다.
        request.setAttribute("p", product);
        // "detail"이라는 뷰 페이지를 반환합니다.
        // 이것은 뷰 리졸버에 의해 실제 뷰 페이지로 매핑됩니다.
        return "detail";
    }

    // 기본 확인하기
    @GetMapping("/") // ViewResolver 클래스 발동 webapp/WEB-INF/views/home.jsp
    public String home(HttpServletRequest request) {
        List<Product> productList = productRepository.findAll();
        request.setAttribute("productList", productList);

        return "home";
    }

    // 입력값 확인하기
    @GetMapping("/write") // ViewResolver 클래스 발동 webapp/WEB-INF/views/write.jsp
    public String writepage() {
        return "write";
    }

    // 기본값 입력하기
    @PostMapping("/product") // ViewResolver 클래스 발동 webapp/WEB-INF/views/write.jsp
    public void write(String name, int price, int qty, String des, HttpServletResponse response) throws IOException {
        System.out.println("name : " + name);
        System.out.println("privce : " + price);
        System.out.println("qty : " + qty);
        System.out.println("des : " + des);

        productRepository.save(name, price, qty, des);

        // 콘트롤러의 메서드를 재호출하는 방법 = (리퀘스트)
        response.sendRedirect("/");
        //return "redirect:/";
    }

    // 기본값 입력하기
    @PostMapping("/seller") // ViewResolver 클래스 발동 webapp/WEB-INF/views/write.jsp
    public void write(String name, String email, HttpServletResponse response) throws IOException {
        System.out.println("name : " + name);
        System.out.println("email : " + email);

        //productRepository.save2(name, email);

        // 콘트롤러의 메서드를 재호출하는 방법 = (리퀘스트)
        response.sendRedirect("/");
        //return "redirect:/";
    }
}