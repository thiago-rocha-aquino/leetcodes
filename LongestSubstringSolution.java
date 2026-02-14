import java.util.HashMap;
import java.util.Map;

public class LongestSubstringSolution {
    
    public int lengthOfLongestSubstring(String s) {
        // Mapa para guardar o caractere e seu índice mais recente
        Map<Character, Integer> charMap = new HashMap<>();
        int maxLen = 0;
        int start = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // Se o caractere já foi visto e está dentro da janela atual
            if (charMap.containsKey(c)) {
                // Movemos o início da janela para logo após a última ocorrência do caractere
                // Math.max garante que não voltaremos o ponteiro 'start' para trás
                start = Math.max(start, charMap.get(c) + 1);
            }

            charMap.put(c, i);
            // Atualiza o comprimento máximo encontrado
            maxLen = Math.max(maxLen, i - start + 1);
        }

        return maxLen;
    }public class LongestSubstringMain {
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
    
}
