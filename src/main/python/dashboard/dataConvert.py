import time
import datetime

input="details"
output=input+".sql"
table="recsys_kpi_logtype_cn_new"



file = open(input)
outfile = open(output,'w')
outfile.write("delete from "+table+" where 1=1 ; \r\n")
tmp_line="insert into "+table +" (type_1,logtype,logtype_cn,`desc`)values('"
#for rn in rowName:
#    tmp_line+=(rn +",")
#tmp_line += " values ("+timFormat+","
    
for line in file:
    la = line.split("\t")
    if(la[3].strip()=="logtype"):
        sqlLine = tmp_line +"pc','"+la[0].strip()+"','"+la[1].strip()+"','"+la[2].strip()+"');"
    else:
        sqlLine = tmp_line +"page','"+la[0].strip()+"','"+la[1].strip()+"','"+la[2].strip()+"');"
    
    outfile.write(sqlLine+"\r\n")
    
    
outfile.close

    
    
