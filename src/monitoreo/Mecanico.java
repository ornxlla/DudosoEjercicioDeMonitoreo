package monitoreo;
import java.util.Calendar;
import java.util.TreeSet;

public class Mecanico {
	private TreeSet<Cliente>clientesEnEspera = new TreeSet<Cliente>();
	private TreeSet<Cliente>clientesAtendidos = new TreeSet<Cliente>();
	public void añadirClienteAEspera(Cliente cliente) {
		this.clientesEnEspera.add(cliente);
	}
	
	public TreeSet<Cliente> getClientesEnEspera() {
		return clientesEnEspera;
	}
	
	public TreeSet<Cliente> ordenarClientesEnEsperaPorNumeroMovil(){
		return clientesEnEspera;
	}

	public TreeSet<Cliente> getClientesAtendidos() {
		return clientesAtendidos;
	}

	public Integer obtenerCantidadDeClientesEnEspera() {
		return this.clientesEnEspera.size();
	}
	
	public Integer obtenerCantidadDeClientesAtendidos() {
		return this.clientesAtendidos.size();
	}

	public TreeSet<Cliente> ordenarClientesEnEsperaPorNombre(){
		TreeSet<Cliente> ordenPorNombre = new TreeSet<Cliente>(new PorNombreComparator());
		ordenPorNombre.addAll(this.clientesEnEspera);
		return ordenPorNombre;
	}
	
	public Cliente atenderCliente() throws NoHayClientesEnEspera {
		if(this.clientesEnEspera.size() > 0) {
			Calendar ahora = Calendar.getInstance();
			this.getClientesEnEspera().first().setFechaAtencion(ahora);
			this.clientesAtendidos.add(this.getClientesEnEspera().first());
			this.clientesEnEspera.removeAll(this.clientesAtendidos);
			return this.getClientesAtendidos().first();
		}
		throw new NoHayClientesEnEspera("No hay clientes en espera por atender");
	}

	public double obtenerTiempoEsperaNoAtendidos() {
		if(this.clientesEnEspera.size() == 0) {
			return 0.0;
		}
		Calendar ahora = Calendar.getInstance();
		long tiempoTotalEspera = 0;
		for (Cliente cliente :clientesEnEspera) {
			long tiempoEspera = ahora.getTimeInMillis() - cliente.getFechaLlegada().getTimeInMillis();
			tiempoTotalEspera += tiempoEspera;
		}
		return (double) tiempoTotalEspera / this.obtenerCantidadDeClientesEnEspera() / 60000;
	}
	
	public double obtenerTiempoEsperaAtendidos() {
		if(this.clientesAtendidos.size() == 0) {
			return 0.0;
		}
		Calendar ahora = Calendar.getInstance();
        long tiempoTotalEspera = 0;
        
        for (Cliente cliente : clientesAtendidos) {
            if (cliente.getFechaAtencion() != null) {
                long tiempoEspera = cliente.getFechaAtencion().getTimeInMillis() - cliente.getFechaLlegada().getTimeInMillis();
                tiempoTotalEspera += tiempoEspera;
            }
        }
        
        int clientesAtendidos = this.obtenerCantidadDeClientesAtendidos();
        return (double) tiempoTotalEspera / clientesAtendidos / 60000;
	}
}
