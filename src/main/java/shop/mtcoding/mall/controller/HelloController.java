package shop.mtcoding.mall.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hello")
    public String hello(HttpServletRequest request){
        // "홍길동"이라는 문자열을 "price"라는 이름으로 HttpServletRequest의 속성으로 설정합니다.
        String name = "홍길동";
        request.setAttribute("price", name);


        // "바나나", "딸기", "참외"를 각각 "banana", "ddalgi", "chamwei"라는 이름으로 HttpServletRequest의 속성으로 설정합니다.
        ArrayList<String> list = new ArrayList<>();
        list.add("바나나");
        list.add("딸기");
        list.add("참외");

        request.setAttribute("banana", list.get(0));
        request.setAttribute("ddalgi", list.get(1));
        request.setAttribute("chamwei", list.get(2));
        // "list"라는 이름으로 ArrayList를 HttpServletRequest의 속성으로 설정합니다.
        request.setAttribute("lost", list);


        // "hello"라는 뷰 페이지를 반환합니다.
        // 이것은 뷰 리졸버에 의해 실제 뷰 페이지로 매핑됩니다.
        return "hello";
    }
}