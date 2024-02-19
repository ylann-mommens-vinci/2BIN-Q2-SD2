import java.util.HashMap;
import java.util.Map;

public class Doodle {
	private PlageHoraire[] plages;

	//todo done
	private Map<String, boolean[]> participantsDisponibilites;

	public Doodle(PlageHoraire... plages) {
		this.plages = plages;
		//todo done
		this.participantsDisponibilites = new HashMap<>();
	}

	// Ajoute les disponibilités d'un participant sous forme d'un tableau de booleen.
	// Les indices du tableau correspondent aux indices du tableau plages
	// true → l'indice i veut dire que le participant est disponible pour la plage � l'indice i du tableau plages
	// false → l'indice i veut dire que le participant n'est pas disponible pour la plage � l'indice i du tableau plages
	public void ajouterDisponibilites(String participant, boolean[] disponibilites) {
		if (disponibilites.length != plages.length)
			throw new IllegalArgumentException();
		//todo done
		for (int i = 0; i < plages.length; i++) {
			if (disponibilites[i]) {
				int nbParticipantPresent = plages[i].getNbParticipantPresent();
				plages[i].setNbParticipantPresent(nbParticipantPresent+1);
			}
		}
		participantsDisponibilites.put(participant, disponibilites);
	}
	
	// Hypoth�se: la PlageHoraire plage en param�tre fait bien partie du tableau plages
	// renvoie vrai si le participant est disponible pour cette plage horaire
	// renvoie faux si le participant n'est pas disponible ou s'il n'a pas rempli le sondage doodle
	public boolean estDisponible(String participant, PlageHoraire plage) {
		//si le personnage a rempli le sondage
		if(participantsDisponibilites.containsKey(participant)) {
			//si le personnage est disponible
			for (int i = 0; i < plages.length; i++) {
				if(plages[i].equals(plage)) {
					return participantsDisponibilites.get(participant)[i];
				}
			}
		}
		return false;
	}

	// renvoie une des plages horaires qui a le maximum de participants pr�vus
	// cette m�thode est appel�e apr�s que les participants aient rempli leurs disponibilit�s
	public PlageHoraire trouverPlageQuiConvientLeMieux() {
		return null;
	}

}
