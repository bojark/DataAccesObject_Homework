package ru.bojark.daohw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.bojark.daohw.service.ProductFetchService;

@RestController
public class GetController {
    ProductFetchService pfs;
    public GetController(ProductFetchService pfs) {
        this.pfs = pfs;
    }

    @GetMapping("/products/fetch-product")
    public String getProductName(@RequestParam("name") String name) {
        return pfs.fetchProduct(name);
    }
}
