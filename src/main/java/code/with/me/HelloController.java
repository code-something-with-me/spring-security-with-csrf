package code.with.me;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author andong@xiaomalixing.com
 */
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String getHello() {
        return "Get Hello!";
    }

    @PostMapping("/hello")
    public String postH() {
        return "Get postH!";
    }

    @GetMapping("/ciao")
    public String getCiao() {
        return "Ciao!";
    }
}
