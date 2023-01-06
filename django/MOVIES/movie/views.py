from django.shortcuts import render
import requests as r
from .models import Article

# Create your views here.

my_key = 'e2335fa8edacf7e80e5e40568135a86b'

def rank(request):
    movie_name = request.POST['name']
    response = r.get(f'http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json?key={my_key}&movieNm={movie_name}').json()

    max_value = response['movieListResult']['movieList'][0]['openDt']
    for current in response['movieListResult']['movieList']:
        if current['openDt'] > max_value:
            max_value = current['openDt']
            movie_name = current['movieCd']
    

    response = r.get(f'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?key={my_key}&movieCd={movie_name}').json()
    article = Article()
    article.openDt = response['movieInfoResult']['movieInfo']['openDt']
    article.showTime = response['movieInfoResult']['movieInfo']['showTm']
    article.save()

    context = {
        'showTime' : response['movieInfoResult']['movieInfo']['showTm'],
        'openDt' : response['movieInfoResult']['movieInfo']['openDt'],
    }
    return render(request, 'movie/rank.html', context)


def index(request):
    return render(request, 'movie/index.html')