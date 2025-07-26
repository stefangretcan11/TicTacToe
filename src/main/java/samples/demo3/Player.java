package samples.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class Player {
    private Stage stage;
    private Scene scene;

    private Parent root;
    @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    @FXML
    private Button btn7;
    @FXML
    private Button btn8;
    @FXML
    private Button btn9;
    @FXML
    private Button buttons[];
    @FXML
    private Button[][] board;

    @FXML
    private void initialize() {
        board = new Button[][]{{btn1, btn2, btn3}, {btn4, btn5, btn6}, {btn7, btn8, btn9}};
    }

    @FXML
    private void initialize1() {
        buttons = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                board[i][j].setFocusTraversable(false);

    }
    @FXML
    private Label indicator;
    @FXML
    private Label myMessage;
    @FXML
    private boolean player = true;
    private int cnt = 0;

    @FXML
    private void marcare1(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        if (clicked.getText().isEmpty()) {
            clicked.setText( player ? "X" : "0");
            clicked.setDisable(true);
            indicator.setText(player ? "Este randul lui 0" : "Este randul lui X");
            if (Winner1(board)) {
                System.out.println("Ai castigat");
                Mesajcastigator(player);
            }
            player  = !player;
            if(CheckFull1(board) ) {
                indicator.setText("Egalitate!Jocul s-a terminat!");
                return;
            }
        }
    }
    private boolean Winner1(Button[][] board) {
        for (int i = 0; i < 3; i++)
            if (!board[i][0].getText().isEmpty() && board[i][0].getText().equals(board[i][1].getText()) && board[i][0].getText().equals(board[i][2].getText())) {
                if(board[i][2].getText().equals("X")) {
                    board[i][0].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                    board[i][1].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                    board[i][2].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                }
                else {
                    board[i][0].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                    board[i][1].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                    board[i][2].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                }
                return true;
            }
        for (int i = 0; i < 3; i++)
            if (!board[0][i].getText().isEmpty() && board[0][i].getText().equals(board[1][i].getText()) && board[0][i].getText().equals(board[2][i].getText())) {
                if(board[0][i].getText().equals("X")) {
                    board[0][i].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                    board[2][i].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                    board[1][i].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                }
                else {
                    board[0][i].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                    board[1][i].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                    board[2][i].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                }
                return true;
            }
        if (!board[0][0].getText().isEmpty() && board[0][0].getText().equals(board[1][1].getText()) && board[0][0].getText().equals(board[2][2].getText()))
        {
            if(board[0][0].getText().equals("X")) {
                board[0][0].setStyle("-fx-background-color: green; -fx-text-fill: white;");
                board[2][2].setStyle("-fx-background-color: green; -fx-text-fill: white;");
                board[1][1].setStyle("-fx-background-color: green; -fx-text-fill: white;");
            }
            else {
                board[0][0].setStyle("-fx-background-color: red; -fx-text-fill: white;");
                board[1][1].setStyle("-fx-background-color: red; -fx-text-fill: white;");
                board[2][2].setStyle("-fx-background-color: red; -fx-text-fill: white;");
            }
            return true;
        }
        if (!board[0][2].getText().isEmpty() && board[0][2].getText().equals(board[1][1].getText()) && board[0][2].getText().equals(board[2][0].getText()))
        {
            if(board[0][2].getText().equals("X")) {
                board[0][2].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                board[2][0].setStyle("-fx-background-color: green;-fx-text-fill: white;");
                board[1][1].setStyle("-fx-background-color: green;-fx-text-fill: white;");
            }
            else {
                board[0][2].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                board[1][1].setStyle("-fx-background-color: red;-fx-text-fill: white;");
                board[2][0].setStyle("-fx-background-color: red;-fx-text-fill: white;");
            }
            return true;
        }
        return false;
    }
//
//    private void showWinScene1() {
//        Parent winRoot = null;
//        try {
//            winRoot = FXMLLoader.load(getClass().getResource("Scena2.fxml"));
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Stage stage = (Stage) btn1.getScene().getWindow(); // orice buton e OK aici
//        stage.setScene(new Scene(winRoot));
//    }
    private Button getButtonByNumber1(int num) {
        switch (num) {
            case 1:
                return btn1;
            case 2:
                return btn2;
            case 3:
                return btn3;
            case 4:
                return btn4;
            case 5:
                return btn5;
            case 6:
                return btn6;
            case 7:
                return btn7;
            case 8:
                return btn8;
            case 9:
                return btn9;
            default:
                return null;
        }
    }
    private boolean checkButton1(Button button) {
        if (button.getText().isEmpty()) return true;
        else return false;
    }
    private boolean CheckFull1(Button[][] Board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].getText().isEmpty()) return false;
        return true;
    }
    @FXML
    private void iesire1(ActionEvent event){
        System.exit(1);
    }
    @FXML
    private void restart1(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Player.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void Mesajcastigator(boolean player){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Jocul s - a terminat");
        alerta.setHeaderText(player ? "Felicitari! X a castigat!" : "Felicitari! 0 a castigat!");
        indicator.setText("Jocul s-a terminat!");
        alerta.showAndWait();
    }
}