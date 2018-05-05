# -*- coding: utf-8 -*-

import xlrd
import xlwt
from xlwt import *


def read_excel():
    fileName = "input.xls"

    excel = xlrd.open_workbook(fileName)
    # 获取目标文件各个shit
    print excel.sheet_names()
    print "开始处理 😄"
    sheet = excel.sheet_by_name('3.0&1.0')
    print "sheet\t 行数\t列数"
    print '%s\t%s\t%s' % (sheet.name, sheet.nrows, sheet.ncols)
    rowNum = sheet.nrows
    dic = {}
    for i in range(1, rowNum):
        iNum = sheet.cell(i, 1).value
        iPro = sheet.cell(i, 2).value
        iMob = sheet.cell(i, 3).value
        print '%s\t%s\t%s' % (iNum, iPro, iMob)
        if dic.has_key(iMob):
            dMob = dic[iMob]
            if dMob.has_key(iPro):
                dNum = dMob[iPro]
                dMob[iPro] = dNum + iNum
            else:
                dMob[iPro] = iNum
        else:
            dic[iMob] = {iPro: iNum}
    # print dic

    # output
    fileOut = "汇总" + fileName
    out = Workbook(encoding='utf-8')
    table = out.add_sheet('sheet0')
    # 设置格式
    alignment = xlwt.Alignment()  # 创建居中
    alignment.horz = xlwt.Alignment.HORZ_CENTER  # 可取值: HORZ_GENERAL, HORZ_LEFT, HORZ_CENTER, HORZ_RIGHT, HORZ_FILLED, HORZ_JUSTIFIED, HORZ_CENTER_ACROSS_SEL, HORZ_DISTRIBUTED
    alignment.vert = xlwt.Alignment.VERT_CENTER  # 可取值: VERT_TOP, VERT_CENTER, VERT_BOTTOM, VERT_JUSTIFIED, VERT_DISTRIBUTED
    style = xlwt.XFStyle()  # 创建样式
    style.alignment = alignment  # 给样式添加文字居中属性
    style.font.height = 250  # 设置字体大小
    style.font.name = u'微软雅黑'
    style.pattern.pattern = Pattern.SOLID_PATTERN  # 设置其模式为实型
    style.pattern.pattern_fore_colour = 50

    style2 = xlwt.XFStyle()
    style2.font.height = 250
    style2.font.name = u'微软雅黑'
    bodi = 1
    style2.borders.left = bodi
    style2.borders.right = bodi
    style2.borders.top = bodi
    style2.borders.bottom = bodi

    style4 = xlwt.XFStyle()
    style4.font.height = 250
    style4.font.name = u'微软雅黑'
    bodi = 1
    style4.borders.left = bodi
    style4.borders.right = bodi
    style4.borders.top = bodi
    style4.borders.bottom = bodi
    style4.pattern.pattern = Pattern.SOLID_PATTERN  # 设置其模式为实型
    style4.pattern.pattern_fore_colour = 50

    style.borders = style2.borders

    sT = xlwt.XFStyle()
    sT.font.height = 250
    sT.font.name = u'微软雅黑'

    j = 4
    t = 1;
    t += 1
    for oMob in dic.keys():
        i = 4
        oTotal = 0
        table.write(i, j, oMob, sT)
        i += 1
        table.write(i, j, "省份", style)
        table.write(i, j + 1, "小记", style)
        i += 1
        for oPro in dic[oMob].keys():
            table.write(i, j, oPro, style2)
            table.write(i, j + 1, dic[oMob][oPro], style2)
            oTotal += dic[oMob][oPro]
            i += 1
        table.write(i, j, "总计", style4)
        table.write(i, j + 1, oTotal, style4)
        j += 4
    for jj in range(100):
        pattern = Pattern()  # 创建一个模式
        pattern.pattern = Pattern.SOLID_PATTERN  # 设置其模式为实型
        pattern.pattern_fore_colour = jj
        jStyle = XFStyle()
        jStyle.pattern = pattern
        table.write(jj, 0, "x", jStyle)

    out.save(fileOut)


if __name__ == '__main__':
    read_excel()
