//package ru.netology.domain;
//
//import ru.netology.repository.ProductManager;
//import ru.netology.repository.ProductRepository;
//
//public class Main {
//
//    public static void main(String[] args) {
//
//        Book product1 = new Book(1, "Маугли", 55, "Киплинг");
//        Smartphone product2 = new Smartphone(2, "Телефон", 26500, "Китай");
//        Book product3 = new Book(3, "Мы", 155, "Замятин");
//        Smartphone product4 = new Smartphone(4, "Самсунг", 20400, "Корея");
//
//        ProductRepository repo = new ProductRepository();
//        ProductManager manager = new ProductManager(repo);
//
//        manager.add(product1);
//        manager.add(product2);
//        manager.add(product3);
//        manager.add(product4);
//        manager.searchBy("Замятин");
//
//
//    }
//}
