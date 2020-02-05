package webapp.server

import grails.gorm.services.Service

import javax.validation.constraints.NotNull

@Service(Server)
interface ServerService {

        public List<Server> findAll()
        int count()

        Server save(@NotNull String servername)
        Server save(Server p)

        Server find(@NotNull Long id)
        Server findByServername(String servername)

        Server delete(@NotNull Long id)

        List<Server> getServers()
        Server saveServer(@NotNull String servername)


    }
