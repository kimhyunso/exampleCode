import requests
from tmdb import pre_url, key

def popular_count():
    URL = f'{pre_url}/movie/popular?api_key={key}'
    # 여기에 코드를 작성합니다.  
    res = requests.get(URL).json()
    movies = res['results']
    return len(movies)


if __name__ == '__main__':
    # popular 영화목록의 개수 출력.
    print(popular_count())  # 출력결과 20
