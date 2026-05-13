package tuprak6;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

class Library {
    private List<AbstractLibraryItem> items = new ArrayList<>();
    private List<Member> members = new ArrayList<>();
    private LibraryLogger logger = new LibraryLogger();

    public boolean isItemIdExist(int id) {
        return items.stream().anyMatch(i -> i.getitemId() == id);
    }

    public boolean isMemberExist(int id) {
        return members.stream().anyMatch(m -> m.getmemberId() == id);
    }

    public String addItem(AbstractLibraryItem item) {
        if(isItemIdExist(item.getitemId()))
            throw new IllegalArgumentException("Item ID tersebut sudah ada");
        items.add(item);
        return item.gettitle() + " berhasil ditambahkan";
    }

    public String addItem(AbstractLibraryItem ... newItems) {
        for (AbstractLibraryItem item : newItems) {
            if (items.stream().anyMatch(i -> i.getitemId() == item.getitemId())) {
                throw new IllegalArgumentException("Item ID " + item.getitemId() + " sudah ada!");
            }
            items.add(item);
        }
        return newItems.length + " item berhasil ditambahkan";
    }
    
    public void addMember(Member member) {
        if (isMemberExist(member.getmemberId())) {
            throw new IllegalArgumentException("Member ID sudah terdaftar!");
        }
        members.add(member);
        }
        
    public AbstractLibraryItem findItemById(int itemId) {
        return items.stream()
                .filter(i -> i.getitemId() == itemId)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Item tidak ditemukan"));
    }

    public Member findMemberById(int id) {
        return members.stream()
                .filter(m -> m.getmemberId() == id)
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Member tidak ditemukan"));
    }

    public String getLibraryStatus() {
        StringBuilder sb = new StringBuilder();
        sb.append("+-----+----------------------+-----------+\n");
        sb.append("| ID  | Judul                | Status    |\n");
        sb.append("+-----+----------------------+-----------+\n");
        for (AbstractLibraryItem item : items) {
            sb.append(String.format("| %-3d | %-20s | %-9s |\n",
                item.getitemId(),
                item.gettitle(),
                item.isBorrowed() ? "Dipinjam" : "Tersedia"));
    }
    sb.append("+-----+----------------------+-----------+\n");
    return sb.toString();
    }

    public String getAllLogs() {
        return logger.getLogsTable();
    }

    public LibraryLogger getLogger() {
        return logger;
    }
}
