package org.example.retrovideogamesdf;

import java.util.List;

public class GamesMachine {
    public String machineName;
    public String manufacturer;
    public String machineDescription;
    public String gameMachineType;
    public String MediaType;
    public int initialLaunchYear;
    public double initialRRP;
    public String photoURL;
    List<Game> games;
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
        return MediaType;
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
        MediaType = mediaType;
    }



    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

}
