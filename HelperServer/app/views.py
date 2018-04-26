from app import app
from flask import render_template, flash, redirect, request, session
from app.forms import LoginForm, SignupForm
from app.models import User, Highscore
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
        return render_template('index.html', session=session, servers=servers)


@app.route('/login', methods=['POST', 'GET'])
def login():
    form = LoginForm()
    if form.validate_on_submit():
        if not User.query.filter_by(email=request.form['email']).first():
            flash('Wrong email')
        else:
            user = User.query.filter_by(email=request.form['email']).first()
            if user.is_correct_password(request.form['password']):
                highscore = Highscore.query.filter_by(id=user.high_score_id).first()
                session['logged_in'] = True
                session['username'] = user.username
                session['deathalltime'] = highscore.deathalltime
                session['deathlastmonth'] = highscore.deathlastmonth
                session['deathlastweek'] = highscore.deathlastweek
                session['gamesalltime'] = highscore.gamesalltime
                session['gameslastmonth'] = highscore.gameslastmonth
                session['gameslastweek'] = highscore.gameslastweek
                session['rating'] = highscore.raiting
                session['ratingmonth'] = highscore.raitingmonth
                session['ratingweek'] = highscore.raitingweek
                session['winsalltime'] = highscore.winsalltime
                session['winslastmonth'] = highscore.winslastmonth
                session['winslastweek'] = highscore.winslastweek
                highscores = Highscore.query.all()
                set_positions(highscores, highscore)
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
            highscore = Highscore(0, 0, 0, 0, 0, 0, 1000, 0, 0, 0, 0, 0)
            user = User(username=request.form['username'], email=request.form['email'],
                        plaintext_password=request.form['password'])
            highscore.users.append(user)
            db.session.add(highscore)
            db.session.commit()
            session['logged_in'] = True
            session['username'] = user.username
            session['deathalltime'] = highscore.deathalltime
            session['deathlastmonth'] = highscore.deathlastmonth
            session['deathlastweek'] = highscore.deathlastweek
            session['gamesalltime'] = highscore.gamesalltime
            session['gameslastmonth'] = highscore.gameslastmonth
            session['gameslastweek'] = highscore.gameslastweek
            session['rating'] = highscore.raiting
            session['ratingmonth'] = highscore.raitingmonth
            session['ratingweek'] = highscore.raitingweek
            session['winsalltime'] = highscore.winsalltime
            session['winslastmonth'] = highscore.winslastmonth
            session['winslastweek'] = highscore.winslastweek
            highscores = Highscore.query.all()
            set_positions(highscores, highscore)
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


def set_positions(h, user):
    session['deathalltime_p'] = sorted(h, key=lambda hs: hs.deathalltime).index(user) + 1
    session['deathlastmonth_p'] = sorted(h, key=lambda hs: hs.deathlastmonth).index(user) + 1
    session['deathlastweek_p'] = sorted(h, key=lambda hs: hs.deathlastweek).index(user) + 1
    session['gamesalltime_p'] = sorted(h, key=lambda hs: hs.gamesalltime).index(user) + 1
    session['gameslastmonth_p'] = sorted(h, key=lambda hs: hs.gameslastmonth).index(user) + 1
    session['gameslastweek_p'] = sorted(h, key=lambda hs: hs.gameslastweek).index(user) + 1
    session['rating_p'] = sorted(h, key=lambda hs: hs.raiting).index(user) + 1
    session['ratingmonth_p'] = sorted(h, key=lambda hs: hs.raitingmonth).index(user) + 1
    session['ratingweek_p'] = sorted(h, key=lambda hs: hs.raitingweek).index(user) + 1
    session['winsalltime_p'] = sorted(h, key=lambda hs: hs.winsalltime).index(user) + 1
    session['winslastmonth_p'] = sorted(h, key=lambda hs: hs.winslastmonth).index(user) + 1
    session['winslastweek_p'] = sorted(h, key=lambda hs: hs.winslastweek).index(user) + 1