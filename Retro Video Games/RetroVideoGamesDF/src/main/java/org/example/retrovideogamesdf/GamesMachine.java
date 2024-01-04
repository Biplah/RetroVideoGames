package org.example.retrovideogamesdf;

import java.util.List;
import java.util.Map;

public class GamesMachine {
    private Map<String, Game> games;
    public String machineName;
    public String manufacturer;
    public String machineDescription;
    public String gameMachineType;
    public String mediaType;
    public int initialLaunchYear;
    public double initialRRP;
    public String photoURL;

    public GamesMachine(String machineName, String manufacturer, String machineDescription, String gameMachineType, String mediaType, int initialLaunchYear, double initialRRP, String photoURL) {
        this.machineName = machineName;
        this.manufacturer = manufacturer;
        this.machineDescription = machineDescription;
        this.gameMachineType = gameMachineType;
        this.mediaType = mediaType;
        this.initialLaunchYear = initialLaunchYear;
        this.initialRRP = initialRRP;
        this.photoURL = photoURL;
    }

    public GamesMachine getNextGamesMachine() {
        return nextGamesMachine;
    }

    public void setNextGamesMachine(GamesMachine nextGamesMachine) {
        this.nextGamesMachine = nextGamesMachine;
    }

    public GamesMachine nextGamesMachine;
    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMachineDescription() {
        return machineDescription;
    }

    public void setMachineDescription(String machineDescription) {
        this.machineDescription = machineDescription;
    }

    public String getGameMachineType() {
        return gameMachineType;
    }

    public void setGameMachineType(String gameMachineType) {
        this.gameMachineType = gameMachineType;
    }

    public String getMediaType() {
        return mediaType;
    }

    public int getInitialLaunchYear() {
        return initialLaunchYear;
    }

    public void setInitialLaunchYear(int initialLaunchYear) {
        this.initialLaunchYear = initialLaunchYear;
    }

    public double getInitialRRP() {
        return initialRRP;
    }

    public void setInitialRRP(double initialRRP) {
        this.initialRRP = initialRRP;
    }

    public void setMediaType(String mediaType) {
        mediaType = mediaType;
    }



    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }
    public void addGame(Game game) {
        games.put(game.getGameName(), game);
    }

    public void removeGame(String gameName) {
        games.remove(gameName);
    }

    // Optional: Remove associated game ports
    public void removeGameAndPorts(String gameName) {
        Game game = games.get(gameName);
        if (game != null) {
            for (GamePort gamePort : game.getGamePorts().values()) {
                removeGamePort(gamePort.getOriginalGame());
            }
        }
        removeGame(gameName);
    }

    public void addGamePort(String gameName, GamePort gamePort) {
        Game game = games.get(gameName);
        if (game != null) {
            game.addGamePort(gamePort);
        }
    }

    public void removeGamePort(String portName) {
        for (Game game : games.values()) {
            game.removeGamePort(portName);
        }
    }

    public Map<String, Game> getGames() {
        return games;
    }
}


