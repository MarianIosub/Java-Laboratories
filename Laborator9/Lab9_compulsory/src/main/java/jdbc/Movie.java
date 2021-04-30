package jdbc;

import java.util.Date;

public class Movie {
    private String title;
    private Integer id;
    private Integer duration;
    private Double rating;
    private Date releaseDate;

    public Movie(String title, Integer id, Integer duration, Double rating, Date releaseDate) {
        this.title = title;
        this.id = id;
        this.duration = duration;
        this.rating = rating;
        this.releaseDate = releaseDate;
    }

    public String getTitle() {
        return title;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDuration() {
        return duration;
    }

    public Double getRating() {
        return rating;
    }

    public Date getReleaseDate() {
        return releaseDate;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setReleaseDate(Date releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "title='" + title + '\'' +
                ", id=" + id +
                ", duration=" + duration +
                ", rating=" + rating +
                ", releaseDate=" + releaseDate +
                '}';
    }
}

