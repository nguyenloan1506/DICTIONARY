import java.util.Scanner;

public class DictionaryManagement {
    Dictionary dict;

    /**
     * hàm insertFromCommandLine (phiên bản từ điển sơ khai).
     */
    public void insertFromCommandline() {
        int n;
        Scanner sc = new Scanner(System.in);
        n = Integer.parseInt(sc.nextLine()); // xử lý lỗi trôi lệnh
        for(int i = 0; i < n; i++) {
            String tumoi;
            String nghia;
            tumoi = sc.nextLine();;
            nghia = sc.nextLine();
            Word new_word = new Word(tumoi, nghia);
            dict.word.add(new_word);
        }
    }

    public static void main(String[] args) {

    }
}
