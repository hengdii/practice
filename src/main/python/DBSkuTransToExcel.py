import xlwt
import pymysql
from xlwt import Workbook


def mysql_execute():
    # 连接 mysql 数据库
    conn = mysql_link('finance_calculate')
    curs = conn.cursor()
    sql = '''select * from billing_sku_detail'''
    curs.execute(sql)
    rows = curs.fetchall()

    w = Workbook()  # 创建一个Excel文件
    ws = w.add_sheet('Data')  # 创建一个工作表
    ws.write(0, 0, '订单号')
    ws.write(0, 1, 'skuId')
    ws.write(0, 2, 'skuName')
    ws.write(0, 3, 'sku数量')
    ws.write(0, 4, '销售价')
    ws.write(0, 5, '分摊促销')
    ws.write(0, 6, '分摊积分')
    ws.write(0, 7, '分摊实付')
    ws.write(0, 8, '时间')
    cursor = conn.cursor()  # 获取游标

    try:
        cursor.execute(sql)  # 执行sql语句
        results = cursor.fetchall()  # 获取执行结果
        row_num = len(results)
        for i in range(1, row_num + 1):
            row_data = results[i - 1]
            # print(row_data[1], row_data[4], row_data[5], row_data[7])
            ws.write(i, 0, row_data[1])
            ws.write(i, 1, row_data[4])
            ws.write(i, 3, row_data[6])
            ws.write(i, 4, row_data[7])
            ws.write(i, 5, row_data[8])
            ws.write(i, 6, row_data[9])
            ws.write(i, 7, row_data[12])
            ws.write(i, 8, row_data[16])
    except:
        print
        "error"
    conn.close()
    w.save('sku20200211.xls')  # 将文件保存到指定目录下


def mysql_link(de_name):
    try:
        db = pymysql.connect("localhost",
                             "root",
                             "1q2w3e4r",
                             de_name)
        return db
    except:
        print("could not connect to mysql server")


if __name__ == '__main__':
    path = mysql_execute()
