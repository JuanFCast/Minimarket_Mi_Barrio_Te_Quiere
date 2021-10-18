package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;


import exceptions.NoPicoCedulaException;
import exceptions.NoWithTIException;

class Mini_MarketTest {
	private int today = LocalDateTime.now().getDayOfMonth();
	private Mini_Market mini_market;

	public void setupScenary1() {
		mini_market=new Mini_Market();
	}
	
	
	@Test
	public void testRegister1() {
		setupScenary1();
		if(today%2 == 0) {
			try {
				Type type = Type.CC;	
				String numID= "1006584131";
				mini_market.registerUser(type, numID);
			} catch (NoWithTIException nwt) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				fail();
			} catch (NoPicoCedulaException npc) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				fail();
			}
		}else {
			try {
				Type type = Type.CC;	
				String numID= "1006584121";
				mini_market.registerUser(type, numID);
			} catch (NoWithTIException nwt) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				fail();
			} catch (NoPicoCedulaException npc) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				fail();
			}
		}

		ArrayList<User> userRegistered = mini_market.getUserRegistered();
		assertEquals(1, userRegistered.size());
	}
	
	
	
	@Test
	public void testRegister2() {
		setupScenary1();
		if(today%2 == 0) {
			try {
				Type type = Type.CC;	
				String numID= "1006584131";
				mini_market.registerUser(type, numID);
				
			} catch (NoWithTIException nwt) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				fail();
			} catch (NoPicoCedulaException npc) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				fail();
			}
		}else {
			try {
				Type type = Type.CC;	
				String numID= "1006584121";
				mini_market.registerUser(type, numID);
			} catch (NoWithTIException nwt) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				fail();
			} catch (NoPicoCedulaException npc) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				fail();
			}
		}

		ArrayList<User> userRegistered = mini_market.getUserRegistered();
		assertEquals(1, userRegistered.size());
		assertEquals(1, mini_market.getAttemps());
	}
	
	
	
	@Test
	public void testRegister3() {
		setupScenary1();
		Type type = Type.TI;	
		String numID= "1006071586";


		try {
			mini_market.registerUser(type, numID);

		} catch (NoWithTIException nwt) {
			System.out.println("No se permite el ingreso a menores de edad\n");
		} catch (NoPicoCedulaException npc) {
			fail();
		}

		ArrayList<User> userRegistered = mini_market.getUserRegistered();
		assertEquals(0, userRegistered.size());
	}
	
	
	
	@Test
	public void testRegister4() {
		setupScenary1();
		if(today%2 == 0) {
			try {
				Type type = Type.CC;	
				String numID= "1006584121";
				mini_market.registerUser(type, numID);
			} catch (NoWithTIException nwt) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				fail();
			} catch (NoPicoCedulaException npc) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				
			}
		}else {
			try {
				Type type = Type.CC;	
				String numID= "1006584131";
				mini_market.registerUser(type, numID);
			} catch (NoWithTIException nwt) {
				System.out.println("No se permite el ingreso a menores de edad\n");
				fail();
			} catch (NoPicoCedulaException npc) {
				System.out.println("No cumple con el Pico y Cedula, por lo que no puede entrar a la tienda\n");
				
			}
		}

		ArrayList<User> userRegistered = mini_market.getUserRegistered();
		assertEquals(0, userRegistered.size());
	}
	
	

}
