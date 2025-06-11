for i in `seq 100`; do R=$(($RANDOM%100000)); seq -i " " $R; echo; done > ../../data/entradasDuplicadas.txt
