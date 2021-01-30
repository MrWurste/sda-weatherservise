package com.sda.watherservice.backend;

public class LocationService {

    LocationRepository repo;
    public LocationService (LocationRepository repository) {
        this.repo = repository;
    }

    public Location addNewLocation(String name, String latitude, String longitude, String country, String region) throws IllegalArgumentException{
        float flatitude = 0f;
        float flongitude = 0f;

        if (name == null || country == null || name.isBlank() || country.isBlank()) {
            throw new IllegalArgumentException("Nazwa miasta i państwo nie mogą być puste");
        }

        // todo flatitude = Float.parseFloat(latitude);
        if (latitude.matches("-?[0-9]{1,2}[.,]?[0-9]{0,4}")) {
            flatitude = Float.parseFloat(latitude.replace(',', '.'));
            if (flatitude < -90 || flatitude > 90) {
                throw new IllegalArgumentException ("Szerokość poza zakresem\nPrawidłowa wartość to -90 - 90\nByło : " + flatitude);
            }
        } else {
            throw new IllegalArgumentException("Niezgodny format zapisu szerokości gograficznej\nOczekiwane 00,0000 lub 00.0000, było : " + latitude);
        }
        if (longitude.matches("-?[0-9]{1,3}[.,]?[0-9]{0,4}")) {
            flongitude = Float.parseFloat(longitude.replace(',', '.'));
            if (flongitude < -180 || flongitude > 180) {
                throw new IllegalArgumentException ("Dłogość poza zakresem\nPrawidłowa wartość to -180 - 180\nByło : " + flatitude);
            }
        } else {
            throw new IllegalArgumentException("Niezgodny format zapisu dłogości gograficznej\nOczekiwane 00,0000 lub 00.0000, było : " + longitude);
        }

        Location location = new Location(name, flatitude, flongitude, country, region);

        return repo.saveNewLocation(location);
    }
}
