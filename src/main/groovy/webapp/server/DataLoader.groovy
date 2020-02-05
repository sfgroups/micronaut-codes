package webapp
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.context.annotation.Requires
import io.micronaut.context.env.Environment
import io.micronaut.context.event.ApplicationEventListener
import io.micronaut.runtime.server.event.ServerStartupEvent
import webapp.server.Server
import webapp.server.ServerService

import javax.inject.Singleton

//tag::class[]
@Slf4j
@CompileStatic
@Singleton // <1>
@Requires(notEnv = Environment.TEST) // <2>
class DataLoader implements ApplicationEventListener<ServerStartupEvent> { // <3>

    final BookService bookService
    final ServerService serverService

    DataLoader(BookService bookService,ServerService serverService) {
        this.bookService = bookService
        this.serverService=serverService
    }

    DataLoader(BookService bookService) {
        this.bookService = bookService
    }
    DataLoader(ServerService serverService){
        this.serverService=serverService
    }

    @Override
    void onApplicationEvent(ServerStartupEvent event) { // <4>
        if (!bookService.count()) {
            log.debug "Loading sample data"
            bookService.save("1","Java")
            bookService.save("2","Groovy")
        }

       if(!serverService.count()){
            log.debug('Adding server data')
            //serverService.save('host01')
           100.times { i ->
               Server p = new Server(servername: "dbhost${i}", memory: 218+i, cpu: 10+i, storage: 100+i, fqdn: "fqdn${i}", ip: "192.168.10.${i}", role: "Application${i}")
               serverService.save(p)
           }
        }
    }
}
