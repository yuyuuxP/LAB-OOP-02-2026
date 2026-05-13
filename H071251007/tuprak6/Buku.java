package tuprak6;

class Buku  extends AbstractLibraryItem {
    private String author;

    public Buku(String author, String title, int itemId) {
        super(title, itemId);
        this.author = author;
    }

    @Override
    public String getDescription() {
        return "Buku: " + gettitle() + " oleh " + author + ", ID: " + getitemId();
    }

    @Override
    public String borrowItem(int days) {
        if (isBorrowed) throw new IllegalArgumentException("Item sudah dipinjam!");
        if (days > 14) throw new IllegalArgumentException("Maksimal 14 hari!");
        isBorrowed = true;
        return "Item " + title + " berhasil dipinjam selama " + days + " hari";
    }

    @Override
    public double calculateFine(int daysLate) {
        return daysLate * 10000;
    }
}
