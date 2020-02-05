package webapp.server

import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Slf4j
@CompileStatic
@Controller("/server")
class ServerController {
    final ServerService serverService

    ServerController(ServerService serverService) {
        this.serverService = serverService
    }

    @Get("/list")
    List<Server> listServers() {
        return serverService.findAll()
    }

    @Get("/count")
    int Count() {
        return serverService.count()
    }

    @Get("/{id}")
    Server show(Long id) {
        return serverService.find(id)
    }

    @Delete("/{id}")
    Server delete(Long id) {
        return serverService.delete(id)
    }

    @Post('/')
    Server save(Server o) {
        serverService.save o
    }

    @Put("/")
    Server Update(Server o) {
        String servername = o.getServername()
        log.info(servername)
        log.info(o?.dump())
        Server obj = serverService.findByServername(servername)
        log.info(obj?.dump())
        Server b
        if (obj){
            obj.setIp(o.getIp())
        b = serverService.save(obj)
    }
        return b
    }

    @Get("/")
    @Produces(MediaType.TEXT_HTML)
    String index() {
        return "<html><title>Server Service Controller</title><body><h1>Server Service Controller</h1></body></html>";
    }
}
