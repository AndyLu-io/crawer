package helloWorld;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by luxiaobo on 2017/4/11.
 */
@RestController
public class HelloWorldController {
    @RequestMapping("/")
    String sayHello() {
        return "helloWorld";
    }

}
