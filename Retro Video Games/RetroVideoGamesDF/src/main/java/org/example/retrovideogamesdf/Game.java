package org.example.retrovideogamesdf;

public class Game {

    public String gameName;
    public String publisher;
    public String gameDescription;
    public String developer;
    public GamesMachine originalGamesMachineDevelopedFor;


    public int initialReleaseYear;
    public String CoverArtImageGame;

    public String getGameName() {
        return gameName;
    }

    public void setGameName(String gameName) {
        this.gameName = gameName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getGameDescription() {
        return gameDescription;
    }

    public void setGameDescription(String gameDescription) {
        this.gameDescription = gameDescription;
    }

    public String getDeveloper() {
        return developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public GamesMachine getOriginalGamesMachineDevelopedFor() {
        return originalGamesMachineDevelopedFor;
    }

    public void setOriginalGamesMachineDevelopedFor(GamesMachine originalGamesMachineDevelopedFor) {
        this.originalGamesMachineDevelopedFor = originalGamesMachineDevelopedFor;
    }

    public int getInitialReleaseYear() {
        return initialReleaseYear;
    }

    public void setInitialReleaseYear(int initialReleaseYear) {
        this.initialReleaseYear = initialReleaseYear;
    }

    public String getCoverArtImageGame() {
        return CoverArtImageGame;
    }

    public void setCoverArtImageGame(String coverArtImageGame) {
        CoverArtImageGame = coverArtImageGame;
    }

}