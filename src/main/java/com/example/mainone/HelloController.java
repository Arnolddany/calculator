package com.example.mainone;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.ResourceBundle;
import java.util.regex.Pattern;

public class HelloController implements Initializable {
    public int index = 1;
    @FXML
    public Button degreeButton;
    @FXML
    public Button sqrtButton;
    @FXML
    public Button sinButton;
    @FXML
    public Button cosButton;
    @FXML
    public Button tanButton;
    @FXML
    public Button arcsinButton;
    @FXML
    public Button arccosButton;
    @FXML
    public Button arctanButton;
    @FXML
    public Button addButton;
    @FXML
    public Button subButton;
    @FXML
    public Button mulButton;
    @FXML
    public Button divButton;
    public double value;
    @FXML
    public Spinner<Double> spinnerOneField;
    @FXML
    private TextArea listHistory;
    @FXML
    public TextField input2;
    @FXML
    public Label result;
    private final ArrayList<String> historyList = new ArrayList<>();

    @FXML
    protected void clearInput2() {
        if (!input2.getText().isEmpty()) {
            input2.clear();
        }
    }
    @FXML
    private void addResultToHistoryTwoOperands(double a, double b, double res) {
        String timeOperation = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String resultForHistory = null;
        if (addButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] " + a + " + " + b + " = "  + res;
        } else if (subButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] " + a + " - " + b + " = " + res;
        } else if (mulButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] " + a + " * " + b + " = " + res;
        } else if (divButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] " + a + " / " + b + " = " + res;
        } else if (degreeButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] " + a + "^" + b + " = " + res;
        }
        index++;
        historyList.add(resultForHistory);
        System.out.println(historyList);
        listHistory.appendText(resultForHistory+System.lineSeparator());
    }
    private void addResultToHistoryOneOperands(double a, double res) {
        String timeOperation = new SimpleDateFormat("HH:mm:ss").format(Calendar.getInstance().getTime());
        String resultForHistory = null;
        if (sqrtButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] √" + a + " = " + res;
        } else if (sinButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] sin(" + a + ") = " + res;
        } else if (cosButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] cos(" + a + ") = " + res;
        } else if (tanButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] tan(" + a + ") = " + res;
        } else if (arcsinButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] arcsin(" + a + ") = " + res;
        } else if (arccosButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] arccos(" + a + ") = " + res;
        } else if (arctanButton.isArmed()) {
            resultForHistory = index + ") [" + timeOperation + "] arctan(" + a + ") = " + res;
        }
        index++;
        historyList.add(resultForHistory);
        System.out.println(historyList);
        listHistory.appendText(resultForHistory+System.lineSeparator());
    }
    @FXML
    protected void addNumbers() {
        if (!input2.getText().isEmpty()) {
            double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
            double b = Double.parseDouble(input2.getText());
            double res = a+b;
            clearInput2();
            result.setText("Результат: " + res);
            addResultToHistoryTwoOperands(a, b, res);
        } else {
            result.setText("Заполните оба поля!");
        }
    }
    @FXML
    protected void subNumbers() {
        if (!input2.getText().isEmpty()) {
            double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
            double b = Double.parseDouble(input2.getText());
            double res = a - b;
            clearInput2();
            result.setText("Результат: " + res);
            addResultToHistoryTwoOperands(a, b, res);
        } else {
            result.setText("Заполните оба поля!");
        }
    }
    @FXML
    protected void mulNumbers() {
        if (!input2.getText().isEmpty()) {
            double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
            double b = Double.parseDouble(input2.getText());
            double res = a*b;
            clearInput2();
            result.setText("Результат: " + res);
            addResultToHistoryTwoOperands(a, b, res);
        } else {
            result.setText("Заполните оба поля!");
        }
    }
    @FXML
    protected void divNumbers() {
        if (!input2.getText().isEmpty()) {
            double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
            double b = Double.parseDouble(input2.getText());
            if (b==0) {
                result.setText("Деление на 0 не возможно!");
            }
            else {
                double res = a/b;
                clearInput2();
                result.setText("Результат: " + res);
                addResultToHistoryTwoOperands(a, b, res);
            }
        } else {
            result.setText("Заполните оба поля!");
        }
    }
    @FXML
    protected void degreeNumbers() {
        if (!input2.getText().isEmpty()) {
            double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
            double b = Double.parseDouble(input2.getText());
            double res = Math.pow(a, b);
            clearInput2();
            result.setText("Результат: " + res);
            addResultToHistoryTwoOperands(a, b, res);
        } else {
            result.setText("Заполните оба поля!");
        }
    }
    @FXML
    protected void sqrtNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        double res = Math.sqrt(a);
        clearInput2();
        result.setText("Результат: " + res);
        addResultToHistoryOneOperands(a, res);
    }
    @FXML
    protected void sinNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        double res = Math.sin(a);
        clearInput2();
        result.setText("Результат: " + res);
        addResultToHistoryOneOperands(a, res);
    }
    @FXML
    protected void cosNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        double res = Math.cos(a);
        clearInput2();
        result.setText("Результат: " + res);
        addResultToHistoryOneOperands(a, res);
    }
    @FXML
    protected void tanNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        double res = Math.tan(a);
        clearInput2();
        result.setText("Результат: " + res);
        addResultToHistoryOneOperands(a, res);
    }
    @FXML
    protected  void arcsinNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        if ((a >= -1) && (a <= 1)){
            double res = Math.asin(a);
            clearInput2();
            result.setText("Результат: " + res);
            addResultToHistoryOneOperands(a, res);
        } else {
            result.setText("Недопустимое значение!");
        }
    }
    @FXML
    protected  void arccosNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        if ((a >= -1) && (a <= 1)){
            double res = Math.acos(a);
            clearInput2();
            result.setText("Результат: " + res);
            addResultToHistoryOneOperands(a, res);
        } else {
            result.setText("Недопустимое значение!");
        }
    }
    @FXML
    protected  void arctanNumber() {
        clearInput2();
        double a = Double.parseDouble(String.valueOf(spinnerOneField.getValue()));
        double res = Math.atan(a);
        clearInput2();
        result.setText("Результат: " + res);
        addResultToHistoryOneOperands(a, res);
    }
    private boolean isDigitSymbol(String newValue) {
        boolean isDigit = false;
        char symbol = newValue.charAt(newValue.length()-1);
        if (Character.isDigit(symbol)) {
            isDigit = true;
        }
        return isDigit;
    }
    private boolean isDigitSymbolBeforePoint(String newValue) {
        boolean isDigit = false;
        char symbol = newValue.charAt(newValue.length()-2);
        if (Character.isDigit(symbol)) {
            isDigit = true;
        }
        return isDigit;
    }
    private boolean isDigitSymbolFirst(String newValue) {
        boolean isDigit = false;
        for (int i = 0; i < newValue.length(); i++) {
            char symbol = newValue.charAt(i);
            if (Character.isDigit(symbol)) {
                isDigit = true;
            }
        }

        return isDigit;
    }
    private int isPointSymbol(String newValue) {
        int index = -1;
        for (int i = 0; i < newValue.length(); i++) {
            if (newValue.contains(".")) {
                index = newValue.indexOf('.');
                System.out.println(index);
                break;
            }

        }
        return index;
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        assert input2 != null : "fx:id=\"input2\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert listHistory != null : "fx:id=\"listHistory\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert result != null : "fx:id=\"result\" was not injected: check your FXML file 'hello-view.fxml'.";

        spinnerOneField.setValueFactory(new SpinnerValueFactory.DoubleSpinnerValueFactory(-Double.MAX_VALUE, Double.MAX_VALUE,
                2.0, 0.1));
//                spinnerOneField.valueProperty().addListener(observable ->
//                        System.out.println(spinnerOneField.getValue()));
        spinnerOneField.valueProperty().addListener(observable -> {
            spinnerOneField.getEditor().setText(String.format("%.3f", spinnerOneField.getValue()));
        });
        input2.textProperty().addListener((observable, oldValue, newValue) -> {

            if (newValue.length() == 1) {
                if ((newValue.lastIndexOf("-") == 0)) {
                    input2.setText(newValue);
                    System.out.println(newValue);
                } else {
                    if (isDigitSymbolFirst(newValue)) {
                        input2.setText(newValue);
                    } else {
                        input2.setText(oldValue);
                    }
                }
            } else if (newValue.length() > 1) {
                if ((newValue.endsWith(".")) && (newValue.lastIndexOf('.') == isPointSymbol(newValue)) && (isPointSymbol(newValue) != -1) && (!isDigitSymbol(newValue)) && (isDigitSymbolBeforePoint(newValue))) {
                    input2.setText(newValue);
                } else {
                    if ((isDigitSymbol(newValue))) {
                        input2.setText(newValue);
                    } else {
                        input2.setText(oldValue);
                    }

                }
            }
                });
    }
}