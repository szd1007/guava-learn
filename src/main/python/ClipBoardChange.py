# -*- coding: utf-8 -*-
from PyQt4.QtCore import *
from PyQt4.QtGui import *
from util import *

app = QApplication([])
clipboard = QApplication.clipboard()


# 监听剪切板事件
def on_clipboard_change():
    data = clipboard.mimeData()
    if data.hasFormat('text/uri-list'):
        for path in data.urls():
            print path
    if data.hasText():
        print data.text()
        print_time(data.text())


clipboard.dataChanged.connect(on_clipboard_change)

app.exec_()
