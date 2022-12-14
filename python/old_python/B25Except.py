#B25Except.py


#age = (int)(input("insert age : "))
#print("내년에는",age+1,"살입니다.")
#Java : "test" + 123 = "test123";

import traceback
a = 4
b = 0

#c = a / b
#print(a,"/",b,"=",c)

try:
    c = a / b
    print(a,"/",b,"=",c)
except Exception as err:
    print("연산 에러",traceback.print_exc())
finally:
    print("마침내")



print("End of try catch")