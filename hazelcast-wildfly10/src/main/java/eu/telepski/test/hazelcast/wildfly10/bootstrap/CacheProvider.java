package eu.telepski.test.hazelcast.wildfly10.bootstrap;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;

@ApplicationScoped
public class CacheProvider {

	private HazelcastInstance hazelcast;
	private IMap<String, Object> cache;
	
	@PostConstruct
	void init() {
		Config config = new Config("hazelcast-instance");
		hazelcast = Hazelcast.getOrCreateHazelcastInstance(config);
		cache = hazelcast.getMap("hazelcast-map");
	}
	
	@Produces
	public IMap<String, Object> provideCache() {
		return cache;
	}
}
