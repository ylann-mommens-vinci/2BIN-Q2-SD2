import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MatriceDAdjacence extends Graph{
	
	private Map<Integer, Airport>  correspondanceIndiceAirport;
	private Map<Airport, Integer>  correspondanceAirportIndice;
	private Flight[][] matrice= new Flight[0][0];
	private int nbAirport=0;

	public MatriceDAdjacence() {
		super();
		correspondanceAirportIndice= new HashMap<Airport,Integer>();
		correspondanceIndiceAirport= new HashMap<Integer,Airport>();
	}

	@Override
	// Complexit�: ?
	protected void ajouterSommet(Airport a) {	
		//� compl�ter
		correspondanceAirportIndice.put(a,nbAirport);
		correspondanceIndiceAirport.put(nbAirport,a);
		nbAirport++;

		matrice = new Flight[nbAirport][nbAirport];
	}

	@Override
	// Complexit�: ?
	protected void ajouterArc(Flight f) {
		//� compl�ter
		var i = correspondanceAirportIndice.get(f.getSource());
		var j = correspondanceAirportIndice.get(f.getDestination());

		matrice[i][j] = f;
	}

	@Override
	// Complexit�: ?
	public Set<Flight> arcsSortants(Airport a) {
		//� compl�ter
		int ligne = correspondanceAirportIndice.get(a);

		HashSet<Flight> f = new HashSet<>();

		for (int j = 0; j < nbAirport; j++) {
			Flight flight = matrice[ligne][j];
			if( flight != null){
				f.add(flight);
			}
		}

		return f;
	}

	@Override
	// Complexit�: ?
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// � compl�ter
		int i = correspondanceAirportIndice.get(a1);
		int j = correspondanceAirportIndice.get(a2);

		return matrice[i][j] != null || matrice[j][i] != null;
	}
	
	

}
