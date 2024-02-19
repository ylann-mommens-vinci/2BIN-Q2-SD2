
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ListeDArc extends Graph{
	
	private ArrayList<Flight> flights;

	public ListeDArc() {
		super();
		flights=new ArrayList<Flight>();
	}

	@Override
	// Complexité: ?
	protected void ajouterSommet(Airport a) {	
		//à ne pas compléter
	}

	@Override
	// Complexité: O(1)
	protected void ajouterArc(Flight f) {
		flights.add(f);
	}

	@Override
	// Complexié : O(N)
	public Set<Flight> arcsSortants(Airport a) {
		//à compléter
		HashSet<Flight> res = new HashSet<>();
		for (Flight f: flights){
			if(f.getSource().equals(a))
				res.add(f);
		}

		return res;
	}

	@Override
	// Complexit�: O(N)
	public boolean sontAdjacents(Airport a1, Airport a2) {
		//à compléter
		for (Flight f: flights){
			if(f.getSource().equals(a1) && f.getDestination().equals(a2))
				return true;
			if(f.getSource().equals(a2) && f.getDestination().equals(a1))
				return true;
		}
		return false;
	}

}
