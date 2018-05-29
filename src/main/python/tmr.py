# -*- coding: utf-8 -*-
# input = "D:\\batch\\antofix\\1111111111\\4yueliushui.txt"
input = "D:\\batch\\antofix\\1111111111out\\ckfksbdmtj.txt"
input22 = "D:\\batch\\antofix\\1111111111out\\andeSum.txt"
output = input + "无库存流水sn"
dic = {}
dic2 = {}

file = open(input)
file2 = open(input22)
outFile = open(output, 'w')
i = 0
for line in file:
    dic[line.strip()] = 1
for line in file2:
    print line
    sp = line.split("\t")
    if dic.has_key(sp[0].strip()):
        print sp[1]
        print sp[0]
        i = i + int(sp[1])
print(i)


outFile.close
