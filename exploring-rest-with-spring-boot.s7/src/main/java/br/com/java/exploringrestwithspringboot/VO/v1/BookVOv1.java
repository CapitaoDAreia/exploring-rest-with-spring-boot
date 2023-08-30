package br.com.java.exploringrestwithspringboot.VO.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@JsonPropertyOrder({"id", "author", "launch_date", "price", "title"})
public class BookVOv1 extends RepresentationModel<BookVOv1> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private String author;

    @JsonProperty("launch_date")
    private String launchDate;

    private Double price;

    private String title;

    public BookVOv1(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BookVOv1 bookVOv1)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(getId(), bookVOv1.getId()) && Objects.equals(getAuthor(), bookVOv1.getAuthor()) && Objects.equals(getLaunchDate(), bookVOv1.getLaunchDate()) && Objects.equals(getPrice(), bookVOv1.getPrice()) && Objects.equals(getTitle(), bookVOv1.getTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getAuthor(), getLaunchDate(), getPrice(), getTitle());
    }
}
