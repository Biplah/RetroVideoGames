package org.example.retrovideogamesdf;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class Game implements Serializable {
    private Map<String, Game> games;

    public String gameName;
    public String publisher;
    public String gameDescription;

    public Game(String gameName, String publisher, String gameDescription, String developer, GamesMachine originalGamesMachineDevelopedFor, int initialReleaseYear, String coverArtImageGame) {
        this.gameName = gameName;
        this.publisher = publisher;
        this.gameDescription = gameDescription;
        this.developer = developer;
        this.originalGamesMachineDevelopedFor = originalGamesMachineDevelopedFor;
        this.initialReleaseYear = initialReleaseYear;
        this.coverArtImageGame = coverArtImageGame;
    }

    private Map<String, GamePort> gamePorts;

    public String developer;
    public GamesMachine originalGamesMachineDevelopedFor;


    public int initialReleaseYear;
    public String coverArtImageGame;
    public Game nextGame;

    public Game getNextGame() {
        return nextGame;
    }

    public void setNextGame(Game nextGame) {
        this.nextGame = nextGame;
    }


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
        return coverArtImageGame;
    }

    public void setCoverArtImageGame(String coverArtImageGame) {
    }
    public void addGamePort(GamePort gamePort) {
        gamePorts.put(gamePort.getOriginalGame(), gamePort);
    }

    public void removeGamePort(String portName) {
        gamePorts.remove(portName);
    }

    public Map<String, GamePort> getGamePorts() {
        return gamePorts;
    }
    public void removeGame() {
        // Remove associated game ports
        gamePorts.clear();
    }
}


