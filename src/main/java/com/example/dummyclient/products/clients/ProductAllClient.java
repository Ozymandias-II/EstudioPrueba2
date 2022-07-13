package com.example.dummyclient.products.clients;

import com.example.dummyclient.products.dto.ProductDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
public class ProductAllClient {

    private static final String BASE_URL = "http://localhost:8080/products";
    private final RestTemplate restTemplate;

    public ProductAllClient(){
        this.restTemplate = new RestTemplate(getClientHttpRequestFactory());
    }

    public List<ProductDTO> obtainAll(){
        ResponseEntity<ProductDTO[]>response = this.restTemplate.getForEntity(BASE_URL, ProductDTO[].class);
        ProductDTO[] objectArray = response.getBody();
        List<ProductDTO> products = Arrays.asList(objectArray);
        for (ProductDTO product : products){
            System.err.println("Prod:"+ product);
        }
        return products;
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        int connectTimeout = 5000;
        int readTimeout = 5000;
        clientHttpRequestFactory.setConnectTimeout(connectTimeout);
        clientHttpRequestFactory.setReadTimeout(readTimeout);
        return clientHttpRequestFactory;
    }
}
