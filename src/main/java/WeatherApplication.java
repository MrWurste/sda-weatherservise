import com.sda.weatherservice.frontend.UserInterface;

public class WeatherApplication {
    public static void main(String[] args) {
        System.out.println("Aplikacja uruchomiona pomyślnie!");
        UserInterface userInterface = new UserInterface();
        userInterface.showWelcomeMessage();
    }
}
