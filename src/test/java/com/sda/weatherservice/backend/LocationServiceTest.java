package com.sda.weatherservice.backend;

import com.sda.watherservice.backend.Location;
import com.sda.watherservice.backend.LocationService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocationServiceTest {

    private static LocationService locationService;

    @BeforeAll
    static void setUp() {
        locationService = new LocationService();
    }

    @Test
    void addNewLocation_createNewLocation() {
        // when
        Location location = locationService.addNewLocation("Gdansk", "40", "50", "Polska", "Pomorskie");

        // then
        assertThat(location).isNotNull();
    }

    @Test
    void addNewLocation_whenCityValueIsNull_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation(null, "40", "50", "Polska", "Pomorskie"));

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    void addNewLocation_whenCityValueIsBlank_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("  ", "40", "50", "Polska", "Pomorskie"));

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    void addNewLocation_whenLatitudeIsMoreThan90_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("Warszawa", "91", "50", "Polska", "Pomorskie"));

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    void addNewLocation_whenLatitudeIsLessThan90Negative_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("Warszawa", "-91", "50", "Polska", "Pomorskie"));

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    void addNewLocation_whenLongitudeIsMoreThan180_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("Warszawa", "50", "181", "Polska", "Pomorskie"));

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }

    @Test
    void addNewLocation_whenLongitudeIsLessThan180Negative_throwsException() {
        // when
        Throwable throwable = catchThrowable(() -> locationService.addNewLocation("Warszawa", "50", "-181", "Polska", "Pomorskie"));

        // then
        assertThat(throwable).isInstanceOf(RuntimeException.class);
    }
}
