package sgouru.springframework.msscbreweryclient.web.cofing;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultConnectionKeepAliveStrategy;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Created by jt on 2019-08-08.
 */
@Component

public class BlockingRestTemplateCustomizer implements RestTemplateCustomizer {

	private final Integer maxTotalconnections;
	private final Integer defaultMaxperroute;
	private final Integer connectionTimeout;
	private final Integer socketTimeout;

	/*
	 * sfg.maxtotalconnections=100 sfg.defaultmaxperroute=20
	 * sfg.connectiontimeout=3000 sfg.sockettimeout=3000
	 * 
	 */
	public BlockingRestTemplateCustomizer(@Value("${sfg.maxtotalconnections}") Integer maxTotalconnections,
			@Value("${sfg.defaultmaxperroute}") Integer defaultMaxperroute,
			@Value("${sfg.connectiontimeout}") Integer connectionTimeout,
			@Value("${sfg.sockettimeout}") Integer socketTimeout) {
		super();
		this.maxTotalconnections = maxTotalconnections;
		this.defaultMaxperroute = defaultMaxperroute;
		this.connectionTimeout = connectionTimeout;
		this.socketTimeout = socketTimeout;
	}

	public ClientHttpRequestFactory clientHttpRequestFactory() {
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
		connectionManager.setMaxTotal(maxTotalconnections);
		connectionManager.setDefaultMaxPerRoute(defaultMaxperroute);

		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(connectionTimeout)
				.setSocketTimeout(socketTimeout).build();

		CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager)
				.setKeepAliveStrategy(new DefaultConnectionKeepAliveStrategy()).setDefaultRequestConfig(requestConfig)
				.build();

		return new HttpComponentsClientHttpRequestFactory(httpClient);
	}

	@Override
	public void customize(RestTemplate restTemplate) {
		restTemplate.setRequestFactory(this.clientHttpRequestFactory());
	}
}
