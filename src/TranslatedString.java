import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.stream.Collectors;

public class TranslatedString implements ITranslatable {

    private String string;
    HashMap<String, String> symbols = new HashMap<>();

    //Конструктор
    public TranslatedString(String string) {
        this.string = string;
        symbols.put("а", "a");        symbols.put("б", "b");
        symbols.put("в", "v");        symbols.put("г", "g");
        symbols.put("д", "d");        symbols.put("е", "e");
        symbols.put("ё", "yo");       symbols.put("ж", "zh");
        symbols.put("з", "z");        symbols.put("и", "i");
        symbols.put("й", "j");        symbols.put("к", "k");
        symbols.put("л", "l");        symbols.put("м", "m");
        symbols.put("н", "n");        symbols.put("о", "o");
        symbols.put("п", "p");        symbols.put("р", "r");
        symbols.put("с", "s");        symbols.put("т", "t");
        symbols.put("у", "u");        symbols.put("ф", "f");
        symbols.put("х", "x");        symbols.put("ц", "cz");
        symbols.put("ч", "ch");       symbols.put("ш", "sh");
        symbols.put("щ", "shh");      symbols.put("ъ", "``");
        symbols.put("ы", "y`");       symbols.put("ь", "`");
        symbols.put("э", "e`");       symbols.put("ю", "yu");
        symbols.put("я", "ya");
        this.swap();
    }

    public String getString() {
        return this.string;
    }

    //Функция для перевода с Кириллицы на Латиницу
    public String CyrillicToLatin() {
        String result = string;
        // Проходим по символам в строке
        for (int i = 0; i < result.length(); i++) {
            //если в ключах symbols содержится текущий символ из строки
            if (symbols.containsKey(Character.toString(result.charAt(i)))) {
                //замена символа в строке (тип String)
                result = result.replace(Character.toString(result.charAt(i)), symbols.get(Character.toString(result.charAt(i))));
            }
            //проверка на буквы в верхнем регистре
            else if (symbols.containsKey(Character.toString(result.charAt(i)).toLowerCase())) {
                result = result.replace(Character.toString(result.charAt(i)), symbols.get(Character.toString(result.toLowerCase().charAt(i))).toUpperCase());
            }
        }
        return result;
    }

    HashMap<String, String> symbols2 = new HashMap<>();


    // фукнция для перевода с латиницы на кириллицу
    public String LatinToCyrillic() {
        String result = string;
        //частные случаи
        result = result.replace("shh", "щ");
        result = result.replace("sh", "ш");
        result = result.replace("zh", "ж");
        result = result.replace("``", "ъ");
        // Проходим по символам в строке
        for (int i = 0; i < result.length(); i++) {
            String ch = Character.toString(result.charAt(i));
            String ch2 = "";
            if (i!=result.length()-1){ch2 = Character.toString(result.charAt(i+1));}
            //если в ключах symbols содержится текущий символ из строки
            if (symbols2.containsKey(ch)) {
                //замена символа в строке (тип String)
                result = result.replace(Character.toString(result.charAt(i)), symbols2.get(Character.toString(result.charAt(i))));
            }
            if (symbols2.containsKey(ch+ch2)){
                result = result.replace(ch+ch2, symbols2.get(ch+ch2));
            }
            //проверка на буквы в верхнем регистре
            if (symbols2.containsKey(Character.toString(result.charAt(i)).toLowerCase())) {
                result = result.replace(Character.toString(result.charAt(i)), symbols2.get(Character.toString(result.toLowerCase().charAt(i))).toUpperCase());
            }
            if (symbols2.containsKey((ch+ch2).toLowerCase())){
                result = result.replace(ch+ch2, symbols2.get((ch+ch2).toLowerCase()).toUpperCase());
            }
        }
        return result;
    }

    public void swap(){
        for ( Map.Entry<String, String> entry : symbols.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            // do something with key and/or tab
            symbols2.put(value, key);
        }
    }

}
