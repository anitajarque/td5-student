package fr.ubx.poo.td5.view;

import fr.ubx.poo.td5.model.Entity;
import javafx.geometry.Insets;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class PickerView extends VBox {
    private final ToggleGroup group = new ToggleGroup();

    public PickerView() {
        this.setSpacing(15);
        this.setPadding(new Insets(15));

        for (Entity entity : Entity.values()) {
            ToggleButton btn = new ToggleButton();
            btn.setToggleGroup(group);
            btn.setUserData(entity);
            btn.setGraphic(new ImageView(ImageResource.get(entity)));
            getChildren().add(btn);
        }
    }

    public Entity getSelected() {
        Toggle toggle = group.getSelectedToggle();
        if (toggle == null)
            return null;
        return (Entity) toggle.getUserData();
    }
}
