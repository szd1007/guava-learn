#!/usr/bin/python
# -*- coding: UTF-8 -*-
import sys
reload(sys)
sys.setdefaultencoding('utf8')
import clipboard
import os
import shutil
from util import *


def mymovefile(srcfile,dstfile):
    if not os.path.isfile(srcfile):
        print "%s not exist!"%(srcfile)
    else:
        fpath,fname=os.path.split(dstfile)    #分离文件名和路径
        if not os.path.exists(fpath):
            os.makedirs(fpath)                #创建路径
        shutil.move(srcfile,dstfile)          #移动文件
        print "move %s -> %s"%( srcfile,dstfile)


#print 'arg len', len(sys.argv)
len = len(sys.argv)
folder_pre = '/Users/zm/github/resources/pics/' 
folder_path = '' 
folder_tmp = folder_pre + 'tmp/'
if len >1:
    folder_path = sys.argv[1].strip() + '/'
else:
    folder_path = 'java/'
 #ts = clipboard.paste()
print 'using param ', folder_path

# 列出tmp所有的文件
for file in os.listdir(folder_tmp):
    print "move %s to %s " %(file, folder_pre + folder_path)
    mymovefile(folder_tmp + file, folder_pre + folder_path + file)

    p_url = "http://www.adamx.org:9999/pics/" + folder_path + file
    print "gen url %s" %(p_url)
    clipboard.copy(p_url)


# png本地图床自动补全
#if ts.endswith(".png"):
#    p_url = "http://www.adamx.org:9999/pics/java" + ts.strip()
#    print p_url
#    clipboard.copy(p_url)
#else:  
#    print_time(ts)
    
