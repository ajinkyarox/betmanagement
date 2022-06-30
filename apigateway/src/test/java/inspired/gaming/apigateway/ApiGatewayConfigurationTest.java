package inspired.gaming.apigateway;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

class ApiGatewayConfigurationTest {

	@Test
	void testRoutes() {
		RouteLocatorBuilder builder = new RouteLocatorBuilder(null);
		RouteLocatorBuilder builder2 = new RouteLocatorBuilder(null);
		builder.routes()
				.route("betmanagementsystem", r -> r.path("/betmanagementsystem/**").uri("lb://betmanagementsystem"))
				.route("loggingapplication", r -> r.path("/loggingapplication/**").uri("lb://loggingapplication"))
				.build();

		builder2.routes()
				.route("betmanagementsystem", r -> r.path("/betmanagementsystem/**").uri("lb://betmanagementsystem"))
				.route("loggingapplication", r -> r.path("/loggingapplication/**").uri("lb://loggingapplication"))
				.build();

		assertEquals(builder2, builder);
	}

}
