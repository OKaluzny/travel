package org.itsimulator.germes.app.rest.service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.test.JerseyTest;
import org.itsimulator.germes.app.rest.dto.CityDTO;
import org.itsimulator.germes.app.rest.service.config.JerseyConfig;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * {@link CityResourceTest} is integration test that verifies
 * {@link CityResource}
 * 
 * @author Morenets
 *
 */
public class CityResourceTest extends JerseyTest {
	@Override
	protected Application configure() {
		return new JerseyConfig();
	}

	@Test
	public void testFindCitiesSuccess() {
		List<Map<String, String>> cities = target("cities").request().get(List.class);
		assertNotNull(cities);
		assertFalse(cities.isEmpty());

		Map<String, String> city = cities.get(0);
		assertEquals(city.get("name"), "Odessa");
	}

	@Test
	@Ignore
	public void testFindCityByIdSuccess() {
		CityDTO city = target("cities/1").request().get(CityDTO.class);
		assertNotNull(city);
		assertEquals(city.getId(), 1);
		assertEquals(city.getName(), "Odessa");
	}

	@Test
	public void testFindCityByIdNotFound() {
		Response response = target("cities/20000").request().get(Response.class);
		assertNotNull(response);
		assertEquals(response.getStatus(), Response.Status.NOT_FOUND.getStatusCode());
	}

	@Test
	public void testFindCityByIdInvalidId() {
		Response response = target("cities/aaab").request().get(Response.class);
		assertNotNull(response);
		assertEquals(response.getStatus(), Response.Status.BAD_REQUEST.getStatusCode());
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testSaveCitySuccess() throws InterruptedException {
		CityDTO city = new CityDTO();
		city.setName("Kiev");
		city.setDistrict("Kiev");
		city.setRegion("Kiev");
		
		CountDownLatch latch = new CountDownLatch(2);

		target("cities").request().rx().post(Entity.entity(city, MediaType.APPLICATION_JSON))
		.thenAccept(response -> {
			latch.countDown();
			assertEquals(response.getStatus(), Response.Status.NO_CONTENT.getStatusCode());
			target("cities").request().rx().get(Response.class)
				.thenAccept(resp -> {
					List<Map<String, String>> cities = (List<Map<String, String>>) resp.readEntity(List.class);
					assertNotNull(cities);
					assertTrue(cities.stream().anyMatch(item -> item.get("name").equals("Kiev")));
					latch.countDown();					
				}).exceptionally(ex -> {
					ex.printStackTrace();
					return null;
				});
		});
		latch.await(5, TimeUnit.SECONDS);
		assertEquals(latch.getCount(), 0);
	}

}
