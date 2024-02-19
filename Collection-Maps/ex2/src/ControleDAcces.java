import java.util.HashMap;
import java.util.HashSet;

public class ControleDAcces {

	//Map avec K-V -> badge-client
	//Set avec tout les badges
	private HashMap<Employe,Badge> mapBadges = new HashMap<>();
	private HashSet<Badge> badges = new HashSet<>();

	public ControleDAcces(){
		
	}
	
	// associe le badge � un employ�
	public void donnerBadge (Badge b, Employe e){
		if(!mapBadges.containsKey(e)){
			mapBadges.put(e,b);
		}
	}
	
	// met � jour les employ�s pr�sents dans le batiment
	public void entrerBatiment (Badge b){
		badges.add(b);
	}

	// met � jour les employ�s pr�sents dans le batiment
	public void sortirBatiment (Badge b){
		badges.remove(b);
	}
	
	// renvoie vrai si l'employ� est dans le batiment, faux sinon
	public boolean estDansBatiment (Employe e){
		return badges.contains(mapBadges.get(e));
	}

}
