# -*- coding: utf-8 -*-
from PyQt4.QtGui import *
from util import *
from pyHookLis import *
from globalValue import *
from folderWatch import *
import threading

app = QApplication([])
clipboard = QApplication.clipboard()


# 监听剪切板事件
def on_clipboard_change():
    data = clipboard.mimeData()
    if data.hasFormat('text/uri-list'):
        for path in data.urls():
            print path
    if data.hasText():
        print "\n\n>>>>>>>\n"
        set_value("msg", data.text())
        print "[" + get_value("msg") + "]"
        print_time(get_value("msg"))
        out = open("d:\sec.conf",'w')
        out.write("8848#"+data.text())
        out.close()

# 监听文件夹变化
#watch("D:\share")

clipboard.dataChanged.connect(on_clipboard_change)
# app.exec_()
keyBoardListenFun()
t1 = threading.Thread(app.exec_())
t1.start()
gol_init()
