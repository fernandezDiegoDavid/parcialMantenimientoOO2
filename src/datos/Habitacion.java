package datos;

public class Habitacion extends Ambiente {
	
	private int plazas;

	public Habitacion() {}

	public Habitacion(int nroDeAmbiente, String ambiente, int plazas) {
		super(nroDeAmbiente, ambiente);
		this.plazas = plazas;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	@Override
	public String toString() {
		return super.toString()+"Habitacion [plazas=" + plazas + "]\n";
	}
	
	

	
	
	

}
