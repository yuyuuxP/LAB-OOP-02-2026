package tuprak6;

import java.util.ArrayList;
import java.util.List;

class Member {
    private String name;
    private int memberId;
    private List<AbstractLibraryItem> borrowedItems;

    public Member(String nama, int memberId) {
        this.name = nama;
        this.memberId = memberId;
        this.borrowedItems = new ArrayList<>();
    }

    public String borrow(AbstractLibraryItem item, int days) {
        if (item.isBorrowed()) throw new IllegalStateException("Item sudah dipinjam!");
        String result = item.borrowItem(days);
        borrowedItems.add(item);
        return result;
    }

    public String returnItem(AbstractLibraryItem item, int daysLate) {
        if (!borrowedItems.contains(item)) 
            throw new IllegalStateException("Item tidak dipinjam oleh member ini!");
        borrowedItems.remove(item);
        item.returnItem();
        double fine = item.calculateFine(daysLate);
        
        return "Item " + item.gettitle() + " berhasil dikembalikan dengan denda: Rp " + String.format("%,.0f", fine);
    }

    public String getBorrowedItemsTable() {
        if (borrowedItems.isEmpty()) {
            return "Tidak ada item yang dipinjam";
    }
    StringBuilder sb = new StringBuilder();
    sb.append("+-----+----------------------+\n");
    sb.append("| ID  | Judul                |\n");
    sb.append("+-----+----------------------+\n");
    for (AbstractLibraryItem item : borrowedItems) {
        sb.append(String.format("| %-3d | %-20s |\n",
                item.getitemId(),
                item.gettitle()));
    }
    sb.append("+-----+----------------------+\n");
    return sb.toString();
}

    public String getName() {
        return name;
    }

    public int getmemberId() {
        return memberId;
    }
}
