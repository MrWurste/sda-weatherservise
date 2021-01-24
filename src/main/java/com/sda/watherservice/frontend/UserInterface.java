package com.sda.watherservice.frontend;

import com.sda.watherservice.backend.LocationController;

import java.util.Scanner;

public class UserInterface {

    private Scanner scanner = new Scanner(System.in);

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

        private LocationController locationService = new LocationController();

    private void addNewLocation() {
        System.out.println("Podaj nazwę miasta: ");
        String name = scanner.next();
        System.out.println("Podaj szerokość geograficzną:");
        String latitude = scanner.next();
        System.out.println("Podaj długość goograficzną:");
        String longitude = scanner.next();
        System.out.println("Podaj nazwę kraju:");
        String country = scanner.next();
        System.out.println("Jeśli chcesz dodać region wpisz 1.\nJeśli chcesz dodać lokację bez regionu wpisz 2.");
        int response = scanner.nextInt();
        switch (response) {
            case 1:
                System.out.println("Podaj nazwę regionu:");
                String region = scanner.next();
                System.out.println("Dodawanie lokacji");
                break;
            case 2:
                System.out.println("Dodawanie lokacji");
                locationService.LocationValidation(name, latitude, longitude, country);
                //todo implementation
                break;
        }
    }

    private void showAddedLocations() {
        System.out.println("Wczytywanie dodanych lokacji");
        //todo implementation
    }

    private void downloadWeatherData() {
        System.out.println("Pobieranie danych pogodowych");
        //todo implementation
    }
}
