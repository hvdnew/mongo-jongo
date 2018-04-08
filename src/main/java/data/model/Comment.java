package data.model;

import org.jongo.marshall.jackson.oid.MongoObjectId;

public class Comment {

    @MongoObjectId
    private String id;
    private String text;
    private Person author;

    private Blog blog;

    public Comment() {
    }

    public Comment(String text, Person author) {
        this.text = text;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Person getAuthor() {
        return author;
    }

    public void setAuthor(Person author) {
        this.author = author;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }
}
