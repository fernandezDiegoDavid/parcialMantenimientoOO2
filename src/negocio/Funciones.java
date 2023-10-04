package negocio;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.LocalTime;

public class Funciones {
	
	public static String pasarDoubleACadena(double objeto) {
		
		String format = "00.00";
		NumberFormat formatter = new DecimalFormat(format);
		String sDouble = formatter.format(objeto);
		
		return sDouble;
	}
	
	public static String calculoCuotas(LocalDate fecha,double monto,double interes,int cantCuotas) {
		         //implementar el calculo de las cuotas
				//declaracion de variables a utilizar
				int nroCuota=0;
				LocalDate fechaDeVencimineto=fecha;
				double saldoPendiente= monto;//el primer saldo pendiente sera el 
				//monto solicitado del credito
				double interesCuota=0;
				double ineteresMensual=interes/12;
				double cuota;
				double deuda;
				double amortizacion;
				String salidaConsola="";
				String sEncabezado="fecha de vencimiento    nrocuota  interescuota  amortizacion cuota  deuda  saldopendiente";
				
				int indice;
				for (indice=0;indice<cantCuotas;indice++) {
					fechaDeVencimineto=fechaDeVencimineto.plusMonths(1);
					nroCuota = nroCuota+1;
					interesCuota = saldoPendiente*ineteresMensual;
					amortizacion = (saldoPendiente*ineteresMensual)/(Math.pow((1+ineteresMensual),cantCuotas-indice )-1);
					cuota = amortizacion+interesCuota;
					deuda= saldoPendiente-amortizacion;
					saldoPendiente = saldoPendiente-amortizacion;
					//intantare darle un nuevo formato a los double
					
					
					
					salidaConsola = salidaConsola+fechaDeVencimineto+"\t\t|"+nroCuota+"\t|"+Funciones.pasarDoubleACadena(interesCuota)+"\t|"+Funciones.pasarDoubleACadena(amortizacion)+"|"+Funciones.pasarDoubleACadena(cuota)+"|"+Funciones.pasarDoubleACadena(deuda)+"|"+Funciones.pasarDoubleACadena(saldoPendiente);
					salidaConsola=salidaConsola+"\n";
				}
		
		
		return sEncabezado+"\n"+salidaConsola;
	}
	
	public static boolean esDiaHabil(LocalDate fecha) {
		int d = fecha.getDayOfWeek().getValue();
		/*
		 * Help: LocalDate fecha=LocalDate.of (2019,9,30); int
		 * nroDiaSem=fecha.getDayOfWeek().getValue(); //nroDiaSem=1,from 1 (Monday) to 7
		 * (Sunday)
		 */
		return ((d >= 1) && (d <= 5));
	}

	public static int cantidadDediashabiles(LocalDate fechaInicio,LocalDate fechaFin) {
		int cantidad=0;
		int d=0;
		LocalDate aux=fechaInicio;
		int iteraciones=Funciones.cantDeDiasEntreFechas(fechaInicio, fechaFin);
		for(int i=0;i<iteraciones;i++) {
			
			d=aux.getDayOfWeek().getValue();
			if ((d<=5)&&(d>=1)) {
				//verificar ademas que no sea feriado
				//aux.equals
				cantidad+=1;
			}
			aux=aux.plusDays(1);
		}
		return cantidad;
	}
	
	public static int cantidadDeDiasNoHabiles(LocalDate fechaInicio,LocalDate fechaFin) {
		int cantidad=0;
		LocalDate aux=fechaInicio;
		while(aux.isBefore(fechaFin)) {
			int d= aux.getDayOfWeek().getValue();
			if ((d==6)||d==7) {
				cantidad+=1;
			}
			aux=aux.plusDays(1);
		}
		return cantidad;
	}
	
	public static double convertirADouble(int n) {
		return ((double) n);
	}
	
	 public static int convertirAEntero(String cadena) {
	
		int entero=0;
		entero =Integer.parseInt(cadena);
		return entero;
		
	}
	public static boolean esBiciesto(LocalDate fecha) {
		boolean bandera=false;
		int year = fecha.getYear();
		if (year % 4 == 0 && ((year % 100 != 0) ||( year % 400==0))) {
			bandera = true;
		}
		return bandera;
	}
	
	public static String traerDiaDeLaSemana(LocalDate fecha)
	{
		int d=0;
		String dia;
		d= fecha.getDayOfWeek().getValue();
		switch (d) {
		 case 1:
			{
				dia="lunes";
		        break;
			}
		 case 2:
			{
				dia="martes";
		        break;
			}
		 case 3:
			{
				dia= "miercoles";
			    break;
			}
		 case 4:
			{
				dia = "jueves";
			    break;
			}
		 case 5:
			{
				dia= "viernes";
			    break;
			}
		 case 6:
			{
				dia = "sabado";
		        break;
			}
		 case 7:
			{
				dia = "domingo";
			    break;
			}
		 default :
			{
				dia= "dia incorrecto... el valor debe ser entre 1 y7";
			     break;
			}
		}
		return dia;
	}
	public static String traerFechaCorta(LocalDate fecha) {
		
		StringBuffer fechaCorta = new StringBuffer();
		
		int aux;
		
		char barra='/';
		aux = fecha.getDayOfMonth();
		fechaCorta.append(aux);
		fechaCorta.append(barra);
		aux = fecha.getMonthValue();
		fechaCorta.append(aux);
		fechaCorta.append(barra);
		aux= fecha.getYear();
		fechaCorta.append(aux);
		
		return fechaCorta.toString();
	}
	
	public static String traerHoraCorta(LocalTime hora) {
		StringBuffer horaCorta = new StringBuffer();
		char barra = ':';
		int aux;
		aux = hora.getHour();
		horaCorta.append(aux);
		horaCorta.append(barra);
		aux= hora.getMinute();
		horaCorta.append(aux);
		return horaCorta.toString();
	}
	public static String []meses= {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre"};
	public static String traerMesEnLetras(LocalDate fecha) {
		int mes = fecha.getMonthValue();
		return meses[mes-1];
		
		
	}
	
	public static String traerFechaLarga(LocalDate fecha) {
		StringBuffer fechaLarga= new StringBuffer();
		String de = "de ";
		String del= "del ";
		fechaLarga.append(Funciones.traerDiaDeLaSemana(fecha));
		fechaLarga.append(' ');
		fechaLarga.append(fecha.getDayOfMonth());
		fechaLarga.append(' ');
		fechaLarga.append(de);
		fechaLarga.append(Funciones.traerMesEnLetras(fecha));
		fechaLarga.append(' ');
		fechaLarga.append(del );
		fechaLarga.append(fecha.getYear());
		return fechaLarga.toString();
		
		
	}

	public static int traerCantDeDiasDeUnMes(LocalDate fecha) {
		int cantDias=0;
		cantDias=fecha.lengthOfMonth();
		return cantDias;
	}
	
	public static int cantDeDiasEntreFechas(LocalDate fechaInicio,LocalDate fechaFin) {
		int cantDeDias=0;
		LocalDate fechaAux;
		fechaAux=fechaInicio;
		while(fechaAux.isBefore(fechaFin)) {
			cantDeDias+=1;
			fechaAux=fechaAux.plusDays(1);
		}
		return cantDeDias;
	}
	
	public static boolean esNumero(char c) {
		boolean bandera=Character.isDigit(c);
		
		
		return bandera;
	}
	public static boolean esLetra(char c) {
		boolean bandera=false;
		if (Funciones.esNumero(c)==false) {
			bandera=true;
		}
		return bandera;
	}
	
	public static boolean esCadenaDeNumeros(String cadena) {
		boolean bandera=true;
		int indice=0;
		for(indice=0;indice<cadena.length();indice++) {
			if (!Funciones.esNumero(cadena.charAt(indice))) {
				bandera=false;
			}
		}
		return bandera;
	}

	public static boolean esCadenaDeLetras(String cadena) {
		boolean bandera=true;
		int indice=0;
		for(indice=0;indice<cadena.length();indice++) {
			if (!Funciones.esLetra(cadena.charAt(indice))) {
				bandera=false;
			}
		}
		return bandera;
	}
	
	public static LocalDate proximoMesFechaHabil(LocalDate fecha) {
		LocalDate ldfechaHabil;
		ldfechaHabil=fecha;
		ldfechaHabil=ldfechaHabil.plusMonths(1);
		int ivalorMes=ldfechaHabil.getMonthValue();
		switch(ivalorMes) {
		case 1: 
			if (ldfechaHabil.getDayOfMonth()==1) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			
			break;
		case 2 :
			if (ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==20) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
				
			}
			if (ldfechaHabil.getDayOfMonth()==21) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			
			
			break;
		case 3 :
			if (ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==24) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			
			break;
		case 4: 
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==2) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			break;
		case 5: 
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==1) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==25) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			break;
		case 6:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if (ldfechaHabil.getDayOfMonth()==17) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if (ldfechaHabil.getDayOfMonth()==20) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			
			if (ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			break;
		case 7:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==9) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			
			break;
		case 8:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==21) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			
			break;
		
		case 9:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			break;
		case 10:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==16) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			
			break;
		case 11:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==20) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			break;
		case 12:
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==8) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==25) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==6) {
				ldfechaHabil=ldfechaHabil.plusDays(2);
			}
			if 
			(ldfechaHabil.getDayOfWeek().getValue()==7) {
				ldfechaHabil=ldfechaHabil.plusDays(1);
			}	
		break;

		}
		return ldfechaHabil;
	}
		

}