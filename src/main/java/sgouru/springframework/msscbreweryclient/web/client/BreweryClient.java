/**
 * 
 */
package sgouru.springframework.msscbreweryclient.web.client;

import java.net.URI;
import java.util.UUID;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import lombok.Data;
import sgouru.springframework.msscbreweryclient.web.model.BeerDto;
import sgouru.springframework.msscbreweryclient.web.model.CustomerDto;

/**
 * @author sriha
 *
 */
@Component
@ConfigurationProperties(value = "sfg.brewery", ignoreUnknownFields = false)
@Data
public class BreweryClient {

	public final static String BEER_PATH = "/api/v1/beer/";
	public final static String CUSTOMER_API_PATH_V1 = "/api/v1/customer/";
	private String apihost;

	private final RestTemplate restTemplate;

	public BreweryClient(RestTemplateBuilder restTemplateBuilder) {
		this.restTemplate = restTemplateBuilder.build();
	}

	public BeerDto getBeerById(UUID id) {
		return restTemplate.getForObject(apihost + BEER_PATH + UUID.randomUUID(), BeerDto.class);
	}

	public URI addNewBeer(BeerDto beerDto) {
		return restTemplate.postForLocation(apihost + BEER_PATH, beerDto);

		// .acceptHeaderRequestCallback(apihost+BEER_PATH+ UUID.randomUUID(),
		// BeerDto.class);
	}

	public void updateBeer(UUID id, BeerDto beerDto) {
		restTemplate.put(apihost + BEER_PATH + id, beerDto);

	}
	
	public void deleteBeer(UUID id)
	{
		restTemplate.delete(apihost + BEER_PATH + id);
	}

	public CustomerDto getCustomerById(UUID id) {
		return restTemplate.getForObject(apihost + CUSTOMER_API_PATH_V1 + UUID.randomUUID(), CustomerDto.class);
		
	}

	public URI addNewCustomer(CustomerDto customerDto) {
		return restTemplate.postForLocation(apihost + CUSTOMER_API_PATH_V1, customerDto);
	}

	public void updateCustomer(UUID id, CustomerDto customerDto) {
		restTemplate.put(apihost + BEER_PATH + id, customerDto);
		
	}

	public void deleteCustomer(UUID id) {
		restTemplate.delete(apihost + BEER_PATH + id);
		
	}
	
}
