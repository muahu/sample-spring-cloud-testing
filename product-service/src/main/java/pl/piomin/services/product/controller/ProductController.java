package pl.piomin.services.product.controller;

import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pl.piomin.services.product.model.Product;
import pl.piomin.services.product.repository.ProductRepository;

@RestController
public class ProductController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);

    private ObjectMapper mapper = new ObjectMapper();

    @Autowired
    ProductRepository repository;

    @PostMapping
    public Product add(@RequestBody Product product) {
        return repository.save(product);
    }

    @PutMapping
    public Product update(@RequestBody Product product) {
        return repository.save(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable("id") String id) {
        return repository.findById(id).orElseThrow();
    }

    @PostMapping("/ids")
    public List<Product> find(@RequestBody List<String> ids) throws JsonProcessingException {
        List<Product> products = repository.findByIds(ids);
        LOGGER.info("Products found: {}", mapper.writeValueAsString(Collections.singletonMap("count", products.size())));
        return products;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        repository.deleteById(id);
    }

}
