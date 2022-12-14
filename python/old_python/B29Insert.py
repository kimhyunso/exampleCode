# B29insert.py
# SQLite : SQL Light -> SQL Lite -> SQLite

import sqlite3

def insertBook():
    conn = sqlite3.connect("book.db")
    cur  = conn.cursor()

    cur.execute( "insert into book_table "+\
                 "( title, year, company,page, flag, price ) "+\
                 " values "+\
                 "('파이썬2', 2018, 'ITBANK1', 1234, 1, 13500)" )

    # +\ 이줄하고 다음줄 하고 같은줄이다라는 표시
    sql = "insert into book_table " + \
          "( title, year, company,page, flag, price ) " +\
          "values "+\
          "(?, ?, ?, ?, ?, ?)"
    cur.execute(sql, ('책제목2', 2018, '출판사M', 300, 1, 15500))
    # tuple쌍으로 된 리스트로 집어넣기
    books = [
        ('책제목3', 2015, '출판사C', 400, 0, 14000),
        ('책제목4', 2005, '출판사K', 450, 1, 15000),
        ('책제목5', 2016, '출판사E', 470, 0, 19000),
        ('책제목6', 2017, '출판사A', 305, 1, 17000),
        ('책제목7', 2019, '출판사B', 444, 1, 20000)
    ]
    cur.executemany(sql, books)

    print("-"*50)
    cur.execute("select * from book_table")
    books = cur.fetchall()

    print(books)
    print("-"*50)
    for book in books:
        print(book)


    conn.commit()
    conn.close()

if __name__ == "__main__":
    insertBook()
