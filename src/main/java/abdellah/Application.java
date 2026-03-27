package abdellah;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


class Application {
    private static final EntityManagerFactory entityManager = Persistence.createEntityManagerFactory("u4w13");




 public static void main(String[] args){
System.out.println("Hello World!");

 }}
