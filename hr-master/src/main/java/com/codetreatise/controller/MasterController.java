package com.codetreatise.controller;

import com.codetreatise.bean.*;
import com.codetreatise.config.StageManager;

//import com.codetreatise.morena.SynchronousHelper;
import com.codetreatise.repository.MasterRepository;
import com.codetreatise.service.*;
import com.codetreatise.view.FxmlView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;

import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.controlsfx.control.textfield.TextFields;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;

import javax.imageio.ImageIO;

import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import java.net.URL;
import java.sql.SQLException;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import java.util.*;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.layout.AnchorPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

@Controller
public class MasterController implements Initializable {

    private static final int ZERO = 0;
    private static final int ONE = 1;
    private static final int PAGE_SIZE = ONE;

    // ImageView constants
    private static final int imageRequestWidth = 80;
    private static final int imageRequestHeight = 80;

    // edit mode status
    private boolean isEditMode = false;

    // Current page
    private int currentPage = 0;

    // Total number of pages
    private int totalPages = 0;

    private KeyEvent myEvent;

    private Items items;

    private Itemready itemready;

    private Itemkarigar itemkarigar;

    private Itemjadtar itemjadtar;

    private ObservableList<Itemkarigaraccessry> itemkarigaraccessries = FXCollections.observableArrayList();

    private ObservableList<Itemjadtaraccessry> itemjadtaraccessries = FXCollections.observableArrayList();

    private ObservableList<Itemreadyaccessry> itemreadyaccessries = FXCollections.observableArrayList();

    // Morena
//	Manager manager;
//	List<Device> devices;
//	Device device;
    @Autowired
    MasterRepository masterRepository;

    @Autowired
    private MasterService masterService;

    @Autowired
    private KarigarmstService karigarmstService;

    @Autowired
    private JadtarmstService jadtarmstService;

    @Autowired
    private AcntmstService acntmstService;

    @Autowired
    private CustomaccessService customaccessService;

    @Autowired
    private ItemkarigarService itemkarigarService;

    @Autowired
    private ItemjadtarService itemjadtarService;

    @Autowired
    private ItemreadyService itemreadyService;

    @Autowired
    private ItemkarigaraccessryService itemkarigaraccessryService;

    @Autowired
    private ItemjadtarcessryService itemjadtaccessryService;

    @Autowired
    private ItemreadyaccessryService itemreadyaccessryService;

    @Autowired
    private MycodeService mycodeService;

    @Lazy
    @Autowired
    private StageManager stageManager;

    @FXML
    TextField itemCodeField;

    @FXML
    TextField itemNameField;

    @FXML
    TextField partyNameField;

    @FXML
    TextField karigarNameField;

    @FXML
    TextField jadtarKarigarNameField;

    @FXML
    TextField printCodeField;

    @FXML
    ImageView masterImageView1;

    @FXML
    ImageView masterImageView2;

    @FXML
    DatePicker karigar_IssueDate;

    @FXML
    TextField karigar_GhatGrossWtField;

    @FXML
    TextField karigar_GhatWtField;

    @FXML
    TextField karigar_PurityField;

    @FXML
    TextField karigar_LabourField;

    @FXML
    TextField karigar_GhatGrossWt2Field;

    @FXML
    TextField karigar_Purity2Field;

    @FXML
    TextField karigar_NetFineField;

    @FXML
    TextField karigar_MTWeightField;

    @FXML
    TextField karigar_MTNameField;

    @FXML
    DatePicker jadtar_ReceiveDate;

    @FXML
    TextField jadtar_JadtarGrossWtField;

    @FXML
    TextField jadtar_KundanField;

    @FXML
    TextField jadtar_RacketField;

    @FXML
    TextField jadtar_TotalKundanField;

    @FXML
    TextField jadtar_TotalAmountField;

    @FXML
    TextField jadtar_TotalVaxField;

    @FXML
    TextField ready_ReadyGrossWtField;

    @FXML
    TextField ready_FittingWtField;

    @FXML
    TextField ready_NetWtField;

    @FXML
    TextField ready_NetKundanField;

    @FXML
    DatePicker ready_ReadyDate;

    @FXML
    Button addButton;

    @FXML
    Button updateButton;

    @FXML
    Button saveButton;

    @FXML
    Button closeButton;

    @FXML
    Button deleteButton;

    @FXML
    Button btnPrintImage;

    @FXML
    Button listButton;

    @FXML
    Button firstButton;

    @FXML
    Button previousButton;

    @FXML
    Button nextButton;

    @FXML
    Button lastButton;

    @FXML
    ImageView addImageView;

    @FXML
    ImageView updateImageView;

    @FXML
    ImageView saveImageView;

    @FXML
    ImageView closeImageView;

    @FXML
    ImageView deleteImageView;

    @FXML
    ImageView listImageView;

    @FXML
    ImageView firstImageView;

    @FXML
    ImageView previousImageView;

    @FXML
    ImageView nextImageView;

    @FXML
    ImageView lastImageView;

    @FXML
    ComboBox codeComboBox;

    @FXML
    ComboBox nameComboBox;

    @FXML
    ComboBox printCodeComboBox;

    @FXML
    TableView<Itemkarigaraccessry> karigar_TableView;

    @FXML
    TableColumn<Itemkarigaraccessry, String> karigar_DetailColumn;

    @FXML
    TableColumn<Itemkarigaraccessry, Double> karigar_GrossColumn;

    @FXML
    TableColumn<Itemkarigaraccessry, Double> karigar_WeightColumn;

    @FXML
    TableColumn<Itemkarigaraccessry, Double> karigar_RateColumn;

    @FXML
    TableColumn<Itemkarigaraccessry, Double> karigar_AmountColumn;

    @FXML
    TableView<Itemjadtaraccessry> jadtar_TableView;

    @FXML
    TableColumn<Itemjadtaraccessry, String> jadtar_AccessoryColumn;

    @FXML
    TableColumn<Itemjadtaraccessry, Double> jadtar_CaratColumn;

    @FXML
    TableColumn<Itemjadtaraccessry, Double> jadtar_WeightColumn;

    @FXML
    TableColumn<Itemjadtaraccessry, Double> jadtar_QtyColumn;

    @FXML
    TableColumn<Itemjadtaraccessry, Double> jadtar_RateColumn;

    @FXML
    TableColumn<Itemjadtaraccessry, Double> jadtar_AmountColumn;

    @FXML
    TableView<Itemreadyaccessry> ready_TableView;

    @FXML
    TableColumn<Itemreadyaccessry, String> ready_AccessoryColumn;

    @FXML
    TableColumn<Itemreadyaccessry, Double> ready_CaratColumn;

    @FXML
    TableColumn<Itemreadyaccessry, Double> ready_WeightColumn;

    @FXML
    TableColumn<Itemreadyaccessry, Double> ready_QtyColumn;

    @FXML
    TableColumn<Itemreadyaccessry, Double> ready_RateColumn;

    @FXML
    TableColumn<Itemreadyaccessry, Double> ready_AmountColumn;

    @FXML
    TextField karigar_GrossField;

    @FXML
    TextField karigar_WeightField;

    @FXML
    TextField karigar_RateField;

    @FXML
    TextField jadtar_CaratField;

    @FXML
    TextField jadtar_WeightField;

    @FXML
    TextField jadtar_Qtyield;

    @FXML
    TextField jadtar_RateField;

    @FXML
    TextField ready_AccessoryField;

    @FXML
    TextField ready_CaratField;

    @FXML
    TextField ready_WeightField;

    @FXML
    TextField ready_QtyField;

    @FXML
    TextField ready_RateField;

    @FXML
    TextField karigar_AmountField;

    @FXML
    private AnchorPane AnchorPane1;

    @FXML
    private TextField karigar_DetailField;

    @FXML
    private TextField jadtar_AccessoryField;

    @FXML
    private TextField jadtar_AmountField;

    @FXML
    private Button jadtar_AddBtn;

    @FXML
    private TextField ready_AmountField;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setTotalPages(getTotalItems());
        getItem(totalPages - ONE);
        setCurrentPage(totalPages - ONE);
        setup();
        setupTables();


    }

    void initializeFromItemListing(Items items) {
        setTotalPages(getTotalItems());
        setCurrentPage(Math.toIntExact(items.getId() - ONE));
        getItem(currentPage);
        setup();
        setupTables();
    }

    public void setup() {
        Runnable populate = this::populateComboBox;
        populate.run();

        // Autocomplete items
        TextFields.bindAutoCompletion(partyNameField, getAcntmst());
        TextFields.bindAutoCompletion(karigarNameField, getKarigar());
        TextFields.bindAutoCompletion(jadtarKarigarNameField, getJadtar());
        TextFields.bindAutoCompletion(karigar_DetailField, getAccessoryDetails());
        TextFields.bindAutoCompletion(jadtar_AccessoryField, getAccessoryDetails());
        TextFields.bindAutoCompletion(ready_AccessoryField, getAccessoryDetails());
        setAllTabMoveFunctionalities();
    }


    private void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    private void setAllTabMoveFunctionalities() {
        itemCodeField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        itemNameField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        partyNameField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigarNameField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        jadtarKarigarNameField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        printCodeField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_IssueDate.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_GhatGrossWtField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_GhatWtField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_PurityField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_LabourField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_GhatGrossWt2Field.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_Purity2Field.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_NetFineField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_MTWeightField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_MTNameField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        // karigar tab starts here
        karigar_GrossField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_WeightField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_RateField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        karigar_DetailField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_AccessoryField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_CaratField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_WeightField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_Qtyield.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_RateField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        ready_AccessoryField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_CaratField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_WeightField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_QtyField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_RateField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        //jdtar down tab movement starts
        jadtar_JadtarGrossWtField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_KundanField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_RacketField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_TotalKundanField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_TotalAmountField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        jadtar_TotalVaxField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        //ready down tab movement starts
        ready_ReadyGrossWtField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_FittingWtField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_NetWtField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_NetKundanField.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });
        ready_ReadyDate.setOnKeyPressed((myEvent) -> {
            try {
                checkKeyPressed(myEvent);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        });

        // karigar number validation  starts here
        karigar_GrossField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    karigar_GrossField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                    setKarigar_Amount();
                }
            }

        });
        karigar_WeightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    karigar_WeightField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                    setKarigar_Amount();
                }
            }
        });
        karigar_RateField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    karigar_RateField.setText(newValue.replaceAll("[^\\^0-9.]", ""));

                    setKarigar_Amount();
                }
            }
        });
//jadtr
        jadtar_CaratField.textProperty().addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    jadtar_CaratField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                    jadtar_WeightField.setDisable(true);
                    jadtar_Qtyield.setDisable(true);
                    setJadTar_Amount_2();
                }
            }
        });
        jadtar_WeightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    jadtar_WeightField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                    jadtar_CaratField.setDisable(true);
                    jadtar_Qtyield.setDisable(true);
                    setJadTar_Amount_1();
                }
            }
        });

        jadtar_Qtyield.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    jadtar_Qtyield.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                }
            }
        });

        jadtar_RateField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    jadtar_RateField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                }
            }
        });
        // ready

        ready_CaratField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    ready_CaratField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                }
            }
        });

        ready_WeightField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    ready_WeightField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                }
            }
        });

        ready_QtyField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    ready_QtyField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                }
            }
        });

        ready_RateField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue,
                                String newValue) {
                if (!newValue.matches("[^\\^0-9.]")) {
                    ready_RateField.setText(newValue.replaceAll("[^\\^0-9.]", ""));
                }
            }
        });
    }

    public void checkKeyPressed(javafx.scene.input.KeyEvent myEvent2) throws InterruptedException {
        KeyCode keycode = myEvent2.getCode();
        if ((keycode == KeyCode.TAB) && (itemCodeField.isFocused() == true)) {
            itemNameField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (itemNameField.isFocused() == true)) {
            partyNameField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (partyNameField.isFocused() == true)) {
            karigarNameField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigarNameField.isFocused() == true)) {
            jadtarKarigarNameField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (jadtarKarigarNameField.isFocused() == true)) {
            printCodeField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (printCodeField.isFocused() == true)) {
            karigar_IssueDate.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_IssueDate.isFocused())) {
            karigar_GhatGrossWtField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_GhatGrossWtField.isFocused() == true)) {
            karigar_GhatWtField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_GhatWtField.isFocused() == true)) {
            karigar_PurityField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_PurityField.isFocused() == true)) {
            karigar_LabourField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_LabourField.isFocused() == true)) {
            karigar_GhatGrossWt2Field.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_GhatGrossWt2Field.isFocused() == true)) {
            karigar_Purity2Field.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_Purity2Field.isFocused() == true)) {
            karigar_NetFineField.requestFocus();
            wait();
            //side part tarts here
        } else if ((keycode == KeyCode.TAB) && (karigar_MTNameField.isFocused() == true)) {
            karigar_MTWeightField.requestFocus();

            wait();

        } else if ((keycode == KeyCode.TAB) && (karigar_Purity2Field.isFocused() == true)) {
            karigar_NetFineField.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_NetFineField.isFocused() == true)) {
            karigar_MTWeightField.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_MTWeightField.isFocused() == true)) {
            karigar_MTNameField.requestFocus();

            wait();

            //kariger right starts
        } else if ((keycode == KeyCode.TAB) && (karigar_DetailField.isFocused() == true)) {
            karigar_GrossField.requestFocus();

            wait();

        } else if ((keycode == KeyCode.TAB) && (karigar_GrossField.isFocused() == true)) {
            karigar_WeightField.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_WeightField.isFocused() == true)) {
            karigar_RateField.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (karigar_RateField.isFocused() == true)) {
            karigar_AmountField.requestFocus();

            wait();

            //jartar
        } else if ((keycode == KeyCode.TAB) && (jadtar_AccessoryField.isFocused() == true)) {
            jadtar_CaratField.requestFocus();

            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_CaratField.isFocused() == true)) {
            jadtar_WeightField.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (jadtar_WeightField.isFocused() == true)) {
            jadtar_Qtyield.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (jadtar_Qtyield.isFocused() == true)) {
            jadtar_RateField.requestFocus();

            wait();
        } else if ((keycode == KeyCode.TAB) && (jadtar_RateField.isFocused() == true)) {
            jadtar_AmountField.requestFocus();
            wait();

            //ready right starts
        } else if ((keycode == KeyCode.TAB) && (ready_AccessoryField.isFocused() == true)) {
            ready_CaratField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_CaratField.isFocused() == true)) {
            ready_WeightField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_WeightField.isFocused() == true)) {
            ready_QtyField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_QtyField.isFocused() == true)) {
            ready_RateField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_RateField.isFocused() == true)) {
            ready_AmountField.requestFocus();
            wait();

            //jadtr last
        } else if ((keycode == KeyCode.TAB) && (jadtar_ReceiveDate.isFocused() == true)) {
            jadtar_JadtarGrossWtField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_JadtarGrossWtField.isFocused() == true)) {
            jadtar_KundanField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_KundanField.isFocused() == true)) {
            jadtar_RacketField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_RacketField.isFocused() == true)) {
            jadtar_TotalKundanField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_TotalKundanField.isFocused() == true)) {
            jadtar_TotalAmountField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_TotalAmountField.isFocused() == true)) {
            jadtar_TotalVaxField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (jadtar_TotalVaxField.isFocused() == true)) {
            jadtar_AccessoryField.requestFocus();
            wait();

            //ready last    
        } else if ((keycode == KeyCode.TAB) && (ready_ReadyGrossWtField.isFocused() == true)) {
            ready_FittingWtField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_FittingWtField.isFocused() == true)) {
            ready_NetWtField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_NetWtField.isFocused() == true)) {
            ready_NetKundanField.requestFocus();
            wait();
        } else if ((keycode == KeyCode.TAB) && (ready_NetKundanField.isFocused() == true)) {
            ready_ReadyDate.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (ready_ReadyDate.isFocused() == true)) {
            ready_AccessoryField.requestFocus();
            wait();

        } else if ((keycode == KeyCode.TAB) && (karigar_MTNameField.isFocused() == true)) {
            karigar_DetailField.requestFocus();
            wait();

        } else {

        }

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
    public void handleScanImage() {

//		manager = Manager.getInstance();
//		devices = manager.listDevices();
        // If there are no scanners connected
        //if (devices.isEmpty()) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
        alert.setHeaderText("Look, an Error Dialog");
        alert.setContentText("Ooops, no device connected!");
        alert.showAndWait();
        //}
        // If there are devices connected
        //else {
        //device ="mydevice";
        File scandir = new File("Scanned Images");
        if (!scandir.exists()) {
            scandir.mkdir();
        }
        BufferedImage bimage = null;
//			try {
//				bimage = SynchronousHelper.scanImage(device);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
        File outputfile = new File("saved.png");
        try {
            ImageIO.write(bimage, "png", outputfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //}
    }

    @FXML
    public void handlePrintImage() {
        Map<String, Object> parameters = new HashMap<>();
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(masterService.report(items.getId()));
        InputStream inputStream = this.getClass().getResourceAsStream("/reports/report.jrxml");
        JasperReport jasperReport = null;
        try {
            jasperReport = JasperCompileManager.compileReport(inputStream);

        } catch (JRException e) {
            e.printStackTrace();
        }
        parameters.put("ReportTitle", "Receipt");
        parameters.put("param", " items.id=" + items.getId().toString());
        parameters.put("knamep", items.getItemKarigar().toString());
        parameters.put("jnamep", items.getJadtarmst().getName());
        parameters.put("itemnamep", items.getKarigarmst().getName());
        parameters.put("itemcode", items.getId().toString());
        SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
        String dtstring = sd.format(items.getItemdate());
        parameters.put("dtstring", dtstring);
        parameters.put("mtwt", items.getItemKarigar().getMtwt().toString());
        parameters.put("pname", items.getAcntmst().getName());
        InputStream imageStream = items.getScanImage().getBinaryStream();
        BufferedImage image = ImageIO.read(imageStream);
        parameters.put("scanimage", image);
        JasperPrint jasperPrint = null;
        try {
           jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        } catch (JRException e) {
            e.printStackTrace();
        }
        JRPdfExporter exporter = new JRPdfExporter();

        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.setExporterOutput(
                new SimpleOutputStreamExporterOutput("employeeReport.pdf"));
        try {
            exporter.exportReport();
        } catch (JRException e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void handleScanReadyImage() {

    }

    @FXML
    public void handlePrintReadyImage() {

    }

    @FXML
    private void handleFirst() {
        setCurrentPage(ZERO);
        getItem(currentPage);
    }

    @FXML
    private void handlePrevious() {
        if (getCurrentPage() != ZERO) {
            setCurrentPage(currentPage -= ONE);
        }
        getItem(currentPage);
    }

    @FXML
    private void handleNext() {
        if (getCurrentPage() < totalPages - ONE) {
            setCurrentPage(currentPage += ONE);
        }
        getItem(currentPage);
    }

    @FXML
    private void handleLast() {
        setCurrentPage(totalPages - ONE);
        getItem(currentPage);
    }

    @FXML
    public void handleItemAdd() {
        if (check4MandatoryFields()) {
            isEditMode = true;
            enableEditMode();
            listNewItem();
        }

    }

    private boolean check4MandatoryFields() {
        boolean result = false;
        if ((itemNameField.getText() == null) || (itemNameField.getText().isEmpty())) {
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            alertInfo.setTitle("Confirmation Dialog");
            alertInfo.setContentText("Item Name Cannot be empty");
            alertInfo.showAndWait();
        } else if ((partyNameField.getText() == null) || (partyNameField.getText().isEmpty())) {
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            alertInfo.setTitle("Confirmation Dialog");
            alertInfo.setContentText("Party Name Cannot be empty");
            alertInfo.showAndWait();
        } else if ((karigarNameField.getText() == null) || (karigarNameField.getText().isEmpty())) {
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            alertInfo.setTitle("Confirmation Dialog");
            alertInfo.setContentText("Karigar Name Cannot be empty");
            alertInfo.showAndWait();
        } else if ((jadtarKarigarNameField.getText() == null) || (jadtarKarigarNameField.getText().isEmpty())) {
            Alert alertInfo = new Alert(Alert.AlertType.INFORMATION);
            alertInfo.setTitle("Confirmation Dialog");
            alertInfo.setContentText("Jadtar Karigar Name Cannot be empty");
            alertInfo.showAndWait();
        } else {
            result = true;
        }

        return result;
    }

    @FXML
    public void handleItemUpdate() {
        isEditMode = false;
        enableEditMode();
    }

    @FXML
    public void handleSaveItem() {
        disableEditMode();
        if (isEditMode) {
            // Adding new item
            getNewItem();
            getNewItemkarigar();
            getNewItemjadtar();
            getNewItemready();
            masterService.save(items);
            itemkarigarService.save(itemkarigar);
            itemjadtarService.save(itemjadtar);
            itemreadyService.save(itemready);
            // increment total number of pages
            totalPages++;
        } else {
            // Update current item
            updateItem();
            updateItemkarigar();
            updateItemjadtar();
            updateItemready();
            masterService.update(items);
            itemkarigarService.update(itemkarigar);
            itemjadtarService.update(itemjadtar);
            itemreadyService.update(itemready);
        }

    }

    @FXML
    public void handleItemDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmation Delete Dialog");
        alert.setHeaderText("Confirmation you are deleting this item");
        alert.setContentText("Are you ok with deleting?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            // ... user chose OK
            masterRepository.delete(items.getId());
            handlePrevious();
        } else {
            // ... user chose CANCEL or closed the dialog
            System.err.println("Deletion canceled!");
        }
    }

    @FXML
    public void handleCloseItem() {
        if (isEditMode) {
            disableEditMode();
            getItem(currentPage);
        } else {
            enableEditMode();
            getItem(currentPage);
        }
    }

    @FXML
    public void handleSearchByCode() {
        int item = codeComboBox.getSelectionModel().getSelectedIndex();
        getItem(item);
    }

    @FXML
    public void handleSearchByName() {
        int item = Math.toIntExact(
                masterService.findByItemname(nameComboBox.getSelectionModel().getSelectedItem().toString()).getId());
        getItem(item);

    }

    @FXML
    public void handleSearchByPrintCode() {

    }

    private void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    private int getCurrentPage() {
        return currentPage;
    }

    private int getTotalItems() {
        Pageable pageable = new PageRequest(0, PAGE_SIZE);
        Page<Items> items = masterService.findAll(pageable);
        return items.getTotalPages();
    }

    private void getItem(int page) {
        Pageable pageable = new PageRequest(page, PAGE_SIZE);
        Page<Items> items = masterService.findAll(pageable);
        this.items = items.getContent().get(0);
        this.itemkarigar = this.items.getItemKarigar();
        this.itemjadtar = this.items.getItemJadtar();
        this.itemready = this.items.getItemReady();
        listItem();

        if (this.itemkarigar != null)
            listItemKarigar();
        if (this.itemjadtar != null)
            listItemJadtar();
        if (this.itemready != null)
            listItemReady();

        if (this.itemkarigaraccessries != null)
            listItemKarigarAccessry();
        if (this.itemjadtaraccessries != null)
            listItemJadtarAccessry();
        if (this.itemreadyaccessries != null)
            listItemReadyAccessry();

    }

    private void listItem() {
        itemCodeField.setText(items.getItemcode());
        itemNameField.setText(items.getItemname());
        partyNameField.setText(items.getAcntmst().getName());
        karigarNameField.setText(items.getKarigarmst().getName());
        jadtarKarigarNameField.setText(items.getJadtarmst().getName());
        try {
            InputStream is = items.getScanImage().getBinaryStream();
            Image image = new Image(is, imageRequestWidth, imageRequestHeight, false, false);
            masterImageView1.setImage(image);
        } catch (SQLException e) {
            System.err.println("SQL image exception");
        } catch (NullPointerException ex) {
            masterImageView1.imageProperty().set(null);
            System.err.println("Null scan image");
        }
        try {
            InputStream is = items.getReadyImage().getBinaryStream();
            Image image = new Image(is, imageRequestWidth, imageRequestHeight, false, false);
            masterImageView2.setImage(image);
        } catch (SQLException e) {
            System.err.println("SQL image exception");
        } catch (NullPointerException ex) {
            masterImageView2.imageProperty().set(null);
            System.err.println("Null ready image");
        }
    }

    private void listItemKarigar() {
        setDoubleOnTextField(karigar_GhatGrossWtField, items.getItemKarigar().getGhatgrswt());
        setDoubleOnTextField(karigar_GhatWtField, items.getItemKarigar().getGhatgrswt());
        setDoubleOnTextField(karigar_PurityField, items.getItemKarigar().getPurity());
        setDoubleOnTextField(karigar_LabourField, items.getItemKarigar().getKarigarlabour());
        setDoubleOnTextField(karigar_GhatGrossWt2Field, items.getItemKarigar().getGhatwt2());
        setDoubleOnTextField(karigar_Purity2Field, items.getItemKarigar().getPurity2());
        setDoubleOnTextField(karigar_NetFineField, items.getItemKarigar().getNetFine());
        setDoubleOnTextField(karigar_MTWeightField, items.getItemKarigar().getMtwt());
        setStringOnTextField(karigar_MTNameField, items.getItemKarigar().getMtname());
        try {
            Date input = items.getItemKarigar().getIssuedate();
            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            karigar_IssueDate.setValue(date);
        } catch (NullPointerException e) {
            System.err.println("Null  date value in Item karigar");
        }
    }

    private void listItemJadtar() {
        setDoubleOnTextField(jadtar_JadtarGrossWtField, items.getItemJadtar().getJadaigrswt());
        setDoubleOnTextField(jadtar_KundanField, items.getItemJadtar().getKundan());
        setStringOnTextField(jadtar_RacketField, items.getItemJadtar().getRacket());
        setDoubleOnTextField(jadtar_TotalKundanField, items.getItemJadtar().getTotalkundan());
        setDoubleOnTextField(jadtar_TotalAmountField, items.getItemJadtar().getTotalamount());
        setDoubleOnTextField(jadtar_TotalVaxField, items.getItemJadtar().getTotalvax());
        try {
            Date input = items.getItemJadtar().getRecdate();
            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            jadtar_ReceiveDate.setValue(date);
        } catch (NullPointerException e) {
            System.err.println("Null date value in Item jadtar");
        }
    }

    private void listItemReady() {
        setDoubleOnTextField(ready_ReadyGrossWtField, items.getItemReady().getReadygrswt());
        setDoubleOnTextField(ready_FittingWtField, items.getItemReady().getFittingwt());
        setDoubleOnTextField(ready_NetWtField, items.getItemReady().getNetwt());
        setDoubleOnTextField(ready_NetKundanField, items.getItemReady().getNetkundan());
        try {
            Date input = items.getItemReady().getReadydate();
            LocalDate date = input.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            ready_ReadyDate.setValue(date);
        } catch (NullPointerException e) {
            System.err.println("Null date value in Item ready");
        }
    }

    private void listItemKarigarAccessry() {
        karigar_TableView.getItems().clear();
        itemkarigaraccessries.addAll(itemkarigaraccessryService.findByItemkarigar(this.itemkarigar));
        karigar_TableView.setItems(itemkarigaraccessries);
    }

    private void listItemJadtarAccessry() {
        jadtar_TableView.getItems().clear();
        itemjadtaraccessries.addAll(itemjadtaccessryService.findByItemjadtar(this.itemjadtar));
        jadtar_TableView.setItems(itemjadtaraccessries);
    }

    private void listItemReadyAccessry() {
        ready_TableView.getItems().clear();
        itemreadyaccessries.addAll(itemreadyaccessryService.findByItemready(this.itemready));
        ready_TableView.setItems(itemreadyaccessries);
    }

    private void getNewItem() {
        Items item = new Items();
        item.setItemcode(String.valueOf(totalPages + ONE));
        item.setItemname(itemNameField.getText());
        item.setKarigarmst(karigarmstService.findByName(karigarNameField.getText()));
        item.setJadtarmst(jadtarmstService.findByName(jadtarKarigarNameField.getText()));
        item.setAcntmst(acntmstService.findByName(partyNameField.getText()));
        this.items = item;
    }

    private void getNewItemkarigar() {
        // Karigar tab
        Itemkarigar itemkarigar = new Itemkarigar();
        itemkarigar.setIssuedate(getDate(karigar_IssueDate));
        itemkarigar.setGhatgrswt(getDoubleFromTextField(karigar_GhatGrossWtField));
        itemkarigar.setGhatwt(getDoubleFromTextField(karigar_GhatWtField));
        itemkarigar.setPurity(getDoubleFromTextField(karigar_PurityField));
        itemkarigar.setKarigarlabour(getDoubleFromTextField(karigar_LabourField));
        itemkarigar.setGhatwt2(getDoubleFromTextField(karigar_GhatGrossWt2Field));
        itemkarigar.setPurity2(getDoubleFromTextField(karigar_Purity2Field));
        itemkarigar.setNetFine(getDoubleFromTextField(karigar_NetFineField));
        itemkarigar.setMtname(karigar_MTNameField.getText());
        itemkarigar.setMtwt(getDoubleFromTextField(karigar_MTWeightField));
        itemkarigar.setItems(items);
        this.itemkarigar = itemkarigar;
    }

    private void getNewItemjadtar() {
        // Jadtar
        Itemjadtar itemjadtar = new Itemjadtar();
        itemjadtar.setTotalkundan(getDoubleFromTextField(jadtar_TotalKundanField));
        itemjadtar.setTotalamount(getDoubleFromTextField(jadtar_TotalAmountField));
        itemjadtar.setTotalvax(getDoubleFromTextField(jadtar_TotalVaxField));
        itemjadtar.setRecdate(getDate(jadtar_ReceiveDate));
        itemjadtar.setRacket(jadtar_RacketField.getText());
        itemjadtar.setJadaigrswt(getDoubleFromTextField(jadtar_JadtarGrossWtField));
        itemjadtar.setKundan(getDoubleFromTextField(jadtar_KundanField));

        itemjadtar.setItems(items);
        this.itemjadtar = itemjadtar;
    }

    private void getNewItemready() {
        // Ready
        Itemready itemready = new Itemready();
        itemready.setReadygrswt(getDoubleFromTextField(ready_ReadyGrossWtField));
        itemready.setReadydate(getDate(ready_ReadyDate));
        itemready.setFittingwt(getDoubleFromTextField(ready_FittingWtField));
        itemready.setNetwt(getDoubleFromTextField(ready_NetWtField));
        itemready.setNetkundan(getDoubleFromTextField(ready_NetKundanField));
        itemready.setItems(items);
        this.itemready = itemready;
    }

    private void listNewItem() {
        // item
        itemCodeField.clear();
        itemCodeField.setText(String.valueOf(totalPages + ONE));
        itemNameField.clear();
        partyNameField.clear();
        karigarNameField.clear();
        jadtarKarigarNameField.clear();
        masterImageView1.imageProperty().set(null);
        masterImageView2.imageProperty().set(null);

        // Karigar
        karigar_IssueDate.getEditor().clear();
        karigar_GhatGrossWtField.clear();
        karigar_GhatWtField.clear();
        karigar_PurityField.clear();
        karigar_LabourField.clear();
        karigar_GhatGrossWt2Field.clear();
        karigar_Purity2Field.clear();
        karigar_NetFineField.clear();
        karigar_MTWeightField.clear();
        karigar_MTNameField.clear();

        // Jadtar
        jadtar_ReceiveDate.getEditor().clear();
        jadtar_JadtarGrossWtField.clear();
        jadtar_KundanField.clear();
        jadtar_RacketField.clear();
        jadtar_TotalKundanField.clear();
        jadtar_TotalAmountField.clear();
        jadtar_TotalVaxField.clear();

        // Ready
        ready_ReadyGrossWtField.clear();
        ready_FittingWtField.clear();
        ready_NetWtField.clear();
        ready_NetKundanField.clear();
        ready_ReadyDate.getEditor().clear();

    }

    private Date getDate(DatePicker datePicker) {
        LocalDate localDate = datePicker.getValue();
        Instant instant = Instant.from(localDate.atStartOfDay(ZoneId.systemDefault()));
        return Date.from(instant);
    }

    private Double getDoubleFromTextField(TextField textField) {
        Double value = null;
        try {
            value = Double.valueOf(textField.getText());
        } catch (NumberFormatException e) {
            System.err.println("Value from text field is not a double");
            value = 0.0;
        }
        return value;
    }

    private void setDoubleOnTextField(TextField textField, Double value) {
        try {
            textField.setText(String.valueOf(value));
        } catch (NullPointerException e) {
            System.err.println("Null setDoubleOnTextField");
            textField.setText("0.0");
        }
    }

    private void setStringOnTextField(TextField textField, String value) {
        if (value == null) {
            value = "";
        }
        textField.setText(value);
    }

    private void enableEditMode() {
        isEditMode = true;
        // Item
        itemNameField.setEditable(true);
        partyNameField.setEditable(true);
        karigarNameField.setEditable(true);
        jadtarKarigarNameField.setEditable(true);

        codeComboBox.setDisable(true);
        codeComboBox.setEditable(false);

        nameComboBox.setDisable(true);
        printCodeComboBox.setDisable(true);

        nameComboBox.setEditable(false);
        printCodeComboBox.setEditable(false);

        // Karigar
        karigar_IssueDate.setEditable(true);
        karigar_GhatGrossWtField.setEditable(true);
        karigar_GhatWtField.setEditable(true);
        karigar_PurityField.setEditable(true);
        karigar_LabourField.setEditable(true);
        karigar_GhatGrossWt2Field.setEditable(true);
        karigar_Purity2Field.setEditable(true);
        karigar_NetFineField.setEditable(true);
        karigar_MTWeightField.setEditable(true);
        karigar_MTNameField.setEditable(true);

        // Jadtar
        jadtar_ReceiveDate.setEditable(true);
        jadtar_JadtarGrossWtField.setEditable(true);
        jadtar_KundanField.setEditable(true);
        jadtar_RacketField.setEditable(true);
        jadtar_TotalKundanField.setEditable(true);
        jadtar_TotalAmountField.setEditable(true);
        jadtar_TotalVaxField.setEditable(true);

        // Ready
        ready_ReadyGrossWtField.setEditable(true);
        ready_FittingWtField.setEditable(true);
        ready_NetWtField.setEditable(true);
        ready_NetKundanField.setEditable(true);
        ready_ReadyDate.setEditable(true);

        addImageView.setImage(new Image("images/drawable-hdpi/ic_add_circle_grey_600_48dp.png"));
        updateImageView.setImage(new Image("images/drawable-hdpi/ic_mode_edit_grey_600_48dp.png"));
        saveImageView.setImage(new Image("images/drawable-hdpi/ic_save_blue_800_48dp.png"));
        deleteImageView.setImage(new Image("images/drawable-hdpi/ic_delete_grey_600_48dp.png"));
        listImageView.setImage(new Image("images/drawable-hdpi/ic_list_grey_600_48dp.png"));
        firstImageView.setImage(new Image("images/drawable-hdpi/ic_first_page_grey_600_48dp.png"));
        previousImageView.setImage(new Image("images/drawable-hdpi/ic_navigate_before_grey_600_48dp.png"));
        nextImageView.setImage(new Image("images/drawable-hdpi/ic_navigate_next_grey_600_48dp.png"));
        lastImageView.setImage(new Image("images/drawable-hdpi/ic_last_page_grey_600_48dp.png"));

        addButton.setDisable(true);
        updateButton.setDisable(true);
        saveButton.setDisable(false);
        closeButton.setDisable(false);
        deleteButton.setDisable(true);
        listButton.setDisable(true);
        firstButton.setDisable(true);
        previousButton.setDisable(true);
        nextButton.setDisable(true);
        lastButton.setDisable(true);



    }

    private void disableEditMode() {
        isEditMode = false;
        // Item
        itemNameField.setEditable(false);
        partyNameField.setEditable(false);
        karigarNameField.setEditable(false);
        jadtarKarigarNameField.setEditable(false);

        // Karigar
        karigar_IssueDate.setEditable(false);
        karigar_GhatGrossWtField.setEditable(false);
        karigar_GhatWtField.setEditable(false);
        karigar_PurityField.setEditable(false);
        karigar_LabourField.setEditable(false);
        karigar_GhatGrossWt2Field.setEditable(false);
        karigar_Purity2Field.setEditable(false);
        karigar_NetFineField.setEditable(false);
        karigar_MTWeightField.setEditable(false);
        karigar_MTNameField.setEditable(false);

        // Jadtar
        jadtar_ReceiveDate.setEditable(false);
        jadtar_JadtarGrossWtField.setEditable(false);
        jadtar_KundanField.setEditable(false);
        jadtar_RacketField.setEditable(false);
        jadtar_TotalKundanField.setEditable(false);
        jadtar_TotalAmountField.setEditable(false);
        jadtar_TotalVaxField.setEditable(false);

        // Ready
        ready_ReadyGrossWtField.setEditable(false);
        ready_FittingWtField.setEditable(false);
        ready_NetWtField.setEditable(false);
        ready_NetKundanField.setEditable(false);
        ready_ReadyDate.setEditable(false);

        addImageView.setImage(new Image("images/drawable-hdpi/ic_add_circle_green_800_48dp.png"));
        updateImageView.setImage(new Image("images/drawable-hdpi/ic_mode_edit_amber_800_48dp.png"));
        saveImageView.setImage(new Image("images/drawable-hdpi/ic_save_grey_600_48dp.png"));
        deleteImageView.setImage(new Image("images/drawable-hdpi/ic_delete_red_800_48dp.png"));
        listImageView.setImage(new Image("images/drawable-hdpi/ic_list_teal_800_48dp.png"));
        firstImageView.setImage(new Image("images/drawable-hdpi/ic_first_page_blue_800_48dp.png"));
        previousImageView.setImage(new Image("images/drawable-hdpi/ic_navigate_before_blue_800_48dp.png"));
        nextImageView.setImage(new Image("images/drawable-hdpi/ic_navigate_next_blue_800_48dp.png"));
        lastImageView.setImage(new Image("images/drawable-hdpi/ic_last_page_blue_800_48dp.png"));

        addButton.setDisable(false);
        updateButton.setDisable(false);
        saveButton.setDisable(true);
        closeButton.setDisable(false);
        deleteButton.setDisable(false);
        listButton.setDisable(false);
        firstButton.setDisable(false);
        previousButton.setDisable(false);
        nextButton.setDisable(false);
        lastButton.setDisable(false);

        karigar_TableView.setEditable(false);
        jadtar_TableView.setEditable(false);
        ready_TableView.setEditable(false);
    }

    private void updateItem() {
        items.setItemname(itemNameField.getText());
        items.setAcntmst(acntmstService.findByName(partyNameField.getText()));
        items.setKarigarmst(karigarmstService.findByName(karigarNameField.getText()));
        items.setJadtarmst(jadtarmstService.findByName(jadtarKarigarNameField.getText()));
    }

    private void updateItemkarigar() {
        itemkarigar.setIssuedate(getDate(karigar_IssueDate));
        itemkarigar.setGhatgrswt(getDoubleFromTextField(karigar_GhatGrossWtField));
        itemkarigar.setGhatwt(getDoubleFromTextField(karigar_GhatWtField));
        itemkarigar.setPurity2(getDoubleFromTextField(karigar_Purity2Field));
        itemkarigar.setNetFine(getDoubleFromTextField(karigar_NetFineField));
        itemkarigar.setPurity(getDoubleFromTextField(karigar_PurityField));
        itemkarigar.setKarigarlabour(getDoubleFromTextField(karigar_LabourField));
        itemkarigar.setGhatwt2(getDoubleFromTextField(karigar_GhatGrossWt2Field));
        itemkarigar.setMtname(karigar_MTNameField.getText());
        itemkarigar.setMtwt(getDoubleFromTextField(karigar_MTWeightField));
    }

    private void updateItemjadtar() {
        itemjadtar.setRecdate(getDate(jadtar_ReceiveDate));
        itemjadtar.setJadaigrswt(getDoubleFromTextField(jadtar_JadtarGrossWtField));
        itemjadtar.setKundan(getDoubleFromTextField(jadtar_KundanField));
        itemjadtar.setRacket(jadtar_RacketField.getText());
        itemjadtar.setTotalkundan(getDoubleFromTextField(jadtar_TotalKundanField));
        itemjadtar.setTotalamount(getDoubleFromTextField(jadtar_TotalAmountField));
        itemjadtar.setTotalvax(getDoubleFromTextField(jadtar_TotalVaxField));

    }

    private void updateItemready() {
        itemready.setReadygrswt(getDoubleFromTextField(ready_ReadyGrossWtField));
        itemready.setFittingwt(getDoubleFromTextField(ready_FittingWtField));
        itemready.setNetwt(getDoubleFromTextField(ready_NetWtField));
        itemready.setNetkundan(getDoubleFromTextField(ready_NetKundanField));
        itemready.setReadydate(getDate(ready_ReadyDate));
    }

    private List<Karigarmst> getKarigar() {
        return karigarmstService.findAll();
    }

    private List<Jadtarmst> getJadtar() {
        return jadtarmstService.findAll();
    }

    private List<Acntmst> getAcntmst() {
        return acntmstService.findAll();
    }

    private List<Customaccess> getAccessoryDetails() {
        return customaccessService.findAll();
    }

    private void populateComboBox() {
        ObservableList<String> itemCodes = FXCollections.observableArrayList();
        ObservableList<String> itemNames = FXCollections.observableArrayList();
        ObservableList<String> itemPrintCodes = FXCollections.observableArrayList();

        List<Items> itemsList = masterService.findAll();
        for (Items item : itemsList) {
            itemCodes.add(item.getItemcode());
            itemNames.add(item.getItemname());
        }

        List<Mycode> mycodeList = mycodeService.findAll();
        for (Mycode mycode : mycodeList) {
            itemPrintCodes.add(mycode.getMcode());
        }

        codeComboBox.setItems(itemCodes);
        nameComboBox.setItems(itemNames);
        printCodeComboBox.setItems(itemPrintCodes);
    }

    private void setupTables() {

        karigar_TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        karigar_DetailColumn.setCellValueFactory(new PropertyValueFactory<>("details"));
        karigar_GrossColumn.setCellValueFactory(new PropertyValueFactory<>("gross"));
        karigar_WeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        karigar_RateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        karigar_AmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

        jadtar_TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        jadtar_AccessoryColumn.setCellValueFactory(new PropertyValueFactory<>("accessory"));
        jadtar_CaratColumn.setCellValueFactory(new PropertyValueFactory<>("carat"));
        jadtar_WeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        jadtar_QtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        jadtar_RateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));

        ready_TableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        ready_AccessoryColumn.setCellValueFactory(new PropertyValueFactory<>("accessory"));
        ready_CaratColumn.setCellValueFactory(new PropertyValueFactory<>("carat"));
        ready_WeightColumn.setCellValueFactory(new PropertyValueFactory<>("weight"));
        ready_QtyColumn.setCellValueFactory(new PropertyValueFactory<>("qty"));
        ready_RateColumn.setCellValueFactory(new PropertyValueFactory<>("rate"));
        ready_AmountColumn.setCellValueFactory(new PropertyValueFactory<>("amount"));

    }

    @FXML
    private void karigar_handleToday() {
        karigar_IssueDate.setValue(LocalDate.now());
    }

    @FXML
    private void jadtar_handleToday() {
        jadtar_ReceiveDate.setValue(LocalDate.now());
    }

    @FXML
    private void ready_handleToday() {
        ready_ReadyDate.setValue(LocalDate.now());
    }

    private void setKarigar_Amount() {
        float newAmount = 0;
        try {
            newAmount = (float) ((Double.parseDouble(karigar_GrossField.getText()))
                    * (Double.parseDouble(karigar_WeightField.getText()))
                    * (Double.parseDouble(karigar_RateField.getText())));
            karigar_AmountField.setText(String.valueOf(newAmount));
        } catch (NumberFormatException e) {
            System.err.println("Number format exception setKarigarAmount");
        }

    }

    private void setJadTar_Amount_1() {
        float newAmount = 0;
        try {
            newAmount = (float) ((Double.parseDouble(jadtar_WeightField.getText()))
                    * (Double.parseDouble(jadtar_RateField.getText())));
            jadtar_AmountField.setText(String.valueOf(newAmount));
        } catch (NumberFormatException e) {
            System.err.println("Number format exception setKarigarAmount");
        }
    }

    private void setJadTar_Amount_2() {
        float newAmount = 0;
        try {
            newAmount = (float) ((Double.parseDouble(jadtar_CaratField.getText()))
                    * (Double.parseDouble(jadtar_RateField.getText())));
            jadtar_AmountField.setText(String.valueOf(newAmount));
        } catch (NumberFormatException e) {
            System.err.println("Number format exception setKarigarAmount");
        }
    }

    @FXML
    private void handleAddItemKarigarAccessory() {
        Itemkarigaraccessry itemkarigaraccessry = new Itemkarigaraccessry(karigar_DetailField.getText(),
                getDoubleFromTextField(karigar_GrossField),
                getDoubleFromTextField(karigar_WeightField),
                getDoubleFromTextField(karigar_RateField),
                getDoubleFromTextField(karigar_AmountField));
        itemkarigaraccessries.add(itemkarigaraccessry);
        karigar_TableView.setItems(itemkarigaraccessries);
    }

    @FXML
    private void handleUpdateItemKarigarAccessory() {

    }

    @FXML
    private void handleDeleteItemKarigarAccessory() {

    }


    @FXML
    private void handleAddItemJadtarAccessory() {
        Itemjadtaraccessry itemjadtaraccessry = new Itemjadtaraccessry(jadtar_AccessoryField.getText(),
                getDoubleFromTextField(jadtar_CaratField),
                getDoubleFromTextField(jadtar_CaratField),
                getDoubleFromTextField(jadtar_Qtyield),
                getDoubleFromTextField(jadtar_CaratField),
                getDoubleFromTextField(jadtar_AmountField));
        itemjadtaraccessries.add(itemjadtaraccessry);
        jadtar_TableView.setItems(itemjadtaraccessries);
    }


    @FXML
    private void handleUpdateItemJadtarAccessory() {

    }

    @FXML
    private void handleDeleteItemJadtarAccessory() {

    }


    @FXML
    private void handleAddItemReadyAccessory() {
        Itemreadyaccessry itemreadyaccessry = new Itemreadyaccessry(ready_AccessoryField.getText(),
                getDoubleFromTextField(ready_CaratField),
                getDoubleFromTextField(ready_WeightField),
                getDoubleFromTextField(ready_QtyField),
                getDoubleFromTextField(ready_RateField),
                getDoubleFromTextField(ready_AmountField));
        itemreadyaccessries.add(itemreadyaccessry);
        ready_TableView.setItems(itemreadyaccessries);
    }

    @FXML
    private void handleUpdateItemReadyAccessory() {

    }

    @FXML
    private void handleDeleteItemReadyAccessory() {

    }


    private void updateDB() {
        List<Itemkarigaraccessry> list1 = itemkarigaraccessryService.findAll();
        for (Itemkarigaraccessry i : list1) {
            i.setDetails(customaccessService.find(i.getAccessryid().getId()).getName());
            itemkarigaraccessryService.update(i);

        }
        List<Itemjadtaraccessry> list2 = itemjadtaccessryService.findAll();
        for (Itemjadtaraccessry j : list2) {
            j.setAccessory(customaccessService.find(j.getCustomaccess().getId()).getName());
            itemjadtaccessryService.update(j);

        }
        List<Itemreadyaccessry> list3 = itemreadyaccessryService.findAll();
        for (Itemreadyaccessry k : list3) {
            k.setAccessory(customaccessService.find(k.getCustomaccess().getId()).getName());
            itemreadyaccessryService.update(k);

        }
    }

    @FXML
    public void handleDeleteItem() {

    }

    @FXML
    public void handleClearItemReadyAccessory(){

    }

}
