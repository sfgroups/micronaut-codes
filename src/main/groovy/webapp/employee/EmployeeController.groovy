package webapp.employee
import groovy.transform.CompileStatic
import groovy.util.logging.Slf4j
import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*

@Slf4j
@CompileStatic
@Controller("/employee")
class EmployeeController {
    final  EmployeeService employeeService

    EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService
    }

    //@Get("/list")
    @Get("/")
    List<Employee> listEmployees() {
        return employeeService.findAll()
    }

    @Get("/count")
    int Count() {
        return employeeService.count()
    }

    @Get("/{employeeID}")
    Employee show(String employeeID) {
        return employeeService.find(employeeID)
    }

    @Delete("/{employeeID}")
    Employee delete(String employeeID) {
        return employeeService.delete(employeeID)
    }

    @Post('/')
    Employee save(Employee o) {
        log.info(o?.dump())
        employeeService.save o
        return o
    }

    @Put("/")
    Employee Update(Employee o) {
        Employee obj = employeeService.find(o.getEmployeeID())
        log.info(obj?.dump())
        if (obj){
            obj.setFullName(o.getFullName())
            obj.setEmpCode(o.getEmpCode())
            obj.setMobile(o.getMobile())
            obj.setPosition(o.getPosition())
           employeeService.save(obj)
        }
        return obj
    }

/*
    @Get("/")
    @Produces(MediaType.TEXT_HTML)
    String index() {
        return "<html><title>Employee Service Controller</title><body><h1>Employee Service Controller</h1></body></html>";
    }
*/
}
