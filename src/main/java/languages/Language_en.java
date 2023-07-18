package languages;

import java.util.ListResourceBundle;

public class Language_en extends ListResourceBundle {
    private static final Object[][] contents =
        {
            {"morning", "Good morning, World!"},
            {"day", "Good day, World!"},
            {"evening", "Good evening, World!"},
            {"night", "Good night, World!"},
        };
    public Object[][] getContents(){
        return contents;
    }
}
