from pprint import pprint

import requests
from tmdb import pre_url, key


def ranking():
    URL = f'{pre_url}/movie/popular?api_key={key}'
    res = requests.get(URL).json()
    movies = res['results']
    movies.sort(key=lambda movie: movie['vote_average'], reverse=True)
    
    return movies[:5]

if __name__ == '__main__':
    # popular 영화목록을 정렬하여 평점순으로 5개 영화.
    pprint(ranking())
    
    """출력결과
    
    """
