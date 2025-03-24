package com.example.market;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;

public class MarketController implements Initializable {
    @FXML
    private Label welcomeText;

    @FXML
    public Boolean turn = true;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("YAY REPLAY THIS SOS GAME!");
    }

    @FXML
    public CheckBox simpleGame;
    public CheckBox generalGame;

    @FXML
    private ChoiceBox<Integer> choiceBox;

    @FXML
    public GridPane gridPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        simpleGame.setSelected(true);
        choiceBox.setValue(8);
        choiceBox.getItems().addAll(2, 3, 4, 5, 6, 7, 8);

        choiceBox.setOnAction(event -> gridSize());


        gridSize();

    }

    @FXML
    protected void onSimpleGameChecked() {
        generalGame.setSelected(false);
        gridSize();

        //begin play

    }

    @FXML
    protected void onGeneralGameChecked() {
        simpleGame.setSelected(false);
        gridSize();

        //begin play


    }

    @FXML
    protected void gridSize() {
        int selected = choiceBox.getValue();

        gridPane.getColumnConstraints().clear();
        gridPane.getRowConstraints().clear();
        gridPane.getChildren().clear();

        for (int size = 0; size < selected; size++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / selected);
            gridPane.getColumnConstraints().add(col);
        }

        for (int size = 0; size < selected; size++) {
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / selected);
            gridPane.getRowConstraints().add(row);
        }

        for (int row = 0; row < selected; row++) {
            for (int column = 0; column < selected; column++) {
                StackPane cell = new StackPane();
                cell.setStyle("-fx-border-color: black");
                cell.setPrefSize(40, 40);

                gridPane.add(cell, column, row);

                final int Frow = row;
                final int Fcolumn = column;




                cell.setOnMouseClicked(event -> WhenCellisClicked(Frow, Fcolumn, cell));

            }
        }
    }

    @FXML
    protected void WhenCellisClicked(int row, int column, StackPane cell) {
        String player = "";
        if (turn == true){
            turn = false;
            player = "S";

            System.out.println(turn);
        } else if (!turn){
            turn = true;
            player = "O";

            System.out.println(turn);
        }



        Label label = new Label(player);
        int selected = choiceBox.getValue();
        if (selected == 2){
            label.setStyle("-fx-font-size: 40px;");
        } else if (selected == 3){
            label.setStyle("-fx-font-size: 30px;");
        } else if (selected == 4){
            label.setStyle("-fx-font-size: 25px;");
        }else if(selected == 5){
                label.setStyle("-fx-font-size: 20px;");
        }else if (selected == 6){
            label.setStyle("-fx-font-size: 19px;");
        }else if (selected == 7){
            label.setStyle("-fx-font-size: 16px;");
        }else if (selected == 8){
            label.setStyle("-fx-font-size: 15px;");
        }
        cell.getChildren().add(label);

    }
}
