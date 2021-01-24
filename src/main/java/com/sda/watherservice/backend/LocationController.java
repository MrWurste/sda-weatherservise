package com.sda.watherservice.backend;

public class LocationController {

        LocationService locationService = new LocationService();

    public void ValidateAndSendToService(String name, String latitude, String longitude, String country) {
        float flatitude = 0f;
        float flongitude = 0f;
        if (latitude.matches("-?[0-9]{1,2}[.,]?[0-9]{0,4}")) {
            latitude.replace('.', ',');
            flatitude = Float.parseFloat(latitude);
            if (flatitude < -90 || flatitude > 90) {
                System.out.println("Szerokość poza zakresem\nPrawidłowa wartość to -90 - 90\nByło : " + flatitude);
                return;
            }
            System.out.println(flatitude);
        } else {
            System.out.println("Niezgodny format zapisu szerokości gograficznej");
            System.out.println("Oczekiwane 00,0000 lub 00.0000, było : " + latitude);
            System.out.println("Proszę spróbować jeszcze raz.");
            return;
        }
        if (longitude.matches("-?[0-9]{1,3}[.,]?[0-9]{0,4}")) {
            longitude.replace('.', ',');
            flongitude = Float.parseFloat(latitude);
            System.out.println(flongitude);
        } else {
            System.out.println("Niezgodny format zapisu długości gograficznej");
            System.out.println("Oczekiwane 000,0000 lub 000.0000, było : " + latitude);
            System.out.println("Proszę spróbować jeszcze raz.");
            return;
        }
        locationService.saveNewLocationNoRegion(name, flatitude, flongitude, country);
    }
}
