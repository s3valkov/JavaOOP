package P02_BookShop;

import java.security.InvalidParameterException;

public class Book {
    private String title;
    private String author;
    private double price;

    public Book(String author, String title, double price) {
        this.setAuthor(author);
        this.setTitle(title);
        this.setPrice(price);
    }

    private void setTitle(String title) {
        if (title.length() < 3) {
            throw new InvalidParameterException("Title not valid!");
        }
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    private void setAuthor(String author) {
        String[] authorsName = author.split("\\s+");
        if (authorsName.length > 1 && Character.isDigit(authorsName[1].charAt(0))) {
            throw new InvalidParameterException("Author not valid!");
        }
        this.author = author;
    }

    private void setPrice(double price) {
        if (price < 1) {
            throw new InvalidParameterException("Price not valid!");
        }
        this.price = price;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(this.getClass().getSimpleName())
                .append(System.lineSeparator())
                .append("Title: ").append(this.getTitle())
                .append(System.lineSeparator())
                .append("Author: ").append(this.getAuthor())
                .append(System.lineSeparator())
                .append("Price: ").append(this.getPrice())
                .append(System.lineSeparator());
        return sb.toString();


    }


}