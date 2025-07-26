package samples.demo3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.geometry.Insets;

import java.io.IOException;
import java.util.Random;

public class MainController {
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
    private Button exit;
    @FXML
    private Button restart;
    @FXML
    private void initialize() {
        board = new Button[][]{{btn1, btn2, btn3}, {btn4, btn5, btn6}, {btn7, btn8, btn9}};
    }

    @FXML
    private void initialize1() {
        buttons = new Button[]{btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
    }

    @FXML
    private Label myMessage;
    @FXML
    private boolean player = true;
    private int cnt = 0 ;
    @FXML
    private Label indicator;
    @FXML
    private void marcare(ActionEvent event) {
        Button clicked = (Button) event.getSource();
        if (clicked.getText().isEmpty()) {
            clicked.setText("X");
            cnt++;
            clicked.setDisable(true);
            clicked.getParent().requestFocus();
            if (Winner(board,player)) {
               // showWinScene();
                Mesajcastigator(player);
            } else {

                player = false;
                MesajIndicator(player,indicator);
                if (CheckFull(board)) {
                    indicator.setText("Jocul s-a terminat!Nu este niciun castigator!");
                    return;
                }

                Button btn10 = new Button();
                if (checkPlace(board) != null) {
                    btn10 = checkPlace(board);
                } else if(cnt == 1 )
                {
                    btn10=CheckPlayerPlace(board);
                    if(btn10!=null);
                    else {
                        if (board[1][1].getText().equals("X")) {
                            if (checkPlace(board) == null) {
                                Random rand = new Random();
                                int myrand = rand.nextInt(9) + 1;
                                btn10 = getButtonByNumber(myrand);
                                while (!checkButton(btn10)) {
                                    myrand = rand.nextInt(9) + 1;
                                    btn10 = getButtonByNumber(myrand);
                                }

                            } else {
                                btn10 = checkPlace(board);
                            }
                        }
                    }

                }
                else {
                    if (cnt == 2) {
                        if (board[1][1].getText().equals("0")) {
                            btn10 = CheckPlayerPlace(board);
                        if (btn10 == null) {
                            btn10 = board[0][0];
                        }
                        }
                        else {
                            if (checkPlace(board) == null) {
                                Random rand = new Random();
                                int myrand = rand.nextInt(9) + 1;
                                btn10 = getButtonByNumber(myrand);
                                while (!checkButton(btn10)) {
                                    myrand = rand.nextInt(9) + 1;
                                    btn10 = getButtonByNumber(myrand);
                                }

                            } else {
                                btn10 = checkPlace(board);
                            }

                        }
                    } else {
                        if (checkPlace(board) == null) {
                            Random rand = new Random();
                            int myrand = rand.nextInt(9) + 1;
                            btn10 = getButtonByNumber(myrand);
                            while (!checkButton(btn10)) {
                                myrand = rand.nextInt(9) + 1;
                                btn10 = getButtonByNumber(myrand);
                            }

                        } else {
                            btn10 = checkPlace(board);
                        }
                    }
                }
            btn10.setText("0");
            btn10.setDisable(true);

                Button comp = new Button();

                player = true;
                MesajIndicator(player,indicator);
                if (Winner(board,player)) {
                   // showWinScene2();
                    player = false;
                    Mesajcastigator(player);
                }

                if (CheckFull(board)) {
                    indicator.setText("Jocul s-a terminat!Nu este niciun castigator!");
                }

            }
        }
    }

    private boolean Winner(Button[][] board,boolean player) {
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

    private void showWinScene() {
        Parent winRoot = null;
        try {
            winRoot = FXMLLoader.load(getClass().getResource("Scena2.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) btn1.getScene().getWindow(); // orice buton e OK aici
        stage.setScene(new Scene(winRoot));
    }

    private void showWinScene2() {
        Parent winRoot = null;
        try {
            winRoot = FXMLLoader.load(getClass().getResource("Scena3.fxml"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = (Stage) btn1.getScene().getWindow(); // orice buton e OK aici
        stage.setScene(new Scene(winRoot));
    }

    private Button getButtonByNumber(int num) {
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

    private boolean checkButton(Button button) {
        if (button.getText().isEmpty()) return true;
        else return false;
    }

    private boolean CheckFull(Button[][] Board) {
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++)
                if (board[i][j].getText().isEmpty()) return false;
        return true;
    }

    private Button checkPlace(Button[][] board) {
        Button xbut = new Button();
        xbut  = null;
        int cntx = 0;
        int cnty = 0;
        for (int i = 0; i < 3; i++) {
            cntx = 0;
            for (int j = 0; j < 3; j++)
                if (board[i][j].getText().equals("X")) cntx++;
            if (cntx == 2) {
                int j = 0;
                for (j = 0; j < 3; j++) {
                    if (board[i][j].getText().isEmpty() && xbut == null) {
                        xbut = board[i][j];
                    }
                }


            }
        }

        for (int i = 0; i < 3; i++) {
            cntx = 0;
            for (int j = 0; j < 3; j++)
                if (board[j][i].getText().equals("X")) cntx++;
            if (cntx == 2) {
                int j = 0;
                for (j = 0; j < 3; j++) {
                    if (board[j][i].getText().isEmpty() && xbut == null) xbut = board[j][i];
                }


            }
        }
        cntx= 0 ;
        for(int i = 0 ; i<3;i++)
        {

            if(board[i][2-i].getText().equals("X")) cntx++;
        }
        if(cntx==2)
            for(int i = 0 ; i<3;i++)
                if(board[i][2-i].getText().isEmpty()  && xbut == null) xbut = board[i][2-i];
        cntx= 0 ;
        boolean blocked = false;
        for(int i = 0 ; i<3;i++)
        {

            if(board[i][i].getText().equals("X")) cntx++;
            if(board[i][i].getText().equals("0")) {
                blocked = true ;
                break;
            }
        }
        if(cntx==2 && !blocked)
            for(int i = 0 ; i<3;i++) {
                if (board[i][i].getText().isEmpty() && xbut == null) xbut = board[i][i];
            }
        for (int i = 0; i < 3; i++) {
            cnty = 0;
            for (int j = 0; j < 3; j++)
                if (board[j][i].getText().equals("0")) cnty++;
            if (cnty == 2) {
                int j = 0;
                for (j = 0; j < 3; j++) {
                    if (board[j][i].getText().isEmpty() )  {
                        board[j][i].setText("0");
                        if(Winner(board,player)) {
                            board[j][i].setText("");
                            return  board[j][i];
                        }
                        board[j][i].setText("");
                    }

                }
            }
        }
//        if(board[0][0].getText().equals(board[1][1].getText()) && board[2][2].getText().isEmpty()) return board[2][2];
//        if(board[1][1].getText().equals(board[2][2].getText()) && board[0][0].getText().isEmpty()) return board[2][2];
        cnty = 0 ;
        for(int i = 0 ; i<3;i++)
        {

            if(board[i][i].getText().equals("0")) cnty++;
        }
        if(cnty==2)
            for(int i = 0 ; i<3;i++)
                if(board[i][i].getText().isEmpty()) {
                    board[i][i].setText("0");
                    if(Winner(board,player)) {
                        board[i][i].setText("");
                        return  board[i][i];
                    }
                    board[i][i].setText("");
                }

        cnty= 0 ;
        for(int i = 0 ; i<3;i++)
        {

            if(board[i][2-i].getText().equals("0")) cnty++;
        }
        if(cnty==2)
            for(int i = 0 ; i<3;i++)
                if(board[i][2-i].getText().isEmpty())
                {
                    board[i][2-i].setText("0");
                    if(Winner(board,player)) {
                        board[i][2-i].setText("");
                        return  board[i][2-i];
                    }
                    board[i][2-i].setText("");
                }
        for (int i = 0; i < 3; i++) {
            cnty = 0;
            for (int j = 0; j < 3; j++)
                if (board[i][j].getText().equals("0")) cnty++;
            if (cnty == 2) {
                int j = 0;
                for (j = 0; j < 3; j++) {
                    if (board[i][j].getText().isEmpty())  {
                        board[i][j].setText("0");
                        if(Winner(board,player)) {
                            board[i][j].setText("");
                            return  board[i][j];
                        }
                        board[i][j].setText("");
                    };

                }
            }
        }
            return xbut;

    }
    private Button CheckPlayerPlace(Button[][] board) {
            if (!board[0][0].getText().isEmpty()) return board[2][2];
            if (!board[0][2].getText().isEmpty()) return board[2][0];
            if (!board[2][2].getText().isEmpty()) return board[0][0];
            if (!board[2][0].getText().isEmpty()) return board[0][2];
            if (!board[1][1].getText().isEmpty()) return board[0][0];
            if (board[1][1].getText().isEmpty()) return board[1][1];
        return null;
    }
    private void Mesajcastigator(boolean player){
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Jocul s - a terminat");
        alerta.setHeaderText(player ? "Felicitari ai castigat!" : "Din pacate ai pierdut!");
        indicator.setText("Jocul s-a terminat!");
        alerta.showAndWait();
    }
    private void MesajIndicator(boolean player,Label indicator){
        indicator.setText(player ? "Este randul lui X" : "Este randul lui 0");

    }
    @FXML
    private void iesire(ActionEvent event){
        System.exit(1);
    }
    @FXML
    private void restart(ActionEvent event){
        try {
            Parent root = FXMLLoader.load(getClass().getResource("Main.fxml"));
            Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}