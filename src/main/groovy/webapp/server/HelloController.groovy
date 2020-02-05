package webapp


import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.validation.Validated
import io.reactivex.Single

import javax.validation.constraints.NotBlank

@Controller("/")
@Validated
public class HelloController {

    /**
     * @param name The person's name
     * @return The greeting
     */
    @Get(uri="/hello/{name}", produces=MediaType.TEXT_PLAIN)
    public Single<String> hello(@NotBlank String name) {
        return Single.just("Hello " + name + "!");
    }

    @Get("/")
    String index() {
        System.getenv().sort().each {k, v ->
            println "$k, $v"
        }
        return "JDBC UL :" + System.env.JDBC_URL + ','+ System.env.OS
    }
}
