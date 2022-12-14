#B27JSON.py
#JSON = JavaScript Object Notation

import json

#한글로 표기시 유니코드로 저장됨...
jsons = {"name":"홍길동", "age":20 ,"address":"Seoul", "job":"programmer"}

print("info = ",json.dumps(jsons))


with open("d:/json.txt","w") as file:
    json.dump(jsons,file)

with open("d:/json.txt","r") as file:
    jsonsInfo = json.load(file)

print(jsonsInfo)
print("value = ",jsonsInfo["name"])
print("age = ",jsonsInfo["age"])
print("address = ",jsonsInfo["address"])
print("job = ",jsonsInfo["job"])

