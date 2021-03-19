package Items;

import java.io.Serializable;
import java.nio.file.Path;
import java.time.Year;

public class Song extends Items implements Serializable {

    private String artist;
    private Year releaseYear;

    public Song(String name, Path path, String artist, Integer releaseYear) {
        this.name = name;
        this.path = path;
        this.artist = artist;
        try {
            if (releaseYear < 0 || releaseYear > 2022) {
                throw new InvalidYearException();
            }
            this.releaseYear = Year.of(releaseYear);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public String getArtist() {
        return artist;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setReleaseYear(Integer releaseYear) {
        try {
            if (releaseYear < 0 || releaseYear > 2022) {
                throw new InvalidYearException();
            }
            this.releaseYear = Year.of(releaseYear);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Song { " +
                "name='" + name + '\'' +
                ", path=" + path +
                ", artist='" + artist + '\'' +
                ", releaseYear=" + releaseYear +
                " } ";
    }
}
