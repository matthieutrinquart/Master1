package Client;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class AgenceService {
	
	@Bean
	public RestTemplate generateRestTemplate(RestTemplateBuilder builder) {
		
		return builder.build();
		}

}
