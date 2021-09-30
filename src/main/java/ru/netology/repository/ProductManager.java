package ru.netology.repository;

import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

public class ProductManager {
    Product[] result;
    private ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }


    public void add(Product product) {
        repository.save(product);
    }


    public Product[] searchBy(String text) {
        result = new Product[0];
        for (Product product : repository.findAll()) {
            if (product.matches(product, text)) {
                Product[] tmp = new Product[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = product;
                result = tmp;
            }
        }
        return result;
    }

public Product[] getResult(){
        return result;
}



}