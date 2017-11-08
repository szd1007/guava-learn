import time
import datetime
from sys import argv
script,input,dateBeforeStr = argv
#dateBefore=1
#input="gcl13"
print "inputfile:",input
print "dateBefore:",dateBeforeStr
dateBefore =int(dateBeforeStr)
output=input+".sql"
table="recsys_kpi_total_new"
rowName =["gmv","req_users","req_num","orders","clicks","all_orders","all_gmv"]
rowId =[7,2,1,5,3,8,10]

tim = (datetime.datetime.now() - datetime.timedelta(days = dateBefore))
sdate_time = tim.strftime("%Y-%m-%d")
stype=11

slogtype="gmv.click"
search_key=12

file = open(input)
outfile = open(output,'w')
tmp_line="insert into "+table +" (date_time,type,logtype,search_key,action,counts)values('"
#delte data if exists
outfile.write("# delte sql \r\n")
delteSql="delete from "+table+ " where date_time='"+sdate_time+"' and type='rec' and logtype='"+slogtype+"';"
outfile.write(delteSql+"\r\n")
outfile.write(" \r\n")

for line in file:
    la = line.split("\t")
    sqlLine = tmp_line
    i=0
    for ri in rowId:
        if(la[search_key]==""):
            spd="rec.index"
        else:
            spd=la[search_key]
        sqlLine=tmp_line+(sdate_time+"','"+"rec"+"','"+slogtype+"','"+spd.strip()+"','"+rowName[i]+"','")
        if(la[ri]!="\N"):
            sqlLine+=(la[ri]+"');")
        else:
            sqlLine+="');"
        outfile.write(sqlLine+"\r\n")
        i+=1
    
outfile.close

    
    
