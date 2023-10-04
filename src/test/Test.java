package test;

import java.util.List;

import datos.OrdenMantenimiento;
import negocio.AmbienteAbm;
import negocio.OrdenDeMantenimientoAbm;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Punto 1 traer Ambiente por id");
		System.out.println(AmbienteAbm.getInstance().traer(8));
		
		System.out.println("prueba de punto 2");
		List<OrdenMantenimiento> lst = OrdenDeMantenimientoAbm.getInstance().traer(AmbienteAbm.getInstance().traer(8));
		for (OrdenMantenimiento ordenMantenimiento : lst) {
			System.out.println(ordenMantenimiento);
		}
		
		System.out.println("prueba de punto 3, lista de ordenes por ambiente y estado terminado false");
		List<OrdenMantenimiento> ordenes = OrdenDeMantenimientoAbm.getInstance().traer(AmbienteAbm.getInstance().traer(8), false);
		for (OrdenMantenimiento ordenMantenimiento : ordenes) {
			System.out.println(ordenMantenimiento);
		}
		
		System.out.println("Prueba de punto 4");
		System.out.println("este punto se realizo luego del examen:");
		System.out.println("calcular el tiempo de ejecucion en dias de la reparacion para las ordenes pendientes del ambiente id=8");
		List<OrdenMantenimiento> or = OrdenDeMantenimientoAbm.getInstance().traer(AmbienteAbm.getInstance().traer(8),false);
		for (OrdenMantenimiento ordenMantenimiento : or) {
			System.out.println(ordenMantenimiento+" cantidad de dias "+ordenMantenimiento.tiempoDeEjecucion());
		}
		
		System.out.println("\nprueba de punto 6 traer ordenes pagadas");
		System.out.println(OrdenDeMantenimientoAbm.getInstance().traer(true));

		System.out.println("pruba de caso 5 traer informe de reparaciones no pagadas:");
		System.out.println(OrdenDeMantenimientoAbm.getInstance().traerInforme(false));
	}

}
