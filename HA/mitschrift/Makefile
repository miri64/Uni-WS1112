TARGET?=mitschrift_hoehere_algorithmik_201112

default: build

clean:
	rm -f *.acn *.acr *.alg *.aux *.bbl *.blg *.dvi *.glg *.glo *.gls *.ist *.lof *.log *.lol *.lot *.out *.pdf *.toc
build: 
	latex $(TARGET).tex
	dvips $(TARGET).dvi
	ps2pdf $(TARGET).ps
	rm $(TARGET).dvi $(TARGET).ps
