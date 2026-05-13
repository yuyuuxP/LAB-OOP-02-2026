package tuprak6;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Library library = new Library();

        while (true) {
            System.out.println("=== Sistem Manajemen Perpustakaan ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tambah Anggota");
            System.out.println("3. Pinjam Item");
            System.out.println("4. Kembalikan Item");
            System.out.println("5. Lihat Status Perpustakaan");
            System.out.println("6. Lihat Log Aktivitas");
            System.out.println("7. Lihat Item yang Dipinjam Anggota");
            System.out.println("8. Keluar");
            System.out.print("Pilih menu: ");

            int pilih;
            while (true) {
                try {
                    pilih = Integer.parseInt(input.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("INPUT HARUS ANGKA!! Ulangi input.\n");
                }
            }

            try {
                switch (pilih) {
                    // case 1 itu toh buat tmbh ki item 
                    case 1:
                        System.out.print("Masukkan jenis (Buku/DVD): ");
                        String jenis = input.nextLine();
                        System.out.print("Judul: ");
                        String title = input.nextLine();

                        int itemId;
                        while (true) {
                            System.out.print("Item ID: ");
                            try {
                                itemId = Integer.parseInt(input.nextLine());
                                if(library.isItemIdExist(itemId)) {
                                    System.out.println("Item ID " + itemId + " sudah ada!! masukkan ID lain.\n");
                                    continue;
                                }
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        try {
                            if (jenis.equalsIgnoreCase("Buku")) {
                            System.out.print("Author: ");
                            String author = input.nextLine();
                            System.out.println(library.addItem(new Buku(author, title, itemId)));
                        } else if (jenis.equalsIgnoreCase("DVD")) {
                            int durasi;
                            while (true) {
                                System.out.print("Durasi (menit): ");
                                try {
                                    durasi = Integer.parseInt(input.nextLine());
                                    break;
                                } catch (NumberFormatException e) {
                                    System.out.println("DURASI HARUS ANGKA!! Ulangi input.\n");
                                }
                            }
                            System.out.println(library.addItem(new DVD(title, itemId, durasi)));
                        } else {
                            System.out.println("Jenis tidak valid!");
                        }
                        } catch (IllegalArgumentException e) {
                            System.out.println("EROR! karena " + e.getMessage());
                        }
                        break;

                    // case 2 utk tmbh member
                    case 2:
                        System.out.print("Nama: ");
                        String nama = input.nextLine();

                        int mid;
                        while (true) {
                            System.out.print("Member ID: ");
                            try {
                                mid = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("MEMBER ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }
                        library.addMember(new Member(nama, mid));
                        System.out.println("Anggota berhasil ditambahkan!\n");
                        break;
                    
                    // case 3 buat pinjam item
                    case 3:
                        int mId;
                        while (true) {
                            System.out.print("Member ID: ");
                            try {
                                mId = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("MEMBER ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        int iId;
                        while (true) {
                            System.out.print("Item ID: ");
                            try {
                                iId = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("ITEM ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        int days;
                        while (true) {
                            System.out.print("Hari pinjam: ");
                            try {
                                days = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("HARI PINJAM HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        Member member = library.findMemberById(mId);
                        AbstractLibraryItem item = library.findItemById(iId);
                        System.out.println(member.borrow(item, days));
                        library.getLogger().logBorrow(item.gettitle(), member.getName());
                        break;
                    
                    // case 4 itu buat mngembalikan buku or dvd
                    case 4:
                        int mId2;
                        while (true) {
                            System.out.print("Member ID: ");
                            try {
                                mId2 = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("MEMBER ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        int iId2;
                        while (true) {
                            System.out.print("Item ID: ");
                            try {
                                iId2 = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("ITEM ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        int late;
                        while (true) {
                            System.out.print("Hari keterlambatan: ");
                            try {
                                late = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("HARI KETERLAMBATAN HARUS ANGKA!! Ulangi input.\n");
                            }
                        }

                        Member member2 = library.findMemberById(mId2);
                        AbstractLibraryItem item2 = library.findItemById(iId2);
                        System.out.println(member2.returnItem(item2, late));
                        library.getLogger().logReturn(item2.gettitle(), member2.getName());
                        break;

                    case 5:
                        System.out.println("\n=== Status Perpustakaan ===");
                        System.out.println(library.getLibraryStatus());
                        break;

                    case 6:
                        System.out.println("\n=== Log Aktivitas ===");
                        System.out.println(library.getAllLogs());
                        break;

                    // case 7 utk melihat item yg pinjam oleh member ini apa saja
                    case 7:
                        int mId3;
                        while (true) {
                            System.out.print("Member ID: ");
                            try {
                                mId3 = Integer.parseInt(input.nextLine());
                                break;
                            } catch (NumberFormatException e) {
                                System.out.println("MEMBER ID HARUS ANGKA!! Ulangi input.\n");
                            }
                        }
                        Member member3 = library.findMemberById(mId3);
                        System.out.println("=== Item yang dipinjam oleh " + member3.getName() + " ===");
                        System.out.println(member3.getBorrowedItemsTable());
                        break;

                    case 8:
                        System.out.println("Keluar dari sistem .............");
                        break;

                    default:
                        System.out.println("Pilihan Anda tidak valid");
                        break;
                }
            } catch (NoSuchElementException | IllegalArgumentException | IllegalStateException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());} 
            
            input.close();
        }
    }
}

