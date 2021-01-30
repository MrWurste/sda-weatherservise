package com.sda.weatherservice.backend;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

public class LocationServiceTest {

    private static LocationRepository repository;
    private static LocationService locationService;

    @BeforeAll
    static void setUp() {
        repository = new LocationRepositoryMock();
        locationService = new LocationService(repository);
    }

    //region addLocationTests
    @Test
    void addNewLocation_createNewLocation() {
        // when
        Location location = locationService.addNewLocation("Gdansk", "40", "50", "Polska", "Pomorskie");

        // then
        assertThat(location).isNotNull();
        assertThat(location.getName()).isEqualTo("Gdansk");
        assertThat(location.getRegion()).isEqualTo("Pomorskie");
        assertThat(location.getCountry()).isEqualTo("Polska");
        assertThat(location.getLongitude()).isEqualTo(50.0f);
        assertThat(location.getLatitude()).isEqualTo(40.0f);
    }

    @Test
    void addNewLocation_whenRegionIsNull_createNewLocation() {
        // when
        Location location = locationService.addNewLocation("Gdansk", "40", "50", "Polska", null);

        // then
        assertThat(location).isNotNull();
        assertThat(location.getName()).isEqualTo("Gdansk");
        assertThat(location.getRegion()).isNull();
        assertThat(location.getCountry()).isEqualTo("Polska");
        assertThat(location.getLongitude()).isEqualTo(50.0f);
        assertThat(location.getLatitude()).isEqualTo(40.0f);
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
    //endregion

    //region showLocationsTests
    @Test
    void showNewlyAddedLocation () {
        //given
        repository.saveNewLocation(new Location("Miejscowość1", "Kraj", 45, 90, "Region"));
        repository.saveNewLocation(new Location("Miejscowość2", "Kraj", 45, 90, "Region"));

        //when
        List<Location> results = repository.findAllLocations();
        //then
        assertThat(results).hasSize(2);
    }
    //endregion
}
