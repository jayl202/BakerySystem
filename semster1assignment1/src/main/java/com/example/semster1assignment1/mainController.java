package com.example.semster1assignment1;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.*;
import java.net.URL;
import java.util.ResourceBundle;

import static com.example.semster1assignment1.main.BakedGoodList;

public class mainController implements Initializable {
    @FXML
    private TextField mainTextFieldName;
    @FXML
    private TextField mainTextFieldOrigin;
    @FXML
    public ListView<BakedGood> mainListView;
    @FXML
    private TextField mainTextFieldDescription;
    @FXML
    private TextField mainTextFieldImage;

    public static mainController bgcon;

    public main selectedMain;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        bgcon =this;

    }

    public void UpdateBGListView() {
        mainListView.getItems().clear();
        FunkyList<BakedGood>.FunkyNode<BakedGood> temp = BakedGoodList.head;
        while (temp != null) {
            mainListView.getItems().add(temp.getContents());
            temp = temp.next;
        }
    }


    public void saveAll(){
        try {
            save();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void loadAll(){
        try {
            load();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @SuppressWarnings("unchecked")
    public void load() throws Exception {
        //list of classes that you wish to include in the serialisation, separated by a comma
        Class<?>[] classes = new Class[] { BakedGood.class,Recipe.class, Ingredient.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        //doing the actual serialisation to an XML file
        ObjectInputStream is = xstream.createObjectInputStream(new FileReader(fileName()));
        BakedGoodList = (FunkyList<BakedGood>) is.readObject();
        is.close();
    }

    public void save() throws Exception {
        Class<?>[] classes = new Class[] { FunkyList.class, FunkyList.FunkyNode.class, BakedGood.class,Recipe.class, Ingredient.class};

        //setting up the xstream object with default security and the above classes
        XStream xstream = new XStream(new DomDriver());
        xstream.allowTypes(classes);

        // XStream xstream = new XStream(new DomDriver());
        ObjectOutputStream out = xstream.createObjectOutputStream(new FileWriter(fileName()));
        out.writeObject(BakedGoodList);
        out.close();
    }

    public String fileName(){
        return "assignment.xml";
    }
    public void switchToViewing(ActionEvent event) {
        main.primaryStage.setScene(main.scene4);

    }

    public void switchToRecipes(ActionEvent event) {
        main.primaryStage.setScene(main.scene2);
        if(mainListView.getSelectionModel().getSelectedItem()==null) {
            RecipeController.rcon.rListView.getItems().clear();
        }
        else {
            RecipeController.rcon.selectedGood =mainListView.getSelectionModel().getSelectedItem();
            RecipeController.rcon.updateRListView(RecipeController.rcon.selectedGood);
        }
    }

    public void addGood(MouseEvent mouseEvent) {
        BakedGoodList.add(new BakedGood(mainTextFieldName.getText(),mainTextFieldOrigin.getText(),mainTextFieldDescription.getText(),mainTextFieldImage.getText()));
        UpdateBGListView();
    }

    public void deleteGood(MouseEvent mouseEvent) {
        int selectedMain = mainListView.getSelectionModel().getSelectedIndex();
        BakedGoodList.delete(selectedMain);
        UpdateBGListView();
    }

    public void resetGood(ActionEvent event) {
        BakedGoodList.reset();
        UpdateBGListView();
    }

    public void updateGoods(ActionEvent event) {
        int selectedIndex = mainListView.getSelectionModel().getSelectedIndex();
        BakedGood selectedGood = mainListView.getSelectionModel().getSelectedItem();
        selectedGood.setGoodName(mainTextFieldName.getText());
        selectedGood.setGoodOrigin(mainTextFieldOrigin.getText());
        selectedGood.setGoodDescription(mainTextFieldDescription.getText());
        selectedGood.setGoodImage(mainTextFieldImage.getText());
        BakedGoodList.add(selectedGood);
        mainListView.getItems().set(selectedIndex, selectedGood);
    }
}
