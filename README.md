# Desafios LeetCode

Soluções em Java para desafios de algoritmos comuns em entrevistas.

## 1. Longest Substring Without Repeating Characters
**Nível:** Médio

**Descrição:**
Dada uma string `s`, encontre o comprimento da **substring** mais longa sem caracteres repetidos.

**Exemplos:**
- **Entrada:** `s = "abcabcbb"`
  **Saída:** `3`
  **Explicação:** A resposta é "abc", com comprimento 3.
- **Entrada:** `s = "bbbbb"`
  **Saída:** `1`
  **Explicação:** A resposta é "b", com comprimento 1.
- **Entrada:** `s = "pwwkew"`
  **Saída:** `3`
  **Explicação:** A resposta é "wke", com comprimento 3. Note que a resposta deve ser uma substring, "pwke" é uma subsequência e não uma substring.

**Arquivos:**
- `LongestSubstringSolution.java`: Implementação otimizada usando *Sliding Window* e *HashMap*.
- `LongestSubstringMain.java`: Execução e testes locais.

---

## 2. Merge Intervals
**Nível:** Médio

**Descrição:**
Dado um array de `intervals` onde `intervals[i] = [start_i, end_i]`, funda todos os intervalos sobrepostos e retorne um array dos intervalos não sobrepostos que cobrem todos os intervalos na entrada.

**Exemplos:**
- **Entrada:** `intervals = [[1,3],[2,6],[8,10],[15,18]]`
  **Saída:** `[[1,6],[8,10],[15,18]]`
  **Explicação:** Como os intervalos [1,3] e [2,6] se sobrepõem, funda-os em [1,6].
- **Entrada:** `intervals = [[1,4],[4,5]]`
  **Saída:** `[[1,5]]`
  **Explicação:** Os intervalos [1,4] e [4,5] são considerados sobrepostos.

**Arquivos:**
- `MergeIntervalsSolution.java`: Implementação ordenando os intervalos pelo início.
- `MergeIntervalsMain.java`: Execução e testes locais.