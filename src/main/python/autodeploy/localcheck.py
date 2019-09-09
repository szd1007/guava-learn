# -*- coding: utf-8 -*-

# author szd1007@github.com
# date 2018-7-31 11:49:09
# version 0.1
import datetime
import os
import thread
import subprocess
from multiprocessing import Process

content = []


def init_aloha_conf(path):
    os.chdir(path)
    # os.system("python -m SimpleHTTPServer 8000 >xx")
    # subprocess.Popen("python.exe -m SimpleHTTPServer 8000", True)


if __name__ == '__main__':
    work_path = "d:/beetle/"
    print "start: "
    init_aloha_conf(work_path)
    os.chdir(work_path)
    conf_file = open("aloha.conf")
    for line in conf_file:
        content.append(line.strip())
    while True:
        print "listed service>>>"
        i = 0
        for line in content:
            sp_i = line.split("#")
            print i, ": ", sp_i[0], "   version:", sp_i[2]
            i = i + 1
        idx = input("input the index to launch:")
        if idx > len(content) - 1:
            continue
        sp = content[idx].split("#")
        new_line = "{0}#{1}#{2}#{3}".format(sp[0], sp[1], int(sp[2]) + 1, datetime.datetime.now().strftime(
            '%Y.%m.%d-%H:%M:%S'))
        content[idx] = new_line
        w_file = open("aloha.conf", 'w')
        for line in content:
            w_file.write(line + "\n")
            w_file.flush()
