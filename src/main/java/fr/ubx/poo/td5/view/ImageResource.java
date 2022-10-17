package fr.ubx.poo.td5.view;

import fr.ubx.poo.td5.model.Entity;
import javafx.scene.image.Image;

public enum ImageResource {
    ROCK("rock.png"),
    GROUND("ground.png"),
    BIGROCK("bigRock.png"),
    CRACK("crack.png"),
    DUST("dust.png");

    public static final int size = 40;
    private final Image image;

    ImageResource(String file) {
        this.image = new Image(ImageResource.class.getResourceAsStream("/images/" + file));
    }

    public static Image get(Entity kind) {
        if (kind != null)
            return ImageResource.valueOf(kind.toString()).image;
        return null;
    }
}
