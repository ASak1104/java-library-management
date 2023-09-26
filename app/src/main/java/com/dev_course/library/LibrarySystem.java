package com.dev_course.library;

import com.dev_course.book.BookManager;
import com.dev_course.io_module.LibraryReader;
import com.dev_course.io_module.LibraryWriter;

import static com.dev_course.library.LibraryMessage.*;

public class LibrarySystem {
    LibraryReader reader;
    LibraryWriter writer;
    BookManager bookManager;


    public LibrarySystem(LibraryReader reader, LibraryWriter writer, BookManager bookManager) {
        this.reader = reader;
        this.writer = writer;
        this.bookManager = bookManager;
    }

    public void run() {
        setMode();

        selectFunction();

        exit();
    }

    private void setMode() {
        writer.println(MOD_SCREEN.msg());

        // TODO : SystemMode 따른 도서관 앱의 로드, 저장 기능 변경
    }

    private void selectFunction() {
        writer.println(FUNCTION_SCREEN.msg());

        String input = reader.readOrElse("-1");

        switch (input) {
            case "0" -> {
                return;
            }
            case "1" -> createBook();
            case "2" -> listBooks();
            case "3" -> findBookByTitle();
            case "4" -> rentBookById();
            case "7" -> deleteBookById();
            default -> writer.println(INVALID_FUNCTION.msg());
        }

        selectFunction();
    }

    private void exit() {
        writer.println(EXIT.msg());
    }

    private void createBook() {
        writer.println(CREATE_BOOK.msg());

        try {
            String title = writeAndRead(READ_CREATE_BOOK_TITLE.msg());
            String author = writeAndRead(READ_CREATE_BOOK_AUTHOR.msg());
            int pages = Integer.parseInt(writeAndRead(READ_CREATE_BOOK_PAGES.msg()));

            writer.append(bookManager.create(title, author, pages));
        } catch (RuntimeException e) {
            writer.append(e);
        }

        writer.flush();
    }

    private void listBooks() {
        writer.println(LIST_BOOK.msg());

        writer.append(bookManager.getInfo());
        writer.append(END_LIST_BOOK.msg());
        writer.flush();
    }

    private void findBookByTitle() {
        writer.println(FIND_BOOK_BY_TITLE.msg());

        try {
            String title = writeAndRead(READ_FIND_BY_TITLE.msg());

            writer.append(bookManager.getInfoByTitle(title));
        } catch (RuntimeException e) {
            writer.append(e);
        }

        writer.append(END_FIND_BOOK_BY_TITLE.msg());
        writer.flush();
    }

    private void rentBookById() {
        writer.println(RENT_BOOK_BY_ID.msg());

        try {
            int id = writeAndReadInt(READ_RENT_BOOK_BY_ID.msg());

            writer.append(bookManager.rentById(id));
        } catch (RuntimeException e) {
            writer.append(e);
        }

        writer.flush();
    }

    private void deleteBookById() {
        writer.println(DELETE_BOOK.msg());

        try {
            int id = writeAndReadInt(READ_DELETE_BOOK_ID.msg());

            writer.append(bookManager.deleteById(id));
        } catch (RuntimeException e) {
            writer.append(e);
        }

        writer.flush();
    }

    private String writeAndRead(String msg) {
        writer.println(msg);

        try {
            return reader.read();
        } catch (Exception e) {
            throw new RuntimeException(EMPTY_INPUT.msg());
        }
    }

    private int writeAndReadInt(String msg) {
        try {
            return Integer.parseInt(writeAndRead(msg));
        } catch (RuntimeException e) {
            throw new RuntimeException(INVALID_INPUT.msg());
        }
    }
}
