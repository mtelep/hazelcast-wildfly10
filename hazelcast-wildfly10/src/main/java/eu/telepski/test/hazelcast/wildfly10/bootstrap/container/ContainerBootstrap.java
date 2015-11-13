package eu.telepski.test.hazelcast.wildfly10.bootstrap.container;

import org.wildfly.swarm.container.Container;

public class ContainerBootstrap {

	public static void main(String[] args) throws Exception {
		
		new Container()
				.start()
				.deploy();
	}
}
