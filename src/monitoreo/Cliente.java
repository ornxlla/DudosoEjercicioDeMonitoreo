package monitoreo;
import java.util.Calendar;
import java.util.Objects;


public class Cliente implements Comparable<Cliente> {

	private String nombre;
	private Integer numeroMovil;
	private Calendar fechaLlegada;
    private Calendar fechaAtencion;
	
	public Cliente(String nombre, Integer numeroMovil, Calendar fechaLlegada) {
		Calendar ahora = Calendar.getInstance();
		this.nombre = nombre;
		this.numeroMovil = numeroMovil;
		this.fechaLlegada = fechaLlegada;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getNumeroMovil() {
		return numeroMovil;
	}


	@Override
	public int hashCode() {
		return Objects.hash(numeroMovil);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(numeroMovil, other.numeroMovil);
	}

	@Override
	public int compareTo(Cliente o) {
		return this.numeroMovil.compareTo(o.numeroMovil);
	}

	public Calendar getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Calendar fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public Calendar getFechaLlegada() {
		return fechaLlegada;
	}



	
}
