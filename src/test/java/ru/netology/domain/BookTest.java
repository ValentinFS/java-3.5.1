package ru.netology.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.manager.ProductManager;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book bookMaugli = new Book(1, "Маугли", 55, "Киплинг");
    Smartphone smartphoneApple = new Smartphone(2, "Apple", 26500, "Китай");
    Book bookWe = new Book(3, "Мы", 155, "Замятин");
    Smartphone smartphoneSamsung = new Smartphone(4, "Самсунг", 20400, "Корея");
    Smartphone smartphoneSamsung1 = new Smartphone(5, "Самсунг", 20400, "Вьетнам");
    Book bookWe1 = new Book(6, "Мы", 155, "Замятин");

    @BeforeEach
    public void setUp() {
        manager.add(bookMaugli);
        manager.add(smartphoneApple);
        manager.add(bookWe);
        manager.add(smartphoneSamsung);
        manager.add(smartphoneSamsung1);
        manager.add(bookWe1);
    }


    @Test
    void shouldMatchesBookByName() {
        assertTrue(bookMaugli.matches("Маугли"));
    }

    @Test
    void shouldMatchesBookByAuthor() {
        assertTrue(bookWe.matches("Замятин"));
    }

    @Test
    void shouldMatchesBookByNothing() {
        assertFalse(bookWe.matches(" "));
    }


}