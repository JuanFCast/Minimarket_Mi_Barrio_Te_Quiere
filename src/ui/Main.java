package ui;

import java.util.Scanner;

import exceptions.NoPicoCedulaException;
import exceptions.NoWithTIException;
import model.Mini_Market;
import model.Type;

public class Main {
	private Mini_Market mini_market;
	private Scanner reader;

	//Constructor
	public Main() {
		reader = new Scanner(System.in);
		mini_market = new Mini_Market();
	}


	public static void main(String[]args) {
		Main pp = new Main();
		int option=0;
		do {
			try {
				option=pp.menu();

				switch(option) {
				case 1:
					pp.registerNewPerson();	
					break;
				case 2:
					pp.consultAttempts();
					break;

				}
			}catch(NumberFormatException nfe) {
				System.out.println("\n	Ingrese solo numeros por favor\n");
			}


		}while(option!=3);
	}

	public int menu() {
		System.out.println("=====================================\n"
				+ "== Bienvenid@ a Mi Barrio Te Quiere ==\n"
				+ "===========  Mini-Mercado  ===========\n"
				+ "======================================");
		System.out.println("Elija una opcion que desea realizar: \n"+
				"(1) Registrar el ingreso de una nueva persona\n"+
				"(2) Consultar la cantidad de personas que han intentado ingresar \n"+
				"(3) Salir del programa\n");

		int option = Integer.parseInt(reader.nextLine());
		return option;
	}

	public  void registerNewPerson() {
		int option = 0;
		Type type = null;
		do {
			try {
				System.out.println("===Registrar el ingreso de una nueva persona===\n"+
						"Elija el tipo de documento de identificacion: \n"+
						"(1) TI - Tarjeta de Identidad\n"+
						"(2) CC - Cedula de Ciudadania \n"+
						"(3) PP - Pasaporte\n"+
						"(4) CE - Cedula de Extranjeria\n");
				option=Integer.parseInt(reader.nextLine());

			}catch(NumberFormatException nfe) {
				System.out.println("\n	Ingrese solo numeros por favor\n");

			}

			switch(option) {
			case 1:
				type = Type.TI;
				break;
			case 2:
				type = Type.CC;
				break;
			case 3:
				type = Type.PP;
				break;
			case 4:
				type = Type.CE;
				break;
			}
			
		}while(option<1 || option>4);

		System.out.println("Digite el numero de su documento de identificacion: ");
		String id=reader.nextLine();

		try {
			mini_market.register(type, id);
			System.out.println("\n	La persona ha sido registrada exitosamente\n");
		}catch(NoWithTIException nwt) {
			System.out.println("\n===========================================\n"
					+ "No se permite el registro a Menores de Edad"
					+ "\n===========================================\n");

		}catch(NoPicoCedulaException npc) {
			System.out.println("\n=============================================\n"
					+ "El Usuario no puede ingresar, porque su pico y cedula no es el dia de hoy"
					+ "\n=============================================\n");

		}
	}

	public void consultAttempts() {
		System.out.println("===Cantidad de personas que han intentado ingresar===\n");
		System.out.println("Actualmente han intentado ingresar "+ mini_market.getAttemps()+" personas\n");

	}


}
