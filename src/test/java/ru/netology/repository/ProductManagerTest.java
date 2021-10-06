package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.manager.ProductManager;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book bookMaugli = new Book(1, "Маугли", 55, "Киплинг");
    Smartphone smartphoneApple = new Smartphone(2, "Apple", 26500, "Китай");
    Book bookWe = new Book(3, "Мы", 155, "Замятин");
    Smartphone smartphoneSamsung = new Smartphone(4, "Самсунг", 20400, "Корея");

    @BeforeEach
    public void setUp() {
        manager.add(bookMaugli);
        manager.add(smartphoneApple);
        manager.add(bookWe);
        manager.add(smartphoneSamsung);
    }


    @Test
    void shouldSearchByAuthor() {

        Product[] expected = new Product[]{bookWe};
        Product[] actual = manager.searchBy("Замятин");
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {

        Product[] expected = new Product[]{smartphoneSamsung};
        Product[] actual = manager.searchBy("Корея");
        assertArrayEquals(expected, actual);
    }

}