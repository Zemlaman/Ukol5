import java.util.Scanner;

public class Databank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Song[] songs = addSong();

        System.out.println("Zadejte cislo operace (1 pro prumernou delku pro interpreta, 2 pro pocet pisni pro interpreta, 3 pro pocet pisni obsahujici frazi)");

        int action = sc.nextInt();

        if (action == 1) {
            lengthOfSongs(songs);
        } else if (action == 2) {
            countOfSongs(songs);
        } else if (action == 3) {
            songsContainingWord(songs);
        } else {

        }
    }

    public static Song[] addSong() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte pocet pisni");
        int count = sc.nextInt();
        String author;
        String name;
        double length;
        Song[] songs = Song[count];

        System.out.println("Zadejte pocet pisni");

        System.out.println("Zadejte pocet pisni");

        for (int i = 0; i < count; i++) {

            System.out.println("Zadejte nazev interpreta");
            author = sc.nextLine();

            System.out.println("Zadejte nazev pisnicky");
            name = sc.nextLine();

            System.out.println("Zadejte delku pisnicky v sekundach");
            length = Double.parseDouble(sc.nextLine());

            songs[i] = new Song(name, author, length);
        }
        return songs;
    }

    public static void lengthOfSongs(Song[] songs) {
        Scanner sc = new Scanner(System.in);
        double length = 0;
        double avgLength = 0;
        int songsCount = 0;

        System.out.println("Zadejte nazev interpreta");
        String author = sc.nextLine();

        for (Song song : songs) {
            if(song.getAuthor().toUpperCase().equals(author)) {
                length += song.getLength();
                songsCount++;
            }
        }

        avgLength = length/songsCount;
        System.out.printf("Prumerna delka pisnicek je " + avgLength);
    }

    public static void countOfSongs(Song[] songs) {
        Scanner sc = new Scanner(System.in);
        int songsCount = 0;
        System.out.println("Zadejte jmeno interpreta");
        String name = sc.nextLine();

        for (Song song : songs) {
            if(song.getAuthor().toUpperCase().equals(name)) {
                songsCount++;
            }
        }

        System.out.printf("Pocet pisnicek je " + songsCount);
    }

    public static void songsContainingWord(Song[] songs) {
        Scanner sc = new Scanner(System.in);
        int songsCount = 0;
        System.out.println("Zadejte frazi");
        String phrase = sc.nextLine();

        for (Song song : songs) {
            if(song.getName().toUpperCase().contains(phrase)) {
                songsCount++;
            }
        }

        System.out.printf("Pocet pisnicek s touto frazi je " + songsCount);
    }
}
