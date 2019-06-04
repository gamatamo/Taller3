import java.util.Scanner;
import com.bank.*;

public aspect Login {
	 //Aspecto2: El login debe realizarse antes de la transacciï¿½n
		private static Scanner input = new Scanner(System.in);
		
		pointcut prevTrans(): call(void Bank.make*())|| call(void Bank.my*());
		before(): prevTrans() {
			System.out.println("Alerta: Antes de realizar la transacción, ingrese los siguientes datos");
			System.out.println("Usuario: ");
			String usuario = input.next();
			System.out.println("Contraseña: ");
			String pass = input.next();
			System.out.println("¡Login exitoso!\n");
			
		}

}
