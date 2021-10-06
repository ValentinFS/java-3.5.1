package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class SmartphoneTest {

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
    void shouldMatchesSmartphoneByName() {
        Product[] expected = new Product[]{smartphoneApple};
        Product[] actual = manager.searchBy("App");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldMatchesSmartphoneByManufacturer() {
        Product[] expected = new Product[]{smartphoneSamsung1};
        Product[] actual = manager.searchBy("Вьетнам");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldMatchesSmartphoneByNothing() {
        Product[] expected = new Product[]{};
        Product[] actual = manager.searchBy(" ");
        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldMatchesSmartphoneBySomeProducts() {
        Product[] expected = new Product[]{smartphoneSamsung, smartphoneSamsung1};
        Product[] actual = manager.searchBy("Самсунг");
        assertArrayEquals(expected, actual);

    }
}