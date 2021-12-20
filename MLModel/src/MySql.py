import mysql.connector
import os


def connect():
    dirname = os.path.dirname(__file__)
    filename = os.path.join(dirname, 'configs/config.ini')

    config_file = open(filename)
    data = config_file.read().splitlines()
    print(data)

    mydb = mysql.connector.connect(host=data[0], user=data[1], passwd=data[2], database=data[3])
    return mydb
