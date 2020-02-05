package webapp.employee


import grails.gorm.services.Service

import javax.validation.constraints.NotNull

@Service(Employee)
interface EmployeeService {

    int count()
    public List<Employee> findAll()

    Employee save(@NotNull String employeeID)
    Employee save(Employee p)

    Employee find(@NotNull String employeeID)


    Employee delete(@NotNull String employeeID)

    List<Employee> getEmployees()

}
