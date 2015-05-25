package org.example.microservices.currenttimeapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.microservices.currenttimeapp.service.CurrentTimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CurrentTimeApp.class)
@WebIntegrationTest({ "server.port=0" })
public class AccessCurrentTimeMsTest {

	private static final Log LOGGER = LogFactory.getLog(AccessCurrentTimeMsTest.class);

	@Autowired
	private CurrentTimeService currentTimeService;

	@Autowired
	private DiscoveryClient discoveryClient;

	@Test
	public void testDiscoveryClient() throws Exception {
		LOGGER.info(discoveryClient.description());
		List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CurrentTimeMs");
		assertFalse(serviceInstances.isEmpty());
		serviceInstances.forEach((ServiceInstance s) -> {
			LOGGER.info(s.getServiceId() + " Port: " + s.getPort());
		});

	}

	@Test
	public void testGetCurrenTime() throws Exception {
		boolean fails = false;
		for (int times = 0; times < 100; times++) {
			try {
				LOGGER.info(currentTimeService.currentTime());
			} catch (Exception e) {
				fails = true;
				LOGGER.error(e);
			}
		}
		assertFalse(fails);
	}
}
