package Solid.calculators;

import Solid.products.Product;

import java.util.List;

public interface Calculator {

    double total(List<Product> products);

    double average(List<Product> products);
}
