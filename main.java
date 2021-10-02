import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        DictionaryManagement.insertFromFile();
        String vocab;
        Scanner sc = new Scanner(System.in);
        System.out.println("\n nhap tu vung muon xoa: ");
        vocab = sc.nextLine();
        DictionaryManagement.remove_word(vocab);
        DictionaryCommandline.showAllWords();
        DictionaryManagement.dictionaryExportToFile();
    }
}
