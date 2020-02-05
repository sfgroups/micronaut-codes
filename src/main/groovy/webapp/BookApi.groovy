package webapp
import io.micronaut.http.annotation.Get

interface BooksApi {

    @Get("/")
    List<Book> listBooks()

    @Get("/{id}")
    Book show(Long id)

}
