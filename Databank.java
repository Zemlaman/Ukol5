import java.util.Scanner;

public class Databank {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final Song[] songs = addSong();

        while (true){
            System.out.println("Zadejte cislo operace (1 pro prumernou delku pro interpreta, 2 pro pocet pisni pro interpreta, 3 pro pocet pisni obsahujici frazi)");

            final int action = sc.nextInt();

            if (action == 1) {
                lengthOfSongs(songs);
                break;
            } else if (action == 2) {
                countOfSongs(songs);
                break;
            } else if (action == 3) {
                songsContainingWord(songs);
                break;
            } else {
                error();
            }
        }
    }

    public static Song[] addSong() {
        final Scanner sc = new Scanner(System.in);

        System.out.println("Zadejte pocet pisni");
        int count = sc.nextInt();
        String author;
        String name;
        int length;
        Song[] songs = new Song[count];

        for (int i = 0; i < count; i++) {
            System.out.println("Zadejte nazev interpreta");
            author = sc.next();

            System.out.println("Zadejte nazev pisnicky");
            name = sc.next();

            System.out.println("Zadejte delku pisnicky v sekundach");
            length = sc.nextInt();

            songs[i] = new Song(author, name, length);
        }
        return songs;
    }

    public static void lengthOfSongs(Song[] songs) {
        final Scanner sc = new Scanner(System.in);
        int length = 0;
        double avgLength;
        int songsCount = 0;

        System.out.println("Zadejte nazev interpreta");
        String author = sc.nextLine();

        for (Song song : songs) {
            if(song.getAuthor().equals(author)) {
                length += song.getLength();
                songsCount++;
            }
        }

        avgLength = length/songsCount;
        System.out.println("Prumerna delka pisnicek je " + avgLength);
    }

    public static void countOfSongs(Song[] songs) {
        final Scanner sc = new Scanner(System.in);
        int songsCount = 0;
        System.out.println("Zadejte jmeno interpreta");
        String name = sc.nextLine();

        for (Song song : songs) {
            if(song.getAuthor().equals(name)) {
                songsCount++;
            }
        }

        System.out.println("Pocet pisnicek je " + songsCount);
    }

    public static void songsContainingWord(Song[] songs) {
        Scanner sc = new Scanner(System.in);
        int songsCount = 0;
        System.out.println("Zadejte frazi");
        final String phrase = sc.nextLine();

        for (Song song : songs) {
            if(song.getName().contains(phrase)) {
                songsCount++;
            }
        }

        System.out.println("Pocet pisnicek s touto frazi je " + songsCount);
    }

    public static boolean error() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Stala se chyba, chcete pokracovat Ano nebo Ne?");
        final String choice = sc.nextLine();

        if (choice.equals("Yes")) {
            return  true;
        } else
            return false;
    }
}
