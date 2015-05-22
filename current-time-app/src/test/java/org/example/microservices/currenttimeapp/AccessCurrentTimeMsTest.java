package org.example.microservices.currenttimeapp;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.example.microservices.currenttimeapp.service.CurrentTimeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertFalse;

/**
 * TODO (KS) Dokumentieren.
 *
 * @author steuer.konstantin <br>
 * copyright (C) 2015, SWM Services GmbH
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = CurrentTimeApp.class)
//@WebIntegrationTest({ "server.port=0" })
public class AccessCurrentTimeMsTest {

	private static final Log LOGGER = LogFactory.getLog(AccessCurrentTimeMsTest.class);

	@Autowired
	private CurrentTimeService currentTimeService;

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
