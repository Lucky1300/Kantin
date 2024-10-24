package warung;

import interfaces.Warunginterface;
import barang.Barang;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Barang[] menuMakan = {
            new Barang("1. Indomie Goreng", 100, 6000),
            new Barang("2. Indomie Rebus", 200, 7000),
            new Barang("3. Indomie Telur", 50, 10000),
            new Barang("4. Indomie Kornet", 30, 12000)
        };

        Barang[] menuRoti = {
            new Barang("1. Sari Roti", 40, 3500),
            new Barang("2. Roti Tawar", 30, 1500),
            new Barang("3. Croissant", 50, 8000)
        };

        Warungmakan warungMakan = new Warungmakan(menuMakan);
        Warungroti warungRoti = new Warungroti(menuRoti);

        Scanner scanner = new Scanner(System.in);
        int pilihan;

        while (true) {
            System.out.println("=== KANTIN GESANG ===");
            System.out.println("1. Warung Makan");
            System.out.println("2. Warung Roti");
            System.out.println("3. Exit");
            System.out.print("Masukkan Pilihan: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                kelolaWarungMakan(warungMakan, scanner);
            } else if (pilihan == 2) {
                kelolaWarungRoti(warungRoti, scanner);
            } else if (pilihan == 3) {
                break;
            }
        }
    }

    private static void kelolaWarungMakan(Warungmakan warungMakan, Scanner scanner) {
        int pilihan;
        do {
            System.out.println("1. Lihat Stok");
            System.out.println("2. Tambah Stok");
            System.out.println("3. Jual Barang");
            System.out.println("4. Isi Ulang Gas");
            System.out.println("5. Hitung Omset");
            System.out.println("6. Exit");
            System.out.print("Masukkan Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    for (Barang barang : warungMakan.tampilkanMenu()) {
                        System.out.println(barang.getNama() + " Stok: " + barang.getStok());
                    }
                    break;
                case 2:
                        System.out.println("Pilih barang yang mau ditambah stok:");
                        int index = 1;
                        for (Barang barang : warungMakan.tampilkanMenu()) {
                            System.out.println(barang.getNama());
                        }
                        System.out.print("Masukan Pilihan: ");
                        int pilihBarang = scanner.nextInt();
                        Barang barangDipilih = warungMakan.tampilkanMenu()[pilihBarang - 1]; 
                        
                        System.out.println("Stok Terkini: " + barangDipilih.getStok());

                        System.out.print("Jumlah Penambahan: ");
                        int jumlahTambah = scanner.nextInt();

                        warungMakan.tambahStok(barangDipilih, jumlahTambah);

                        System.out.println("Stok Terkini: " + barangDipilih.getStok());
                        break;
               case 3:  
                        index = 1;

                        for (Barang barang : warungMakan.tampilkanMenu()) {
                            System.out.println( barang.getNama() + " (Rp. " + barang.getHarga() + ")");
                    
                        }
                        
                        System.out.print("Pilih barang yang ingin dijual: ");
                        pilihBarang = scanner.nextInt();

                        System.out.print("Masukkan jumlah barang yang ingin dijual:");
                        int jualBarang = scanner.nextInt();

                        Barang selectedBarang = warungMakan.tampilkanMenu()[pilihBarang - 1];
                        int totalTransaksi = jualBarang * selectedBarang.getHarga();

                        System.out.println("Jumlah Penjualan: " + jualBarang);
                        System.out.println("Jumlah Transaksi: Rp. " + totalTransaksi);

                        if (jualBarang <= selectedBarang.getStok()) {
                            warungMakan.jualBarang(selectedBarang, jualBarang);
                            System.out.println("Stok Terkini: " + selectedBarang.getStok());
                        } else {
                            System.out.println("Stok tidak mencukupi!");
                        }
                        break;
                   
                   
                case 4:
                    System.out.println("Gas Saat Ini: " + warungMakan.getGas());

                    System.out.print("Ingin Isi Ulang Gas? (Biaya = 22000): ");
                    char isiUlang = scanner.next().charAt(0);

                    if (isiUlang == 'y' || isiUlang == 'Y') {
                        warungMakan.isiUlangGas();
                        System.out.println("Gas Telah Diisi Ulang");
                    } else {
                        System.out.println("Gas Tidak Diisi Ulang");
                    }
                    break;

                case 5:
                    System.out.println("Omset: " + warungMakan.hitungOmset());
                    break;
            }
        } while (pilihan != 6);
    }

    private static void kelolaWarungRoti(Warungroti warungRoti, Scanner scanner) {
        int pilihan;
        do {
            System.out.println("1. Lihat Stok");
            System.out.println("2. Tambah Stok");
            System.out.println("3. Jual Barang");
            System.out.println("4. Hitung Omset");
            System.out.println("5. Exit");
            System.out.print("Masukkan Pilihan: ");
            pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    for (Barang barang : warungRoti.tampilkanMenu()) {
                        System.out.println(barang.getNama() + " - Stok: " + barang.getStok());
                    }
                    break;
                case 2:
                    System.out.println("Pilih barang yang mau ditambah stok:");
                        int index = 1;
                        for (Barang barang : warungRoti.tampilkanMenu()) {
                            System.out.println(barang.getNama());
                        }
                        System.out.print("Masukan Pilihan: ");
                        int pilihBarang = scanner.nextInt();
                        Barang barangDipilih = warungRoti.tampilkanMenu()[pilihBarang - 1]; 
                        
                        System.out.println("Stok Terkini: " + barangDipilih.getStok());

                        System.out.print("Jumlah Penambahan: ");
                        int jumlahTambah = scanner.nextInt();

                        warungRoti.tambahStok(barangDipilih, jumlahTambah);

                        System.out.println("Stok Terkini: " + barangDipilih.getStok());
                        break;
                case 3:
                    index = 1;
                        for (Barang barang : warungRoti.tampilkanMenu()) {
                            System.out.println( barang.getNama() + " (Rp. " + barang.getHarga() + ")");
                            
                        } 
                        
                        System.out.print("Pilih barang yang ingin dijual: ");
                        pilihBarang = scanner.nextInt();
                        System.out.print("Masukkan jumlah barang yang ingin dijual:");
                        int jualBarang = scanner.nextInt();

                        Barang selectedBarang = warungRoti.tampilkanMenu()[pilihBarang - 1];
                        int totalTransaksi = jualBarang * selectedBarang.getHarga();

                        System.out.println("Jumlah Penjualan: " + jualBarang);
                        System.out.println("Jumlah Transaksi: Rp. " + totalTransaksi);

                        if (jualBarang <= selectedBarang.getStok()) {
                            warungRoti.jualBarang(selectedBarang, jualBarang);
                            System.out.println("Stok Terkini: " + selectedBarang.getStok());
                        } else {
                            System.out.println("Stok tidak mencukupi!");
                        }
                        break;
                case 4:
                        System.out.println("Omset: Rp. " + warungRoti.hitungOmset());
                        break;
            }
        } while (pilihan != 5);
    }
}
