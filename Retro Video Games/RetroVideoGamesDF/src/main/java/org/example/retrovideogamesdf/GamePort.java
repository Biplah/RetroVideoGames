package org.example.retrovideogamesdf;

public class GamePort extends Game {

    public Game originalGame;
    public GamesMachine newMachine;
    public String portDeveloper;
    public int initialReleaseYearOfGamePort;

    public int getInitialReleaseYearOfGamePort() {
        return initialReleaseYearOfGamePort;
    }

    public void setInitialReleaseYearOfGamePort(int initialReleaseYearOfGamePort) {
        this.initialReleaseYearOfGamePort = initialReleaseYearOfGamePort;
    }

    public Game getOriginalGame() {
        return originalGame;
    }

    public void setOriginalGame(Game originalGame) {
        this.originalGame = originalGame;
    }

    public GamesMachine getNewMachine() {
        return newMachine;
    }

    public void setNewMachine(GamesMachine newMachine) {
        this.newMachine = newMachine;
    }

    public String getPortDeveloper() {
        return portDeveloper;
    }

    public void setPortDeveloper(String portDeveloper) {
        this.portDeveloper = portDeveloper;
    }
}