import sqlite3
import threading

# ---------- Database ----------

conn = sqlite3.connect("demo.db")
cursor = conn.cursor()

cursor.execute("""
CREATE TABLE IF NOT EXISTS student(
    id INTEGER,
    name TEXT
)
""")

conn.commit()
conn.close()


# ---------- Function ----------

def add_student(id, name):
    try:
        conn = sqlite3.connect("demo.db")
        cursor = conn.cursor()

        cursor.execute(
            "INSERT INTO student VALUES (?, ?)",
            (id, name)
        )

        conn.commit()

        print(name, "added successfully")

        conn.close()

    except Exception as e:
        print("Error:", e)


# ---------- Multithreading ----------

t1 = threading.Thread(target=add_student, args=(1, "Alex"))
t2 = threading.Thread(target=add_student, args=(2, "John"))

t1.start()
t2.start()

t1.join()
t2.join()


# ---------- Display Data ----------

try:
    conn = sqlite3.connect("demo.db")
    cursor = conn.cursor()

    cursor.execute("SELECT * FROM student")

    data = cursor.fetchall()

    print("\nStudent Records:")

    for row in data:
        print(row)

    conn.close()

except Exception as e:
    print("Display Error:", e)