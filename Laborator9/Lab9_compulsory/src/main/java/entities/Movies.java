package entities;


import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="MOVIES")
@NamedQueries(
        {@NamedQuery(name="Movies.findByName",query = "SELECT m FROM Movies m where m.title=:title")}
)
public class Movies {
  @Id
  @SequenceGenerator(name = "sequence",
          sequenceName = "movies_id_seq")
  @GeneratedValue(generator = "sequence")
  @Column(name = "ID")
  private String id;
  @Column(name = "TITLE")
  private String title;
  @Column(name = "RELEASE_DATE")
  private java.sql.Date releaseDate;
  @Column(name = "DURATION")
  private String duration;
  @Column(name = "SCORE")
  private double score;

  public Movies(){}
  public Movies(String id, String title, Date releaseDate, String duration, double score) {
    this.id = id;
    this.title = title;
    this.releaseDate = releaseDate;
    this.duration = duration;
    this.score = score;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }


  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }


  public java.sql.Date getReleaseDate() {
    return releaseDate;
  }

  public void setReleaseDate(java.sql.Date releaseDate) {
    this.releaseDate = releaseDate;
  }


  public String getDuration() {
    return duration;
  }

  public void setDuration(String duration) {
    this.duration = duration;
  }


  public double getScore() {
    return score;
  }

  public void setScore(double score) {
    this.score = score;
  }

  @Override
  public String toString() {
    return "Movie{" +
            "id='" + id + '\'' +
            ", title='" + title + '\'' +
            ", releaseDate=" + releaseDate +
            ", duration='" + duration + '\'' +
            ", score=" + score +
            '}';
  }
}
