import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kelas TaskManager digunakan untuk mengelola daftar tugas.
 */
public class TaskManager {
    private List<Task> taskList;

    /**
     * Konstruktor untuk membuat objek TaskManager.
     */
    public TaskManager() {
        taskList = new ArrayList<>();
    }

    /**
     * Kelas Task digunakan untuk merepresentasikan tugas dengan deskripsi.
     */
    public class Task {
        private String deskripsi;

        /**
         * Konstruktor untuk membuat objek tugas dengan deskripsi.
         *
         * @param deskripsi Deskripsi tugas.
         */
        public Task(String deskripsi) {
            this.deskripsi = deskripsi;
        }

        /**
         * Metode ini digunakan untuk mengambil deskripsi tugas.
         *
         * @return Deskripsi tugas.
         */
        public String getDeskripsi() {
            return deskripsi;
        }
    }

    /**
     * Metode ini digunakan untuk menambahkan tugas ke daftar tugas.
     *
     * @param task Tugas yang akan ditambahkan.
     */
    public void tambahTugas(Task task) {
        taskList.add(task);
    }

    /**
     * Metode ini digunakan untuk mengedit tugas dalam daftar.
     *
     * @param indeks Indeks tugas yang akan diedit.
     * @param task   Tugas baru yang akan menggantikan tugas lama.
     */
    public void editTugas(int indeks, Task task) {
        if (indeks >= 0 && indeks < taskList.size()) {
            taskList.set(indeks, task);
        }
    }

    /**
     * Metode ini digunakan untuk menghapus tugas dari daftar.
     *
     * @param indeks Indeks tugas yang akan dihapus.
     */
    public void hapusTugas(int indeks) {
        if (indeks >= 0 && indeks < taskList.size()) {
            taskList.remove(indeks);
        }
    }

    /**
     * Metode ini digunakan untuk menampilkan daftar tugas ke layar.
     */
    public void tampilkanTugas() {
        System.out.println("Daftar Tugas:");
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println((i + 1) + ". " + taskList.get(i).getDeskripsi());
        }
    }

    /**
     * Metode utama untuk menjalankan program TaskManager.
     *
     * @param args Argumen baris perintah (tidak digunakan dalam contoh ini).
     */
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        boolean menu = true;
        while (menu) {
            System.out.println("\nMenu:");
            System.out.println("1. Tambah Tugas");
            System.out.println("2. Edit Tugas");
            System.out.println("3. Hapus Tugas");
            System.out.println("4. Tampilkan Daftar Tugas");
            System.out.println("5. Keluar");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Pilih opsi: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan deskripsi tugas baru: ");
                    String deskripsi = scanner.nextLine();
                    Task tugasBaru = taskManager.new Task(deskripsi);
                    taskManager.tambahTugas(tugasBaru);
                    System.out.println("Tugas berhasil ditambahkan.");

                    break;
                case 2:
                    taskManager.tampilkanTugas();
                    System.out.print("Masukkan indeks tugas yang akan diedit: ");
                    int indeksEdit = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Masukkan deskripsi tugas yang baru: ");
                    String deskripsiBaru = scanner.nextLine();
                    Task tugasEdit = taskManager.new Task(deskripsiBaru);
                    taskManager.editTugas(indeksEdit - 1, tugasEdit);
                    System.out.println("Tugas berhasil diubah.");
                    break;
                case 3:
                    taskManager.tampilkanTugas();
                    System.out.print("Masukkan indeks tugas yang akan dihapus: ");
                    int indeksHapus = scanner.nextInt();
                    taskManager.hapusTugas(indeksHapus - 1);
                    System.out.println("Tugas berhasil dihapus.");
                    break;
                case 4:
                    taskManager.tampilkanTugas();
                    break;
                case 5:
                    menu = false;
                    break;
                default:
                    System.out.println("Opsi tidak valid. Silakan pilih opsi yang benar.");
                    break;
            }
        }
    }
}
