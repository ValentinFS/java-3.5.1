package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {

    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);
    Book bookMaugli = new Book(1, "Маугли", 55, "Киплинг");
    Smartphone smartphoneApple = new Smartphone(2, "Apple", 26500, "Китай");
    Book bookWe = new Book(3, "Мы", 155, "Замятин");
    Smartphone smartphoneSamsung = new Smartphone(4, "Самсунг", 20400, "Корея");

    @Test
    void shouldAdd() {
        manager.add(bookMaugli);
        manager.add(smartphoneApple);
        manager.add(bookWe);
        manager.add(smartphoneSamsung);

        Product[] expected = new Product[]{bookMaugli, smartphoneApple, bookWe, smartphoneSamsung};
        Product[] actual = repo.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchBy() {
        manager.add(bookMaugli);
        manager.add(smartphoneApple);
        manager.add(bookWe);
        manager.add(smartphoneSamsung);
        manager.searchBy("Киплинг");

        Product[] expected = new Product[]{bookMaugli};
        Product[] actual = manager.getResult();
        assertArrayEquals(expected, actual);
    }

}