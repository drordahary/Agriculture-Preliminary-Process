from src import MySql
from src import Forecasting


def main():
    print(MySql.connect())
    results = Forecasting.predict("RICE")
    for result in results[0]["Prediction"]:
        print(result)
    print(results[0]["Years"])
    print("Accuracy: " + str(round(results[1] * 100, 2)) + "%")


if __name__ == '__main__':
    main()
