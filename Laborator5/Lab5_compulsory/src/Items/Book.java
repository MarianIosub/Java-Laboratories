package Items;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Year;

public class Book extends Items implements Serializable {

    private String author;
    private Year releaseYear;

    public Book(String name, Path path, String author, Integer year) {
        this.name = name;
        this.path = path;
        this.author = author;
        try {
            if (year < 0 || year > 2022) {
                throw new InvalidYearException();
            }
            this.releaseYear = Year.of(year);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String getAuthor() {
        return author;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setReleaseYear(Integer year) {
        try {
            if (year < 0 || year > 2022) {
                throw new InvalidYearException();
            }
            this.releaseYear = Year.of(year);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Book {" + " name='" + name + '\'' +
                ", path=" + path +
                ", author='" + author + '\'' +
                ", releaseYear=" + releaseYear +
                " } ";
    }
}
