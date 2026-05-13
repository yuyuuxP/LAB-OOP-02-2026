package tuprak6;

abstract class AbstractLibraryItem {
    protected String title;
    protected int itemId;
    protected boolean isBorrowed;

    public AbstractLibraryItem(String title, int itemId) {
        this.title = title;
        this.itemId = itemId;
        this.isBorrowed = false;
    }

    public abstract String getDescription();
    public abstract String borrowItem(int days);
    public abstract double calculateFine(int daysLate);


    public String returnItem() {
        if(!isBorrowed) throw new IllegalStateException("Item belum dipinjam!");
        isBorrowed = false;
        return title + " dikembalikan";
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public String gettitle() {
        return title;
    }

    public int  getitemId() {
        return itemId;
    }
}