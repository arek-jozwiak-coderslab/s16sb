package pl.coderslab;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
public class HomeController {
    @GetMapping("/")

    public String hello(Model model){
        Faker faker = new Faker(new Locale("pl_PL"));
        model.addAttribute("fact", faker.avatar().image());

        return "/hello";
    }
}
