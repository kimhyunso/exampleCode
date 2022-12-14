#B22Regular.py : RegularExpression
#입력한 값이 휴대번호 인지 검사하는 프로그램을 만들어라..

import re

mobile = "010-1234-5a78"

print("mobile = ",mobile)
print("mobile len = ",len(mobile))

text = "My name is Hong jil dong. 010-1234-5678 My phone number is 010-1234-56a6"

# "i"를 찾아보자
print("i = ",re.findall("i",text))
#"Q"를 찾아보자
print("Q = ",re.findall("Q",text))
#"-"를 찾아보자
print("- = ",re.findall("-",text))
#알파벳만 찾아보자 소문자
print("alphabet = ",re.findall("[a-z]",text))
#알파벳을 찾아보자 대문자
print("Upper = ",re.findall("[A-Z]",text))
#폰넘버를 찾아보자
print("Phone Number = ",re.findall("01[016789]-[0-9]{4}-[0-9]{4}",text))
text = "ABCD가나다abcd홍길동#鬨姞蝀カタカナ*"
#한글만 찾아보자
print("Korea = ",re.findall("[가-힣]",text))