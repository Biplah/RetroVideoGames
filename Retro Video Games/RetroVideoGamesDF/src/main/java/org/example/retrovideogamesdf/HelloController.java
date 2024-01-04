package org.example.retrovideogamesdf;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.util.*;


public class HelloController {

    private GameMap<String, Game> gamesMap = new GameMap<>();
    private GameMachineMap<String, GamesMachine> gamesMachineMap = new GameMachineMap<>();
    private GamePortMap<String, GamePort> gamePortMap = new GamePortMap<>();

    @FXML
    private TextField gameNameField;
    @FXML
    private TextField originalGameField;
    @FXML
    private TextField publisherField;
    @FXML
    private TextField gameDescriptionField;
    @FXML
    private TextField machineDescriptionField;
    @FXML
    private TextField developerField;
    @FXML
    private TextField originalGamesMachineDevelopedForField;
    @FXML
    private TextField initialReleaseYearField;
    @FXML
    private TextField coverArtImageGameField;
    @FXML
    private TextField searchField;
    private TextField initialLaunchYearField;
    @FXML
    private TextField machineNameField;
    @FXML
    private TextField manufacturerField;
    @FXML
    private TextField machineDescription;
    @FXML
    private TextField gameMachineTypeField;
    @FXML
    private TextField mediaTypeField;
    @FXML
    private TextField initialLaunchYear;
    @FXML
    private TextField initialRRPField;
    @FXML
    private TextField photoURLField;


    @FXML
    private ComboBox<String> searchCriteriaComboBox;

    @FXML
    private ListView<GamesMachine> gameMachineListView;

    private ObservableList<GamesMachine> allGameMachines; // Initialize this with your data
    private TreeView<String> gamesTreeView;
    private ContextMenu contextMenu;

    //Search
    @FXML
    private void onSearchGameMachinesButton() {
        String searchTerm = searchField.getText().toLowerCase();
        String searchCriteria = searchCriteriaComboBox.getValue();

        if (searchCriteria == null || searchTerm.isEmpty()) {
            return;
        }

        ObservableList<GamesMachine> filteredList = FXCollections.observableArrayList();

        for (GamesMachine machine : allGameMachines) {
            String fieldValue = getFieldValue(machine, searchCriteria).toLowerCase();
            if (fieldValue.contains(searchTerm)) {
                filteredList.add(machine);
            }
        }

        gameMachineListView.setItems(filteredList);
    }

    private String getFieldValue(GamesMachine machine, String criteria) {
        switch (criteria) {
            case "Name/Title":
                return machine.getMachineName();
            case "Type":
                return machine.getGameMachineType();
            case "Year":
                return String.valueOf(machine.getInitialLaunchYear());

            default:
                return "";
        }
    }

    //Add Buttons
    @FXML
    public void onAddGameButton(ActionEvent actionEvent) {
        String gameName = gameNameField.getText();
        String publisher = publisherField.getText();
        String gameDescription = gameDescriptionField.getText();
        String developer = developerField.getText();
        String originalGamesMachineName = originalGamesMachineDevelopedForField.getText();
        int initialReleaseYear = Integer.parseInt(initialReleaseYearField.getText());
        String coverArtImageGame = coverArtImageGameField.getText();

        GamesMachine originalGamesMachine = findOrCreateGamesMachine(originalGamesMachineName);

        Game newGame = new Game(gameName, publisher, gameDescription, developer,
                originalGamesMachine, initialReleaseYear, coverArtImageGame);

        // Assuming game names are unique, use the game name as the key in the gamesMap
        gamesMap.putGames(gameName, newGame);

        // You can update the UI or perform other actions here
        clearFields(); // Optionally clear the input fields after adding a game
    }
    public void onAddGameMachineButton(ActionEvent actionEvent) {
        String machineName = gameNameField.getText();
        String manufacturer = publisherField.getText();
        String machineDescription = gameDescriptionField.getText();
        String gameMachineType = developerField.getText();
        String mediaType = originalGamesMachineDevelopedForField.getText();
        int initialLaunchYear = Integer.parseInt(initialReleaseYearField.getText());
        double intitialRRP = Double.parseDouble(coverArtImageGameField.getText());
        String photoURL = originalGamesMachineDevelopedForField.getText();

        GamesMachine newGamesMachine = new GamesMachine(machineName,manufacturer,machineDescription,gameMachineType,mediaType,initialLaunchYear,intitialRRP,photoURL);

        // Assuming game names are unique, use the game name as the key in the gamesMap
        gamesMachineMap.putGamesMachine(machineName,newGamesMachine);

        // You can update the UI or perform other actions here
        clearFields(); // Optionally clear the input fields after adding a game
    }
    public void onAddGamePortButton(ActionEvent actionEvent) {
        String portDeveloper = developerField.getText(); // Assuming this should be developerField
        String originalGameName = gameNameField.getText();
        int initialReleaseYearOfGamePort = Integer.parseInt(initialReleaseYearField.getText());

        Game originalGame = gamesMap.getGame(originalGameName);

        if (originalGame != null) {
            GamePort newGamePort = new GamePort(portDeveloper,originalGame, initialReleaseYearOfGamePort);

            gamePortMap.putGamePort(portDeveloper, newGamePort);

            clearFields();
        }
    }
//Delete Buttons
public void onDeleteGamesMachineButton(String machineName) {
    GamesMachine gamesMachine = gamesMachineMap.getGamesMachine(machineName);

    if (gamesMachine != null) {
        // Remove games and associated game ports
        for (Game game : gamesMachine.getGames().values()) {
            gamesMachine.removeGameAndPorts(game.getGameName());
        }

        // Remove the game machine
        gamesMachineMap.remove(machineName);

        // Optionally, update UI or perform other actions
    }
    public void onDeleteGame(String gameName) {
        Game game = gamesMap.getGame(gameName);

        if (game != null) {
            // Remove the game and associated game ports
            game.removeGame();

            // Remove the game from the map
            gamesMap.remove(gameName);

            // Optionally, update UI or perform other actions
        }
    }
    @FXML
    private void onDeleteGameButton(ActionEvent event) {
        String gameName = gameNameField.getText();
        onDeleteGame(gameName);
    }

}





    private GamesMachine findOrCreateGamesMachine(String machineName) {
        GamesMachine gamesMachine = gamesMachineMap.getGamesMachine(machineName);

        return gamesMachine;
    }
    private Game findOrCreateGame(String gameName) {
        Game game = gamesMap.getGame(gameName);

        return game;
    }

    private void clearFields() {
        gameNameField.clear();
        publisherField.clear();
        gameDescriptionField.clear();
        developerField.clear();
        originalGamesMachineDevelopedForField.clear();
        initialReleaseYearField.clear();
        coverArtImageGameField.clear();
    }

    private void handleSortButtonClick() {
        sortGames("name", true);

        // You can update your UI or do other things after sorting
        // For example, update a TableView or any other UI component displaying the games.
    }


    //Sort Methods
    public void sortGames(String sortBy, boolean ascending) {
        Comparator<Game> comparator = getGameComparator(sortBy);

        if (!ascending) {
            comparator.reversed();
        }

        gamesMap.sortGames();
    }

    // Method to get the appropriate comparator for Games (including game ports)
    private Comparator<Game> getGameComparator(String sortBy) {
        switch (sortBy) {
            case "name":
                return Comparator.comparing(Game::getGameName, String.CASE_INSENSITIVE_ORDER);
            case "publisher":
                return Comparator.comparing(Game::getPublisher, String.CASE_INSENSITIVE_ORDER);
            case "releaseYear":
                return Comparator.comparingInt(Game::getInitialReleaseYear);
            // Add more cases for other sorting criteria
            default:
                // Default sorting by name
                return Comparator.comparing(Game::getGameName, String.CASE_INSENSITIVE_ORDER);
        }
    }

    public void sortGameMachines(String sortBy, boolean ascending) {
        Comparator<Game> comparator = getGameComparator(sortBy);

        if (!ascending) {
            comparator.reversed();
        }

        gamesMachineMap.sortGameMachines();
    }

    // Method to get the appropriate comparator for Games (including game ports)
    private Comparator<GamesMachine> getGameMachineComparator(String sortBy) {
        switch (sortBy) {
            case "machine name":
                return Comparator.comparing(GamesMachine::getMachineName, String.CASE_INSENSITIVE_ORDER);
            case "Manufacturer":
                return Comparator.comparing(GamesMachine::getManufacturer, String.CASE_INSENSITIVE_ORDER);
            case "Machine type":
                return Comparator.comparing(GamesMachine::getGameMachineType, String.CASE_INSENSITIVE_ORDER);
            case "Media Type":
                return Comparator.comparing(GamesMachine::getMediaType, String.CASE_INSENSITIVE_ORDER);
            case "Initial Launch Year":
                return Comparator.comparingInt(GamesMachine::getInitialLaunchYear);
            // Add more cases for other sorting criteria
            default:
                // Default sorting by name
                return Comparator.comparing(GamesMachine::getMachineName, String.CASE_INSENSITIVE_ORDER);
        }
    }

    public GameMap<String, Game> filterGames(String searchTerm) {
        GameMap<String, Game> filteredGames = new GameMap<>();

        for (GameMap.Entry<String, Game> entry : gamesMap.entrySet()) {
            Game game = entry.getValue();
            if (matchesSearchTerm(game, searchTerm)) {
                gamesMap.putGames(String.valueOf(game),game);
            }
        }

        return filteredGames;
    }

    private boolean matchesSearchTerm(Game game, String searchTerm) {
        // Customize this method based on your criteria for matching
        // For example, check if the search term is present in the game name, publisher, etc.

        // Here's a simple example for illustration (case-insensitive partial match on the game name)
        return game.getGameName().toLowerCase().contains(searchTerm.toLowerCase());
    }

    public static class GamesList<T> {

    }
    @FXML
    private void initialize() {
        // Initialize your data (populate the gamesMachineMap with data)
        populateData();

        // Initialize the context menu
        contextMenu = new ContextMenu();

        // Populate the context menu
        updateContextMenu();

        // Set the context menu to the TreeView
        gamesTreeView.setContextMenu(contextMenu);
    }

    private void updateContextMenu() {
        // Clear existing menu items
        contextMenu.getItems().clear();

        // Iterate through games machines
        for (GameMachineMap.Entry<String, GamesMachine> gamesMachineEntry : gamesMachineMap.entrySet()) {
            String gamesMachineName = gamesMachineEntry.getKey();
            GamesMachine gamesMachine = gamesMachineEntry.getValue();

            // Create a menu item for each games machine
            MenuItem gamesMachineItem = new MenuItem(gamesMachineName);

            // Add an event handler for the games machine menu item
            gamesMachineItem.setOnAction(event -> handleGamesMachineSelection(gamesMachine));

            // Add the games machine menu item to the context menu
            contextMenu.getItems().add(gamesMachineItem);
        }
    }

    private void handleGamesMachineSelection(GamesMachine gamesMachine) {
        // Handle the selection of a games machine
        // You can implement the logic for the drill-down menu here
        System.out.println("Selected Games Machine: " + gamesMachine);
    }

    private void populateData() {
        String machineName= String.valueOf(machineNameField);
        String manufacturer= String.valueOf(manufacturerField);
        String machineDescription= String.valueOf(machineDescriptionField);
        String gameMachineType= String.valueOf(gameMachineTypeField);
        String mediaType= String.valueOf(mediaTypeField);
        int initialLaunchYear= Integer.parseInt(String.valueOf(initialLaunchYearField));
        double initialRRP= Double.parseDouble(String.valueOf(gameNameField));
        String photoURL= String.valueOf(gameNameField);
        GamesMachine gamesMachine1 = new GamesMachine(machineName,manufacturer,machineDescription,gameMachineType,mediaType,initialLaunchYear,initialRRP,photoURL);

        String gameName = String.valueOf(gameNameField);
        String publisher= String.valueOf(publisherField);
        String gameDescription= String.valueOf(gameDescriptionField);
        String developer= String.valueOf(developerField);
        GamesMachine originalGamesMachineDevelopedFor = findOrCreateGamesMachine(String.valueOf(machineNameField));
        int initialReleaseYear= Integer.parseInt(String.valueOf(initialReleaseYearField));
        String coverArtImageGame= String.valueOf(gameNameField);
        // Create a game and add it to the games machine
        Game game1 = new Game(gameName,publisher,gameDescription,developer,originalGamesMachineDevelopedFor,initialReleaseYear,coverArtImageGame);


        gamesMachine1.getGames().put(String.valueOf(Integer.parseInt("Game1")), game1);
        String portDeveloper= String.valueOf(gameNameField);
        Game originalGame= findOrCreateGame(String.valueOf(originalGameField));
        int initialReleaseYearOfGamePort = Integer.parseInt(String.valueOf(gameNameField));

        // Create a game port and add it to the game
        GamePort gamePort1 = new GamePort(portDeveloper,originalGame,initialReleaseYearOfGamePort);
        game1.getGamePorts().put(String.valueOf(Integer.parseInt("GamePort1")), gamePort1);

        // Add the games machine to the gamesMachineMap
        gamesMachineMap.putGamesMachine("GamesMachine1", gamesMachine1);
    }

    // Method to delete a GamesMachine
    private void deleteGamesMachine(String gamesMachineName) {
        gamesMachineMap.remove(gamesMachineName);
        updateContextMenu(); // Refresh the context menu
    }


}



