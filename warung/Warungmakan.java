package warung;

import interfaces.Warunginterface;
import barang.Barang;

public class Warungmakan implements Warunginterface {
    private Barang[] menu;
    private int gas = 15;
    private int omset = 0;

    public Warungmakan(Barang[] menu) {
        this.menu = menu;
    }

    @Override
    public boolean tambahStok(Barang barang, int jumlah) {
        barang.setStok(barang.getStok() + jumlah);
        return true;
    }

    @Override
    public boolean jualBarang(Barang barang, int jumlah) {
        if (barang.getStok() >= jumlah && gas > 0) {
            barang.setStok(barang.getStok() - jumlah);
            gas--;  // Gas berkurang setiap ada penjualan
            omset += barang.getHarga() * jumlah;
            return true;
        }
        return false;
    }

    @Override
    public Barang[] tampilkanMenu() {
        return menu;
    }

    public void isiUlangGas() {
        if (gas < 15) {
            gas = 15;
            System.out.println("Gas berhasil diisi ulang. Biaya: 22.000");
        }
    }

    public int hitungOmset() {
        return omset;
    }
    public int getGas() {
        return this.gas;  // Assuming you have a `gas` field that stores the current gas level
}

}
