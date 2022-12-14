#B10 dict.py
#key : value

days = {"SUM":1, "MON":2, "TUS":3, "WED":4}
print(days)
print(days["MON"])

eng = {"Apple":"사과", "King":"왕", "Desk":"책상", "Mobile":"핸드폰", "Python":"파이썬"}
print(eng["Mobile"])
print("key list = ",list(eng.keys()))
print("value list = ",list(eng.values()))
print("sorted key = ",sorted(eng.keys()))
print("sorted key reverse = ",sorted(eng.keys(), reverse=True))
