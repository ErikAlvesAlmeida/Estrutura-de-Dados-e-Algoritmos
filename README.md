# 📚 Estrutura de Dados e Algoritmos

Este repositório contém implementações de algoritmos fundamentais da disciplina **Estrutura de Dados e Algoritmos**, desenvolvidos em **Java** usando o editor **VIM**. Os testes são feitos com arquivos `.txt` contendo dados aleatórios (geralmente para simular o pior caso), gerados via **Shell Script**. Os resultados são visualizados graficamente com a linguagem **R**.

---

## 🚀 Tecnologias Utilizadas

- ☕ **Java** — Implementação dos algoritmos
- 🐚 **Shell Script** — Geração de dados para testes
- 📈 **R** — Visualização dos resultados em gráficos
- 🧠 **VIM** — Editor utilizado para escrever os códigos

---

## 🧪 Estrutura de Teste

1. Executamos os algoritmos com arquivos `.txt` contendo dados aleatórios.
2. Os dados de entrada e saída são gravados para análise.
3. Utilizamos scripts em **R** para plotar gráficos que analisam o desempenho (tempo, número de comparações, etc.).

---

## 📊 Exemplo de Execução

1. Gere um arquivo com dados (exemplo para gerar 1000 números):

```bash
seq 1000 | shuf > entrada.txt
```

2. Compile e execute o algoritmo Java:

```bash
javac Algoritmo.java
java Algoritmo < entrada.txt > saida.txt
```

3. Para plotar o gráfico com R:

```bash
Rscript plotar.R
```

# 🧰 Como Instalar o R

## Windows <br>
Acesse o site oficial: https://cran.r-project.org/

Clique em "Download R for Windows".

Instale normalmente como qualquer outro software.

## Linux <br>
```bash
sudo apt update
sudo apt install r-base
```

# 🖼️ Plotando os Gráficos com R
O script plotar.R lê os dados de saída gerados pelo algoritmo e plota um gráfico automaticamente. Certifique-se de que o arquivo saida.txt esteja no mesmo diretório que o script.
```bash
Rscript plotar.R
```

# 💡 Objetivo
Este projeto tem como objetivo estudar e analisar o desempenho de diferentes algoritmos de estrutura de dados e ordenação, observando seu comportamento em casos práticos e teóricos.
