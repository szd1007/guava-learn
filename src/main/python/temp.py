# -*- coding: utf-8 -*-
# input = "D:\\batch\\antofix\\1111111111out\\4yueliushui.txt"
# input = "D:\\batch\\antofix\\1111111111out\\5yue1-10liushui.txt"
input = "D:\\batch\\antofix\\1111111111out\\5yue10-18liushui.txt"
output = input + ".sum"
dic = {}
file = open(input)
outFile = open(output, 'w')
i = 0
for line in file:
    if i == 0:
        i = 1
        continue
    sp = line.split('\t')
    print(sp[1] +":"+ sp[8])
    asn = sp[1]
    num = int(sp[8])
    if dic.has_key(asn):
        dic[asn] = dic[asn] + num
    else:
        dic[asn] = num

for tmpAsn in dic.keys():
    outFile.write("{0}\t{1}\n".format(tmpAsn, dic[tmpAsn]))
outFile.close
