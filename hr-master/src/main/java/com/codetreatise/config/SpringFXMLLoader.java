package com.codetreatise.config;

import java.io.IOException;
import java.util.ResourceBundle;

import com.codetreatise.bean.Items;
import com.codetreatise.controller.MasterController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * Will load the FXML hierarchy as specified in the load method and register
 * Spring as the FXML Controller Factory. Allows Spring and Java FX to coexist
 * once the Spring Application context has been bootstrapped.
 */
@Component
public class SpringFXMLLoader<T> {
    private final ResourceBundle resourceBundle;
    private final ApplicationContext context;
    private T controller;


    @Autowired
    public SpringFXMLLoader(ApplicationContext context, ResourceBundle resourceBundle) {
        this.resourceBundle = resourceBundle;
        this.context = context;
    }

    public Parent load(String fxmlPath) throws IOException {
        Parent root ;
        FXMLLoader loader = new FXMLLoader();
        loader.setControllerFactory(context::getBean); //Spring now FXML Controller Factory
        loader.setResources(resourceBundle);
        loader.setLocation(getClass().getResource(fxmlPath));
        loader.setControllerFactory(context::getBean);
        root = loader.load();
        controller = loader.getController() ;
        return root;
    }

    public T getController() {
        return controller;
    }

}
