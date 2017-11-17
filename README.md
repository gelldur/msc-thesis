# My master's thesis
### Subject in English:  
**Decompiling Android OS applications.**  

### Subject in Polish:  
**Dekompilacja aplikacji działających w systemie Android OS.**  

### Abstract in English:
The main point of this paper is to explain process of decompilation Android application. At the beginning I will introduce how application is build. We will use this knowledge to review tools that can help us with this task. Thanks to those tools we will receive smali code and we will learn how to read and modify smali code. We will describe how Android system is identyfying applications. In the end I will show why we should care about securing our apps and how harmful it could be for us, when we don't do it. We will get knowledge how dissasembly process looks like.

### Abstract in Polish:
Celem pracy jest omówienie procesu dekompilacji aplikacji mobilnych pisanych na system operacyjny Android.
Na początku poznamy budowę aplikacji androidowej. Korzystając z tej wiedzy nauczymy się obsługi narzędzi, które ułatwiają proces dekompilacji. Dzięki tym narzędziom otrzymamy wynik deasemblacji i nauczymy się go interpretować. Z tak otrzymanego wyniku postaramy się poskładać wszystko z powrotem do działającej aplikacji. Dowiemy się także jak system Android identyfikuje i weryfikuje pochodzenie aplikacji. Na koniec dowiemy się jakie niebezpieczeństwo niesie za sobą źle zabezpieczony kod aplikacji. Prześledzimy również proces, który utrudnia odzyskiwanie kodu źródłowego za pomocą technik odwrotnej inżynierii.

### Keywords:
RE, inżynieria odwrotna, dekompilacja, android, dalvik, apk, apktool, smali, zaciemnianie kodu, deasembler, disassembler, asembler, dekompilator, release, debug, dex, C++, Java
reverse engineering, decompilation, obfuscation, disassembly, objdump, assembler

## Generated PDF
Generated PDF is available [in repository](Master's%20thesis%20-%20Decompiling%20Android%20OS%20applications%20by%20Dawid%20Drozd.pdf)

## How to download
Clone repository:  
`git clone --recursive {repository url}`

Or clone normally and then  
`git submodule update --init --recursive`

## How to generate PDF
- `pdflatex Thesis.tex`
- `bibtex Thesis` - for generating bibliography
- `pdflatex Thesis.tex` - again to add bibliography...

Command `latex Thesis.tex` also should work for generating `.div` file

## Use `make`

```
# For build pdf
make
# For clean
make clean
```
