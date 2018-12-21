import time
import logging
from watchdog.observers import Observer
from watchdog.events import FileSystemEventHandler, LoggingEventHandler
from watchdog.observers.api import ObservedWatch


class MyHandler(FileSystemEventHandler):
    def on_modified(self, event):
        print " file [%s] changed!" % event.src_path


def watch(path):
    print "start watching folder.. %s", path
    event_handler_1 = MyHandler()
    observer = Observer()
    watch = observer.schedule(event_handler_1, path, True)
    observer.start()
    print "watching success"



