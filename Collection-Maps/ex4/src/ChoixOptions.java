import java.util.*;

public class ChoixOptions {
	
	// associe le nom d'une option avec son objet Option correspondant
	private Map<String, Option> options;
	// ajouter ici les autres attributs
	private Map<Etudiant, List<String>> preferenceEtudiant;


	
	//constructeur prenant un entier et une suite de string en param�tres
	//ces string repr�sentent les noms des diff�rentes options possibles
	public ChoixOptions(int nbEtudiantsParOption, String... nomsOption) {
		this.options = new HashMap<String, Option>();
		if (nomsOption.length < 3)
			throw new IllegalArgumentException();
		for (int i = 0; i < nomsOption.length; i++) {
			String nomOption = nomsOption[i];
			options.put(nomOption, new Option(nomOption, nbEtudiantsParOption));
		}
		// initialiser les nouveaux attributs
		preferenceEtudiant = new TreeMap<>(Comparator.comparing(Etudiant::getMoyenne).reversed().thenComparing(Etudiant::getNom));
	}

	// cette méthode encode les préférences des étudiants
	// il ne faut pas vérifier que ces choix soient valides
	public void ajouterPreferences(Etudiant etu, String choix1, String choix2, String choix3) {
		List<String> preferences = new ArrayList<>();
		preferences.add(choix1);
		preferences.add(choix2);
		preferences.add(choix3);

		preferenceEtudiant.put(etu, preferences);
	}

	// cette méthode est appelée aprés que les étudiants aient donn� leurs préférences
	// cette méthode attribue les options aux étudiants en favorisant les étudiants
	// ayant les meilleures moyennes si il n'y a plus de place disponible dans certaines
	// options. Pour les étudiants faibles, si les deux premiéres options sont pleines,
	// il faut recourir au troisiéme choix.
	// Cette méthode doit faire appel à la méthode inscrireEtudiant de la classe Option.
	public void attribuerOptions(){
		for(Etudiant etu : preferenceEtudiant.keySet() ){
			List<String> preferences = preferenceEtudiant.get(etu);

			// On parcourt les préférences de l'étudiant et on l'inscrit dans la première option disponible
			for(String option : preferences){
				if(options.get(option).inscrireEtudiant(etu)){
					break;
				}
			}
		}
	}
	
	public String toString(){
		String s="";

		for (Option o:options.values()){
			s=s+o+"\n"+"-----------------"+"\n";
		}
		return s;
	}
}
