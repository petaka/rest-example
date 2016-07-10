package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * HTTP requests are handled by a controller.
 * These components are easily identified by the @RestController annotation,
 * and the GreetingController below handles GET requests for /greeting by returning
 * a new instance of the Greeting class:
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /**
    The @RequestMapping annotation ensures that HTTP requests to /greeting are mapped to the greeting() method.
     @RequestMapping maps all HTTP operations by default. Use @RequestMapping(method=GET) to narrow this mapping
     @RequestParam binds the value of the query string parameter name into the name parameter
     of the greeting() method. This query string parameter is optional (required=false by default)
     : if it is absent in the request, the defaultValue of "World" is used.
     */
    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    /**
     * returns a new Greeting object with id and content attributes based on the next value from the counter,
     * and formats the given name by using the greeting template.
     *
     * The Greeting object must be converted to JSON.
     * Thanks to Spring’s HTTP message converter support, you don’t need to do this conversion manually.
     * Because Jackson 2 is on the classpath, Spring’s MappingJackson2HttpMessageConverter is automatically
     * chosen to convert the Greeting instance to JSON.
     */
}
