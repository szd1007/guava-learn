#!/usr/bin/python
# -*- coding: UTF-8 -*-

import sys
import pyperclip
from util import *
#print 'arg len', len(sys.argv)
len = len(sys.argv)
ts = '0' 
if len >1:
    ts = sys.argv[1] 
else:
    ts = pyperclip.paste()
print 'using param ', ts
   
print_time(ts)
