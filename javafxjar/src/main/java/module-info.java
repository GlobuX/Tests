module ru.globux.javafxjar {
    requires javafx.controls;
    requires javafx.fxml;


    opens ru.globux.javafxjar to javafx.fxml;
    exports ru.globux.javafxjar;
}