package fr.ubx.poo.td5.model;

import java.lang.reflect.Field;

import static fr.ubx.poo.td5.model.Entity.*;

public class GridRepoVar implements GridRepo {

    private final Entity[][] sample1 = {
            {GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, DUST, GROUND, GROUND},
            {GROUND, GROUND, ROCK, CRACK, GROUND, GROUND, BIGROCK, GROUND, GROUND},
            {GROUND, ROCK, GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, CRACK, GROUND},
            {GROUND, DUST, GROUND, DUST, GROUND, GROUND, GROUND, GROUND, GROUND},
            {GROUND, GROUND, GROUND, CRACK, GROUND, DUST, BIGROCK, GROUND, GROUND},
            {GROUND, ROCK, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND, GROUND},
    };

    private final Entity[][] sample2 = {
            {GROUND, ROCK, DUST, ROCK, GROUND},
            {GROUND, CRACK, BIGROCK, CRACK, DUST},
            {GROUND, CRACK, CRACK, GROUND, BIGROCK},
            {ROCK, DUST, DUST, GROUND, DUST}
    };

    private Entity[][] getEntities(String name) {
        try {
            Field field = this.getClass().getDeclaredField(name);
            return (Entity[][]) field.get(this);
        } catch (IllegalAccessException e) {
            return null;
        } catch (NoSuchFieldException e) {
            return null;
        }
    }

    @Override
    public Grid load(String name) {
        /*  Crée une nouvelle instance de la classe Grid et initialise les champs de l'objet avec les informations de sample1.
            Retourn le nouvel objet.
         */
        Entity[][] entities = getEntities(name);
        if (entities == null)
            return null;
        // Votre code ici
        Grid grid= new Grid(sample1[0].length, sample1.length);
        for(int i=0; i<sample1[0].length; i++){ //column
            for(int j=0;j< sample1.length; j++) { //file
                grid.set(i,j, sample1[i][j]);
            }
        }
        return grid;
    }

    @Override
    public String export(Grid grid) {
        /*  Retourne sous forme de chaîne de caractères la déclaration Java correspondant aux tableau d'entités de l'objet grid.
            Le code produit peut être utilisé pour remplacer la déclaration de sample1 plus haut.
        */
        StringBuilder s = new StringBuilder();
        s.append( "{");
        for(int i=0; i<sample1[0].length; i++){ //column
            s.append("\n");
            for(int j=0;j< sample1.length; j++) { //file
                s.append(grid.get(i,j).toString()+", ");
            }
            s.append( "},");
            System.out.println(s.toString());
        }
        return s.toString();
    }


}