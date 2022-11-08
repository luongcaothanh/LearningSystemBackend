package com.hcmut.learningsystemserverrest.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Textbook")
public class Textbook {
    @Id
    @Column(name = "ID", nullable = false, length = 16)
    private String id;

    @Column(name = "TextbookName", nullable = false, length = 256)
    private String textbookName;

    @Column(name = "PublishingHouse", nullable = false, length = 64)
    private String publishingHouse;

    @Column(name = "PublishingYear", columnDefinition = "char(4)", nullable = false)
    private String publishingYear;

    @Column(name = "Category", nullable = false, length = 256)
    private String category;

    @Column(name = "AuthorName", nullable = false, length = 128)
    private String authorName;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTextbookName() {
        return textbookName;
    }

    public void setTextbookName(String textbookName) {
        this.textbookName = textbookName;
    }

    public String getPublishingHouse() {
        return publishingHouse;
    }

    public void setPublishingHouse(String publishingHouse) {
        this.publishingHouse = publishingHouse;
    }

    public String getPublishingYear() {
        return publishingYear;
    }

    public void setPublishingYear(String publishingYear) {
        this.publishingYear = publishingYear;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
