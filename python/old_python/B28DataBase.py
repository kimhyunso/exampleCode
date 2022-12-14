# B28db.py
# SQLite : SQL Light -> SQL Lite -> SQLite

import sqlite3

def make_connect():
    conn = sqlite3.connect("book.db")
    cur  = conn.cursor()

    cur.execute( '''
        CREATE TABLE book_table (
            idx    integer primary key,
            title   text,
            year    integer,
            company     text,
            page    integer,
            flag    integer,
            price   integer
        )'''
    )

    conn.commit()
    conn.close()

if __name__ == "__main__":
    make_connect()
