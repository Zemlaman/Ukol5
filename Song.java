public class Song {
    private final String author;
    private final String name;
    private final int length;

    public Song(String author, String name, int length) {
        this.author = author;
        this.name = name;
        this.length = length;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getName() {
        return this.name;
    }

    public int getLength() {
        return this.length;
    }
}
