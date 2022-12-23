from pprint import pprint

import requests
from tmdb import pre_url, key

def vote_average_movies():
    URL = f'{pre_url}/movie/popular?api_key={key}'
    res = requests.get(URL).json()
    movies = res['results']
    vote_over_8_movies = list(filter(lambda movie: movie['vote_average'] >= 8, movies))
    return vote_over_8_movies
    
if __name__ == '__main__':
    # popular 영화목록중 vote_average가 8 이상인 영화목록 출력.
    pprint(vote_average_movies())
    
    """ 출력결과
    [
        {
            'adult': False,
            'backdrop_path': '/tQ91wWQJ2WRNDXwxuO7GCXX5VPC.jpg',
            'genre_ids': [878, 28, 12],
            'id': 76600,
            'original_language': 'en',
            'original_title': 'Avatar: The Way of Water',
            'overview': 'Set more than a decade after the events of the first film, '     
                        'learn the story of the Sully family (Jake, Neytiri, and their '  
                        'kids), the trouble that follows them, the lengths they go to '   
                        'keep each other safe, the battles they fight to stay alive, and '
                        'the tragedies they endure.',
            'popularity': 4334.092,
            'poster_path': '/5ScPNT6fHtfYJeWBajZciPV3hEL.jpg',
            'release_date': '2022-12-14',
            'title': 'Avatar: The Way of Water',
            'video': False,
            'vote_average': 8.1,
            'vote_count': 897
        },
        {
            'adult': False,
            'backdrop_path': '/vSvogVWimBiaKx9dVCzirh3u9qS.jpg',
            'genre_ids': [16, 14, 18],
            'id': 555604,
            'original_language': 'en',
            'original_title': "Guillermo del Toro's Pinocchio",
            'overview': "During the rise of fascism in Mussolini's Italy, a wooden boy "   
                        "brought magically to life struggles to live up to his father's "  
                        'expectations.',
            'popularity': 3041.505,
            'poster_path': '/vx1u0uwxdlhV2MUzj4VlcMB0N6m.jpg',
            'release_date': '2022-11-09',
            'title': "Guillermo del Toro's Pinocchio",
            'video': False,
            'vote_average': 8.5,
            'vote_count': 865
        }
    ]
    
    """