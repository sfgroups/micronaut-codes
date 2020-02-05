package webapp.server

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import org.grails.datastore.gorm.GormEntity

@Entity
@EqualsAndHashCode(includes = "id")
class Server implements GormEntity<Server> {

    String servername
    String ip
    String fqdn
    String domain
    String os
    String environment
    String role
    String contact
    String status
    String platform
    int cpu
    int memory
    int storage
    String hostserver
    String abletoconnect
    String isexclude
    String comments

    Date dateCreated
    Date lastUpdated

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    static mapping = {
        table 'servers'
        version false
        id column: 'id'
        servername column: 'servername', index: 'Name_Idx', unique: true
        dateCreated column: 'created'
        lastUpdated column: 'updated'
    }

    static constraints = {
        servername blank: false
        ip nullable: true
        fqdn nullable: true
        domain nullable: true
        os nullable: true
        environment nullable: true
        role nullable: true
        contact nullable: true
        status nullable: true
        platform nullable: true
        cpu nullable: true
        memory nullable: true
        storage nullable: true
        hostserver nullable: true
        abletoconnect nullable: true
        isexclude nullable: true
        comments nullable: true

        dateCreated nullable: true
        lastUpdated nullable: true
    }
}