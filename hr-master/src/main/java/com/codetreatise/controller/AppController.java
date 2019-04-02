package com.codetreatise.controller;

import com.codetreatise.bean.Acntmst;
import com.codetreatise.bean.Customaccess;
import com.codetreatise.bean.Jadtarmst;
import com.codetreatise.bean.Karigarmst;
import com.codetreatise.config.StageManager;
import com.codetreatise.service.AcntmstService;
import com.codetreatise.service.CustomaccessService;
import com.codetreatise.service.JadtarmstService;
import com.codetreatise.service.KarigarmstService;
import com.codetreatise.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Collection;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

@Controller
public class AppController implements Initializable {

    @Lazy
    @Autowired
    private StageManager stageManager;

    private static final String NAME = "Name";

    private static final String ACCESSORY_NAME = "Accessory Name";

    private static final String PARTY_CODE = "Party Code";

    private static final String KARIGARMST = "Karigarmst";

    private static final String JADTARMST = "Jadtarmst";

    private static final String PARTY_MASTER = "Party Master";

    private static final String CUSTOMACCESS = "Customaccess";

    private KeyEvent myEvent;

    @Autowired
    private KarigarmstService karigarmstService;

    @Autowired
    private JadtarmstService jadtarmstService;

    @Autowired
    private CustomaccessService customaccessService;

    @Autowired
    private AcntmstService acntmstService;

    private ObservableList list = FXCollections.observableArrayList();

    @FXML
    Text lblItemMaster;

    @FXML
    Text ibiItemListing;

    @FXML
    Text lblKarigarMaster;

    @FXML
    Text lblJadtarMaster;

    @FXML
    Text lblPartyMaster;

    @FXML
    Text lblAccessoryMaster;

    @FXML
    Text tableTitle;

    @FXML
    ListView listView;

    @FXML
    TextField primaryTextField;

    @FXML
    TextField secondaryTextField;

    @FXML
    Text primaryText;

    @FXML
    Text secondaryText;

    @FXML
    Button saveButton;

    @FXML
    ImageView addImageView;

    @FXML
    ImageView updateImageView;

    @FXML
    ImageView saveImageView;

    @FXML
    ImageView deleteImageView;

    @FXML
    private HBox hboxButtons;

    @FXML
    Button btnDelete;

    @FXML
    Button btnUpdate;

    @FXML
    Button btnAdd;

    @FXML
    BorderPane primaryStage;

    @FXML
    public void handleItemMaster() {
        stageManager.switchScene(FxmlView.ITEM_MASTER);
    }

    @FXML
    public void handleItemListing() {
        stageManager.switchScene(FxmlView.ITEM_LISTING);
    }

    @FXML
    public void handleKarigarMaster() {
        displayWelcomControls(true);
        primaryTextField.setText("");
        tableTitle.setText(KARIGARMST);
        enableSecondary(false);
        primaryText.setText(NAME);
        primaryTextField.setPromptText("Enter karigar name");
        listItems(karigarmstService.findAll());
    }

    @FXML
    public void handleJadtarMaster() {
        displayWelcomControls(true);
        primaryTextField.setText("");
        enableSecondary(false);
        tableTitle.setText(JADTARMST);
        primaryText.setText(NAME);
        primaryTextField.setPromptText("Enter jadtar name");
        listItems(jadtarmstService.findAll());
    }

    @FXML
    public void handlePartyMaster() {
        displayWelcomControls(true);
        primaryTextField.setText("");
        tableTitle.setText(PARTY_MASTER);
        primaryText.setText(PARTY_CODE);
        primaryTextField.setPromptText("Enter party code");
        enableSecondary(true);
        secondaryText.setText(NAME);
        secondaryTextField.setPromptText("Enter name");
        listItems(acntmstService.findAll());
    }

    @FXML
    public void handleAccessoriesMaster() {
        displayWelcomControls(true);
        primaryTextField.setText("");
        tableTitle.setText(CUSTOMACCESS);
        primaryText.setText(ACCESSORY_NAME);
        primaryTextField.setPromptText("Enter accessories name");
        enableSecondary(false);
        listItems(customaccessService.findAll());
    }

    public void handleBackup() {
    }

    @FXML
    public void handleUpdate() {
        if (checkTableSelected()) {
            switch (getSelectedTable()) {
                case KARIGARMST:
                    Karigarmst karigarmst = (Karigarmst) getSelectedItem();
                    primaryTextField.setText(karigarmst.getName());
                    enableSave();
                    break;
                case JADTARMST:
                    Jadtarmst jadtarmst = (Jadtarmst) getSelectedItem();
                    primaryTextField.setText(jadtarmst.getName());
                    enableSave();
                    break;
                case CUSTOMACCESS:
                    Customaccess customaccess = (Customaccess) getSelectedItem();
                    primaryTextField.setText(customaccess.getName());
                    enableSave();
                    break;
                case PARTY_MASTER:
                    Acntmst acntmst = (Acntmst) getSelectedItem();
                    primaryTextField.setText(acntmst.getAlias());
                    secondaryTextField.setText(acntmst.getName());
                    enableSave();
                    break;
                default:
            }

        }
    }

    @FXML
    public void handleSave() {
        if (checkTableSelected()) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            switch (getSelectedTable()) {
                case KARIGARMST:
                    Karigarmst karigarmst = (Karigarmst) getSelectedItem();
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to update karigarmst?");
                    Optional<ButtonType> karigarmst_result = alert.showAndWait();
                    if (karigarmst_result.get() == ButtonType.OK) {
                        if (checkPrimaryText()) {
                            karigarmst.setName(primaryTextField.getText());
                        }
                        karigarmstService.update(karigarmst);
                        updateList(karigarmst);

                    } else {
                        actionCancelled();
                    }
                    clearFields();
                    disableSave();
                    break;
                case JADTARMST:
                    Jadtarmst jadtarmst = (Jadtarmst) getSelectedItem();
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to update jadtarmst?");
                    Optional<ButtonType> jadtarmst_result = alert.showAndWait();
                    if (jadtarmst_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        if (checkPrimaryText()) {
                            jadtarmst.setName(primaryTextField.getText());
                        }
                        jadtarmstService.update(jadtarmst);
                        updateList(jadtarmst);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }
                    clearFields();
                    disableSave();
                    break;
                case CUSTOMACCESS:
                    Customaccess customaccess = (Customaccess) getSelectedItem();
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to update Customaccess?");
                    Optional<ButtonType> customaccess_result = alert.showAndWait();
                    if (customaccess_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        if (checkPrimaryText()) {
                            customaccess.setName(primaryTextField.getText());
                        }
                        customaccessService.update(customaccess);
                        updateList(customaccess);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }
                    clearFields();
                    disableSave();
                    break;
                case PARTY_MASTER:
                    Acntmst acntmst = (Acntmst) getSelectedItem();
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to update Party master?");
                    Optional<ButtonType> party_result = alert.showAndWait();
                    if (party_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        if (checkPrimaryText()) {
                            acntmst.setName(secondaryTextField.getText());
                        }
                        if (checkSecondaryText()) {
                            acntmst.setAlias(primaryTextField.getText());
                        }

                        acntmstService.update(acntmst);
                        updateList(acntmst);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    disableSave();
                    break;
                default:
            }
        }
    }

    @FXML
    public void handleDelete() {
        if (checkTableSelected()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            switch (getSelectedTable()) {
                case KARIGARMST:
                    karigarmstService.delete((Karigarmst) getSelectedItem());
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to delete from karigarmst?");
                    Optional<ButtonType> karigarmst_result = alert.showAndWait();
                    if (karigarmst_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        list.remove(getSelectedItem());
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    break;
                case JADTARMST:
                    jadtarmstService.delete((Jadtarmst) getSelectedItem());
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to delete from jadtarmst?");
                    Optional<ButtonType> jadtarmst_result = alert.showAndWait();
                    if (jadtarmst_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        list.remove(getSelectedItem());
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    break;
                case CUSTOMACCESS:
                    customaccessService.delete((Customaccess) getSelectedItem());
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to delete from Customaccess?");
                    Optional<ButtonType> customaccess_result = alert.showAndWait();
                    if (customaccess_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        list.remove(getSelectedItem());
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    break;
                case PARTY_MASTER:
                    acntmstService.delete((Acntmst) getSelectedItem());
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to delete from Party master?");
                    Optional<ButtonType> party_result = alert.showAndWait();
                    if (party_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        list.remove(getSelectedItem());
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    break;
                default:
            }
        }
    }

    @FXML
    public void handleAdd() {

        if (checkTableSelected() && checkPrimaryText()) {
            String add = primaryTextField.getText();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            switch (getSelectedTable()) {
                case KARIGARMST:
                    Karigarmst karigarmst = new Karigarmst();
                    karigarmst.setName(add);
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to add to karigarmst?");
                    Optional<ButtonType> karigarmst_result = alert.showAndWait();
                    if (karigarmst_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        karigarmstService.save(karigarmst);
                        list.add(karigarmst);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    break;
                case JADTARMST:
                    Jadtarmst jadtarmst = new Jadtarmst();
                    jadtarmst.setName(add);
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to add to jadtarmst?");
                    Optional<ButtonType> jadtarmst_result = alert.showAndWait();
                    if (jadtarmst_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        jadtarmstService.save(jadtarmst);
                        list.add(jadtarmst);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }

                    clearFields();
                    break;
                case CUSTOMACCESS:
                    Customaccess customaccess = new Customaccess();
                    customaccess.setName(add);

                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to add to Customaccess?");
                    Optional<ButtonType> customaccess_result = alert.showAndWait();
                    if (customaccess_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        customaccessService.save(customaccess);
                        list.add(customaccess);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }
                    clearFields();
                    break;
                case PARTY_MASTER:
                    Acntmst acntmst = new Acntmst();
                    acntmst.setName(add);
                    alert.setTitle("Confirmation Dialog");
                    alert.setContentText("Are you sure you want to add to Party master?");
                    Optional<ButtonType> party_result = alert.showAndWait();
                    if (party_result.get() == ButtonType.OK) {
                        // ... user chose OK
                        if (checkSecondaryText()) {
                            acntmst.setAlias(secondaryTextField.getText());
                        }
                        acntmstService.save(acntmst);
                        list.add(acntmst);
                    } else {
                        // ... user chose CANCEL or closed the dialog
                        actionCancelled();
                    }
                    clearFields();
                    break;
                default:
            }
        }

    }

    private Object getSelectedItem() {
        return list.get(listView.getSelectionModel().getSelectedIndex());
    }

    private void updateList(Object object) {
        listView.getItems().set(listView.getSelectionModel().getSelectedIndex(), object);
    }

    private String getSelectedTable() {
        if (checkTableSelected()) {
            return tableTitle.getText();
        }
        return "Select a table first";
    }

    private boolean checkTableSelected() {
        return tableTitle != null;
    }

    private boolean checkPrimaryText() {
        boolean result = false;
        if ((primaryTextField.getText() == null) || (primaryTextField.getText().isEmpty())) {
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            alertInfo.setTitle("Confirmation Dialog");
            alertInfo.setContentText("Name Cannot be empty");
            alertInfo.showAndWait();
        } else {
            result = true;
        }

        return result;
    }

    private boolean checkSecondaryText() {
        return secondaryTextField != null;
    }

    private void enableSecondary(boolean enable) {
        secondaryTextField.setVisible(enable);
        secondaryText.setVisible(enable);
        setTabMoveFunctionality();
    }

    private void setTabMoveFunctionality() {
        if (secondaryTextField.isVisible()) {
            primaryTextField.setOnKeyPressed((myEvent) -> {
                try {
                    checkKeyPressed(myEvent);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });
            secondaryTextField.setOnKeyPressed((myEvent) -> {
                try {
                    checkKeyPressed(myEvent);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            });

        }

    }

    public void checkKeyPressed(javafx.scene.input.KeyEvent myEvent2) throws InterruptedException {

        KeyCode keycode = myEvent2.getCode();
        // char charTyped = myEvent2.getCharacter().charAt(0);
        if ((keycode == KeyCode.TAB)
                && (primaryTextField.isFocused() == true)
                && (secondaryTextField.isVisible() == true)) {
            secondaryTextField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (primaryTextField.isFocused() == true)) {
            btnAdd.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (secondaryTextField.isFocused() == true)) {
            btnAdd.requestFocus();

            wait();

        } else if ((keycode == KeyCode.TAB) && (btnAdd.isFocused() == true)) {
            btnUpdate.requestFocus();
            wait();

        } else if ((keycode == KeyCode.ENTER) && (btnAdd.isFocused() == true)) {
            handleAdd();

        } else if ((keycode == KeyCode.ENTER) && (btnUpdate.isFocused() == true)) {
            handleUpdate();

        } else if ((keycode == KeyCode.ENTER) && (saveButton.isFocused() == true)) {
            handleSave();

        } else if ((keycode == KeyCode.ENTER) && (btnDelete.isFocused() == true)) {
            handleDelete();

        } else if ((keycode == KeyCode.TAB) && (btnUpdate.isFocused() == true)) {
            saveButton.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (btnDelete.isFocused() == true)) {
            primaryTextField.requestFocus();
            wait();
        } else {
        }
    }

    private void listItems(Collection collection) {
        listView.getItems().clear();
        list.addAll(collection);
        listView.setItems(list);
    }

    private void clearFields() {
        primaryTextField.clear();
        secondaryTextField.clear();
    }

    private void actionCancelled() {
        Alert actionCancelled = new Alert(Alert.AlertType.INFORMATION);
        actionCancelled.setTitle("Information Dialog");
        actionCancelled.setHeaderText(null);
        actionCancelled.setContentText("Action cancelled!");
        actionCancelled.showAndWait();
    }

    private void enableSave() {
        saveButton.setDisable(false);
        addImageView.setImage(new Image("images/drawable-hdpi/ic_add_circle_grey_600_48dp.png"));
        updateImageView.setImage(new Image("images/drawable-hdpi/ic_mode_edit_grey_600_48dp.png"));
        saveImageView.setImage(new Image("images/drawable-hdpi/ic_save_blue_800_48dp.png"));
        deleteImageView.setImage(new Image("images/drawable-hdpi/ic_delete_grey_600_48dp.png"));

    }

    private void disableSave() {
        saveButton.setDisable(true);
        addImageView.setImage(new Image("images/drawable-hdpi/ic_add_circle_green_800_48dp.png"));
        updateImageView.setImage(new Image("images/drawable-hdpi/ic_mode_edit_amber_800_48dp.png"));
        saveImageView.setImage(new Image("images/drawable-hdpi/ic_save_grey_600_48dp.png"));
        deleteImageView.setImage(new Image("images/drawable-hdpi/ic_delete_red_800_48dp.png"));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        displayWelcomControls(false);
        loadTabFeatures();

    }

    private void displayWelcomControls(boolean b) {
        primaryText.setVisible(b);
        primaryTextField.setVisible(b);
        hboxButtons.setVisible(b);
        listView.setVisible(b);
    }

    private void loadTabFeatures() {
        btnAdd.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        btnUpdate.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        saveButton.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        });
        btnDelete.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        lblItemMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    handleItemMaster();
                }
            }
        });

        ibiItemListing.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    handleItemListing();
                }
            }
        });

        lblKarigarMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    handleKarigarMaster();
                }
            }
        });

        lblJadtarMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    handleJadtarMaster();
                }
            }
        });

        lblPartyMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    handlePartyMaster();
                }
            }
        });

        lblAccessoryMaster.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (mouseEvent.getButton().equals(MouseButton.PRIMARY)) {
                    handleItemMaster();
                }
            }
        });

    }

}
