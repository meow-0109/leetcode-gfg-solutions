public class SeventeenJ {
    public static void main(String[] args) {
        String s = "aabbbbeeeeffggg";
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            char current = s.charAt(i);
            int count = 0;
            while (i < s.length() && s.charAt(i) == current) {
                count++;
                i++;
            }
            result.append(current).append(count);
        }
        System.out.println(result.toString());
    }
}
 