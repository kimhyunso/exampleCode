# B30update.py
# SQLite : SQL Light -> SQL Lite -> SQLite

import sqlite3

def updateBook():
    conn = sqlite3.connect("book.db")
    cur  = conn.cursor()

    sql = "update book_table SET " + \
          "title=? , price=? WHERE idx= ?"
    cur.execute(sql, ('Python World', 53000, 3))

    print("-"*50)
    cur.execute("select * from book_table")
    books = cur.fetchall()
    for book in books:
        print(book)

    print("Fetch Many .." * 3)
    cur.execute("select * from book_table")
    books = cur.fetchmany(5)
    for book in books:
        print(book)

    conn.commit()
    conn.close()

if __name__ == "__main__":
    updateBook()