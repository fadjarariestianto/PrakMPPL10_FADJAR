import java.util.Scanner;
import java.text.DecimalFormat;

public class jarak2titik
{
	public static void main(String[] args)
	{
		System.out.println("Nama: Fadjar Ariestianto Suleman");
        System.out.println("NIM: 064002100032");
        System.out.println("Rabu, 6 April 2022");
        System.out.println(" ");
		
		Scanner input = new Scanner(System.in);
		int x1,y1,x2,y2;
        double hasil;
		
		System.out.println("nilai x1: ");
        x1 = input.nextInt();
        System.out.println("nilai y1: ");
        y1 = input.nextInt();
        System.out.println("nilai x2: ");
        x2 = input.nextInt();
        System.out.println("nilai y2: ");
        y2 = input.nextInt();
		
        hasil = Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1));
        DecimalFormat df = new DecimalFormat("#.##");
        System.out.println("Jarak antara titik ("+x1+","+y1+") dan ("+x2+","+y2+") adalah "+df.format(hasil));
    }
}