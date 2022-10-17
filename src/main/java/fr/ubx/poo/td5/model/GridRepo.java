package fr.ubx.poo.td5.model;

public interface GridRepo {
    Grid load(String string);
    String export(Grid grid);
}
