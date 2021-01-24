import com.sda.frontend.UI;
import com.sda.frontend.UI_Impl;
import com.sda.utils.AppUtils; // todo unnecessary import

public class WSMain { // todo change a name
    public static void main(String[] args) {
        System.out.println("Aplikacja uruchomiona pomyślnie!");
        UI ui = new UI_Impl();
        ui.showWelcomeMessage();
    }
}
