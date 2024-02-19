import java.util.*;

public class GestionImpression {
	private Map<String, Deque<Impression>> impressionParUtilisateur = new HashMap<>();
	
	public void ajouterImpression(Impression impr){
		String utilisateur = impr.getIdUtilisateur();

		//Si l'utilisateur a déja des impressions en cours
		if(impressionParUtilisateur.containsKey(utilisateur)){
			Deque<Impression> pile = impressionParUtilisateur.get(utilisateur);
			pile.addFirst(impr);
			impressionParUtilisateur.put(utilisateur,pile);
		}else { 
			Deque<Impression> pile = new ArrayDeque<>();
			pile.addFirst(impr);
			impressionParUtilisateur.put(utilisateur,pile);
		}
	}
	
	public Impression selectionnerImpression(){
		//On récupère le premier utilisateur qui a des impressions en cours
		String utilisateur = impressionParUtilisateur.keySet().iterator().next();
		Deque<Impression> pile = impressionParUtilisateur.get(utilisateur);
		Impression impr = pile.removeFirst();
		if(pile.isEmpty()){
			impressionParUtilisateur.remove(utilisateur);
		}else{
			impressionParUtilisateur.put(utilisateur,pile);
		}
		return impr;
	}


}
