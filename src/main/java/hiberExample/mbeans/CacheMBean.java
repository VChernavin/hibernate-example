package hiberExample.mbeans;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

@ManagedResource
@Component
public class CacheMBean {

	private static final String COMPANY_BY_ID = "company.byId";
	private static final String COMPANY_BY_NAME = "company.byName";

	private final EhCacheCacheManager ehCacheCacheManager;

	@Autowired
	public CacheMBean(EhCacheCacheManager ehCacheCacheManager) {
		this.ehCacheCacheManager = ehCacheCacheManager;
	}

	@ManagedOperation
	public void clearCompanyByIdCache() {
		clearCache(COMPANY_BY_ID);
	}

	@ManagedOperation
	public void clearCompanyByNameCache() {
		clearCache(COMPANY_BY_NAME);
	}

	@ManagedAttribute
	public String getCompanyByIdCache() {
		return getCompanyCache(COMPANY_BY_ID);

	}

	@ManagedAttribute
	public String getCompanyByNameCache() {
		return getCompanyCache(COMPANY_BY_NAME);
	}

	private String getCompanyCache(String cacheName) {
		List keys = Objects.requireNonNull(ehCacheCacheManager.getCacheManager()).getEhcache(cacheName).getKeys();
		return ehCacheCacheManager.getCacheManager().getEhcache(cacheName).getAll(keys).entrySet()
				.stream()
				.map(entry -> entry.getKey() + " - " + entry.getValue())
				.collect(Collectors.joining(", "));
	}

	private void clearCache(String cacheName) {
		Objects.requireNonNull(ehCacheCacheManager.getCache(cacheName)).clear();
	}
}
