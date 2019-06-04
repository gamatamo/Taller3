import java.util.Scanner;
import com.bank.*;

public aspect Login {
	 //Aspecto2: El login debe realizarse antes de la transacci�n
		private static Scanner input = new Scanner(System.in);
		
		pointcut prevTrans(): call(void Bank.make*())|| call(void Bank.my*());
		before(): prevTrans() {
			System.out.println("Alerta: Antes de realizar la transacci�n, ingrese los siguientes datos");
			System.out.println("Usuario: ");
			String usuario = input.next();
			System.out.println("Contrase�a: ");
			String pass = input.next();
			System.out.println("�Login exitoso!\n");
			
		}

}
