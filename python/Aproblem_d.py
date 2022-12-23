from pprint import pprint

import requests
from tmdb import pre_url, key


def recommendation(title):
    URL = f'{pre_url}/search/movie?api_key={key}&query={title}&language=ko-KR'
    res = requests.get(URL).json()
    movies = res['results']

    if movies:
        movie_id = movies[0]['id']
        URL = f'{pre_url}/movie/{movie_id}/recommendations?api_key={key}&language=ko-KR'
        res = requests.get(URL).json()
        recommendations = res['results']

        r_titles = list(map(lambda r_movie: r_movie['original_title'], recommendations))
        return r_titles

    # 아래는 없어도 같은동작    
    else:
        return None


if __name__ == '__main__':
    """
    제목에 해당하는 영화가 있으면
    해당 영화의 id를 기반으로
    추천 영화의 제목만으로 이루어진 목록 구성.
    추천 영화가 없을 경우 [].
    영화 id검색에 실패할 경우 None.
    """
    print(recommendation('기생충'))
    # ['Green Book', 'Awdat Al-Rouh', 'Joker', ... 'Little Women', 'Pulp Fiction'] (한글로 나와도 상관없음)
    pprint(recommendation('그래비티'))
    # 추천 영화 없음 => []
    pprint(recommendation('검색할 수 없는 영화'))
    # 검색 불가능 => None
