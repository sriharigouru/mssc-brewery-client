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
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {

	private UUID uuid;
	private String name;
}
