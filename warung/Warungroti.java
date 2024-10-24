package warung;

import interfaces.Warunginterface;
import barang.Barang;

public class Warungroti implements Warunginterface {
    private Barang[] menu;
    private int totalOmset;
    
    public Warungroti(Barang[] menu) {
        this.menu = menu;
        this.totalOmset = 0; // Initialize total revenue to 0
    }

    @Override
    public boolean tambahStok(Barang barang, int jumlah) {
        barang.setStok(barang.getStok() + jumlah);
        return true;
    }

    @Override
    public boolean jualBarang(Barang barang, int jumlah) {
       // System.out.println("coba jual: " + barang.getNama() + " Quantity: " + jumlah); // Debug line
        if (barang.getStok() >= jumlah) {
            barang.setStok(barang.getStok() - jumlah);
            totalOmset += barang.getHarga() * jumlah; // Update totalOmset here
           // System.out.println("Updated total omset: Rp. " + totalOmset); // Debug line
            return true;
        }
        return false;
    }
    @Override
    public Barang[] tampilkanMenu() {
        return menu;
    }
    
    public int hitungOmset() {
        return totalOmset; // Return the total revenue
    }
}
