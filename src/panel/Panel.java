package panel;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;

/**
 * Párbeszédpanelek
 * @author Tóth József
 */
public class Panel {

    /**
     * Hibaüzenet megjelenítése párbeszédpanelen
     * @param title: a panel címe
     * @param message: a panelen megjelenő üzenet 
     */
    public static void error(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    /**
     * Megerősítés kérése igen/nem párbeszédpanelen
     * @param title: a panel címe
     * @param message: a panelen megjelenő üzenet
     * @return: true, ha az Igen gombot választották,
     *          egyébként false
     */
    public static boolean yesOrNo(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        ButtonType btIgen = new ButtonType("Igen",ButtonData.YES);
        ButtonType btNem = new ButtonType("Nem",ButtonData.NO);
        alert.getButtonTypes().setAll(btIgen, btNem);
        return alert.showAndWait().get() == btIgen;
    }

}