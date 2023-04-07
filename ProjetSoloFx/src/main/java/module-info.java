module com.example.projetsolofx {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.projetsolofx to javafx.fxml;
    exports com.example.projetsolofx;
}