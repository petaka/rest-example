package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by pedro on 10/07/16.
 */
@RestController
public class PersonController {

    @RequestMapping("/person")
    public Person person(@RequestParam(value = "list", required = false) String list) {
        return new Person(list);
    }
}
