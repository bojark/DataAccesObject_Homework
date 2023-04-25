package ru.bojark.daohw.service;

import org.springframework.stereotype.Service;
import ru.bojark.daohw.domain.Product;
import ru.bojark.daohw.repository.DBRepo;


import java.util.List;

@Service
public class ProductFetchService {
    DBRepo repo;
    public ProductFetchService(DBRepo repo) {
        this.repo = repo;
    }

    public String fetchProduct(String name){
        StringBuilder sb = new StringBuilder();
        List<Product> list = repo.fetchProduct(name);

        for (Product product : list
        ) {
            sb.append(product).append("\n");
        }

        return sb.toString();
    }

}
