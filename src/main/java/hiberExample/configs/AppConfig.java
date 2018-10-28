package hiberExample.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import hiberExample.services.CarService;
import hiberExample.services.CompanyService;
import hiberExample.services.DepartmentService;

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
}
