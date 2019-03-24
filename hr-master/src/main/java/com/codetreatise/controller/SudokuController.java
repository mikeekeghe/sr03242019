package com.codetreatise.controller;

import com.codetreatise.config.StageManager;
import com.codetreatise.view.FxmlView;
import de.sfuhrm.sudoku.Creator;
import de.sfuhrm.sudoku.GameMatrix;
import de.sfuhrm.sudoku.Riddle;
import de.sfuhrm.sudoku.Solver;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;

import java.net.URL;
import java.util.ResourceBundle;

@Controller
public class SudokuController  implements Initializable {

    @FXML
    GridPane sudokuGridPane;

    @FXML
    Button exitButton;

    @FXML
    Button oneButton;
    @FXML
    Button twoButton;
    @FXML
    Button threeButton;
    @FXML
    Button fourButton;

    private String code = "";

    @Lazy
    @Autowired
    private StageManager stageManager;


    private GameMatrix matrix = Creator.createFull();

    private void solve(Riddle riddle) {
        Solver solver = new Solver(riddle);
        solver.solve();
    }

    @FXML
    public void handleNew() {
        Riddle riddle = Creator.createRiddle(matrix);
        solve(riddle);
        sudokuGridPane.getChildren().retainAll(sudokuGridPane.getChildren().get(0));
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Text text = new Text(Byte.toString(riddle.get(column, row)));
                text.getStyleClass().add("grid-text");
                // handle empty 0 in suduko grid generated
                if (text.getText().equals("0")) text.setText(" ");
                sudokuGridPane.add(text, row, column);
            }
        }
    }

    @FXML
    public void handleSolve() {
        sudokuGridPane.getChildren().retainAll(sudokuGridPane.getChildren().get(0));
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                Text text = new Text(Byte.toString(matrix.get(column, row)));
                text.getStyleClass().add("grid-text");
                sudokuGridPane.add(text, row, column);
            }
        }
    }

    @FXML
    public void handleExit() {
        Stage primaryStage = (Stage) exitButton.getScene().getWindow();
        exitButton.setOnAction(actionEvent -> primaryStage.close());
    }


    @FXML
    public void handleOneButton() {
        code = code.concat("1");
    }

    @FXML
    public void handleTwoButton() {
        code = code.concat("2");
    }

    @FXML
    public void handleThreeButton() {
        code = code.concat("3");
    }

    @FXML
    public void handleFourButton() {
        code = code.concat("4");
        if (code.equals("1234")) {
             launch();
        }
        else code = "";
    }

    private void launch() {
        stageManager.switchScene(FxmlView.LOGIN);
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        handleNew();
    }
}