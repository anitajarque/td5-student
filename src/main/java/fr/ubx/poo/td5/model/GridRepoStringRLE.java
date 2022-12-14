package fr.ubx.poo.td5.model;

public class GridRepoStringRLE implements GridRepo{

    //RLE method
    public static String encode(String str)
    {
        // stocke la string de sortie
        String encoding = "";

        // cas de base
        if (str == null) {
            return encoding;
        }

        int count;

        for (int i = 0; i < str.length(); i++)
        {
            // compte les occurrences du caractère à l'index `i`
            count = 1;
            while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1))
            {
                count++;
                i++;
            }

            // ajoute le caractère courant et son nombre au résultat
            encoding += String.valueOf(count) + str.charAt(i);
        }

        return encoding;
    }

    public static String decode(String str)
    {
        // stocke la string de sortie
        String decoding = "";

        // cas de base
        if (str == null) {
            return decoding;
        }

        for (int i = 0; i < str.length(); i++)
        {
            if(i+1<str.length() && str.charAt(i+1)>='0' && str.charAt(i+1)<='9'){
                for(int j=0; j<Integer.parseInt(String.valueOf(str.charAt(i+1))); j++){
                    decoding += str.charAt(i);
                }
                i++;
            }
            else{
                decoding += str.charAt(i);
            }
        }

        return decoding;
    }

    final char EOL = 'x';

    @Override
    public Grid load(String string) {
        int x=0;
        int total=0;
        int columna=0;
        string = decode(string);

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
        return encode(s.toString());
    }
}
