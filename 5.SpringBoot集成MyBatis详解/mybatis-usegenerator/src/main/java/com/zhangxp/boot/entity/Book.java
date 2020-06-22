package com.zhangxp.boot.entity;

import javax.persistence.*;

public class Book {
    @GeneratedValue(generator = "JDBC")
    private Integer id;

    private String reader;

    private String isbn;

    private String title;

    private String author;

    private String description;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return reader
     */
    public String getReader() {
        return reader;
    }

    /**
     * @param reader
     */
    public void setReader(String reader) {
        this.reader = reader;
    }

    /**
     * @return isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }
}