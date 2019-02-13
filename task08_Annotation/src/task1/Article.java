package task1;

public class Article {
    private int pages;
    @PrintAnnotation
    private String name;
    @PrintAnnotation("description")
    private String description;
    private String author;

    public Article(String name, String description, String author) {
        this.name = name;
        this.description = description;
        this.author = author;
    }

    public String getFullDescription(String name){
        return name + "  " + description;
    }

    public boolean checkAuthor(String author){
        return author.equals(this.author);
    }

    public int addMorePages(int p){
        return p + this.pages;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
