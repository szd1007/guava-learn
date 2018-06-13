# -*- coding: utf-8 -*-
#
# by oldj
# https://oldj.net/
#

import pythoncom
import pyHook
from globalValue import *
import webbrowser as web


def run_to_use_default_browser_open_url(url):
    web.open_new_tab(url)


# firefox浏览器
def use_firefox_open_url(url):
    browser_path = r'C:\Program Files (x86)\Mozilla Firefox\firefox.exe'
    # 这里的‘firefox’只是一个浏览器的代号，可以命名为自己认识的名字，只要浏览器路径正确
    web.register('firefox', web.Mozilla('mozilla'), web.BackgroundBrowser(browser_path))
    # web.get('firefox').open(url,new=1,autoraise=True)
    web.get('firefox').open_new_tab(url)


def onMouseEvent(event):
    # 监听鼠标事件
    # print "MessageName:", event.MessageName
    # print "Message:", event.Message
    # print "Time:", event.Time
    # print "Window:", event.Window
    # print "WindowName:", event.WindowName
    # print "Position:", event.Position
    # print "Wheel:", event.Wheel
    # print "Injected:", event.Injected
    # print "---"
    # 返回 True 以便将事件传给其它处理程序
    # 注意，这儿如果返回 False ，则鼠标事件将被全部拦截
    # 也就是说你的鼠标看起来会僵在那儿，似乎失去响应了
    return True


def onKeyboardEvent(event):
    # 监听键盘事件
    # print "MessageName:", event.MessageName
    # print "Message:", event.Message
    # print "Time:", event.Time
    # print "Window:", event.Window
    # print "WindowName:", event.WindowName
    # print "Ascii:", event.Ascii, chr(event.Ascii)
    # print "Key:", event.Key
    # print "KeyID:", event.KeyID
    # print "ScanCode:", event.ScanCode
    # print "Extended:", event.Extended
    # print "Injected:", event.Injected
    # print "Alt", event.Alt
    # print "Transition", event.Transition
    # print "---"
    msg = get_value("msg", "null")
    if "F1" == str(event.Key):
        print "google search ", msg
        url = "https://www.google.com.hk/search?newwindow=1&safe=strict&source=hp&ei=fY0gW_SJDMif0gLIw5bwAg&q=" + msg
        run_to_use_default_browser_open_url(url)
    if "F2" == str(event.Key):
        print "youDao search ", msg
        url = "http://youdao.com/w/eng/" + msg + "/#keyfrom=dict2.index"
        run_to_use_default_browser_open_url(url)

    # 同鼠标事件监听函数的返回值
    return True


def keyBoardListenFun():
    # 创建一个“钩子”管理对象
    hm = pyHook.HookManager()

    # 监听所有键盘事件
    hm.KeyDown = onKeyboardEvent
    # 设置键盘“钩子”
    hm.HookKeyboard()

    # 监听所有鼠标事件
    # hm.MouseAll = onMouseEvent
    # 设置鼠标“钩子”
    # hm.HookMouse()

    # 进入循环，如不手动关闭，程序将一直处于监听状态
    pythoncom.PumpMessages()


if __name__ == "__main__":
    main()
