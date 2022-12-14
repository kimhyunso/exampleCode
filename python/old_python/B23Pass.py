#B23Pass.py : 모듈로 만들 예정

import re

def validatePassword(pwd):
    """
    함수 설명 : 사용자가 입력한 비밀번호의 검증
    요구조건 : 비밀번호는 6~12 사이이다.
    요구조건2 : 대문자와 소문자가 각각 한번 들어가야한다.
    정규식을 이용해 검사
    :param pwd:
    :return: True or Flase
    """
    #1 . 글자수를 검사한다.
    if len(re.findall("[a-zA-Z0-9]{6,12}$",pwd)) == 0:
        print(pwd,"의 패턴이 잘못되었습니다.")
        return False

    #2.영어대문자나 소문자가 각각 한번이상 들어가야한다.
    #[A-Z] = [ABCDEFGHIJKLNMNOPQRSTUVWXYZ]
    if len(re.findall("[A-Z]",pwd)) == 0 or len(re.findall("[a-z]",pwd)) == 0:
        print(pwd,"는 대문자와 소문자가 한번씩은 나와야합니다.")
        return False

    print(pwd,"는 비밀번호로 적당합니다. ")
    return True

#^ 시작을 나타내는 기호
#$ 마지막을 나타내는 기호
#^01[016789]-[0-9]{4}-[0-9]{4}$

if __name__ == "__main__" :
    validatePassword("12345")
    validatePassword("asda3sd1234")
    validatePassword("한글테스트")
    validatePassword("sdfsfs!!@#!A")

