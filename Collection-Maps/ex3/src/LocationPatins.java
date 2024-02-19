import java.time.LocalTime;
import java.util.*;

import static java.time.temporal.ChronoUnit.MILLIS;

public class LocationPatins {

	private HashMap<Integer, Deque<Integer>> mapEmplacementPointure = new HashMap<>();
	//K → position | V → Heure de départ de la location
	private HashMap<Integer,LocalTime> mapEmplacementEnLocation = new HashMap<>();
	private final int[] casiersBase;

	public LocationPatins(int[] casiers) {
		//TODO done
		casiersBase=casiers;

		// On parcourt la liste des paires
		for (int i = 0; i < casiers.length; i++) {
			if (casiers[i]>48 || casiers[i]<33)
				throw new IllegalArgumentException();

			// Si la pointure n'a pas d'emplacement, on initialise une ArrayDeque
			if(!mapEmplacementPointure.containsKey(casiers[i])){
				mapEmplacementPointure.put(casiers[i], new ArrayDeque<>());
			}

			// On ajoute dans la map la position de la paire
			mapEmplacementPointure.get(casiers[i]).add(i);
		}
	}

	// date1 < date2
	private static double prix(LocalTime date1, LocalTime date2) {
		// 1 euro par milliseconde (c'est assez cher en effet)
		return MILLIS.between(date1, date2) ;
	}

	public int attribuerCasierAvecPatins(int pointure) {
		if (pointure < 33 || pointure > 48)
			throw new IllegalArgumentException();
		LocalTime l = LocalTime.now();

		//TODO done
		if(mapEmplacementPointure.get(pointure).isEmpty() || !mapEmplacementPointure.containsKey(pointure))
			return -1;

		int position = mapEmplacementPointure.get(pointure).removeFirst();
		mapEmplacementEnLocation.put(position,l);
		return position;
	}

	public double libererCasier(int numeroCasier) {
		//TODO done

		// On calcule le prix de la location et on le remet dans la map
		LocalTime heureDebut = mapEmplacementEnLocation.get(numeroCasier);
		LocalTime heureFin = LocalTime.now();

		mapEmplacementPointure.get(casiersBase[numeroCasier]).add(numeroCasier);
        return prix(heureDebut,heureFin);
	}

}
