from board.models import Article
# Create
# 1
article = Article()
article.title = '1번글'
article.content = '내용'
article.author = '작성자'
article.save()

# 2
article = Article(title='2번글', content='테스트', author='까마귀')
article.save()

# 3
Article.objects.create(title='3번글', content='고양이', author='강아지')

# Read (조회)
# 단일 조회
## objects => 매니저
Article.objects

article = Article.objects.get(id=1)
article = Article.objects.get(pk=1)
article.title
article.content
article.id

# 전체 조회
articles = Article.objects.all()
for article in articles:
    print(article.title)

# Update (수정)
article = Article.objects.get(id=1)
article.title = 'tests'
article.content = 'content update'
article.save()

# Delete (삭제)
Article.objects.get(id=1).delete()

# ORM (Object Relation Mapper)

