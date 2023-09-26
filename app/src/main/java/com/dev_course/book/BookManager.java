package com.dev_course.book;

public interface BookManager {
    String create(String title, String author, int pages);
    String getInfo();
    String getInfoByTitle(String title);
    String deleteById(int id);
}