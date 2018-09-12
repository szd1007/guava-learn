# $language = "python"
# $interface = "1.0"
import os
import sys
workPath = "D:\\"
os.chdir(workPath)
inputFile = open("sec.conf")
opId = 0
opCode = ""
genCmd = ""
for conf in inputFile:
    sp = conf.split("#")
    opId = int( sp[0].strip())
    opCode = sp[1].strip()
    break
opId = int(crt.Dialog.Prompt("0入库\n1出库\n2入库详情\n3出库详情","查询参数","0",False))
#crt.Dialog.MessageBox(str(opId),"opid",64|0)
#asnCode
if 0 == opId:
    genCmd = "select * from grn_store_wms where asn_code='"+opCode+"'\\G;"
elif 1 == opId:
    genCmd = "select * from out_store_wms where order_code='"+opCode+"'\\G;"
elif 2 == opId:
    genCmd = "select * from grn_goods_wms where asn_code='"+opCode+"'\\G;"
elif 3 == opId:
    genCmd = "select * from out_goods_wms where order_code = '"+opCode+"'\\G;"

def main():
    crt.Screen.Send(genCmd)

main()
