package RahulShettyAcademy.test;

import java.io.IOException;
import java.util.ArrayList;

public class ExcelDataTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		DataDriven dd= new DataDriven();
		
		ArrayList<String> data= dd.getData("Add Profile");
		System.out.println(data.get(0));
		System.out.println(data.get(1));
		System.out.println(data.get(2));
		System.out.println(data.get(3)) ;
		
	}

}
