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
    @Override
    public Grid load(String string) {
        return null;
    }

    @Override
    public String export(Grid grid) {
        return null;
    }
}
