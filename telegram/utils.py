import requests as r
import random as ran

# token = '5973424626:AAFEMLy0JqY4lxKWOY8McCU8o8JRai20owA'
# chat_id = '5859393656'
token = '5973424626:AAFEMLy0JqY4lxKWOY8McCU8o8JRai20owA'

def send_message(message, sender_id):
    token = '5973424626:AAFEMLy0JqY4lxKWOY8McCU8o8JRai20owA'
    
    if message == 'lotto' or message == '로또':
        message = ran.sample(range(1, 46), 6)
    
    url = f'https://api.telegram.org/bot{token}/sendMessage?chat_id={sender_id}&text={message}'
    r.get(url)

# output_message = '안녕하세요 chat-bot'
# # update_url = f'https://api.telegram.org/bot{token}/getUpdates'
# # response = r.get(update_url).json()
# # input_message = response['result'][-1]['message']['text']
# # # 최신 메세지의 발신자 id 출력
# # chat_id = response['result'][-1]['message']['from']['id']


# update_url = f'https://api.telegram.org/bot{token}/getUpdates'
# response = r.get(update_url).json()
# # input_message = response['result'][-1]['message']['text']
# # 최신 메세지의 발신자 id 출력
# # chat_id = response['result'][-1]['message']['from']['id']
# # 최신 메세지 기준으로, hi라고 들어오면 'hello'라고 답을 하고
# # 안녕이라고 들어오면, '안녕하세요'로 응답한다
# # if input_message == '로또':
# #     output_message = ran.sample(range(1, 46), 6)
# # elif input_message == 'hi':
# #     output_message = 'hello'
# # elif input_message == '안녕':
# #     output_message = '안녕하세요'
# # else:
# #     output_message = '처리할 수 없습니다 :('
#     # url = f'https://api.telegram.org/bot{token}/sendMessage?chat_id={chat_id}&text={output_message}'
#     # r.get(url)


# '''
# https://api.telegram.org/bot5973424626:AAFEMLy0JqY4lxKWOY8McCU8o8JRai20owA
# /sendMessage?chat_id=5859393656&text=hi

# https://api.telegram.org/bot5973424626:AAFEMLy0JqY4lxKWOY8McCU8o8JRai20owA
# /getUpdates
# '''

server_url = 'streetcat.pythonanywhere.com'

print(f'https://api.telegram.org/bot{token}/setWebhook?url={server_url}')

