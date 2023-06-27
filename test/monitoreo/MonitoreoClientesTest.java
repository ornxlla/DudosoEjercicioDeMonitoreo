package monitoreo;

import static org.junit.Assert.*;

import java.util.Calendar;

import org.junit.Test;

public class MonitoreoClientesTest {

	@Test
	public void queSePuedaAñadirUnCliente() {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JULY, 27, 9, 0);
		Cliente cliente = new Cliente("Ornella", 19384, fechaLlegada1);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		assertEquals((Integer)1, mecanico.obtenerCantidadDeClientesEnEspera());
	}
	
	@Test
	public void queSePuedaAtenderUnCliente() throws NoHayClientesEnEspera {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JULY, 27, 9, 0);
		Calendar fechaLlegada2 = Calendar.getInstance();
		fechaLlegada2.set(2023, Calendar.JULY, 27, 9, 11);
		Cliente cliente = new Cliente("Ornella", 1123, fechaLlegada1);
		Cliente clienteDos = new Cliente("Eliana", 1125, fechaLlegada2);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		mecanico.añadirClienteAEspera(clienteDos);
		assertEquals(cliente, mecanico.atenderCliente());
	}
	
	@Test
	public void obtenerCantidadDeClientesAtendidos() throws NoHayClientesEnEspera {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JULY, 27, 9, 0);
		Calendar fechaLlegada2 = Calendar.getInstance();
		fechaLlegada2.set(2023, Calendar.JULY, 27, 9, 11);
		Calendar fechaLlegada3 = Calendar.getInstance();
		fechaLlegada3.set(2023, Calendar.JULY, 27, 9, 15);
		Cliente cliente = new Cliente("Ornella", 1123, fechaLlegada1);
		Cliente clienteDos = new Cliente("Eliana", 1125, fechaLlegada2);
		Cliente clienteTres = new Cliente("Romina", 1167, fechaLlegada3);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		mecanico.añadirClienteAEspera(clienteDos);
		mecanico.añadirClienteAEspera(clienteTres);
		mecanico.atenderCliente();
		mecanico.atenderCliente();
		mecanico.atenderCliente();
		assertEquals((Integer)3, mecanico.obtenerCantidadDeClientesAtendidos());
	}
	@Test (expected = NoHayClientesEnEspera.class)
	public void queNoSePuedaAtenderUnCliente() throws NoHayClientesEnEspera {
		Mecanico mecanico = new Mecanico();
		mecanico.atenderCliente();
		assertEquals((Integer)0, mecanico.getClientesEnEspera());
	}
	
	@Test
	public void ordenarClientesPorNumeroMovil() {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JULY, 27, 9, 0);
		Calendar fechaLlegada2 = Calendar.getInstance();
		fechaLlegada2.set(2023, Calendar.JULY, 27, 9, 11);
		Calendar fechaLlegada3 = Calendar.getInstance();
		fechaLlegada3.set(2023, Calendar.JULY, 27, 9, 15);
		Cliente cliente = new Cliente("Ornella", 1123, fechaLlegada1);
		Cliente clienteDos = new Cliente("Eliana", 1125, fechaLlegada2);
		Cliente clienteTres = new Cliente("Romina", 1167, fechaLlegada3);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		mecanico.añadirClienteAEspera(clienteDos);
		mecanico.añadirClienteAEspera(clienteTres);
		
		assertEquals(cliente, mecanico.ordenarClientesEnEsperaPorNumeroMovil().first());
		assertEquals(clienteTres, mecanico.ordenarClientesEnEsperaPorNumeroMovil().last());
	}
	
	@Test
	public void ordenarClientesPorNombre() {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JULY, 27, 9, 0);
		Calendar fechaLlegada2 = Calendar.getInstance();
		fechaLlegada2.set(2023, Calendar.JULY, 27, 9, 11);
		Calendar fechaLlegada3 = Calendar.getInstance();
		fechaLlegada3.set(2023, Calendar.JULY, 27, 9, 15);
		Cliente cliente = new Cliente("Ornella", 1123, fechaLlegada1);
		Cliente clienteDos = new Cliente("Eliana", 1125, fechaLlegada2);
		Cliente clienteTres = new Cliente("Romina", 1167, fechaLlegada3);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		mecanico.añadirClienteAEspera(clienteDos);
		mecanico.añadirClienteAEspera(clienteTres);
		
		assertEquals(clienteDos, mecanico.ordenarClientesEnEsperaPorNombre().first());
		assertEquals(clienteTres, mecanico.ordenarClientesEnEsperaPorNombre().last());
	}
	
	//DUDOSOOOOOOOOOOOOOOOOOOO
	
	@Test
	public void obtenerCantidadDeTiempoAproxEnEspera() {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JUNE, 27, 9, 0);
		Calendar fechaLlegada2 = Calendar.getInstance();
		fechaLlegada2.set(2023, Calendar.JUNE, 27, 9, 15);
		Cliente cliente = new Cliente("Ornella", 1123, fechaLlegada1);
		Cliente clienteDos = new Cliente("Eliana", 1125, fechaLlegada2);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		mecanico.añadirClienteAEspera(clienteDos);
		double tiempoEsperaNoAtendido = mecanico.obtenerTiempoEsperaNoAtendidos();
		assertEquals(290.5, tiempoEsperaNoAtendido, 0.01);

	}
	
	@Test
	public void obtenerCantidadDeTiempoAproxAtendidos() throws NoHayClientesEnEspera {
		Calendar fechaLlegada1 = Calendar.getInstance();
		fechaLlegada1.set(2023, Calendar.JUNE, 27, 9, 0);
		Calendar fechaLlegada2 = Calendar.getInstance();
		fechaLlegada2.set(2023, Calendar.JUNE, 27, 9, 15);
		Cliente cliente = new Cliente("Ornella", 1123, fechaLlegada1);
		Cliente clienteDos = new Cliente("Eliana", 1125, fechaLlegada2);
		Mecanico mecanico = new Mecanico();
		mecanico.añadirClienteAEspera(cliente);
		mecanico.añadirClienteAEspera(clienteDos);
		mecanico.atenderCliente();
		mecanico.atenderCliente();
		double tiempoEsperaAtendidos = mecanico.obtenerTiempoEsperaAtendidos();
		assertEquals(290.5, tiempoEsperaAtendidos, 0.01);
	}
}
