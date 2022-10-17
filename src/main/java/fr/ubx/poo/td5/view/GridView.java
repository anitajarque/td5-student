package fr.ubx.poo.td5.view;

import fr.ubx.poo.td5.model.Grid;
import javafx.scene.layout.BorderPane;

public class GridView extends BorderPane {
    private final Grid grid;
    private final PickerView pickerView;

    public GridView(Grid grid, PickerView pickerView) {
        this.grid = grid;
        this.pickerView = pickerView;
        setPrefSize(grid.getWidth() * ImageResource.size,
                grid.getHeight() * ImageResource.size);
        for (int i = 0; i < this.grid.getWidth(); i++) {
            for (int j = 0; j < this.grid.getHeight(); j++) {
                createTile(i, j);
            }
        }
    }

    private void createTile(int i, int j) {
        int layoutX = i * ImageResource.size;
        int layoutY = j * ImageResource.size;
        Tile tile = new Tile(ImageResource.get(this.grid.get(i, j)), layoutX, layoutY);
        getChildren().add(tile);
        tile.setOnMouseClicked(e -> update(tile, i, j));
        tile.setOnMouseEntered(e -> {
            if (e.isShiftDown()) {
                update(tile, i, j);
            }
        });
    }

    private void update(Tile tile, int i, int j) {
        if (pickerView.getSelected() != null && pickerView.getSelected() != grid.get(i, j)) {
            getChildren().remove(tile);
            grid.set(i, j, pickerView.getSelected());
            createTile(i, j);
        }
    }
}
