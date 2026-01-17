public class Kendaraan implements Comparable<Kendaraan> {
    private int nomorAntrian;
    private String namaPemilik;
    private String jenisKendaraan;
    private int prioritas; // 1=Tinggi, 2=Sedang, 3=Rendah

    public Kendaraan(int nomorAntrian, String namaPemilik, String jenisKendaraan, int prioritas) {
        this.nomorAntrian = nomorAntrian;
        this.namaPemilik = namaPemilik;
        this.jenisKendaraan = jenisKendaraan;
        this.prioritas = prioritas;
    }

    public int getPrioritas() {
        return prioritas;
    }

    @Override
    public int compareTo(Kendaraan o) {
        return Integer.compare(this.prioritas, o.prioritas);
    }

    @Override
    public String toString() {
        return "Antrian " + nomorAntrian +
                " | " + namaPemilik +
                " | " + jenisKendaraan +
                " | Prioritas: " + prioritas;
    }
}
