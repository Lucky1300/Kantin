package interfaces;

import barang.Barang;

public interface Warunginterface {
    boolean tambahStok(Barang barang, int jumlah);
    boolean jualBarang(Barang barang, int jumlah);
    Barang[] tampilkanMenu();
}
