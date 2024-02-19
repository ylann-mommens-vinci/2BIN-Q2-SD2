import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListeDAdjacence extends Graph{
	
	private Map<Airport,Set<Flight>> outputFlights;

	public ListeDAdjacence(){
		super();
		outputFlights=new HashMap<Airport,Set<Flight>>();
	}

	@Override
	// Complexit�: ?
	protected void ajouterSommet(Airport a) {	
		//� compl�ter
		outputFlights.put(a,new HashSet<>());
	}

	@Override
	// Complexité: 0(1)
	protected void ajouterArc(Flight f) {
		//à compléter
		Set<Flight> airports = outputFlights.get(f.getSource());
		airports.add(f);
	}

	@Override
	// Complexité: 0(1)
	public Set<Flight> arcsSortants(Airport a) {
		//à compléter
		return outputFlights.get(a);
	}

	@Override
	// Complexit�: O(2N) --> O(N)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		// � compl�ter
		// On boucle tout les vol sortant de a1
		for (Flight f : outputFlights.get(a1)){
			if (f.getDestination().equals(a2))
				return true;
		}

		for (Flight f : outputFlights.get(a2)){
			if(f.getDestination().equals(a1)){
				return true;
			}
		}

		return false;
	}
}
