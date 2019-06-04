import java.io.BufferedWriter;
import java.io.File;
import java.util.Calendar;
import com.bank.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.io.FileWriter;
import java.io.IOException;

public aspect Log {	 
	    
	    File file = new File("log.txt");
	    Calendar cal = Calendar.getInstance();
	    //Aspecto1: Deben hacer los puntos de cortes (pointcut) para crear un log con los tipos de transacciones realizadas.
	  
	   pointcut successTrans() : call(void Bank.makeTransaction());
	   after() : successTrans() {
	    	System.out.println("**** Dinero acreditado ****");
	    	String tipo = "Acreditación";
	        Date date = cal.getTime();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	        String strDate = dateFormat.format(date);
	       
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
				bw.write(tipo + " , "+ strDate);
				bw.newLine();
				System.out.println("Transacción registrada\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	
	    }
	   
	   
	   pointcut successMoney() : call(void Bank.myMoney());	    
	   after() : successMoney() {
	    	System.out.println("**** Retiro realizado ****");
	    	String tipo = "Retiro";
	        Date date = cal.getTime();
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");
	        String strDate = dateFormat.format(date);
	       
	        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
				bw.write(tipo + " , "+ strDate);
				bw.newLine();
				System.out.println("Transacción registrada\n");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	    	
	    }
	    
}
