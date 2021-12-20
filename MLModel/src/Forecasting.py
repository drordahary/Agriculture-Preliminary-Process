import pandas as pd
import os
from sklearn import linear_model
import numpy as np

global area_name
global yield_name

dirname = os.path.dirname(__file__)
train_path = os.path.join(dirname, 'datasets/train.csv')
test_path = os.path.join(dirname, 'datasets/test.csv')

train_data = pd.read_csv(train_path)
test_data = pd.read_csv(test_path)


def predict(crop):
    global area_name
    global yield_name
    if crop.upper() == "RICE":
        area_name = "AREA UNDER CULTIVATION RICE"
        yield_name = "YIELD RICE"
    if crop.upper() == "CORN":
        area_name = "AREA UNDER CULTIVATION CORN"
        yield_name = "YIELD CORN"
    if crop.upper() == "WHEAT":
        area_name = "AREA UNDER CULTIVATION WHEAT"
        yield_name = "YIELD WHEAT"

    x_axis_train = train_data[['METEOROLOGICAL DROUGHT', 'HYDROLOGICAL DROUGHT', 'AGRICULTURAL DROUGHT', area_name]]
    y_axis_train = train_data[[yield_name]]

    x_axis_test = test_data[['METEOROLOGICAL DROUGHT', 'HYDROLOGICAL DROUGHT', 'AGRICULTURAL DROUGHT', area_name]]
    y_axis_test = test_data[[yield_name]]

    line = linear_model.LinearRegression()
    model = line.fit(x_axis_train, y_axis_train)
    accuracy = line.score(x_axis_test, y_axis_test)

    data = {
        "Prediction": np.array(model.predict(x_axis_test)[0:5].tolist()),
        "Years": np.array([2008, 2009, 2010, 2011, 2012]).tolist()
    }

    return data, accuracy
