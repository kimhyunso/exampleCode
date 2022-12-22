import random

def pick_lotto():
    lucky = random.sample(range(1, 46), 6)
    return lucky

if __name__ == '__main__':
    print(__name__)