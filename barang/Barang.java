package barang;

public class Barang {
    private String nama;
    private int stok;
    private int stokAwal; 
    private int harga;

    public Barang(String nama, int stok, int harga) {
        this.nama = nama;
        this.stok = stok;
        this.stokAwal = stok; 
        this.harga = harga;
    }
    
    public int getStokAwal() {
        return stokAwal;
    }

    public String getNama() {
        return nama;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

}
