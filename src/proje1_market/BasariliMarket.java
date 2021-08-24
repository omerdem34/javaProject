package proje1_market;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class BasariliMarket{
	
	

/* Basrili Market alış-veriş programı.
*
* 1. Adım: Ürünler ve fiyatları içeren listeleri oluşturunuz.
*          No     Ürün         Fiyat
          ====  =======        =========
           00   Domates         2.10 TL
           01   Patates         3.20 TL
           02   Biber           1.50 TL
           03   Soğan          2.30 TL
           04   Havuç              3.10 TL
           05   Elma            1.20 TL
           06   Muz             1.90 TL
           07   Çilek              6.10 TL
           08   Kavun           4.30 TL
           09   Üzüm              2.70 TL
           10   Limon           0.50 TL
* 2. Adım: Kullanıcının ürün nosuna göre listeden ürün seçmesini isteyiniz.
* 3. Adım: Kaç kg satın almak istediğini sorunuz.
* 4. Adım: Alınacak bu ürünü sepete ekleyiniz ve Sepeti yazdırınız.
* 5. Başka bir ürün alıp almak istemediğini sorunuz.
* 6. Eğer devam etmek istiyorsa yeniden ürün seçme kısmına yönlendiriniz.
* 7. Eğer bitirmek istiyorsa ödeme kısmına geçiniz ve ödem sonrasında programı bitirinzi.
*/

	public static List<String> urunler = new ArrayList();
	
	public static  List<Double> fiyatlar= new ArrayList();
	
	public static  List<String> sepettekiUrunler= new ArrayList();
	
	public static  List<Double> sepettekiFiyat= new ArrayList(); 
	
	public static  List<Double> sepettekiKilo= new ArrayList();
	
		public static void main(String[] args) {
			
			Scanner scan = new Scanner(System.in);
			
			urunler.addAll(Arrays.asList("Domate","Patates","Biber","Sogan","Havuc","Elma","Muz","Cilek","Kavun","Uzum","Limon"));
			fiyatlar.addAll(Arrays.asList(2.1,3.20,1.50,2.30,3.10,1.20,1.90,6.10,4.30,2.70,0.50));
			int urunNo;
			double kg=0;
			String devam;
			double toplam=0;
			
			do {
			urunleriListele();
			System.out.println("Almak istediginiz urunun numarasini girin");
			urunNo=scan.nextInt();
			System.out.println("Kac kilo almak istiyorsunuz");
			kg=scan.nextDouble();
			sepeteEkle(urunNo,kg);
			toplam=sepetiYazdir();
			System.out.println();
			System.out.println("devam etmek istiyormusunuz (E/H)");
			devam=scan.next();
			}while(devam.equalsIgnoreCase("E"));
			
			odemeYap(toplam);
		
		}

		public static void odemeYap(double toplam) {
			Scanner scan=new Scanner(System.in);
			double miktar=0;
			System.out.println("odemeniz gereken miktar = "+toplam);
			
			do {
				
			
			System.out.println("ne kadar paraniz var");
			miktar+=scan.nextDouble();
			if (miktar<toplam) {
				System.out.println("paraniz yetersiz ekleme yapin");
				System.out.println("ekleme yapacaginiz miktar : "+(toplam-miktar));
			}
		}while(miktar<=toplam);
			
			System.out.println("su ana kadar"+miktar+"odeme yaptin");
			System.out.println("toplam borcunuz"+toplam);
			System.out.println("----------------------------------");
			System.out.println("para ustunuz : "+(miktar-toplam));
			
		}

		private static double sepetiYazdir() {
			double sepettekiToplam=0;
			System.out.println("urunadi\tkilo\ttutar");
			System.out.println("------------------------------");
			for (int i = 0; i < sepettekiUrunler.size(); i++) {
				
				System.out.println(sepettekiUrunler.get(i)+"\t"+sepettekiKilo.get(i)+"\t"+sepettekiFiyat.get(i));
				sepettekiToplam+=sepettekiFiyat.get(i);
			}
			
			return sepettekiToplam;
		}



		private static void sepeteEkle(int urunNo, double kg) {
			
			sepettekiUrunler.add(urunler.get(urunNo));
			sepettekiKilo.add(kg);
			sepettekiFiyat.add(fiyatlar.get(urunNo)*kg);
			
			
			
			
			
		}



		public static void urunleriListele() {
			
			System.out.println("NO\tURUNLER\t\tFİYATLAR");
			System.out.println("-----------------------------");
			for (int i = 0; i < urunler.size(); i++) {
				System.out.println(i+ "\t "+urunler.get(i)+"\t\t "+fiyatlar.get(i));
				
			}
			
		}
	
		


}