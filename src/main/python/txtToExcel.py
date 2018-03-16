# -*- coding: utf-8 -*-

import xlrd
import xlwt
import os
from xlwt import *

def convet(outTitle, fileName):
    delimiter = "\t"

    #fileName = "input.txt"
    #outTitle = title

    file = open(fileName)
    outName = fileName + ".xls"
    out = Workbook(encoding = 'utf-8')
    table = out.add_sheet('sheet0')

    i = 0
    j = 0
    for title in outTitle:
        table.write(i, j, title.strip())
        j += 1

    i = 0
    j = 0
    for line in file:
        i += 1
        j = 0
        split = line.split(delimiter)
        for field in split:
            table.write(i, j, field.strip())
            j += 1
    out.save(outName)
if __name__=='__main__':
    stock = ["时间","商品所属商户","商品名称","商品编码","库存组织","仓库编号","未出库存量（含出库中）","未出库商品金额","入库中数量","出库中数量"]
    inTitle = ["单据编号（入库单编号）","单据状态","事务类型","入库单生成时间","成功入库时间","商品所属商户","供应商","库存组织","商品编码（ISBN）","商品名称","商品唯一编码（SN号）","计量单位","数量","仓库","库位","采购实际成本（减掉折扣）","采购实际单价","采购折扣额","金额（采购实际成本+折扣金额）","价税合计","采购付款时间","备注","收书订单号","支付方式","第三方流水号","物流公司","物流单号"]
    oTitle = ["单据编号","单据状态","事务类型","出库发起时间","出库完成时间","商品所属商户","库存组织","商品编码","商品名称","出库数量","商品唯一编号（SN）","仓库","库位","供应商","实际成本","商品销售价格","邮费","折扣额","实付金额（不含邮费）","价税合计","客户订单号","确认收货时间","支付方式","支付公司流水号","物流公司","物流单号"]
    file_dir = "."
    for root, dirs, files in os.walk(file_dir):
        for file in files:
            if file.find("saveGrnDetail") == 0:
                convet(inTitle, file)
            elif file.find("saveOutDetail") == 0:
                convet(oTitle, file)
            elif file.find("saveStockDetail") == 0:
                convet(stock, file)
