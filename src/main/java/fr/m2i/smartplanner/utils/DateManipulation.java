package fr.m2i.smartplanner.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Class qui permettra la simplification des recherches temporelles
 */
public class DateManipulation {

    public DateManipulation(){

    }

    // Range d'une journée
    public ArrayList<Long> getDayRange(Long timestamp) throws ParseException {

        ArrayList<Long> rangeDaily = new ArrayList<>();
        // Ici datetime complet.
        Long secondsToMillis = timestamp*1000L;
        Date fullAskedDate = new Date(secondsToMillis);
        // Ici on instancie un format de date plus simple vide
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        // Ici on met la date demandée et on l'obtient au format string demandé
        String simpleDateString= formatter.format(fullAskedDate);
        Date simpleDate = formatter.parse(simpleDateString);
        // On peut maintenant reconstruire proprement la date
        Long tms1 = simpleDate.getTime()/1000L;
        Long tms2 = tms1+86399; // Nombre de secondes dans une journée -1
        rangeDaily.add(tms1);rangeDaily.add(tms2);
        String toPrint = "Date : "+simpleDate+"  | tms1 : "+tms1+"  |  tms2 : "+tms2;
        // On renvoit le range sous forme d'un tableau à deux entrées
        return rangeDaily;
    }

    public ArrayList<Long> getMonthRange(Long timestamp){

        ArrayList<Long> rangeDaily = new ArrayList<>();
        // Ici datetime complet.
        Long secondsToMillis = timestamp*1000L;
        Date fullAskedDate = new Date(secondsToMillis);
        // Ici on instancie un format de date plus simple vide
        SimpleDateFormat formatter = new SimpleDateFormat("/MM/yyyy");
        // Ici on met la date demandée et on l'obtient au format string demandé
        String simpleDate= formatter.format(fullAskedDate);
        // On peut maintenant reconstruire proprement la date
        Long tms1 = new Date(simpleDate).getTime();
        System.out.println("Date : "+simpleDate+"  | tms1 : "+tms1);
        Long tms2 = tms1+86399; // Nombre de secondes dans une journée -1
        rangeDaily.add(tms1);rangeDaily.add(tms2);
        // On renvoit le range sous forme d'un tableau à deux entrées
        return rangeDaily;
    }

}
