# -*- coding: utf-8 -*-
inputWms = "D:\\batch\\antofix\\1111111111out\\wmsTotalOrduni"
inputAn = "D:\\batch\\antofix\\1111111111out\\andeSumUni"
output = "D:\\batch\\antofix\\1111111111out\\diff.sum"
wmsDic = {}
anDis = {}
file = open(inputWms)
outFile = open(output, 'w')
for line in file:
    sp = line.split('\t')
#    print(sp[0] + sp[1])
    asn = sp[0]
    num = int(sp[1])
    if wmsDic.has_key(asn):
        wmsDic[asn] = wmsDic[asn] + num
    else:
        wmsDic[asn] = num
file2 = open(inputAn)
for line in file2:
    sp = line.split('\t')
#    print(sp[0] + sp[1])
    asn = sp[0]
    num = int(sp[1])
    if anDis.has_key(asn):
        anDis[asn] = anDis[asn] + num
    else:
        anDis[asn] = num

for tmpAsn in wmsDic.keys():
    if anDis.has_key(tmpAsn):
        if anDis[tmpAsn] != wmsDic[tmpAsn]:
            outFile.write("{0}\t{1}\t{2}\n".format(tmpAsn, wmsDic[tmpAsn], anDis[tmpAsn]))
        else:
            print("{0}\t{1}\t{2}\n".format(tmpAsn, wmsDic[tmpAsn], anDis[tmpAsn]))

outFile.write("***********************wms入库缺失入库单*****\n")
for tmpAsn in anDis.keys():
    if not wmsDic.has_key(tmpAsn):
        outFile.write("{0}\n".format(tmpAsn))

outFile.write("***********************安得入库缺失入库单*****\n")
for tmpAsn in wmsDic.keys():
    if not anDis.has_key(tmpAsn):
        outFile.write(tmpAsn+"\n")
outFile.close
