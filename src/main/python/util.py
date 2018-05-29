# -*- coding: utf-8 -*-
import time


# 将10位时间戳转换为时间字符串，默认为2017-10-01 13:37:04格式
def timestamp_to_date(time_stamp, format_string="%Y-%m-%d %H:%M:%S"):
    time_array = time.localtime(time_stamp)
    str_date = time.strftime(format_string, time_array)
    return str_date


# 将时间戳规范为10位时间戳
def timestamp_to_timestamp10(time_stamp):
    time_stamp = int(time_stamp * (10 ** (10 - len(str(time_stamp)))))
    return time_stamp


def print_time(timeStamp):
    time_stamp = str(timeStamp)
    if time_stamp.isdigit() and len(time_stamp.strip()) == 13 and time_stamp.startswith("1"):
        lon_t = long(timeStamp)
        tt = timestamp_to_timestamp10(lon_t)
        print("format time: %s" % timestamp_to_date(tt))


if __name__ == '__main__':
    print_time("1527219683072")
