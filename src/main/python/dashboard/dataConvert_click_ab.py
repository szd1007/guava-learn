import time
import datetime

from sys import argv

script, input, dateBeforeStr = argv
# dateBefore=1
# input="gcl13"
print "inputfile:", input
print "dateBefore:", dateBeforeStr
dateBefore = int(dateBeforeStr)

output = input + ".sql"
table = "recsys_kpi_expid_new"
rowName = ["req_num", "clicks", "orders", "gmv"]
rowId = [2, 5, 7, 8]

tim = (datetime.datetime.now() - datetime.timedelta(days=dateBefore))
sdate_time = tim.strftime("%Y-%m-%d")
sexpid = 1

slogtype = "ab.click"
search_key = 9

file = open(input)
outfile = open(output, 'w')
tmp_line = "insert into " + table + " (expid,date_time,type,logtype,search_key,action,counts)values('"
# delte data if exists
outfile.write("# delte sql \r\n")
delteSql = "delete from " + table + " where date_time='" + sdate_time + "' and type='rec' and logtype='" + slogtype + "';"
outfile.write(delteSql + "\r\n")
outfile.write(" \r\n")

for line in file:
    la = line.split("\t")
    sqlLine = tmp_line
    i = 0
    for ri in rowId:
        if (la[search_key] == ""):
            spd = "rec.index"
        else:
            spd = la[search_key]
        sqlLine = tmp_line + (la[
                                  sexpid].strip() + "','" + sdate_time + "','" + "rec" + "','" + slogtype + "','" + spd.strip() + "','" +
                              rowName[i] + "','")
        if (la[ri] != "\N" and la[ri] != "NULL"):
            sqlLine += (la[ri] + "');")
        else:
            sqlLine += "');"
        outfile.write(sqlLine + "\r\n")
        i += 1

outfile.close
