# -*- coding: utf-8 -*-
import os

workPath = "D:\\batch\\antofix\\1111111111\\20180531"
os.chdir(workPath)
# input = "4yueliushui.txt"
input = "wrongAddUsableNum"
output = input + "_merge"
outSql = input + "_sql"
type4 = {}
type5 = {}
file = open(input)
outFile = open(output, 'w')
outSqlFile = open(outSql, 'w')
i = 0
for line in file:
    if i == 0:
        i = 1
        continue
    sp = line.split('\t')
    if int(sp[2]) == 4:
        if type4.has_key(sp[0]):
            type4[sp[0]] = type4[sp[0]] + int(sp[3].strip())
        else:
            type4[sp[0]] = int(sp[3].strip())
    elif int(sp[2]) == 5:
        if type5.has_key(sp[0]):
            type5[sp[0]] = type5[sp[0]] + int(sp[3].strip())
        else:
            type5[sp[0]] = int(sp[3].strip())
print type4
print type5
for sku in type4.keys():
    count = 0;
    if type5.has_key(sku):
        count = type4[sku] - type5[sku];
    else:
        count = type4[sku]
    outFile.write(sku + "\t" + str(count) + "\n")
    outSqlFile.write(
        "update stock_info set usable_normal_sum_num=usable_normal_sum_num-{0} where sku_code=\'{1}\' and warehouse=100 ;\n".format(
            count, sku))
