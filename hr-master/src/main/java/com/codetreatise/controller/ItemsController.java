package com.codetreatise.controller;

import com.codetreatise.bean.*;
import com.codetreatise.config.StageManager;
import com.codetreatise.repository.ItemsRepository;
import com.codetreatise.service.*;
import com.codetreatise.view.FxmlView;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

@Controller
public class ItemsController implements Initializable {

    private static final int ZERO = 0;
    private static final int ONE = 1;

    private static final int PAGE_SIZE = 6;

    private static final int ROWS = 2;

    private static final int COLUMNS = 3;

    // Total number of pages
    private int pages = ZERO;

    // Current page
    private int currentPage = ZERO;

    private List<Items> itemsList;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private ItemsService itemsService;

    @Autowired
    private KarigarmstService karigarmstService;

    @Autowired
    private JadtarmstService jadtarmstService;

    @Autowired
    private CustomaccessService customaccessService;

    @Autowired
    private AcntmstService acntmstService;

    @FXML
    GridPane gridPane;

    @FXML
    Text pagesText;

    @FXML
    TextField pageNumberTextField;

    @FXML
    TextField nameTextField;

    @FXML
    TextField ghatWtTextField;

    @FXML
    ComboBox karigarComboBox;

    @FXML
    ComboBox jadtarComboBox;

    @FXML
    ComboBox customAccessComboBox;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        populateJadtarComboBox();
        populateKarigarComboBox();
        populateCustomAccessComboBox();
        getItems(currentPage);
        updatePagesText();
    }

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
        stageManager.switchScene(FxmlView.APP);
    }

    @FXML
    public void handleJadtarMaster() {
        stageManager.switchScene(FxmlView.APP);
    }

    @FXML
    public void handlePartyMaster() {
        stageManager.switchScene(FxmlView.APP);
    }

    @FXML
    public void handleAccessoriesMaster() {
        stageManager.switchScene(FxmlView.APP);
    }

    @FXML
    private void handleFirst() {
        currentPage = ZERO;
        getItems(currentPage);
    }


    @FXML
    private void handlePrevious() {
        if (getCurrentPage() != ZERO)
            setCurrentPage(currentPage -= ONE);
        getItems(currentPage);
    }

    @FXML
    private void handleNext() {
        //handle zero based indexing -1
        if (getCurrentPage() < pages - ONE)
            setCurrentPage(currentPage += ONE);
        getItems(currentPage);
    }

    @FXML
    private void handleLast() {
        currentPage = pages - ONE;
        getItems(currentPage);
    }


    private void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private int getCurrentPage() {
        return currentPage;
    }

    private void getItems(int page) {
        Pageable pageable = new PageRequest(page, PAGE_SIZE);
        Page<Items> items = itemsService.findAll(pageable);
        pages = items.getTotalPages();
        itemsList = items.getContent();
        makeList();
        updatePagesText();
    }


    @FXML
    private void makeList() {
        clearGrid();
        try {
            int count = 0;
            for (int row = 0; row < ROWS; row++) {
                for (int column = 0; column < COLUMNS; column++) {
                    Items item = itemsList.get(count);
                    Text code = new Text("Code: " + item.getItemcode());
                    Text name = new Text("Name: " + item.getItemname());
                    Text party = new Text("Party: " + acntmstService.find(item.getAcntmst().getId()).getName());
                    Text karigar = new Text("Karigar: " + karigarmstService.find(item.getKarigarmst().getId()));
                    Text jadtar = new Text("Jadtar: " + jadtarmstService.find(item.getJadtarmst().getId()));
                    ImageView imageView = null;
                    try {
                        InputStream is = item.getScanImage().getBinaryStream();
                        Image image = new Image(is, 100, 100, false, false);
                        imageView = new ImageView(image);
                        imageView.minHeight(100);
                        imageView.minWidth(100);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }catch(NullPointerException ex){
                        System.err.println(ex);
                    }
                    VBox vbox = new VBox();
                    vbox.setSpacing(5);
                    vbox.setAlignment(Pos.CENTER);
                    vbox.getChildren().addAll(code, name, party, karigar, jadtar, imageView);
                    gridPane.setAlignment(Pos.CENTER);
                    gridPane.add(vbox, column, row);
                    count++;
                }
            }
        } catch (IndexOutOfBoundsException ex) {
            System.err.println("Items less than six");
        }
    }

    private void clearGrid() {
        gridPane.getChildren().retainAll(gridPane.getChildren().get(0));
    }

    private void populateJadtarComboBox() {
        List<Jadtarmst> options = jadtarmstService.findAll();
        jadtarComboBox.setItems(FXCollections.observableArrayList(options));
    }

    private void populateKarigarComboBox() {
        List<Karigarmst> options = karigarmstService.findAll();
        karigarComboBox.setItems(FXCollections.observableArrayList(options));
    }

    private void populateCustomAccessComboBox() {
        List<Customaccess> options = customaccessService.findAll();
        customAccessComboBox.setItems(FXCollections.observableArrayList(options));
    }

    // updates the value of the pagesText
    private void updatePagesText() {
        // handle zero-based indexing
        int page = currentPage + 1;
        pagesText.setText(page + "/" + pages);
    }

    @FXML
    public void handleShowPage() {
        int page = 0;
        if (pageNumberTextField.getText() != null) {
            try {
                page = Integer.parseInt(pageNumberTextField.getText()) - 1;
                if (page > pages) {
                    System.err.println("More than total pages");
                } else {
                    currentPage = page;
                    getItems(currentPage);
                    updatePagesText();

                }
            } catch (NumberFormatException e) {
                System.err.println("Can't change page to a non-number");
            }
        }

    }

    private boolean checkComboBox(ComboBox comboBox) {
        boolean status = false;
        if (comboBox.getValue() != null)
            status = true;
        return status;
    }

    private boolean checkTextField(TextField textField) {
        boolean status = false;
        if (textField.getText() != null)
            status = true;
        return status;
    }

    private String getTextField(TextField textField) {
        String text = "";
        if (textField.getText() != null)
            text = textField.getText();
        return text;
    }


    @FXML
    public void handleReset() {
        nameTextField.clear();
        karigarComboBox.getSelectionModel().clearSelection();
        jadtarComboBox.getSelectionModel().clearSelection();
        customAccessComboBox.getSelectionModel().clearSelection();
        ghatWtTextField.clear();
    }


    @FXML
    public void handleSearch() {
        boolean name = checkTextField(nameTextField);
        boolean karigar = checkComboBox(karigarComboBox);
        boolean jadtar = checkComboBox(jadtarComboBox);
        boolean customAccess = checkComboBox(customAccessComboBox);
        boolean ghatWt = checkTextField(ghatWtTextField);

        String searchName = getTextField(nameTextField);

        QItems qItems = QItems.items;
        BooleanExpression booleanExpression = qItems.itemname.like(Expressions.asString("%").concat(searchName).concat("%"));
        Pageable pageable = new PageRequest(currentPage, PAGE_SIZE);
        Page<Items> itemsPage = itemsRepository.findAll(booleanExpression, pageable);
        itemsList = itemsPage.getContent();
        this.pages = itemsPage.getTotalPages();
        makeList();
        updatePagesText();
    }


}
