from flask import Flask
import os

app = Flask(__name__)
app.secret_key = os.urandom(12)
app.config.from_object('config')

from app import views