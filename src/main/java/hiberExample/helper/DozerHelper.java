package hiberExample.helper;

import java.util.ArrayList;
import java.util.List;

import org.dozer.Mapper;
import org.dozer.MappingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DozerHelper {

	private final Mapper mapper;

	@Autowired
	public DozerHelper(Mapper mapper) {
		this.mapper = mapper;
	}

	public <T> T map(Object o, Class<T> aClass) throws MappingException {
		return mapper.map(o, aClass);
	}

	public <T> List<T> mapList(List<?> objectList, Class<T> aClass) throws MappingException {
		List<T> result = new ArrayList<T>();
		for (Object object : objectList) {
			result.add(mapper.map(object, aClass));
		}
		return result;
	}

}
