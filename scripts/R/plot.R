# Se o pacote não tiver instalado na máquina.
#install.packages('ggplot2', repos = "http://cran.us.r-project.org")

library('ggplot2')

args <- commandArgs()

data = read.table(args[length(args)], header = T)
ggplot(data, aes(x = busca, y = time, colour = alg)) + geom_line() + scale_y_continuous(trans = "log2")
