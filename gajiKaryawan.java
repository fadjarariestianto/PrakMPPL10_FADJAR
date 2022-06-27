import java.util.Scanner;
public class gajiKaryawan {
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		int gajiPokok = 0;
		int totalGaji = 0;
		int asuransi  = 0;
		int uangMakan = 0;
		System.out.print("");
		System.out.print("\nMasukan Nama : ");
		char nama = sc.next().charAt(0);
		System.out.print("\nMasukan Nomor Induk Kerja : ");
		int nik =sc.nextInt();
		System.out.println("1. Pegawai Tetap");
		System.out.println("2. Pegawai Honorer");
		System.out.println("3. Pegawai Magang");
		System.out.print("");
		System.out.print("Masukan pilihan golongan : ");
		int pilih = sc.nextInt();
		System.out.println("");
		
		if (pilih==1) {
			gajiPokok = 10000;
			asuransi = 500;
			uangMakan = 2500;
    }
		else if (pilih==2) {
			gajiPokok = 7000;
			asuransi = 500;
			uangMakan = 2500;	
		}
		else if (pilih==3) {
			gajiPokok = 5000;
			asuransi = 500;
			uangMakan = 2500;
		}
		totalGaji=(gajiPokok + asuransi + uangMakan);
		System.out.println("");
