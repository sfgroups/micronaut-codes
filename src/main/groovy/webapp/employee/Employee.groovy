package webapp.employee

import grails.gorm.annotation.Entity
import groovy.transform.EqualsAndHashCode
import org.grails.datastore.gorm.GormEntity

@Entity
class Employee implements GormEntity<Employee> {
    String employeeID
    String fullName
    String empCode
    String mobile
    String position

    Date dateCreated
    Date lastUpdated

    def beforeUpdate() {
        lastUpdated = new Date()
    }

    static mapping = {
        version false
        id false
        employeeID index: 'Name_Idx', unique: true
    }

    static constraints = {
        employeeID blank: false,  nullable: false
        dateCreated nullable: true
        lastUpdated nullable: true
    }
}
