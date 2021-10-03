import java.util.Scanner;

public class DictionaryCommandline extends Dictionary{
    /**
     * hàm showAllWords: hiển thị kết quả danh sách dữ liệu từ điển trên màn hình.
     */
    public static void showAllWords() {
        String res = "";
        res += "No    ";
        res += "| English      "; //vi tri 6
        res += "| Vietnamese"; // Vi tri 15
        System.out.println(res);

        for (int i = 0; i < Dictionary.word.size(); i++) {
            res = "";
            res += (i + 1);
            for (int j = 1; j <= (6 - res.length()); j++) res += " ";
            res += "| " + Dictionary.word.get(i).getWord_target();
            for (int j = 1; j <= (30 - res.length()); j++) res += " ";
            res += "| " + Dictionary.word.get(i).getWord_explain();
            System.out.println(res);
            //System.out.println(word.get(i).toString());
        }
    }

    /**
     * hàm dictionaryBasic() gọi hàm insertFromCommandline và hàm showAllWords.
     */
    public void dictionaryBasic() {
        DictionaryManagement.insertFromCommandline();
        showAllWords();
    }


    /**
     * hàm dictionaryAdvanced() (phiên bản commandline cải tiến lần 1).

    public void dictionaryAdvanced() {

    }
    */

    /**
     * hàm dictionarySearcher: chức năng tìm kiếm các từ (cải tiến lần 2)
     */
    public void dictionarySearcher() {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhap tu can tim kiem");
        String search = sc.nextLine();
    }
}
