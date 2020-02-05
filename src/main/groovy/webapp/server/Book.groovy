package webapp
import grails.gorm.annotation.Entity

@Entity
class Book {

    String bookid
    String name

    static constraints = {
	bookid nullable: false
        name nullable: false
    }

}
