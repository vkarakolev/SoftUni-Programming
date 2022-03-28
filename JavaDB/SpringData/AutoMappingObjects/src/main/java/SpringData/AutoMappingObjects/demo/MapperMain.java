package SpringData.AutoMappingObjects.demo;

import SpringData.AutoMappingObjects.demo.dto.EmployeeDTO;
import SpringData.AutoMappingObjects.demo.dto.ManagerDTO;
import SpringData.AutoMappingObjects.demo.entities.Address;
import SpringData.AutoMappingObjects.demo.entities.Employee;
import org.modelmapper.ModelMapper;

import java.math.BigDecimal;
import java.time.LocalDate;

public class MapperMain {
    public static void main(String[] args) {
        ModelMapper mapper = new ModelMapper();

        Address address = new Address("street", 1, "Plovdiv", "Bulgaria");
        Employee manager = new Employee("Mr.", "Manager", BigDecimal.TEN, LocalDate.now(), address, false );
        Employee first = new Employee("Mr.", "Employee First", BigDecimal.ONE, LocalDate.now(), address, false);
        Employee second = new Employee("Mr.", "Employee Second", BigDecimal.ZERO, LocalDate.now(), address, true);

        manager.addEmployee(first);
        manager.addEmployee(second);

        ManagerDTO dto = mapper.map(manager, ManagerDTO.class);

        System.out.println(dto);
    }
}
