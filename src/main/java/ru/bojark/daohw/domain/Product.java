package ru.bojark.daohw.domain;

public class Product {
    private final String name;
    private final String product_name;

    public Product(String name, String product){
        this.name = name;
        this.product_name = product;
    }

    @Override
    public String toString() {
        return name + " " + product_name;
    }
}
