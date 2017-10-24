# My master's thesis
---
Subject in English:  
**Decompiling Android OS applications.**  

Subject in Polish:  
**Dekompilacja aplikacji działających w systemie Android OS.**  

## How to download
----
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
