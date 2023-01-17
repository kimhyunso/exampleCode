from django.db import models

# Create your models here.
class Person(models.Model):
    name = models.CharField(max_length=50)
    age = models.IntegerField(default=20)
    # like_people = models.ManyToManyField('facebook.Feed', related_name='like_feeds')
    def __str__(self):
        return f'{self.pk}: {self.name}'

class Feed(models.Model):
    author = models.ForeignKey(Person, on_delete=models.CASCADE, related_name='feeds')
    content = models.TextField()
    like_people = models.ManyToManyField(Person, related_name='like_feeds')


class Comment(models.Model):
    content = models.CharField(max_length=50)
    author = models.ForeignKey(Person, on_delete=models.CASCADE)
    feed = models.ForeignKey(Feed, on_delete=models.CASCADE)


'''
p1 = Person.objects.create(name='neo', age=23)
p2 = Person.objects.create(name='asd', age=23)
p3 = Person.objects.create(name='asdasd', age=23)

f1 = Feed.objects.create(content='asdasd', author=p1)
c1 = Comment.objects.create(content='sdfdsfsdf', feed=f1, author=p2)

# 좋아요 한 게시글 모두
p1.like_feeds.all()

# 좋아요 한 사람들 모두
f1.like_people.all()

# p1이 좋아요 한 게시글에 f1추가 => join 테이블에 p1, f1 레코드 추가
p1.like_feeds.add(f1)
# 결과같음 중복 안됨
f1.like_people.add(p1)

# join 테이블에서 p1, f1으로 구성된 레코드 삭제
p1.like_feeds.remove(f1)


p1.feeds.first().like_people.order_by('age')[0].feeds.first().comment_set()

p1 = Person.objects.get(pk=1)
f1.like_people.filter(pk=p1.pk).exists()
p1 in f1.like_people.all()

'''