import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите строку: ");
        TranslatedString str = new TranslatedString(scan.nextLine());
        String tr = str.CyrillicToLatin();
        System.out.println(tr);
        TranslatedString str2 = new TranslatedString(str.CyrillicToLatin());
        System.out.println(str2.LatinToCyrillic());


    }
}
