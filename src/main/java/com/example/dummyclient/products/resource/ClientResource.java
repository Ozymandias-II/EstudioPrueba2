package com.example.dummyclient.products.resource;

import com.example.dummyclient.products.clients.ProductAllClient;
import com.example.dummyclient.products.dto.ProductDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/facturacion")
public class ClientResource {

    private final ProductAllClient service;

    public ClientResource(ProductAllClient service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> obtainProductsForTransaction(){
        System.err.println("Antes del Call");
        return ResponseEntity.ok(this.service.obtainAll());
    }
}
