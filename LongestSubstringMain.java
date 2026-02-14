public class LongestSubstringMain {
    public static void main(String[] args) {
        LongestSubstringSolution solution = new LongestSubstringSolution();
        
        String input1 = "abcabcbb";
        String input2 = "bbbbb";
        String input3 = "pwwkew";

        System.out.println("Input: " + input1 + " | Max Length: " + solution.lengthOfLongestSubstring(input1)); // Esperado: 3
        System.out.println("Input: " + input2 + " | Max Length: " + solution.lengthOfLongestSubstring(input2)); // Esperado: 1
        System.out.println("Input: " + input3 + " | Max Length: " + solution.lengthOfLongestSubstring(input3)); // Esperado: 3
    }
}
