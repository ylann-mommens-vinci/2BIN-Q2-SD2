import javax.swing.text.html.HTMLEditorKit;
import java.util.HashMap;
import java.util.LinkedList;

public class Ordonnancement {
	public static final int NIVEAU_PRIORITE_MAX=5;
	private HashMap<Integer, LinkedList<Tache>> taches = new HashMap<>();
	public Ordonnancement(){

	}

	public void ajouterTache (String descriptif, int priorite){
		// Si la liste est vide on crée une liste
		if(taches.get(priorite)== null){
			LinkedList<Tache> listeTaches = new LinkedList<>();
			listeTaches.add(new Tache(descriptif,priorite));
			taches.put(priorite,listeTaches);
		}else {
			taches.get(priorite).add(new Tache(descriptif,priorite));
		}
	}
	
	//renvoie la tache prioritaire
	//renvoie null si plus de tache presente
	public Tache attribuerTache(){
		//On parcourt chaque taches
		for (int i = NIVEAU_PRIORITE_MAX; i >=1; i--) {

			//On récupere la liste de tache de cet indice
			LinkedList<Tache> tache = taches.get(i);
			if(tache!=null && !tache.isEmpty()){
				return tache.poll();
			}
		}
		return null;
	}
}
