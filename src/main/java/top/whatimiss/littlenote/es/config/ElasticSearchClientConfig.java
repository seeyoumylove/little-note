package top.whatimiss.littlenote.es.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wcj
 * @create 2020/10/20  下午4:11
 * @description
 */
@Configuration
public class ElasticSearchClientConfig {

    @Value("${es.host}")
    private String esHost;

    @Value("${es.port}")
    private Integer esPort;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        try {
            RestHighLevelClient client = new RestHighLevelClient(
                    RestClient.builder(
                            new HttpHost(esHost, esPort, "http")));
            return client;
        } catch (Exception e) {
            return null;
        }
    }


}
