package datos;

public  abstract class Ambiente {
	
	protected  int nroDeAmbiente;
	protected String ambiente;
	
	public Ambiente() {}
	
	public Ambiente(int nroDeAmbiente, String ambiente) {
		super();
		this.nroDeAmbiente = nroDeAmbiente;//es el id
		this.ambiente = ambiente;
	}
	public int getNroDeAmbiente() {
		return nroDeAmbiente;
	}
	protected void setNroDeAmbiente(int nroDeAmbiente) {
		this.nroDeAmbiente = nroDeAmbiente;
	}
	public String getAmbiente() {
		return ambiente;
	}
	public void setAmbiente(String ambiente) {
		this.ambiente = ambiente;
	}

	@Override
	public String toString() {
		return "\nAmbiente [nroDeAmbiente=" + nroDeAmbiente + ", ambiente=" + ambiente + "]";
	}
	
	
	

}
