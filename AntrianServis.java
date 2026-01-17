import java.util.PriorityQueue;

public class AntrianServis {
    private PriorityQueue<Kendaraan> antrian = new PriorityQueue<>();

    public void tambah(Kendaraan k) {
        antrian.add(k);
    }

    public Kendaraan panggil() {
        return antrian.poll();
    }

    public PriorityQueue<Kendaraan> getAntrian() {
        return antrian;
    }

    public boolean isEmpty() {
        return antrian.isEmpty();
    }
}
