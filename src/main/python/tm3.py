# -*- coding: utf-8 -*-
import os
workPath = "D:\\batch\\antofix\\1111111111"
os.chdir(workPath)
# input = "4yueliushui.txt"
input = "andeFinishAsn"
input22 = "wmsLostAsn"
output = input + "无库存流水sn"
dic = {}
dic2 = {}

file = open(input)
file2 = open(input22)
outFile = open(output, 'w')
i = 0
for line in file:
    dic[line] = 1
for line in file2:
    dic2[line] = 1

outFile.write("wms接收到入库失败反馈，但是安得库存流水中没有增加记录的入库单列表\n")
for k in dic2.keys():
    if not dic.has_key(k):
        outFile.write("{0}\n".format(k.strip()))
outFile.write("wms入库单没有在安得流水表中记录\n")
for k in dic.keys():
    if not dic2.has_key(k):
        outFile.write("{0}\n".format(k.strip()))

outFile.close
