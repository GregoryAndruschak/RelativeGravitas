from app import app
from flask import render_template, flash, redirect, request, session
from app.forms import LoginForm, SignupForm
from app.models import User
from app import db


global servers
servers = []


@app.route('/')
@app.route('/index')
def index():
    if not session.get('logged_in') or session.get('logged_in') is None:
        return redirect('/login')
    else:
        global servers
        return render_template('index.html', username=session['username'], servers=servers)


@app.route('/login', methods=['POST', 'GET'])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        if not User.query.filter_by(email=request.form['email']).first():
            flash('Wrong email')
        else:
            user = User.query.filter_by(email=request.form['email']).first()
            if user.is_correct_password(request.form['password']):
                session['logged_in'] = True
                session['username'] = user.username
                return redirect('/')
            else:
                flash('Wrong password')
    return render_template('login.html', form=form)


@app.route("/logout")
def logout():
    session['logged_in'] = False
    return redirect('/index')


@app.route("/signup", methods=['POST', 'GET'])
def signup():
    form = SignupForm()
    if form.validate_on_submit():
        if User.query.filter_by(email=request.form['email']).first():
            flash('This email is already in use')
        elif User.query.filter_by(username=request.form['username']).first():
            flash('This username is already taken')
        elif len(str(request.form['password'])) < 8:
            flash('Password is too short')
        else:
            user = User(username=request.form['username'], email=request.form['email'],
                        plaintext_password=request.form['password'])
            db.session.add(user)
            db.session.commit()
            session['logged_in'] = True
            session['username'] = user.username
            return redirect('/')
    return render_template('signup.html', form=form)


@app.route('/become_online', methods=['POST', 'GET'])
def become_online():
    global servers
    if request.remote_addr not in servers:
        servers.append(request.remote_addr)
    return redirect('/')


@app.route('/become_offline', methods=['POST', 'GET'])
def become_offline():
    global servers
    new_s = []
    for ip in servers:
        if ip != request.remote_addr:
            new_s.append(ip)
    servers = new_s
    return redirect('/')

