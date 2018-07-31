# -*- coding: utf-8 -*-

# author shangzhidong@zhuanzhuan.com
# date 2018-7-31 11:49:09
# version 0.1

import sys
import urllib2
import time
import datetime
import os
md5Sum = {}


def get_html(url):
    req = urllib2.Request(url)
    res_data = urllib2.urlopen(req)
    res = res_data.read()
    return res


def reload_service(s_name, s_sp, s_url):
    print "reload service:", s_name, "\n"
    file_name = os.path.split(s_sp[1])[1]
    remote_url = s_url + s_sp[1]
    print "try to remote local file :", file_name
    os.system("rm -f " + file_name)
    print "fetch file in :", remote_url
    os.system("wget " + remote_url)
    cp = "cp " + file_name + "  xxx/" + s_name + "/" + file_name
    print "copy to lib: ", cp
    os.system(cp)
    restart = "w " + s_name
    print "restart service :", restart
    os.system(restart)


if __name__ == '__main__':
    url = "http://19:8000/"
    if len(sys.argv) > 1:
        url = sys.argv[1]
    while True:
        print "start process ", datetime.datetime.now().strftime('%Y.%m.%d-%H:%M:%S')
        aloha = get_html(url + "aloha.conf")
        print "aloha conf: ", aloha
        print "\n>>>>>>>>>>>>>>>>>>>>\n"
        save_file = open("aloha_local", 'w')
        save_file.write(aloha)
        save_file.flush()
        read_file = open("aloha_local")
        for line in read_file:
            print "parse: ", line, "\n"
            sp = line.split("#")
            service_name = sp[0].strip()
            http_loc = sp[1].strip()
            md5_key = sp[2].strip()

            if service_name in md5Sum:
                if md5Sum.get(service_name) != md5_key:
                    print "@@@@@@@@@@@@ new md5Sum found ", service_name, " old:", md5Sum.get(
                        service_name), " new:", md5_key, "\n"
                    reload_service(service_name, sp, url)
                    md5Sum[service_name] = md5_key
            else:
                print "@@@@@@@@@@@@@ found new service config: ", service_name
                reload_service(service_name, sp, url)
                md5Sum[service_name] = md5_key

        print "########end process ", datetime.datetime.now().strftime('%Y.%m.%d-%H:%M:%S')
        time.sleep(3)  # sleep 3 s
        exit(0)
