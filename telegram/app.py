from flask import Flask, request
import random as ran
from utils import send_message
import utils as u

app = Flask(__name__)


# decorator
@app.route('/', methods=['POST'])
def home():
    # 서버로서 우리가 받은 요청 request => Server
    response = request.json
    input_message = response['message']['text']
    sender_id = response['message']['from']['id']
    # 우리가 보내는 요청 requests => Client
    send_message(input_message, sender_id)
    return 'Hello Server!'


@app.route('/hi')
def hi():
    return 'hi'

app.run(port=80, debug=True)