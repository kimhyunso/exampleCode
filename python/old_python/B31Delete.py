# B30update.py
# SQLite : SQL Light -> SQL Lite -> SQLite

import sqlite3

def deleteBook():
    conn = sqlite3.connect("book.db")
    cur  = conn.cursor()

    cur.execute("delete from book_table where idx > 1 ")

    print("-"*50)
    cur.execute("select * from book_table")
    books = cur.fetchall()
    for book in books:
        print(book)

    conn.commit()
    conn.close()

if __name__ == "__main__":
    deleteBook()