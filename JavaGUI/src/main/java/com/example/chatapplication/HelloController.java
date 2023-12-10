package com.example.chatapplication;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class HelloController {
    @FXML
    private VBox chatMessages;
    private boolean isMyTurn = true;
    @FXML
    private TextField messageTextField;

    @FXML
    private void addMessage(String message) {
        HBox messageBox = new HBox();
        Label messageLabel = new Label(message);

        messageBox.getStyleClass().add(isMyTurn ? "your-message" : "guess-message");

        messageLabel.getStyleClass().add("message-label");

        messageBox.getChildren().addAll(messageLabel);

        chatMessages.getChildren().add(messageBox);

        isMyTurn = !isMyTurn;
    }

    @FXML
    private void onEnterPressed(ActionEvent event) {
        String message = messageTextField.getText().trim();

        if (!message.isEmpty()) {

            addMessage(message);

            String partnerMessage = "Thank you!";
            addMessage(partnerMessage);

            messageTextField.clear();
        }
    }
}