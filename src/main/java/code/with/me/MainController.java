package code.with.me;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andong@xiaomalixing.com
 */
@Controller
public class MainController {
    @GetMapping("/main")
    public String main() {
        return "main.html";
    }
}
