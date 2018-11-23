package hiberExample.helper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DozerHelper {
	private final DozerBeanMapper dozerBeanMapper;

	@Autowired
	public DozerHelper(DozerBeanMapper dozerBeanMapper) {
		this.dozerBeanMapper = dozerBeanMapper;
	}

	public <T> T map(Object o, Class<T> aClass) throws MappingException {
		return dozerBeanMapper.map(o, aClass);
	}

	public <T> List<T> mapList(List<?> objectList, Class<T> aClass) throws MappingException {
		List<T> result = new ArrayList<T>();
		for (Object object : objectList) {
			result.add(dozerBeanMapper.map(object, aClass));
		}
		return result;
	}

}
