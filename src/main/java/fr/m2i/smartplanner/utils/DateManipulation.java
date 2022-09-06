package fr.m2i.smartplanner.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
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
        // On renvoit le range sous forme d'un tableau à deux entrées
        return rangeDaily;
    }

    public ArrayList<Long> getWeekRange(Long timestamp) throws ParseException {

        ZoneId defaultZoneId = ZoneId.systemDefault();
        ArrayList<Long> rangeWeekly = new ArrayList<>();

        // Ici datetime complet à partir de l'input tms
        Long secondsToMillis = timestamp*1000L;
        Date fullAskedDate = new Date(secondsToMillis);

        // Ici on obtient le jour de la semaine auquel correspond la date
        Integer dayOfTheWeek = fullAskedDate.getDay();

        // Ici on instancie un format de date plus simple vide
        SimpleDateFormat formatterYearFirst = new SimpleDateFormat("yyyy-MM-dd");

        // Ici on met la date demandée et on l'obtient au format string demandé
        String simpleDateSource= formatterYearFirst.format(fullAskedDate);

        // Cette variable contiendra le nombre de jour à enlever pour atteindre lundi
        Long daysToAdd = 0L;

        // Dans ce switch on définira le nombre de jour à enlever selon le
        // dayOfTheWeek récupéré plus haut
        switch(dayOfTheWeek){

            case 0: // Sunday
                daysToAdd = -6L;
                break;
            case 1: // Monday
                daysToAdd = 0L;
                break;
            case 2: // Tuesday
                daysToAdd = -1L;
                break;
            case 3: // Wednesday
                daysToAdd = -2L;
                break;
            case 4: // Thursday
                daysToAdd = -3L;
                break;
            case 5: // Friday
                daysToAdd = -4L;
                break;
            case 6: // Saturday
                daysToAdd = -5L;
                break;
            default:
                break;
        }

        // On peut maintenant reconstruire proprement la date
        LocalDate monthBeginningLD = LocalDate.parse(simpleDateSource).plusDays(daysToAdd);

        // Add 7 days to the beginningDate to construct the endDate
        LocalDate monthEndLD = monthBeginningLD.plusDays(7);

        //On traduit les deux précédents LocalDate en Date pour en extraire le tms
        Date monthBeginning = Date.from(monthBeginningLD.atStartOfDay(defaultZoneId).toInstant());
        Date monthEnd = Date.from(monthEndLD.atStartOfDay(defaultZoneId).toInstant());

        // Nos deux tms
        Long tms1 = monthBeginning.getTime()/1000;
        Long tms2 = (monthEnd.getTime()/1000)-1; // le premier de la semaine suivante moins une seconde

        // On renvoit le range sous forme d'un tableau à deux entrées
        rangeWeekly.add(tms1);rangeWeekly.add(tms2);
        return rangeWeekly;
    }

    public ArrayList<Long> getMonthRange(Long timestamp) throws ParseException {

        ZoneId defaultZoneId = ZoneId.systemDefault();
        ArrayList<Long> rangeMonthly = new ArrayList<>();

        // Ici datetime complet à partir de l'input tms
        Long secondsToMillis = timestamp*1000L;
        Date fullAskedDate = new Date(secondsToMillis);

        // Ici on instancie un format de date plus simple vide
        SimpleDateFormat formatterYearFirst = new SimpleDateFormat("yyyy-MM-dd");

        // Ici on met la date demandée et on l'obtient au format string demandé
        String simpleDateSource= formatterYearFirst.format(fullAskedDate);

        // On reconstitue la date avec le jour à 1
        String[] dateElements = simpleDateSource.split("-");
        String simpleDateNew = dateElements[0]+"-"+dateElements[1]+"-01";

        // On peut maintenant reconstruire proprement la date
        LocalDate monthBeginningLD = LocalDate.parse(simpleDateNew);

        // Add 1 month to the date
        LocalDate monthEndLD = monthBeginningLD.plusMonths(1);

        //On traduit les deux précédents LocalDate en Date pour en extraire le tms
        Date monthBeginning = Date.from(monthBeginningLD.atStartOfDay(defaultZoneId).toInstant());
        Date monthEnd = Date.from(monthEndLD.atStartOfDay(defaultZoneId).toInstant());

        // Nos deux tms
        Long tms1 = monthBeginning.getTime()/1000;
        Long tms2 = (monthEnd.getTime()/1000)-1; // le premier du mois suivant moins une seconde

        // On renvoit le range sous forme d'un tableau à deux entrées
        rangeMonthly.add(tms1);rangeMonthly.add(tms2);
        return rangeMonthly;
    }

}
