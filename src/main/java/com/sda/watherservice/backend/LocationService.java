package com.sda.watherservice.backend;

public class LocationService {

    private LocationRepository locationRepository = new LocationRepository();

    public void Validate(String name, String latitude, String longitude, String country, String region) throws IllegalArgumentException{
        float flatitude = 0f;
        float flongitude = 0f;

        if (name == null || country == null) {
            throw new IllegalArgumentException("Nazwa miasta i państwo nie mogą być puste");
        }
        if (latitude.matches("-?[0-9]{1,2}[.,]?[0-9]{0,4}")) {
            latitude.replace('.', ',');
            if (flatitude < -90 || flatitude > 90) {
                throw new IllegalArgumentException ("Szerokość poza zakresem\nPrawidłowa wartość to -90 - 90\nByło : " + flatitude);
            }
        } else {
            throw new IllegalArgumentException("Niezgodny format zapisu szerokości gograficznej\nOczekiwane 00,0000 lub 00.0000, było : " + latitude);
        }
        if (longitude.matches("-?[0-9]{1,3}[.,]?[0-9]{0,4}")) {
            longitude.replace('.', ',');
            if (flatitude < -180 || flatitude > 180) {
                throw new IllegalArgumentException ("Dłogość poza zakresem\nPrawidłowa wartość to -180 - 180\nByło : " + flatitude);
            }
        } else {
            throw new IllegalArgumentException("Niezgodny format zapisu dłogości gograficznej\nOczekiwane 00,0000 lub 00.0000, było : " + longitude);
        }

        Location location = new Location(name, flatitude, flongitude, country, region);
        locationRepository.saveNewLocationNoRegion(location);
    }
}
