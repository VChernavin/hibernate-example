package hiberExample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hiberExample.services.CarService;
import hiberExample.services.CompanyService;
import hiberExample.services.DepartmentService;
import hiberExample.services.EmployeeService;
import hiberExample.services.PhoneDetailsService;
import hiberExample.services.PhoneService;

@Configuration
public class AppConfig {

	@Bean
	public CompanyService companyService() {
		return new CompanyService();
	}

    @Bean
    public CarService carService() {
        return new CarService();
    }

    @Bean
    public DepartmentService departmentService() {
        return new DepartmentService();
    }

	@Bean
	public EmployeeService employeeService() {
		return new EmployeeService();
	}

	@Bean
	public PhoneDetailsService phoneDetailsService() {
		return new PhoneDetailsService();
	}

	@Bean
	public PhoneService phoneService() {
		return new PhoneService();
	}
}
