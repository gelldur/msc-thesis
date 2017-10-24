Thesis.pdf: Thesis.tex Thesis.bib
	pdflatex Thesis.tex
	bibtex Thesis
	pdflatex Thesis.tex

.PHONY: clean
clean:
	rm -f Thesis.pdf Thesis.toc Thesis.out Thesis.lot Thesis.lol Thesis.log Thesis.lof Thesis.aux Thesis.blg Thesis.bbl
	
