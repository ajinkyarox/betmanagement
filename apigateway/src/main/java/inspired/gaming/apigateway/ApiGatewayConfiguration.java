package inspired.gaming.apigateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import inspired.gaming.apigateway.util.JwtAuthenticationFilter;



@Configuration
public class ApiGatewayConfiguration {

	@Autowired
	private JwtAuthenticationFilter filter;

	@Bean
	public RouteLocator routes(RouteLocatorBuilder builder) {
		return builder.routes().route("betmanagementsystem", r -> r.path("/betmanagementsystem/**").filters(f -> f.filter(filter)).uri("lb://betmanagementsystem")).
				route("loggingapplication", r-> r.path("/loggingapplication/**").filters(f -> f.filter(filter)).uri("lb://loggingapplication"))
				.build();
	}

}
