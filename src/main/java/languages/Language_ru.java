package languages;

import java.util.ListResourceBundle;

public class Language_ru extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"morning", "Доброе утро, Мир!"},
                    {"day", "Добрый день, Мир!"},
                    {"evening", "Добрий вечер, Мир!"},
                    {"night", "Доброй ночи, Мир!"},
            };
    public Object[][] getContents(){
        return contents;
    }
}
