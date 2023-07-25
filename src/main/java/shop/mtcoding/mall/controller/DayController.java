package shop.mtcoding.mall.controller;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;

@Controller
public class DayController {

    @GetMapping("/day")
    public String day(HttpServletRequest request) {
        String morning = "아침";
        request.setAttribute("time", morning);

        ArrayList<String> List = new ArrayList<>();
//        list.add("아침");
//        list.add("점심");
//        list.add("저녁");
//
//        request.setAttribute("morning", list.get(0));
//        request.setAttribute("afternoon", list.get(1));
//        request.setAttribute("evening", list.get(2));
//
//        request.setAttribute("list", list);

        return "day";
    }
} // class
