package org.example.retrovideogamesdf;

public class GamePort {

    public GamePort(String portDeveloper, Game originalGame, int initialReleaseYearOfGamePort) {
        this.portDeveloper = portDeveloper;
        this.originalGame = originalGame;
        this.initialReleaseYearOfGamePort = initialReleaseYearOfGamePort;
    }

    public GamesMachine newMachine;
    public String portDeveloper;
    public Game originalGame;
    public int initialReleaseYearOfGamePort;
    public GamePort nextGamePort;

    public GamePort getNextGamePort() {
        return nextGamePort;
    }

    public void setNextGamePort(GamePort nextGamePort) {
        this.nextGamePort = nextGamePort;
    }

    public int getInitialReleaseYearOfGamePort() {
        return initialReleaseYearOfGamePort;
    }

    public void setInitialReleaseYearOfGamePort(int initialReleaseYearOfGamePort) {
        this.initialReleaseYearOfGamePort = initialReleaseYearOfGamePort;
    }

    public String getOriginalGame() {
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