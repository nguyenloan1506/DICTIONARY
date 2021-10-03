import java.util.Locale;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class DictionaryManagement {

    /**
     * hàm insertFromCommandLine (phiên bản từ điển sơ khai).
     */
    public static void insertFromCommandline() {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n nhap so luong tu muon them: ");
        n = Integer.parseInt(sc.nextLine()); // xử lý lỗi trôi lệnh
        for(int i = 0; i < n; i++) {
            String tumoi;
            String nghia;
            System.out.println("\n nhap tu moi: ");
            tumoi = sc.nextLine();
            System.out.println("\n nhap nghia cua tu: ");
            nghia = sc.nextLine();
            Word vocab = new Word(tumoi, nghia);
            Dictionary.word.add(vocab);
        }
    }

    /**
     * hàm insertFromFile (cải tiến 1)
     */
    public static void insertFromFile() {
        try {
            FileReader file_ = new FileReader("C:\\Users\\TTT\\IdeaProjects\\BTL\\src\\dictionaries.txt");
            BufferedReader buffer = new BufferedReader(file_);
            String line = "";
            while (true) {
                line = buffer.readLine();
                if(line == null) {
                    break;
                }
                /**
                 * mảng str là mảng lưu giữ từ mới và nghĩa.
                 * split để cắt tại nơi có nhiều dấu cách.
                 */
                String str[] = line.split("\t"); // do mỗi từ cách nhau bởi 1\t
                String new_word = str[0];
                String meaning = str[1];
                Word vocab = new Word(new_word, meaning);
                Dictionary.word.add(vocab);
            }
            buffer.close();
            file_.close();
        } catch (Exception e) {
        }
        DictionaryCommandline.showAllWords();
    }

    /**
     * Tra cuu tu dien.

    public static void dictionaryLookup() {
        System.out.println("Nhap tu can search: ");
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        int index = Dictionary.word.indexOf(key);
        if (index == -1) {
            System.out.println("Tu vung chua update");
        } else {
            String res = "Nghia cua tu la: ";
            res += Dictionary.word.get(index).getWord_explain();
        }
    }
    */

    /**
     * đã sửa lỗi không phân biệt chữ hoa chữ thường.
     */
    public static void dictionaryLookup() {
        boolean kt = false;
        System.out.println("Nhap tu can search: ");
        Scanner sc = new Scanner(System.in);
        String key = sc.nextLine();
        key = key.toLowerCase();
        for (int i = 0; i < Dictionary.word.size(); i++) {
            if (Dictionary.word.get(i).getWord_target().equals(key) == true) {
                kt = true;
                String res = "Nghia cua tu la: ";
                res += Dictionary.word.get(i).getWord_explain();
                System.out.println(res);
                break;
            }
        }
        if (kt == false) {
            System.out.println("\n Tu vung chua update");
        }
    }
    /**
     * hàm sửa từ.
     * @param vocab
     * @param newword
     * @param meaning
     */
    public static void fix_word(Word vocab, String newword, String meaning) {
        for(Word w: Dictionary.word) {
            if (w.getWord_target().equals(vocab) == true) {
                w.setWord_target(newword);
                w.setWord_explain(meaning);
            }
        }
    }

    /**
     * hàm xóa từ (command line cai tien 2).
     */
    public static void remove_word(String vocab) {
        boolean kt = false;
        for (int i = 0; i < Dictionary.word.size(); i++) {
            if(Dictionary.word.get(i).getWord_target().equals(vocab) == true) {
                kt = true;
                Dictionary.word.remove(i);
                return;
            }
        }
        if (kt == false) {
            System.out.println("\n Tu vung chua duoc cap nhat");
        }
    }

    /**
     * ham dictionaryExportToFile
     */
    public static void dictionaryExportToFile () {
        try{
            FileWriter file_write = new FileWriter("C:\\Users\\TTT\\IdeaProjects\\BTL\\src\\dictionaries.txt");
            BufferedWriter buffer_write = new BufferedWriter(file_write);
            for(Word w: Dictionary.word) {
                buffer_write.write(w.toString());
                buffer_write.newLine(); // sau khi in het tinh nang cua 1 tu thi xuong dong
            }
            buffer_write.close();
            file_write.close();
        } catch (Exception e) {

        }
    }

    /**
     * hàm dictionarySearcher.
     */
    public static void dictionarySearch () {
        System.out.println("\n nhap tu can tim kiem: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        s = s.toLowerCase();
        int n = s.length();
        int dem = 0;
        for(int i = 0; i<Dictionary.word.size(); i++){
            String s1 = Dictionary.word.get(i).getWord_target();
            int j = s1.indexOf(s);
            if(j == 0){
                System.out.println(s1);
                dem++;
            }
        }
        if(dem==0){
            System.out.println("\n khong co tu nao bat dau bang "+s);
        }
    }

}
