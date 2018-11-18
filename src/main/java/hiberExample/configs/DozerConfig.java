package hiberExample.configs;

import org.dozer.DozerBeanMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DozerConfig {

	@Bean(name = "org.dozer.Mapper")
	public DozerBeanMapper dozerBean() {
		//		List<String> mappingFiles = Arrays.asList(
		//				"dozer-configration-mapping.xml"
		//		);

		//		dozerBean.setMappingFiles(mappingFiles);
		return new DozerBeanMapper();
	}
}
