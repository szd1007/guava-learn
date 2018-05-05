input = "asn.txt"
output = input + ".sh"
logName = "zzmerchant_info.log.2018-04-2*"
file = open(input)
outFile = open(output, 'w')
count = len(file.readlines())
outFile.write("#!/bin/sh\n")
# outFile.write(str(count))
file2 = open(input)
i = 0
for line in file2:
    i += 1
    outFile.write(
        "cat " + logName + " |grep " + line.strip() + " |grep \"ZZMerchantController:41\" |head -n1 >>more \n")
    outFile.write("printf \"process asncode[" + line.strip() + "]   " + str(i * 100 / count) + "%%\\r\"\n")
outFile.close
