''' O Desafio Técnico: "Validar Parênteses"
Imagine que estamos construindo um linter (ferramenta de análise de código) para o nosso sistema. Precisamos de uma função pequena e eficiente que verifique se os caracteres de abertura e fechamento em uma string estão balanceados corretamente.

O Problema:
Dada uma string contendo apenas os caracteres '(', ')', '{', '}', '[' e ']', determine se a string de entrada é válida.

Uma string é válida se:

Parênteses abertos devem ser fechados pelo mesmo tipo de parênteses.

Parênteses abertos devem ser fechados na ordem correta.

Exemplos:

Entrada: () -> Saída: True

Entrada: ()[]{} -> Saída: True

Entrada: (] -> Saída: False

Entrada: ([)] -> Saída: False

Entrada: {[]} -> Saída: True
'''


def validacao(string):
    pilha = []
    mapear = {")": "(",
             "}": "{",
             "]": "["}
    
    for char in string:
        if char in mapear:
            topo = pilha.pop() if pilha else '#'
            if mapear[char] != topo:
                return False
        else:
            pilha.append(char)
    return not pilha

# Testando a função com os exemplos fornecidos
print(validacao("()"))        # Saída: True
print(validacao("()[]{}"))    # Saída: True
print(validacao("(]"))        # Saída: False
print(validacao("([)]"))      # Saída: False
print(validacao("{[]}"))      # Saída: True