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
    Smartphone smartphoneSamsung1 = new Smartphone(5, "Самсунг", 20400, "Вьетнам");

    @BeforeEach
    public void setUp() {
        manager.add(bookMaugli);
        manager.add(smartphoneApple);
        manager.add(bookWe);
        manager.add(smartphoneSamsung);
        manager.add(smartphoneSamsung1);
    }


    @Test
    void shouldAdd() {
        Product[] expected = new Product[]{bookMaugli, smartphoneApple, bookWe, smartphoneSamsung, smartphoneSamsung1};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByAuthor() {

        manager.searchBy("Киплинг");

        Product[] expected = new Product[]{bookMaugli};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByName() {

        manager.searchBy("Мы");

        Product[] expected = new Product[]{bookWe};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByModel() {

        manager.searchBy("Apple");

        Product[] expected = new Product[]{smartphoneApple};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByManufacturer() {

        manager.searchBy("Корея");

        Product[] expected = new Product[]{smartphoneSamsung};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchByNothing() {

        manager.searchBy(" ");

        Product[] expected = new Product[]{};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBySomeProducts() {

        manager.searchBy("Самсунг");

        Product[] expected = new Product[]{smartphoneSamsung, smartphoneSamsung1};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }


}