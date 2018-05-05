input = "asn.txt"
output = input + ".sql"

file = open(input)
outFile = open(output, 'w')

for line in file:
    outFile.write("" + line.strip() + "'  order by create_time desc limit 1\" > " + line.strip())

outFile.close
