import java.util.Scanner;

public class DictionaryCommandline extends Dictionary{
    /**
     * hàm showAllWords: hiển thị kết quả danh sách dữ liệu từ điển trên màn hình.
     */
    public static void showAllWords() {
        String res = "";
        res += "No\t";
        res += "| English\t\t\t"; //vi tri 6
        res += "| Vietnamese"; // Vi tri 15
        System.out.println(res);

        for (int i = 0; i < Dictionary.word.size(); i++) {
            res = "";
            res += (i + 1);
            //for (int j = 1; j <= (6 - res.length()); j++) res += " ";
            res += "\t| " + Dictionary.word.get(i).getWord_target();
            //for (int j = 1; j <= (30 - res.length()); j++) res += " ";
            int len = Dictionary.word.get(i).getWord_target().length();
            if (len >= 6) {
                res += "\t\t\t| " + Dictionary.word.get(i).getWord_explain();
            } else {
                res += "\t\t\t\t| " + Dictionary.word.get(i).getWord_explain();
            }
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
