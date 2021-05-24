/**
 * 
 */
package sgouru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import sgouru.springframework.msscbreweryclient.web.model.BeerDto;
import sgouru.springframework.msscbreweryclient.web.model.CustomerDto;

/**
 * @author sriha
 *
 */
@SpringBootTest
class BreweryClientTest {

	@Autowired
	private BreweryClient breweryClient;

	/**
	 * Test method for
	 * {@link sgouru.springframework.msscbreweryclient.web.client.BreweryClient#getBeerById(java.util.UUID)}.
	 */
	@Test
	void testGetBeerById() {
		BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());

		assertNotNull(beerDto);

		// fail("Not yet implemented");
	}

	@Test
	void addNewBeer() {
		BeerDto beerDto = BeerDto.builder().uuid(null).beerName("my beer name").beerStyle("my beer style").upc(10)
				.build();
		URI newUri = breweryClient.addNewBeer(beerDto);
		assertNotNull(newUri);

	}

	@Test
	void updateBeer() {
		BeerDto beerDto = BeerDto.builder().uuid(null).beerName("my beer name").beerStyle("my beer style").upc(10)
				.build();
		breweryClient.updateBeer(UUID.randomUUID(), beerDto);

	}

	@Test
	void deleteBeer() {
		
		breweryClient.deleteBeer(UUID.randomUUID());

	}
	
	@Test
	void testGetCustomerById() {
		CustomerDto customerDto = breweryClient.getCustomerById(UUID.randomUUID());
		
		assertNotNull(customerDto);

		// fail("Not yet implemented");
	}

	@Test
	void addNewCustomer() {
		CustomerDto customerDto = CustomerDto.builder().uuid(null).name("my customer name").build();
		URI newUri = breweryClient.addNewCustomer(customerDto);
		assertNotNull(newUri);

	}

	@Test
	void updateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().uuid(null).name("my customer name")
				.build();
		breweryClient.updateCustomer(UUID.randomUUID(), customerDto);

	}

	@Test
	void deleteCustomer() {
		
		breweryClient.deleteCustomer(UUID.randomUUID());

	}
	
}
