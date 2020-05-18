import xlwt
import pymysql
from xlwt import Workbook


def mysql_execute():
    # 连接 mysql 数据库
    global amount, s
    conn = mysql_link('finance_calculate')
    curs = conn.cursor()
    sql = '''select * from billing_settlement_detail'''
    curs.execute(sql)
    rows = curs.fetchall()

    w = Workbook()  # 创建一个Excel文件
    ws = w.add_sheet('Data')  # 创建一个工作表
    ws.write(0, 0, '订单号')
    ws.write(0, 1, '支付账户')
    ws.write(0, 2, '分账方')
    ws.write(0, 3, '分账金额')
    ws.write(0, 4, '时间')
    cursor = conn.cursor()  # 获取游标

    try:
        cursor.execute(sql)  # 执行sql语句
        results = cursor.fetchall()  # 获取执行结果
        row_num = len(results)

        for i in range(1, row_num + 1):
            row_data = results[i - 1]
            ws.write(i, 0, str(row_data[1]))
            if row_data[4] == 1:
                s = "实付"
                amount = row_data[7]
            elif row_data[4] == 2:
                s = "积分"
                amount = row_data[7] / 100
            elif row_data[4] == 3:
                s = "优惠"
                amount = row_data[7]
            ws.write(i, 1, s)
            ws.write(i, 2, row_data[5])
            ws.write(i, 3, amount)
            ws.write(i, 4, str(row_data[8]))
    except:
        print()
        "error"
    conn.close()
    w.save('/Users/jiatengyu/Desktop/Fcs_data/计费分账20200512.xls')  # 将文件保存到指定目录下


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
