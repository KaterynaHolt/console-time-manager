package languages;

import java.util.ListResourceBundle;

public class Language_uk extends ListResourceBundle {
    private static final Object[][] contents =
            {
                    {"morning", "Доброго ранку, Світ!"},
                    {"day", "Добрий день, Світ!"},
                    {"evening", "Добрий вечір, Світ!"},
                    {"night", "Доброї ночі, Світ!"},
            };
    public Object[][] getContents(){
        return contents;
    }
}
