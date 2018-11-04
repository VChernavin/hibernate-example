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

	private final EhCacheCacheManager ehCacheCacheManager;

	@Autowired
	public CacheMBean(EhCacheCacheManager ehCacheCacheManager) {
		this.ehCacheCacheManager = ehCacheCacheManager;
	}

	@ManagedAttribute
	public String[] getCacheList() {
		return Objects.requireNonNull(ehCacheCacheManager.getCacheManager()).getCacheNames();
	}

	@ManagedAttribute
	public String getCompanyCache(String cacheName) {
		List keys = Objects.requireNonNull(ehCacheCacheManager.getCacheManager()).getEhcache(cacheName).getKeys();
		return ehCacheCacheManager.getCacheManager().getEhcache(cacheName).getAll(keys).entrySet()
				.stream()
				.map(entry -> entry.getKey() + " - " + entry.getValue())
				.collect(Collectors.joining(", "));
	}

	@ManagedOperation
	public void clearCache(String cacheName) {
		Objects.requireNonNull(ehCacheCacheManager.getCache(cacheName)).clear();
	}
}
