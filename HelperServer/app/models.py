from sqlalchemy.ext.hybrid import hybrid_property, hybrid_method

from app import db, bcrypt


class User(db.Model):
    __tablename__ = 'users'

    id = db.Column(db.Integer, primary_key=True)
    username = db.Column(db.String(16), unique=True, nullable=False)
    email = db.Column(db.String(120), unique=True, nullable=False)
    password = db.Column(db.BLOB(60), nullable=False)

    def __init__(self, username, email, plaintext_password):
        self.username = username
        self.email = email
        self.set_password = plaintext_password

    @hybrid_property
    def ppassword(self):
        return self.password

    @ppassword.setter
    def set_password(self, plaintext_password):
        self.password = bcrypt.generate_password_hash(plaintext_password)

    @hybrid_method
    def is_correct_password(self, plaintext_password):
        return bcrypt.check_password_hash(self.ppassword, plaintext_password)

    def __repr__(self):
        return '<User {}>'.format(self.username)

