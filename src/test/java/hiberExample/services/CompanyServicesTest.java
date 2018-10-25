//package hiberExample.services;
//
//import java.util.List;
//
//import org.junit.Assert;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.test.context.ContextConfiguration;
//import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
//
//import hiberExample.models.Company;
//
//@ContextConfiguration(locations = "classpath:application-context-test.xml")
//@RunWith(SpringJUnit4ClassRunner.class)
//public class CompanyServicesTest {
//
//	@Autowired
//	CompanyService companyService;
//
//	@Test
//	public void save () {
//		Company company = new Company();
//		company.setName("com1");
//		companyService.create(company);
//		List<Company> companies = companyService.getAll();
//		Assert.assertEquals(company.getName(), companies.get(0).getName());
//	}
//}
