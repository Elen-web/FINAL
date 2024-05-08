public class dataProvider {
    public static final Object[][] VALID_SEARCH_KEYWORDS = {
            {"Tressa Janes"},
            {"Brian K Gray"},
            {"Brittany Coleman"},
    };

    public static final Object[][] INVALID_SEARCH_KEYWORDS = {
            {"ադսասդկլյկլհայկսհդյկասդ"},
            {"աասդփփճրկասդշշասֆասֆսդ"},
    };

    public static final Object[][] EDGE_CASE_SEARCH_KEYWORDS = {
            {""}, // Empty string
            {"   "}, // Spaces
            {"a"} // Single character
    };


    public dataProvider() {
    }
}
