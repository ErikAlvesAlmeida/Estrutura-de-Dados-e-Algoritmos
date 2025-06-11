start=1
end=2000
lines=100
per_line=$(( (end - start + 1) / lines ))

current=$start
for i in $(seq $lines); do
    seq -s " " $current $((current + per_line - 1))
    echo
    current=$((current + per_line))
done > ../../data/entradaDuplicadas.txt


