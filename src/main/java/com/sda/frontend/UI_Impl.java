package com.sda.frontend;

import com.sda.utils.AppUtils;

public class UI_Impl implements UI { // todo change a name to UserInterface

    AppUtils appUtils = new AppUtils(); // todo change to the Scanner class

    @Override
    public void showWelcomeMessage() {
        while (true) {
            System.out.println("Witaj w prostej aplikacji pogodowej! Co chciał(a)byś zrobić?");
            System.out.println("1. Dodaj nową lokację");
            System.out.println("2. Pokaż dodane już lokacje");
            System.out.println("3. Pobież dane pogodowe");
            System.out.println("4. Zakończ pracę z aplikacją");

            int responce = appUtils.getInteger(); // todo response

            switch (responce) {
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

    @Override
    public void addNewLocation() { // todo make private
        System.out.println("Podaj nazwę miasta: ");
        String name = appUtils.getString();
        System.out.println("Podaj szerokość geograficzną:");
        String latitude = appUtils.getString();
        System.out.println("Podaj długość goograficzną:");
        String longitude = appUtils.getString();
        System.out.println("Podaj nazwę kraju:");
        String country = appUtils.getString();
        System.out.println("Jeśli chcesz dodać region wpisz 1.\nJeśli chcesz dodać lokację bez regionu wpisz 2.");
        int responce = appUtils.getInteger(); // todo response
        switch (responce) {
            case 1:
                System.out.println("Podaj nazwę regionu:");
                String region = appUtils.getString();
                System.out.println("Dodawanie lokacji");
                break;
            case 2:
                System.out.println("Dodawanie lokacji");
                //todo
                break;
        }
    }

    @Override
    public void showAddedLocations() { // todo make private
        System.out.println("Wczytywanie dodanych lokacji");
        //todo
    }

    @Override
    public void downloadWeatherData() { // todo make private
        System.out.println("Pobieranie danych pogodowych");
        //todo
    }
}
