package webapp

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller("/home")
class HomeController {
    private static final Logger LOG = LoggerFactory.getLogger(HomeController.class);

    @Get("/")
    HttpStatus index() {
        return HttpStatus.OK
    }

    @Get("/list")
    list() {
        LOG.info("Simple Job every 10 seconds :{}", new SimpleDateFormat("dd/M/yyyy hh:mm:ss").format(new Date()));
        try {
            def arr = new int[3];
            arr[5] = 5;
        } catch (Exception ex) {
            LOG.error(ex.toString())
            LOG.info("stack trace", ex)
        }
        return "hello"
    }

    @Get("/info")
    info(){
        try {
            throw new IOException("network"); //or anything that have declared checked exception
        } catch (Exception ex) {
            LOG.error(ex.toString())
            LOG.info("stack trace", ex)
        }
        return "ERROR"
    }
}