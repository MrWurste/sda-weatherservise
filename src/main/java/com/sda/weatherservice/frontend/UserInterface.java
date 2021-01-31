package com.sda.weatherservice.frontend;

import com.sda.weatherservice.backend.LocationController;
import com.sda.weatherservice.backend.WeatherDataController;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);
    private LocationController locationController = new LocationController();
    private WeatherDataController weatherController = new WeatherDataController();

    public void showWelcomeMessage() {
        while (true) {
            System.out.println("Witaj w prostej aplikacji pogodowej! Co chciał(a)byś zrobić?");
            System.out.println("1. Dodaj nową lokację");
            System.out.println("2. Pokaż dodane już lokacje");
            System.out.println("3. Pobież dane pogodowe");
            System.out.println("4. Zakończ pracę z aplikacją");

            int response = scanner.nextInt();

            switch (response) {
                case 1:
                    addNewLocation();
                    break;
                case 2:
                    showAddedLocations();
                    break;
                case 3:
                    downloadWeatherData();
                    break;
                case 4:
                    return;
            }
        }
    }

    private void addNewLocation() {
        String newLocation = "";
        System.out.println("Podaj nazwę miasta: ");
        String name = scanner.next();
        System.out.println("Podaj nazwę kraju:");
        String country = scanner.next();
        System.out.println("Podaj szerokość geograficzną:");
        String latitude = scanner.next();
        System.out.println("Podaj długość goograficzną:");
        String longitude = scanner.next();
        System.out.println("Jeśli chcesz dodać region wpisz 1.\nJeśli chcesz dodać lokację bez regionu wpisz 2.");
        int response = scanner.nextInt();
        switch (response) {
            case 1:
                System.out.println("Podaj nazwę regionu:");
                String region = scanner.next();
                System.out.println("Dodawanie lokacji");
                newLocation = locationController.addNewLocation(name, latitude, longitude, country, region);
                break;
            case 2:
                System.out.println("Dodawanie lokacji");
                newLocation = locationController.addNewLocation(name, latitude, longitude, country, null);
                break;
        }
        System.out.println(newLocation);
    }

    private void showAddedLocations() {
        System.out.println("Wczytywanie dodanych lokacji");
        String locations = locationController.getLocations();
        locations = locations
                .replaceAll("\\{", "\n\\{")
                .replaceAll("}]", "}\n]");
        System.out.println("Zapisane lokacje: " + locations);
    }

    private void downloadWeatherData() {
        System.out.println("Pobieranie danych pogodowych");
        String locNames = locationController.getLocations();
        String weatherDatas = weatherController.getWeatherDatas();
        weatherDatas = weatherDatas
                .replaceAll("\\{", "\n\\{")
                .replaceAll("}]", "}\n]");
        System.out.println("Dane pogodowe: " + weatherDatas);
    }
}
