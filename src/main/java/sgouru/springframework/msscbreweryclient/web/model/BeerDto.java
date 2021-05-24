/**
 * 
 */
package sgouru.springframework.msscbreweryclient.web.model;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sriha
 *
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BeerDto {
	private String beerName;
	private UUID uuid;
	private String beerStyle;
	private long upc;

}

