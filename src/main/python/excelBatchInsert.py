import pymysql
import xlrd

'''
    连接数据库
    args：db_name（数据库名称）
    returns:db

'''


def mysql_link(de_name):
    try:
        db = pymysql.connect("localhost",
                             "root",
                             "1q2w3e4r",
                             de_name)
        return db
    except:
        print("could not connect to mysql server")


'''
    读取excel函数
    args：excel_file（excel文件，目录在py文件同目录）
    returns：book
'''


def open_excel(excel_file):
    try:
        book = xlrd.open_workbook(excel_file)  # 文件名，把文件与py文件放在同一目录下
        return book
    except:
        print("open excel file failed!")


'''
    执行插入操作
    args:db_name（数据库名称）
         table_name(表名称）
         excel_file（excel文件名，把文件与py文件放在同一目录下）
hui
'''


def store_to(db_name, table_name, excel_file):
    db = mysql_link(db_name)  # 打开数据库连接
    cursor = db.cursor()  # 使用 cursor() 方法创建一个游标对象 cursor
    sql1 = "truncate table "+table_name
    cursor.execute(sql1)

    book = open_excel(excel_file)  # 打开excel文件
    sheets = book.sheet_names()  # 获取所有sheet表名
    for sheet in sheets:
        sh = book.sheet_by_name(sheet)  # 打开每一张表
        row_num = sh.nrows
        print(row_num)
        list = []  # 定义列表用来存放数据
        for i in range(1, row_num):  # 第一行是标题名，对应表中的字段名所以应该从第二行开始，计算机以0开始计数，所以值是1
            row_data = sh.row_values(i)  # 按行获取excel的值
            value = (row_data[0], row_data[1], row_data[2], row_data[3], row_data[4])
            list.append(value)  # 将数据暂存在列表
            # print(i)
        sql = "INSERT INTO " + table_name + " (sku_id,supplier_id,\
        deductio_type,billing_type,deduction_value)VALUES(%s,%s,%s,%s,%s)"
        cursor.executemany(sql, list)  # 执行sql语句
        db.commit()  # 提交
        list.clear()  # 清空list
        print("worksheets: " + sheet + " has been inserted " + str(row_num) + " datas!")
    cursor.close()  # 关闭连接
    db.close()


if __name__ == '__main__':
    store_to('finance_calculate', 'billing_rule', 'billingRule.xlsx')
