package monitoreo;

public class NoHayClientesEnEspera extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public NoHayClientesEnEspera(String mensaje) {
		super(mensaje);
	}
}
