package fr.ubx.poo.td5.model;

import javax.swing.text.Position;

public class GridRepoString implements GridRepo{

    final char EOL = 'x';

    @Override
    public Grid load(String string) {
        int x=0;
        int total=0;
        int columna=0;
        for(int i=0; i<string.length(); i++){
            if(string.charAt(i)==EOL){
                x++;
            }
            else{
                total++;
            }
        }
        if(string.charAt(string.length()-1)!=EOL){
            throw new GridException("Missing eol character");
        }
        columna=total/x;
        Grid grid= new Grid(columna, x);
        for(int i=0; i<columna; i++){ //column
            for(int j=0;j<x; j++) { //file
                grid.set(i,j, Entity.fromCode(string.charAt(i*(columna)+j+i)));
            }
        }
        return grid;
    }

    @Override
    public String export(Grid grid) {
        StringBuilder s = new StringBuilder();
        for(int i=0; i<grid.getHeight(); i++){ //column
            for(int j=0;j< grid.getWidth(); j++) { //file
                s.append(grid.get(i,j).getCode());
            }
            s.append( "x");
            System.out.println(s.toString());
        }
        return s.toString();
    }
    public Grid create(int width, int height) {
        Grid grid= new Grid(width, height);
        for(int i=0; i<width; i++){ //column
            for(int j=0;j<height; j++) { //file
                grid.set(i,j, Entity.fromCode('G'));
            }
        }
        return grid;
    }

    public Graph<Position> getGraph(Grid grid){

        return null;
    }
}
