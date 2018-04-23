from app import app
from flask import render_template, flash, redirect, request, session, abort
from forms import LoginForm

@app.route('/')
@app.route('/index')
def index():
    if not session.get('logged_in'):
        return render_template('login.html')
    else:
        return "Hello Boss!"

@app.route('/login', methods=['POST'])
def login():
    if request.form['password'] == 'password' and request.form['email'] == 'admin@admin.com':
        session['logged_in'] = True
    else:
        flash('Wrong email or password!')
    return index()

@app.route("/logout")
def logout():
    session['logged_in'] = False
    return index()

@app.route("/signup", methods=['POST', 'GET'])
def signup():
    pass