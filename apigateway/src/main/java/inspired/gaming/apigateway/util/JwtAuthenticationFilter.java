package inspired.gaming.apigateway.util;

import java.net.URI;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements GatewayFilter {

	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Value("${server.path}")
	private String serverPath;

	@Autowired
    private DiscoveryClient discoveryClient;
	
	@Override
	public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
		ServerHttpRequest request = (ServerHttpRequest) exchange.getRequest();
		ServerWebExchange mutatedExchange = null;
		final List<String> apiEndpoints = List.of("/register", "/login");

		Predicate<ServerHttpRequest> isApiSecured = r -> apiEndpoints.stream()
				.noneMatch(uri -> r.getURI().getPath().contains(uri));

		if (isApiSecured.test(request)) {
			if (!request.getHeaders().containsKey("Authorization")) {
				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.UNAUTHORIZED);

				return response.setComplete();
			}

			final String token = request.getHeaders().getOrEmpty("Authorization").get(0);

			try {
				boolean flag = jwtUtil.validateToken(token);
				if(!flag && !exchange.getRequest().getURI().toString().contains("saveAccountDetails") &&
						!exchange.getRequest().getURI().toString().contains("swagger-ui")) {
					ServerHttpResponse response = exchange.getResponse();
					response.setStatusCode(HttpStatus.UNAUTHORIZED);

					return response.setComplete();
				}
				String applicationName = exchange.getRequest().getURI().toString().replaceAll(serverPath, "");
				List<String> listOfServiceNames = Arrays.asList(applicationName.split("/"));
				List<ServiceInstance> listOfInst = this.discoveryClient.getInstances(listOfServiceNames.get(0));
				System.out.println(listOfInst.get(0).getPort());
				StringBuilder sb = new StringBuilder();
				for(String temp: listOfServiceNames) {
					if(temp.equals(listOfServiceNames.get(0))) {
						continue;
					}
					sb.append(temp+"/");
				}
				if(sb.toString().equals("")) {
					URI uri = new URI(listOfInst.get(0).getUri().toString()+"/");
					exchange.getRequest().mutate().uri(uri).build();
			        ServerHttpRequest mutatedRequest = exchange.getRequest().mutate().uri(uri).build();
			        mutatedExchange = exchange.mutate().request(mutatedRequest).build();
				}
				else {
					StringBuilder sb2 = new StringBuilder(sb.toString().substring(0, sb.toString().length() - 1));
					URI uri = new URI(listOfInst.get(0).getUri().toString()+"/"+sb2.toString());
					exchange.getRequest().mutate().uri(uri).build();
			        ServerHttpRequest mutatedRequest = exchange.getRequest().mutate().uri(uri).build();
			        mutatedExchange = exchange.mutate().request(mutatedRequest).build();
				}
				

			} catch (Exception e) {
				// e.printStackTrace();

				ServerHttpResponse response = exchange.getResponse();
				response.setStatusCode(HttpStatus.BAD_REQUEST);

				return response.setComplete();
			}

			/*
			 * Claims claims = jwtUtil.getClaims(token);
			 * exchange.getRequest().mutate().header("id",
			 * String.valueOf(claims.get("id"))).build();
			 */
		}
		
		return chain.filter(mutatedExchange);
	}

}