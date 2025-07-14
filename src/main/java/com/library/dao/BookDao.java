package com.library.dao;

import com.library.model.Book;
import com.library.util.JPAUtil;
import jakarta.persistence.EntityManager;
import java.util.List;

public class BookDao {
    public void addBook(Book book) {
        EntityManager em = JPAUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        em.close();
    }

    public List<Book> getAllBooks() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Book> books = em.createQuery("from Book", Book.class).getResultList();
        em.close();
        return books;
    }

    public void deleteBook(int id) {
        EntityManager em = JPAUtil.getEntityManager();
        Book book = em.find(Book.class, id);
        if (book != null) {
            em.getTransaction().begin();
            em.remove(book);
            em.getTransaction().commit();
        }
        em.close();
    }
}
