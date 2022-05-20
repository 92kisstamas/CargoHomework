package com.company.CargoHomework;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Hozzunk létre egy Cargo osztályt.
        // 2. Az osztály rendelkezzen date, source, destination, type, value mezőkkel.
        // 4. Hozzuk létre a gettereket + settereket + toStringet
        // 5. Legyen 3 konstruktor:
        //      - default
        //      - minden mezőt beállító
        //      - egy pontosveszzőkkel elválasztott sort váró (CSV)


        try {
            // ---------- 6 Olvassuk be a cargo.csv tartalmát és tároljuk el egy List<Cargo>
            //        // adatstruktúrába. ----------
            List<Cargo> cargoList = new ArrayList<>();

            try (BufferedReader reader = new BufferedReader(new FileReader("cargo.csv"))){
                String line = null;

                while ((line = reader.readLine()) != null) {
                    Cargo cargo = new Cargo(line);
                    cargoList.add(cargo);
                }
            }

            // ---------- 7. Írjuk ki az adatok számát. ----------

            System.out.println( "===========================================\n"
                    +"Az adatok száma: " + cargoList.size() + "\n");

            // 8. Határozzuk meg a legnagyobb értékű rakományt.

            double highestValueCargo = Integer.MIN_VALUE;
            for (Cargo cargo : cargoList) {
                if (cargo.getValue() > highestValueCargo){
                    highestValueCargo = cargo.getValue();
                }
            }
            System.out.println( "===========================================\n"
                    +"Legnagyobb értékű rakomány: " + highestValueCargo + "\n");

            // 9. Határozzuk meg a legkisebb értékű rakományt.

            double lowestValueCargo = Integer.MAX_VALUE;
            for (Cargo cargo : cargoList) {
                if (cargo.getValue() < lowestValueCargo){
                    lowestValueCargo = cargo.getValue();
                }
            }
            System.out.println("Legkisebb értékű rakomány: " + lowestValueCargo
                    + "\n===========================================\n");

            // 10. Volt-e legalább 900 értékű Műszaki cikkek rakomány?

            for (Cargo cargo : cargoList) {
                if (cargo.getType().equalsIgnoreCase("Műszaki cikkek")
                        && cargo.getValue() >= 900){
                    System.out.println("===========================================\n"
                            +"Volt 900-nál nagyobb értékű Műszaki cikkek rakomány.\n"
                            + "===========================================\n");
                    break;
                }
            }

            // 11. Készítsünk bolygónkénti kimutatást az exportált rakományok értékéről.

            double totalValueEarth = 0;
            double totalValueMoon = 0;
            double totalValueMars = 0;
            double totalValueGanymedes = 0;
            for (Cargo cargo : cargoList) {
                if (cargo.getSource().equalsIgnoreCase("Föld")) {
                    totalValueEarth += cargo.getValue();
                } else if (cargo.getSource().equalsIgnoreCase("Hold")) {
                    totalValueMoon += cargo.getValue();
                } else if (cargo.getSource().equalsIgnoreCase("Mars")) {
                    totalValueMars += cargo.getValue();
                } else if (cargo.getSource().equalsIgnoreCase("Ganymedes")) {
                    totalValueGanymedes += cargo.getValue();
                }
            }
            System.out.println("===========================================\n"
                + "Bolygónkénti exportált rakományok értéke:\n"
                + "Föld: \t\t" + totalValueEarth + ";\n"
                + "Hold: \t\t" + totalValueMoon + ";\n"
                + "Mars: \t\t" + totalValueMars + ";\n"
                + "Ganymedes: \t" + totalValueGanymedes + ";\n"
                + "===========================================\n");

            // 12. Készítsünk kategóriánkénti kimutatást a rakományok értékéről.

            double totalValueRawMaterials = 0;
            double totalValueFoods = 0;
            double totalValueTechnicalArticles = 0;
            double totalValueEnergyCarriers = 0;
            for (Cargo cargo : cargoList) {
                if (cargo.getSource().equalsIgnoreCase("Nyersanyagok")) {
                    totalValueRawMaterials += cargo.getValue();
                } else if (cargo.getSource().equalsIgnoreCase("Élelmiszer")) {
                    totalValueFoods += cargo.getValue();
                } else if (cargo.getSource().equalsIgnoreCase("Műszaki cikkek")) {
                    totalValueTechnicalArticles += cargo.getValue();
                } else if (cargo.getSource().equalsIgnoreCase("Energiahordozók")) {
                    totalValueEnergyCarriers += cargo.getValue();
                }
            }
            System.out.println("===========================================\n"
                    + "Kategóriánkénti kimutatás a rakományok értékéről:\n"
                    + "Nyersanyagok: \t\t" + totalValueEarth + ";\n"
                    + "Élelmiszer: \t\t" + totalValueMoon + ";\n"
                    + "Műszaki cikkek: \t" + totalValueMars + ";\n"
                    + "Energiahordozók: \t" + totalValueGanymedes + ";\n"
                    + "===========================================\n");


            // 13. Adjunk hozzá a Cargo osztályhoz egy getGrossValue számított értéket
            // visszaadó gettert.
            // 14. Hozzunk létre egy TaxedCargo osztályt.
            //          Az osztálynak legyen egy százalékot és egy limitet tároló további
            //          mezője.
            //          Ha a nettó érték nagyobb a limitnél,
            //          akkor a bruttó érték legyen a limit és a limit feletti rész
            //          százalékkal növelt értékének az összege.
            // 15. Jelenleg csak a Műszaki cikkekre vetnek ki adót (200 galaktikus kredit
            // fölött 10%)
            //      pl. nettó 200 -> bruttó 200
            //      pl. nettó 300 -> bruttó 210 (200 + (300 - 200) * 0.1)
            //      Hozzunk létre egy faktory metódust, amelyik egy sort kap paraméterként.
            //      Ha a szorban szerepel a Műszaki cikkek érték, akkor adjon vissza
            //      egy TaxedCargo osztályt,
            //      egyébként egy Cargo osztályt.
            // 16. Írjon ki a földről induló szállítmányok után fizetett összes adót.

            List<TaxedCargo> taxedCargoList = new ArrayList<>();

            cargoList.clear();

            try (BufferedReader reader = new BufferedReader(new FileReader("cargo.csv"))){
                String line = null;

                while ((line = reader.readLine()) != null) {
                    TaxedCargo taxedCargo = new TaxedCargo();
                    taxedCargo.factory(line);
                }
            }

        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
