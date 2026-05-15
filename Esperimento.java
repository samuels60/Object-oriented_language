package stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

class Album {

    private String author;
    private List<String> songs;
    private int year;
    private String title;

    public Album(String author, String title,
                 int year, String... songs){
        this.author = author;
        this.year = year;
        this.title = title;
        this.songs = new ArrayList<>(Arrays.asList(songs));
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getSongs() {
        return songs;
    }
    // + metodi get per tutti gli attributi
}


public class Esperimento {
    public static void main(String[] args) {
        List<Album> albums = new ArrayList<>();
        albums.add(new Album("Pink Floyd", "The Dark Side of the Moon", 1973,
                "Speak to Me", "Breathe", "Time", "Money"));
        albums.add(new Album("Pink Floyd", "Wish You Were Here", 1975,
                "Shine On You Crazy Diamond", "Wish You Were Here"));
        albums.add(new Album("Pink Floyd", "Animals", 1977,
                "Dogs", "Pigs (Three Different Ones)", "Sheep"));
        albums.add(new Album("Pink Floyd", "The Wall", 1979,
                "Another Brick in the Wall", "Comfortably Numb"));
        albums.add(new Album("Pink Floyd", "The Division Bell", 1994,
                "High Hopes", "Keep Talking"));

        albums.add(new Album("Led Zeppelin", "Led Zeppelin IV", 1971,
                "Black Dog", "Rock and Roll", "Stairway to Heaven"));
        albums.add(new Album("The Beatles", "Abbey Road", 1969,
                "Come Together", "Something", "Here Comes the Sun"));
        albums.add(new Album("The Beatles", "Sgt. Pepper’s Lonely Hearts Club Band", 1967,
                "Lucy in the Sky with Diamonds", "A Day in the Life"));
        albums.add(new Album("The Rolling Stones", "Exile on Main St.", 1972,
                "Rocks Off", "Tumbling Dice"));
        albums.add(new Album("Queen", "A Night at the Opera", 1975,
                "Bohemian Rhapsody", "Love of My Life"));

        albums.add(new Album("Nirvana", "Nevermind", 1991,
                "Smells Like Teen Spirit", "Come as You Are"));
        albums.add(new Album("Pearl Jam", "Ten", 1991,
                "Alive", "Even Flow"));
        albums.add(new Album("Radiohead", "OK Computer", 1997,
                "Paranoid Android", "Karma Police"));
        albums.add(new Album("Radiohead", "Kid A", 2000,
                "Everything in Its Right Place", "Idioteque"));
        albums.add(new Album("Oasis", "(What’s the Story) Morning Glory?", 1995,
                "Wonderwall", "Champagne Supernova"));

        albums.add(new Album("Metallica", "Master of Puppets", 1986,
                "Battery", "Master of Puppets"));
        albums.add(new Album("Iron Maiden", "The Number of the Beast", 1982,
                "Run to the Hills", "Hallowed Be Thy Name"));
        albums.add(new Album("AC/DC", "Back in Black", 1980,
                "Hells Bells", "Back in Black"));
        albums.add(new Album("Guns N’ Roses", "Appetite for Destruction", 1987,
                "Welcome to the Jungle", "Sweet Child o’ Mine"));
        albums.add(new Album("Black Sabbath", "Paranoid", 1970,
                "War Pigs", "Paranoid"));

        albums.add(new Album("Michael Jackson", "Thriller", 1982,
                "Billie Jean", "Beat It", "Thriller"));
        albums.add(new Album("Prince", "Purple Rain", 1984,
                "When Doves Cry", "Purple Rain"));
        albums.add(new Album("Madonna", "Like a Prayer", 1989,
                "Like a Prayer", "Express Yourself"));
        albums.add(new Album("Whitney Houston", "Whitney Houston", 1985,
                "Saving All My Love for You", "How Will I Know"));
        albums.add(new Album("Bruce Springsteen", "Born to Run", 1975,
                "Thunder Road", "Born to Run"));

        albums.add(new Album("Kendrick Lamar", "To Pimp a Butterfly", 2015,
                "King Kunta", "Alright"));
        albums.add(new Album("Nas", "Illmatic", 1994,
                "N.Y. State of Mind", "The World Is Yours"));
        albums.add(new Album("The Notorious B.I.G.", "Ready to Die", 1994,
                "Juicy", "Big Poppa"));
        albums.add(new Album("Dr. Dre", "The Chronic", 1992,
                "Nuthin' but a 'G' Thang", "Let Me Ride"));
        albums.add(new Album("Lauryn Hill", "The Miseducation of Lauryn Hill", 1998,
                "Doo Wop (That Thing)", "Ex-Factor"));
        albums.stream()
              .filter(s->s.getYear()<2000)
              .flatMap(s->s.getSongs().stream())
              .sorted()
              .limit(100)
              .forEach(System.out::println);

    }
}
