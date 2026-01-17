import javax.swing.*;
import java.awt.*;

public class MainGUI extends JFrame {

    private JTextField txtNama, txtJenis;
    private JComboBox<String> cbPrioritas;
    private JTextArea areaAntrian;

    private AntrianServis servis = new AntrianServis();
    private int nomor = 1;

    public MainGUI() {
        setTitle("Sistem Antrian Servis Kendaraan");
        setSize(600, 450);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Panel Input
        JPanel panelInput = new JPanel(new GridLayout(4, 2, 5, 5));
        panelInput.setBorder(BorderFactory.createTitledBorder("Input Data Kendaraan"));

        txtNama = new JTextField();
        txtJenis = new JTextField();
        cbPrioritas = new JComboBox<>(new String[]{
                "1 - Tinggi", "2 - Sedang", "3 - Rendah"
        });

        panelInput.add(new JLabel("Nama Pemilik"));
        panelInput.add(txtNama);
        panelInput.add(new JLabel("Jenis Kendaraan"));
        panelInput.add(txtJenis);
        panelInput.add(new JLabel("Prioritas"));
        panelInput.add(cbPrioritas);

        JButton btnTambah = new JButton("Tambah Antrian");
        JButton btnPanggil = new JButton("Panggil Kendaraan");

        panelInput.add(btnTambah);
        panelInput.add(btnPanggil);

        // Area Output
        areaAntrian = new JTextArea();
        areaAntrian.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaAntrian);
        scroll.setBorder(BorderFactory.createTitledBorder("Daftar Antrian"));

        // Action
        btnTambah.addActionListener(e -> tambahAntrian());
        btnPanggil.addActionListener(e -> panggilAntrian());

        add(panelInput, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }

    private void tambahAntrian() {
        String nama = txtNama.getText();
        String jenis = txtJenis.getText();
        int prioritas = cbPrioritas.getSelectedIndex() + 1;

        if (nama.isEmpty() || jenis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Data belum lengkap!");
            return;
        }

        Kendaraan k = new Kendaraan(nomor++, nama, jenis, prioritas);
        servis.tambah(k);
        tampilkanAntrian();

        txtNama.setText("");
        txtJenis.setText("");
    }

    private void panggilAntrian() {
        if (servis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Antrian kosong!");
            return;
        }

        Kendaraan k = servis.panggil();
        JOptionPane.showMessageDialog(this,
                "Memanggil:\n" + k.toString());
        tampilkanAntrian();
    }

    private void tampilkanAntrian() {
        areaAntrian.setText("");
        for (Kendaraan k : servis.getAntrian()) {
            areaAntrian.append(k + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainGUI().setVisible(true));
    }
}
